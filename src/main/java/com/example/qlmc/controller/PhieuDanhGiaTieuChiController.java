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

import com.example.qlmc.entity.PhieuDanhGiaTieuChi;
import com.example.qlmc.entity.PhongBan;
import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.entity.TieuChuan;
import com.example.qlmc.service.PhieuDanhGiaTieuChiService;
import com.example.qlmc.service.PhongBanService;
import com.example.qlmc.service.TieuChiService;
import com.example.qlmc.service.TieuChuanService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/api/phieudanhgiatieuchi")
public class PhieuDanhGiaTieuChiController {
    @Autowired
    private PhieuDanhGiaTieuChiService phieuDanhGiaTieuChiService;

    @Autowired
    private PhongBanService phongBanService;

    @Autowired
    private TieuChuanService tieuChuanService;

    @Autowired
    private TieuChiService tieuChiService;

    @GetMapping
    public ResponseEntity<List<PhieuDanhGiaTieuChi>> getAllPhieuDanhGia(){
        return ResponseEntity.ok(phieuDanhGiaTieuChiService.getAllPhieuDanhGia());
    }
    @DeleteMapping("/{idPhieuDanhGia}")
    public ResponseEntity<String> deletePhieuDanhGia(@PathVariable int idPhieuDanhGia){
        try {
            phieuDanhGiaTieuChiService.deletePhieuDanhGia(idPhieuDanhGia);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<String> insertPhieuDanhGia(@RequestBody JsonNode formData){

        try {
            PhieuDanhGiaTieuChi phieuDanhGiaTieuChi = new PhieuDanhGiaTieuChi();
            int idPhongBan = Integer.parseInt(formData.get("idPhongBan").asText());
            phieuDanhGiaTieuChi.setIdPhongBan(idPhongBan);
            int idTieuChuan = Integer.parseInt(formData.get("idTieuChuan").asText());
            phieuDanhGiaTieuChi.setIdTieuChuan(idTieuChuan);
            int idTieuChi = Integer.parseInt(formData.get("idTieuChi").asText());
            TieuChi tieuChi = tieuChiService.findById(idTieuChi);
            phieuDanhGiaTieuChi.setTieuChi(tieuChi);

            phieuDanhGiaTieuChi.setMoTa(formData.get("moTa").asText());
            phieuDanhGiaTieuChi.setDiemManh(formData.get("diemManh").asText());
            phieuDanhGiaTieuChi.setDiemTonTai(formData.get("diemTonTai").asText());
            phieuDanhGiaTieuChi.setKeHoach(formData.get("keHoach").asText());

            phieuDanhGiaTieuChi.setMucDanhGia(Integer.parseInt(formData.get("mucDanhGia").asText()));

            phieuDanhGiaTieuChiService.insertPhieuDanhGia(phieuDanhGiaTieuChi);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updatePhieuDanhGia(@RequestBody JsonNode formData){
        try {
            PhieuDanhGiaTieuChi phieuDanhGiaTieuChi = new PhieuDanhGiaTieuChi();
            phieuDanhGiaTieuChi.setIdPhieuDanhGiaTieuChi(Integer.parseInt(formData.get("idPhieuDanhGia").asText()));
            int idPhongBan = Integer.parseInt(formData.get("idPhongBan").asText());
            phieuDanhGiaTieuChi.setIdPhongBan(idPhongBan);
            int idTieuChuan = Integer.parseInt(formData.get("idTieuChuan").asText());
            phieuDanhGiaTieuChi.setIdTieuChuan(idTieuChuan);
            int idTieuChi = Integer.parseInt(formData.get("idTieuChi").asText());
            TieuChi tieuChi = tieuChiService.findById(idTieuChi);
            phieuDanhGiaTieuChi.setTieuChi(tieuChi);

            phieuDanhGiaTieuChi.setMoTa(formData.get("moTa").asText());
            phieuDanhGiaTieuChi.setDiemManh(formData.get("diemManh").asText());
            phieuDanhGiaTieuChi.setDiemTonTai(formData.get("diemTonTai").asText());
            phieuDanhGiaTieuChi.setKeHoach(formData.get("keHoach").asText());

            phieuDanhGiaTieuChi.setMucDanhGia(Integer.parseInt(formData.get("mucDanhGia").asText()));

            phieuDanhGiaTieuChiService.updatePhieuDanhGia(phieuDanhGiaTieuChi);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

}
