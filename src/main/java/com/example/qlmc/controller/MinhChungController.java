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
    public List<MinhChung> getAllMinhChung() {
        return service.getAllMinhChung();
    }
    @GetMapping("/{idGoiY}")
    public List<Map<String, Object>> getAllWithIdGoiY(@PathVariable int idGoiY) {
        List<Object[]> result = service.getAllWithIdGoiY(idGoiY);
        return result.stream()
                .map(row -> Map.of(
                    "idMc", row[0],
                    "parentMaMc", row[1],
                    "childMaMc", row[2],
                    "idKmc", row[3],
                    "idTieuChuan", row[4],
                    "idGoiY", row[5],
                    "soHieu", row[6],
                    "tenMinhChung", row[7],
                    "linkLuuTru", row[8],
                    "caNhan", row[9]))
                .collect(Collectors.toList());
    }

    @GetMapping("/delete")
    public ResponseEntity<String> processMinhChung(@RequestParam(value = "idMc") int idMc,@RequestParam (value = "parentMaMc") String parentMaMc) {

        try {
            service.processMinhChung(idMc, parentMaMc);
            return ResponseEntity.ok("Processing completed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing MinhChung: " + e.getMessage());
        }
    }


    @PostMapping
    public MinhChung saveMinhChung(@RequestBody MinhChung data) {
        return service.saveData(data);
    }
}
