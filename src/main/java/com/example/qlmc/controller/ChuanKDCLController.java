package com.example.qlmc.controller;

import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.entity.GoiY;
import com.example.qlmc.service.ChuanKDCLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chuankdcl")
public class ChuanKDCLController {

    @Autowired
    private ChuanKDCLService chuanKDCLService;

    @GetMapping
    public List<ChuanKDCL> getAllChuanKDCL() {
        return chuanKDCLService.getAllChuanKDCLs();
    }

    @GetMapping("/updateTenKdcl")
    public ResponseEntity<String> updateTenKdcl(@RequestParam(value = "tenKdcl") String tenKdcl,@RequestParam (value = "idKdcl") int idKdcl) {

        try {
            chuanKDCLService.updateTenKdcl(tenKdcl, idKdcl);
            return ResponseEntity.ok("Processing completed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing MinhChung: " + e.getMessage());
        }
    }

    @GetMapping("/updateNamBanHanh")
    public ResponseEntity<String> updateNamBanHanh(@RequestParam(value = "namBanHanh") String namBanHanh,@RequestParam (value = "idKdcl") int idKdcl) {

        try {
            chuanKDCLService.updateNamBanHanh(namBanHanh, idKdcl);
            return ResponseEntity.ok("Processing completed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing MinhChung: " + e.getMessage());
        }
    }
    @DeleteMapping("/deleteChuanKDCL")
    public ResponseEntity<String> deleteChuanKDCL(@RequestParam (value = "idKdcl") int idKdcl) {
        try {
            chuanKDCLService.deleteChuanKDCL(idKdcl);
            return ResponseEntity.ok("Processing completed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing MinhChung: " + e.getMessage());
        }
    }

}
