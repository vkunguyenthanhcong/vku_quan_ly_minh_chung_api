package com.example.qlmc.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.service.KhoMinhChungService;

@RestController
@RequestMapping("/api/khominhchung")
public class KhoMinhChungController {
    @Autowired
    private KhoMinhChungService khoMinhChungService;

    @GetMapping
    public ResponseEntity<List<KhoMinhChung>> getAllKhoMinhChung() {
        return ResponseEntity.ok(khoMinhChungService.getAllKhoMinhChung());
    }

    @PostMapping
    public ResponseEntity<String> saveMinhChung(@RequestBody KhoMinhChung data) {
        try {
            khoMinhChungService.saveData(data);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @PutMapping("/edit/{idKmc}")
    public ResponseEntity<String> updateKhoMinhChung(@PathVariable int idKmc, @RequestBody KhoMinhChung data) {
        try {
            khoMinhChungService.updateKhoMinhChung(idKmc,data);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @GetMapping("/findById/{idKmc}")
    public ResponseEntity<KhoMinhChung> findById(@PathVariable int idKmc) {
        return ResponseEntity.ok(khoMinhChungService.findAllById(idKmc));
    }

    @GetMapping("/searchByNotDate")
    public ResponseEntity<List<KhoMinhChung>> searchByNotDate(@RequestParam(value = "tenMc") String tenMc, @RequestParam(value = "soHieu") String soHieu,@RequestParam(value = "idLoai") String idLoai) {
        return ResponseEntity.ok(khoMinhChungService.searchByNotDate(tenMc, soHieu, idLoai));
    }
    @GetMapping("/searchByDate")
    public ResponseEntity<List<KhoMinhChung>> searchByDate(@RequestParam(value = "tenMc") String tenMc, @RequestParam(value = "soHieu") String soHieu,@RequestParam(value = "idLoai") String idLoai, @RequestParam(value = "startDate") Date startDate, @RequestParam(value = "endDate") Date endDate) {
        return ResponseEntity.ok(khoMinhChungService.searchByDate(tenMc, soHieu, idLoai, startDate, endDate));
    }
}
