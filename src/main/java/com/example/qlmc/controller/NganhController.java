package com.example.qlmc.controller;

import java.util.List;

import org.checkerframework.checker.units.qual.N;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.Khoa;
import com.example.qlmc.entity.Nganh;
import com.example.qlmc.service.CTDTService;
import com.example.qlmc.service.KhoaService;
import com.example.qlmc.service.NganhService;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.api.client.json.Json;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/nganh")
public class NganhController {

    @Autowired
    private  NganhService nganhService;
    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public ResponseEntity<List<Nganh>> getAllNganh() {
        return ResponseEntity.ok(nganhService.getAllNganh());
    }
    @PostMapping()
    public ResponseEntity<List<Nganh>> insertNewNganh(@RequestBody JsonNode nganh) {
       Nganh newNganh = new Nganh();
       newNganh.setMaNganh(nganh.get("maNganh").asText());
       newNganh.setMaKhoa(nganh.get("maKhoa").asText());
       newNganh.setTenNganh(nganh.get("tenNganh").asText());
       newNganh.setTrinhDo(nganh.get("trinhDo").asText());
       return ResponseEntity.ok(nganhService.insertNew(newNganh));
    }
    @PutMapping("/{maNganh}")
    public ResponseEntity<?> updateNganh(@PathVariable String maNganh, @RequestBody JsonNode nganh) {
        try {
            if (nganh == null || !nganh.fieldNames().hasNext()) {
                return ResponseEntity.badRequest().body("Request body is empty or invalid.");
            }
    
            String fieldName = nganh.fieldNames().next();
            String fieldValue = nganh.get(fieldName).asText();
    
            Nganh nganhUpdate = nganhService.getNganhById(maNganh);
            if (nganhUpdate == null) {
                return ResponseEntity.status(404).body("Nganh with maNganh " + maNganh + " not found.");
            }
            switch (fieldName) {
                case "tenNganh":
                    nganhUpdate.setTenNganh(fieldValue);
                    break;
                case "maKhoa":
                    nganhUpdate.setMaKhoa(fieldValue);
                    break;
                case "trinhDo":
                    nganhUpdate.setTrinhDo(fieldValue);
                    break;
                default:
                    return ResponseEntity.badRequest().body("Invalid field: " + fieldName);
            }
    
            nganhService.updateNganh(nganhUpdate);
            return ResponseEntity.ok("Nganh updated successfully.");
    
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred while processing the request: " + e.getMessage());
        }
    }
    @DeleteMapping("/{maNganh}")
    public ResponseEntity<List<Nganh>> deleteNganh(@PathVariable String maNganh){
        Nganh deleteNganh = nganhService.getNganhById(maNganh);
        return ResponseEntity.ok(nganhService.deleteNganh(deleteNganh)); 
    }
    
}