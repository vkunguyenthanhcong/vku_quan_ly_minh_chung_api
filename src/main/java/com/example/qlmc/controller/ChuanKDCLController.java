package com.example.qlmc.controller;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ChuanKDCL>> getAllChuanKDCL() {
        return ResponseEntity.ok(chuanKDCLService.getAllChuanKDCLs());
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertChuanKdcl(@RequestBody ChuanKDCL chuanKdcl) {
        try{
            chuanKDCLService.insertNewChuanKdcl(chuanKdcl.getTenKdcl(), chuanKdcl.getNamBanHanh());
            return ResponseEntity.ok("OK");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @GetMapping("/updateTenKdcl")
    public ResponseEntity<String> updateTenKdcl(@RequestParam(value = "tenKdcl") String tenKdcl,@RequestParam (value = "idKdcl") int idKdcl) {
        try {
            chuanKDCLService.updateTenKdcl(tenKdcl, idKdcl);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @GetMapping("/updateNamBanHanh")
    public ResponseEntity<String> updateNamBanHanh(@RequestParam(value = "namBanHanh") String namBanHanh,@RequestParam (value = "idKdcl") int idKdcl) {
        try {
            chuanKDCLService.updateNamBanHanh(namBanHanh, idKdcl);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteChuanKDCL")
    public ResponseEntity<String> deleteChuanKDCL(@RequestParam (value = "idKdcl") int idKdcl) {
        try {
            chuanKDCLService.deleteChuanKDCL(idKdcl);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

}
