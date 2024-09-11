package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.MinhChung;
import com.example.qlmc.service.MinhChungService;


@RestController
@RequestMapping("/api/minhchung")
public class MinhChungController {
    @Autowired
    private MinhChungService service;

    @GetMapping
    public ResponseEntity<List<MinhChung>> getAllMinhChung() {
        return ResponseEntity.ok(service.getAllMinhChung());
    }
    
    @GetMapping("/CountMinhChungWithTieuChi/{idTieuChi}")
    public ResponseEntity<List<Map<String, Object>>>countMinhChungWithTieuChi(@PathVariable int idTieuChi) {
        List<Object[]> result = service.countMinhChungWithTieuChi(idTieuChi);
        List<Map<String, Object>> responseList = result.stream()
            .map(row -> Map.of(
                "total", row[0]))
            .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);    
    }
    @GetMapping("/MinhChungAndIdTieuChi")
    public ResponseEntity<List<Map<String, Object>>> getAllWithIdGoiY() {
        List<Object[]> result = service.getAllMinhChungAndidTieuChi();
        
        List<Map<String, Object>> response = result.stream()
                .map(row -> {
                    String parentMaMc = (String) row[1];
                    String childMaMc = (String) row[2];
                    String maMinhChung = parentMaMc + childMaMc;
                    return Map.of(
                        "idMc", row[0],
                        "maMinhChung", maMinhChung,
                        "idKmc", row[3],
                        "idTieuChuan", row[4],
                        "idGoiY", row[5],
                        "maDungChung", row[6],
                        "soHieu", row[7],
                        "tenMinhChung", row[8],
                        "linkLuuTru", row[9],
                        "idTieuChi", row[10]
                    );
                })
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/findByIdTieuChi/{idTieuChi}")
    public ResponseEntity<List<Map<String, Object>>> getAllWithIdTieuChi(@PathVariable int idTieuChi) {
        List<Object[]> result = service.getAllWithIdTieuChi(idTieuChi);
        List<Map<String, Object>> response = result.stream()
                .map(row -> Map.of(
                    "parentMaMc", row[0],
                    "childMaMc", row[1],
                    "tenMinhChung", row[2],
                    "soHieu", row[3],
                    "thoiGian", row[4],
                    "donViBanHanh", row[5],
                    "linkLuuTru", row[6]))
                .collect(Collectors.toList());
                return ResponseEntity.ok(response);
    }

    @GetMapping("/MinhChungKhongDungChung")
    public ResponseEntity<List<Map<String, Object>>> getAllMinhChungKhongDungChung() {
        List<Object[]> result = service.getAllMinhChungKhongDungChung();
        List<Map<String, Object>> response = result.stream()
                .map(row -> Map.of(
                    "idMc", row[0],
                    "parentMaMc", row[1],
                    "childMaMc", row[2],
                    "tenMinhChung", row[3],
                    "linkLuuTru", row[4]))
                .collect(Collectors.toList());
                return ResponseEntity.ok(response);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> processMinhChung(@RequestParam(value = "idMc") int idMc,@RequestParam (value = "parentMaMc") String parentMaMc) {

        try {
            service.processMinhChung(idMc, parentMaMc);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> saveMinhChung(@RequestBody MinhChung data) {
        try {
            service.saveData(data);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @GetMapping("/findByMaCtdt/{maCtdt}")
    public ResponseEntity<List<Map<String, Object>>> findByMaCtdt(@PathVariable String maCtdt) {
        List<Object[]> result = service.findByMaCtdt(maCtdt);
        List<Map<String, Object>> response = result.stream()
                .map(row -> Map.of(
                    "idMinhChung", row[0],
                    "parentMaMc", row[1],
                    "childMaMc", row[2],
                    "idKhoMinhChung", row[3],
                    "idTieuChuan", row[4],
                    "idGoiY", row[5],
                    "maDungChung", row[6],
                    "tenMinhChung", row[7]))
                .collect(Collectors.toList());
                return ResponseEntity.ok(response);
    }
    @PostMapping("/dungchung")
    public ResponseEntity<String> createMinhChung(@RequestBody MinhChung request) {
        try {
            service.addMinhChungDungChung(request.getIdKmc(), request.getIdTieuChuan(), request.getIdGoiY(), request.getMaDungChung());
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    
}
