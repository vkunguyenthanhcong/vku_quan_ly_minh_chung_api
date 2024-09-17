package com.example.qlmc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.CTDT;
import com.example.qlmc.service.CTDTService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/api/ctdt")
public class CTDTController {

    @Autowired
    private CTDTService ctdtService;

    @GetMapping
    public ResponseEntity<List<CTDT>> getAllCTDT() {
        return ResponseEntity.ok(ctdtService.getAllCTDT());
    }

    @GetMapping("/filter/{maKdcl}")
    public ResponseEntity<List<CTDT>> getAllCTDTByMaKDCL(@PathVariable String maKdcl) {
        return ResponseEntity.ok(ctdtService.getAllCTDTByMaKDCL(maKdcl));
    }

    @GetMapping("/detail/{maCtdt}")
    public ResponseEntity<Optional<CTDT>> getThongTinChuongTrinhDaoTao(@PathVariable String maCtdt) {
        Optional<CTDT> response = ctdtService.getThongTinChuongTrinhDaoTao(maCtdt);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCTDT(@RequestBody JsonNode formData) {
        try {
            ctdtService.updateCTDT(formData.get("maCtdt").asText(), formData.get("tenCtdt").asText(), formData.get("maKhoa").asText(), formData.get("maNganh").asText());
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{maCtdt}")
    public ResponseEntity<String> deleteCTDT(@PathVariable(value = "maCtdt") String maCtdt) {
        try {
            ctdtService.deleteCTDT(maCtdt);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

}
