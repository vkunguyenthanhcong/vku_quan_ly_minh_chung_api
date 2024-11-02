package com.example.qlmc.controller;

import java.util.List;

import com.example.qlmc.entity.CTDT;
import com.example.qlmc.entity.Res;
import com.example.qlmc.entity.TieuChuan;
import com.example.qlmc.service.TieuChuanService;
import com.example.qlmc.service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.service.TieuChiService;


@RestController
@RequestMapping("/api/tieuchi")
public class TieuChiController {

    @Autowired
    private TieuChiService tieuChiService;
    @Autowired
    private TieuChuanService tieuChuanService;
    @Autowired
    private UploadService uploadService;

    @GetMapping
    public ResponseEntity<List<TieuChi>> getAllTieuChi() {
        return ResponseEntity.ok(tieuChiService.getAllTieuChi());
    }

    @GetMapping("/findById/{idTieuChi}")
    public ResponseEntity<TieuChi> findById(@PathVariable int idTieuChi) {
        return ResponseEntity.ok(tieuChiService.findById(idTieuChi));
    }
    @PostMapping
    public ResponseEntity<String> insertNewTieuChi(@RequestBody JsonNode formData) {
        try {
            TieuChi tieuChi = new TieuChi();
            String tenTieuChi = formData.get("ten").asText();
            String stt = formData.get("stt").asText();
            String yeuCau = formData.get("yeuCau").asText();
            int idTieuChuan = Integer.parseInt(formData.get("idParent").asText());
            TieuChuan tieuChuan = tieuChuanService.findById(idTieuChuan);

            tieuChi.setTenTieuChi(tenTieuChi);
            tieuChi.setStt(Integer.parseInt(stt));
            tieuChi.setIdTieuChuan(idTieuChuan);
            tieuChi.setYeuCau(yeuCau);

            String tenGoogleDrive = "Tiêu chí " + stt;
            Res res = uploadService.createFolder(tenGoogleDrive, tieuChuan.getIdGoogleDrive());
            tieuChi.setIdGoogleDrive(res.getUrl());

            tieuChiService.insertNewTieuChi(tieuChi);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updateTieuChi(@RequestBody JsonNode formData) {
        try {
            tieuChiService.updateTieuChi(formData);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }


    
}