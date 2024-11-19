package com.example.qlmc.controller;

import com.example.qlmc.entity.PhieuDanhGiaTieuChuan;
import com.example.qlmc.service.PhieuDanhGiaTieuChuanService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phieudanhgiatieuchuan")
public class PhieuDanhGiaTieuChuanController {
    @Autowired
    private PhieuDanhGiaTieuChuanService phieuDanhGiaTieuChuanService;

    @GetMapping
    public ResponseEntity<List<PhieuDanhGiaTieuChuan>> getAll(){
        return ResponseEntity.ok(phieuDanhGiaTieuChuanService.getAllPhieuDanhGiaTieuChuan());
    }
    @GetMapping("/{idPhieuDanhGiaTieuChuan}")
    public ResponseEntity<PhieuDanhGiaTieuChuan> findById(@PathVariable int idPhieuDanhGiaTieuChuan){
        return ResponseEntity.ok(phieuDanhGiaTieuChuanService.findById(idPhieuDanhGiaTieuChuan));
    }
    @PostMapping
    public ResponseEntity<String> savePhieuDanhGia(@RequestBody JsonNode formData){
        try {
            PhieuDanhGiaTieuChuan phieuDanhGiaTieuChuan = new PhieuDanhGiaTieuChuan();
            phieuDanhGiaTieuChuan.setIdPhongBan(formData.get("idPhongBan").asInt());
            phieuDanhGiaTieuChuan.setMoTa(formData.get("moTa").asText());
            phieuDanhGiaTieuChuan.setIdTieuChuan(formData.get("idTieuChuan").asInt());
            phieuDanhGiaTieuChuan.setDiemManh(formData.get("diemManh").asText());
            phieuDanhGiaTieuChuan.setDiemTonTai(formData.get("diemTonTai").asText());
            phieuDanhGiaTieuChuan.setKeHoach(formData.get("keHoach").asText());
            phieuDanhGiaTieuChuan.setMucDanhGia(formData.get("mucDanhGia").asText());
            phieuDanhGiaTieuChuanService.savePhieuDanhGia(phieuDanhGiaTieuChuan);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updatePhieuDanhGia(@RequestBody JsonNode formData){
        try {
            PhieuDanhGiaTieuChuan phieuDanhGiaTieuChuan = phieuDanhGiaTieuChuanService.findById(formData.get("idPhieuDanhGia").asInt());
            phieuDanhGiaTieuChuan.setIdPhongBan(formData.get("idPhongBan").asInt());
            phieuDanhGiaTieuChuan.setMoTa(formData.get("moTa").asText());
            phieuDanhGiaTieuChuan.setIdTieuChuan(formData.get("idTieuChuan").asInt());
            phieuDanhGiaTieuChuan.setDiemManh(formData.get("diemManh").asText());
            phieuDanhGiaTieuChuan.setDiemTonTai(formData.get("diemTonTai").asText());
            phieuDanhGiaTieuChuan.setKeHoach(formData.get("keHoach").asText());
            phieuDanhGiaTieuChuan.setMucDanhGia(formData.get("mucDanhGia").asText());
            phieuDanhGiaTieuChuanService.savePhieuDanhGia(phieuDanhGiaTieuChuan);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
}
