package com.example.qlmc.controller;

import java.util.List;

import com.example.qlmc.entity.Res;
import com.example.qlmc.service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.service.ChuanKDCLService;

@RestController
@RequestMapping("/api/chuankdcl")
public class ChuanKDCLController {

    @Autowired
    private ChuanKDCLService chuanKDCLService;
    @Autowired
    private UploadService uploadService;

    @GetMapping
    public ResponseEntity<List<ChuanKDCL>> getAllChuanKDCL() {
        return ResponseEntity.ok(chuanKDCLService.getAllChuanKDCLs());
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertChuanKdcl(@RequestBody ChuanKDCL chuanKDCL) {
        try {
            Res res = uploadService.createFolderChuanKDCL(chuanKDCL.getTenKdcl());
            chuanKDCLService.insertNewChuanKdcl(chuanKDCL.getTenKdcl(), chuanKDCL.getNamBanHanh(), res.getUrl(), chuanKDCL.getSoLuongTieuChuan());

            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }


    @GetMapping("/updateTenKdcl")
    public ResponseEntity<String> updateTenKdcl(@RequestParam(value = "tenKdcl") String tenKdcl,@RequestParam (value = "maKdcl") String maKdcl) {
        try {
            chuanKDCLService.updateTenKdcl(tenKdcl, maKdcl);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @GetMapping("/updateNamBanHanh")
    public ResponseEntity<String> updateNamBanHanh(@RequestParam(value = "namBanHanh") String namBanHanh,@RequestParam (value = "maKdcl") String maKdcl) {
        try {
            chuanKDCLService.updateNamBanHanh(namBanHanh, maKdcl);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteChuanKDCL")
    public ResponseEntity<String> deleteChuanKDCL(@RequestParam (value = "maKdcl") String maKdcl) {
        try {
            ChuanKDCL chuanKDCL = chuanKDCLService.getChuanKdclByMaKdcl(maKdcl);
            uploadService.deleteChuanKdcl(chuanKDCL.getIdGoogleDrive());
            chuanKDCLService.deleteChuanKDCL(maKdcl);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }

    }

}
