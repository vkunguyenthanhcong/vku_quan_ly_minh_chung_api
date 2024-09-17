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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.entity.PhanCongDanhGia;
import com.example.qlmc.entity.PhongBan;
import com.example.qlmc.service.ChuanKDCLService;
import com.example.qlmc.service.PhanCongDanhGiaService;
import com.example.qlmc.service.PhongBanService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/phancongdanhgia")
public class PhanCongDanhGiaController {
    @Autowired
    private PhanCongDanhGiaService phanCongDanhGiaService;
    @Autowired
    private PhongBanService phongBanService;
    @Autowired
    private ChuanKDCLService chuanKDCLService;

    @GetMapping
    public ResponseEntity<List<PhanCongDanhGia>> getAllPhanCongDanhGia(){
        return ResponseEntity.ok(phanCongDanhGiaService.getAllPhanCongDanhGia());
    }

    @PostMapping
    public ResponseEntity<String> insertNewPhanCongDanhGia(@RequestBody ObjectNode formData) {
    try {
        PhanCongDanhGia phanCong = new PhanCongDanhGia();
        phanCong.setSttTieuChuanBatDau(Integer.parseInt(formData.get("sttTieuChuanBatDau").asText()));
        phanCong.setSttTieuChuanKetThuc(Integer.parseInt(formData.get("sttTieuChuanKetThuc").asText()));

        int idPhongBan = Integer.parseInt(formData.get("idPhongBan").asText());
        PhongBan phongBan = phongBanService.getPhongBanWithId(idPhongBan);
        phanCong.setPhongBan(phongBan);
        String maKdcl = formData.get("maKdcl").asText();
        ChuanKDCL chuanKdcl = chuanKDCLService.getChuanKdclByMaKdcl(maKdcl);
        phanCong.setChuanKdcl(chuanKdcl);
        phanCongDanhGiaService.insertNew(phanCong);
        return ResponseEntity.ok("OK");
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
    }
    }
    @DeleteMapping("/{idPhanCong}")
    public ResponseEntity<String> deletePhanCong(@PathVariable int idPhanCong){
        try {
            phanCongDanhGiaService.deletePhanCong(idPhanCong);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updatePhanCong(@RequestBody JsonNode formData){
        try {
            PhanCongDanhGia phanCong = new PhanCongDanhGia();
            phanCong.setIdPhanCong(Integer.parseInt(formData.get("idPhanCong").asText()));
            phanCong.setSttTieuChuanBatDau(Integer.parseInt(formData.get("sttTieuChuanBatDau").asText()));
            phanCong.setSttTieuChuanKetThuc(Integer.parseInt(formData.get("sttTieuChuanKetThuc").asText()));
    
            int idPhongBan = Integer.parseInt(formData.get("idPhongBan").asText());
            PhongBan phongBan = phongBanService.getPhongBanWithId(idPhongBan);
            phanCong.setPhongBan(phongBan);
            String maKdcl = formData.get("maKdcl").asText();
            ChuanKDCL chuanKdcl = chuanKDCLService.getChuanKdclByMaKdcl(maKdcl);
            phanCong.setChuanKdcl(chuanKdcl);
            phanCongDanhGiaService.insertNew(phanCong);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @GetMapping("/findByIdPhongBan")
    public ResponseEntity<List<PhanCongDanhGia>> findAllByIdPhongBanAndMaKdcl(@RequestParam (value="maKdcl") String maKdcl, @RequestParam (value = "idPhongBan") int idPhongBan){
        return ResponseEntity.ok(phanCongDanhGiaService.findAllPhanCongByIdPhongBan(idPhongBan, maKdcl));
    }
    
}
