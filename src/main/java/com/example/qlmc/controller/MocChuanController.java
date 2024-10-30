package com.example.qlmc.controller;

import java.util.List;

import com.example.qlmc.entity.*;
import com.example.qlmc.service.TieuChiService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.qlmc.service.MocChuanService;


@RestController
@RequestMapping("/api/mocchuan")
public class MocChuanController {
    @Autowired
    private MocChuanService service;
    @Autowired
    private TieuChiService tieuChiService;
    @Autowired
    private MocChuanService mocChuanService;

    @GetMapping
    public ResponseEntity<List<MocChuan>> getAllMocChuan() {
        return ResponseEntity.ok(service.getAllMocChuan());
    }

    @PostMapping
    public ResponseEntity<String> insertNewMocChuan(@RequestBody JsonNode formData) {
        try {
            MocChuan mocChuan = new MocChuan();
            String tenMocChuan = formData.get("ten").asText();
            String stt = formData.get("stt").asText();
            int idTieuChi = Integer.parseInt(formData.get("idParent").asText());
            mocChuan.setTenMocChuan(tenMocChuan);
            mocChuan.setIdTieuChi(idTieuChi);

            mocChuanService.insertMocChuan(mocChuan);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updateMocChuan(@RequestBody JsonNode formData) {
        try {
            mocChuanService.updateMocChuan(formData);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
}
