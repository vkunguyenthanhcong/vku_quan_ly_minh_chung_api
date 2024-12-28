package com.example.qlmc.controller;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.example.qlmc.entity.DonViBanHanh;
import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.service.DonViBanHanhService;
import com.example.qlmc.service.KhoMinhChungService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/api/khominhchung")
public class KhoMinhChungController {
    @Autowired
    private KhoMinhChungService khoMinhChungService;
    @Autowired
    private DonViBanHanhService donViBanHanhService;

    @GetMapping
    public ResponseEntity<List<KhoMinhChung>> getAllKhoMinhChung() {
        return ResponseEntity.ok(khoMinhChungService.getAllKhoMinhChung());
    }

    @PostMapping
    public ResponseEntity<String> saveMinhChung(@RequestBody JsonNode data) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
            Date utilDate = formatter.parse(data.get("thoiGian").asText());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            KhoMinhChung kmc = new KhoMinhChung();
            kmc.setTenMinhChung(data.get("tenMinhChung").asText());
            kmc.setSoHieu(data.get("soHieu").asText());
            kmc.setThoigian(sqlDate);
            DonViBanHanh donViBanHanh = donViBanHanhService.findById(data.get("idDvbh").asInt());
            kmc.setDonViBanHanh(donViBanHanh);
            kmc.setIdLoai(data.get("idLoai").asInt());
            kmc.setLinkLuuTru(data.get("linkLuuTru").asText());
            khoMinhChungService.updateKhoMinhChung(kmc);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            System.out.println("Error processing: " + e.getMessage());
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @PutMapping("/edit/{idKmc}")
    public ResponseEntity<String> updateKhoMinhChung(@PathVariable int idKmc, @RequestBody JsonNode data) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
            Date utilDate = formatter.parse(data.get("thoiGian").asText());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            KhoMinhChung kmc = khoMinhChungService.findAllById(idKmc);
            kmc.setTenMinhChung(data.get("tenMinhChung").asText());
            kmc.setSoHieu(data.get("soHieu").asText());
            kmc.setThoigian(sqlDate);
            DonViBanHanh donViBanHanh = donViBanHanhService.findById(data.get("idDvbh").asInt());
            kmc.setDonViBanHanh(donViBanHanh);
            kmc.setIdLoai(data.get("idLoai").asInt());
            kmc.setLinkLuuTru(data.get("linkLuuTru").asText());
            khoMinhChungService.updateKhoMinhChung(kmc);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            System.out.println("Error processing: " + e.getMessage());
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
        java.sql.Date startDated = new java.sql.Date(startDate.getTime());
        java.sql.Date endDated = new java.sql.Date(endDate.getTime());
        return ResponseEntity.ok(khoMinhChungService.searchByDate(tenMc, soHieu, idLoai, startDated, endDated));
    }
}
