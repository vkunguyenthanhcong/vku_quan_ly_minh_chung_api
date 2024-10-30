package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.qlmc.entity.*;
import com.example.qlmc.service.CTDTService;
import com.example.qlmc.service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.qlmc.service.TieuChuanService;

@RestController
@RequestMapping("/api/tieuchuan")
public class TieuChuanController {

    @Autowired
    private TieuChuanService tieuChuanService;
    @Autowired
    private CTDTService ctdtService;
    @Autowired
    private UploadService  uploadService;

    @GetMapping
    public ResponseEntity<List<TieuChuan>> getAllTieuChuan() {
        return ResponseEntity.ok(tieuChuanService.getAllTieuChuan());
    }
    @GetMapping("/findByMaCtdt/{maCtdt}")
    public ResponseEntity<List<TieuChuan>> findByMaCtdt(@PathVariable("maCtdt") String maCtdt) {
        return ResponseEntity.ok(tieuChuanService.findByMaCtdt(maCtdt));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TieuChuan> findById(@PathVariable int id) {
        return ResponseEntity.ok(tieuChuanService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> insertNewTieuChuan(@RequestBody JsonNode formData) {
        try {
            TieuChuan tieuChuan = new TieuChuan();
            String tenTieuChuan = formData.get("ten").asText();
            String stt = formData.get("stt").asText();;

            tieuChuan.setTenTieuChuan(tenTieuChuan);
            tieuChuan.setStt(Integer.parseInt(stt));

            tieuChuan.setMaCtdt(formData.get("idParent").asText());
            CTDT ctdt = ctdtService.getThongTinChuongTrinhDaoTao(formData.get("idParent").asText());

            String tenGoogleDrive = "Tiêu chuẩn " + stt + ". " + tenTieuChuan;
            Res res = uploadService.createFolder(tenGoogleDrive, ctdt.getIdGoogleDrive());
            tieuChuan.setIdGoogleDrive(res.getUrl());

            tieuChuanService.insertNewTieuChuan(tieuChuan);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updateTieuChuan(@RequestBody JsonNode formData) {
        try {
            tieuChuanService.updateTieuChuan(formData);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    
}