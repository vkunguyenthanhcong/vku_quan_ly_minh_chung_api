package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.PhongBan;
import com.example.qlmc.service.PhongBanService;

@RestController
@RequestMapping("/api/phongban")
public class PhongBanController {
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public ResponseEntity<List<PhongBan>> getAllPhongBan(){
        return ResponseEntity.ok(phongBanService.getAllPhongBan());
    }
    @GetMapping("/{idPhongBan}")
    public ResponseEntity<PhongBan> getAllPhongBanById(@PathVariable int idPhongBan){
        return ResponseEntity.ok(phongBanService.getPhongBanWithId(idPhongBan));
    }

    @PostMapping
    public ResponseEntity<List<PhongBan>> createNewPhongBan(@RequestBody PhongBan phongBan) {
        phongBanService.createNewPhongBan(phongBan);
        return ResponseEntity.ok(phongBanService.getAllPhongBan());
    }

    @PutMapping
    public ResponseEntity<String> editPhongBan(@RequestBody PhongBan phongBan) {
        try {
            phongBanService.editTenPhongBan(phongBan);  
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{idPhongBan}")
    public ResponseEntity<List<PhongBan>> deletePhongBan(@PathVariable int idPhongBan){
        phongBanService.deletePhongBan(idPhongBan);  
        return ResponseEntity.ok(phongBanService.getAllPhongBan());
    }

    
}
