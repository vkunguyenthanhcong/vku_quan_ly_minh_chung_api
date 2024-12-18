package com.example.qlmc.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.example.qlmc.entity.*;
import com.example.qlmc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/api/ctdt")
public class CTDTController {

    @Autowired
    private CTDTService ctdtService;
    @Autowired
    private ChuanKDCLService chuanKDCLService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private NganhService nganhService;
    @Autowired
    private UploadService uploadService;

    @GetMapping
    public ResponseEntity<List<CTDT>> getAllCTDT() {
        return ResponseEntity.ok(ctdtService.getAllCTDT());
    }
    @GetMapping("/detail/{maCtdt}")
    public ResponseEntity<CTDT> getThongTinChuongTrinhDaoTao(@PathVariable String maCtdt) {
        CTDT response = ctdtService.getThongTinChuongTrinhDaoTao(maCtdt);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<String> insertCTDT(@RequestBody JsonNode formData) {
        try {
            CTDT ctdt = new CTDT();
            Integer loai = Integer.parseInt(formData.get("loai").asText());
            if(loai == 1){
                String maCtdt = formData.get("maCtdt").asText();
                String tenCtdt = formData.get("tenCtdt").asText();
                int soTinChi = Integer.parseInt(formData.get("soTinChi").asText());
                String trinhDo = formData.get("trinhDo").asText();

                Khoa khoa = khoaService.getKhoaById(formData.get("maKhoa").asText());
                ChuanKDCL chuanKDCL = chuanKDCLService.getChuanKdclByMaKdcl(formData.get("maKdcl").asText());
                Nganh nganh = nganhService.getNganhById(formData.get("maNganh").asText());

                ctdt.setMaCtdt(maCtdt);
                ctdt.setTenCtdt(tenCtdt);
                ctdt.setSoTinChi(soTinChi);
                ctdt.setKhoa(khoa);
                ctdt.setChuanKdcl(chuanKDCL);
                ctdt.setNganh(nganh);
                ctdt.setTrinhDo(trinhDo);
                ctdt.setLoai(loai);
                Res res = uploadService.createFolder(tenCtdt, chuanKDCL.getIdGoogleDrive());
                ctdt.setIdGoogleDrive(res.getUrl());

                ctdtService.insertCTDT(ctdt);
                return ResponseEntity.ok("OK");
            }else{

                String tenCtdt = formData.get("tenCtdt").asText();
                String maCtdt = formData.get("maCtdt").asText();

                ChuanKDCL chuanKDCL = chuanKDCLService.getChuanKdclByMaKdcl(formData.get("maKdcl").asText());
                ctdt.setMaCtdt(maCtdt);
                ctdt.setChuanKdcl(chuanKDCL);
                ctdt.setTenCtdt(tenCtdt);
                ctdt.setLoai(loai);

                Res res = uploadService.createFolder(tenCtdt, chuanKDCL.getIdGoogleDrive());
                ctdt.setIdGoogleDrive(res.getUrl());

                ctdtService.insertCTDT(ctdt);
                return ResponseEntity.ok("OK");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
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
            CTDT ctdt = ctdtService.getThongTinChuongTrinhDaoTao(maCtdt);
            uploadService.deleteGoogleDrive(ctdt.getIdGoogleDrive());
            ctdtService.deleteCTDT(maCtdt);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PostMapping("/copydata")
public ResponseEntity<String> copyData(@RequestBody JsonNode formData) {
    // Fetch the original and new CTDT objects
    CTDT originalCtdt = ctdtService.getThongTinChuongTrinhDaoTao(formData.get("maCtdt_1").asText());
    CTDT newCtdt = ctdtService.getThongTinChuongTrinhDaoTao(formData.get("maCtdt_2").asText());
    newCtdt.setMaCtdt(formData.get("maCtdt_2").asText());

    // Initialize and clear the existing TieuChuan list in newCtdt
    List<TieuChuan> existingTieuChuanList = newCtdt.getTieuChuan();
    existingTieuChuanList.clear();

    // Copy TieuChuan, TieuChi, MocChuan, and GoiY
    List<TieuChuan> newTieuChuanList = originalCtdt.getTieuChuan().stream()
        .map(originalTieuChuan -> {
            TieuChuan newTieuChuan = new TieuChuan();
            newTieuChuan.setTenTieuChuan(originalTieuChuan.getTenTieuChuan());
            newTieuChuan.setStt(originalTieuChuan.getStt());
            newTieuChuan.setCtdt(newCtdt); // Maintain bi-directional relationship
            
            // Create folder in Google Drive
            try {
                String tenGoogleDrive = "Tiêu chuẩn " + originalTieuChuan.getStt() + ". " + originalTieuChuan.getTenTieuChuan();
                Res folderRes = uploadService.createFolder(tenGoogleDrive, newCtdt.getIdGoogleDrive());
                newTieuChuan.setIdGoogleDrive(folderRes.getUrl());
            } catch (GeneralSecurityException | IOException e) {
                throw new RuntimeException("Error processing TieuChuan: " + originalTieuChuan.getTenTieuChuan(), e);
            }

            // Copy TieuChi and related data
            List<TieuChi> newTieuChiList = originalTieuChuan.getTieuChi().stream()
                .map(originalTieuChi -> {
                    TieuChi newTieuChi = new TieuChi();
                    newTieuChi.setTenTieuChi(originalTieuChi.getTenTieuChi());
                    newTieuChi.setStt(originalTieuChi.getStt());
                    newTieuChi.setYeuCau(originalTieuChi.getYeuCau());
                    newTieuChi.setTieuChuan(newTieuChuan); // Maintain bi-directional relationship

                    // Create folder in Google Drive
                    try {
                        String tenGoogleDrive = "Tiêu chí " + originalTieuChi.getStt() + ". " + originalTieuChi.getTenTieuChi();
                        Res folderRes = uploadService.createFolder(tenGoogleDrive, newTieuChuan.getIdGoogleDrive());
                        newTieuChi.setIdGoogleDrive(folderRes.getUrl());
                    } catch (GeneralSecurityException | IOException e) {
                        throw new RuntimeException("Error processing TieuChi: " + originalTieuChi.getTenTieuChi(), e);
                    }

                    // Copy MocChuan and GoiY
                    List<MocChuan> newMocChuanList = originalTieuChi.getMocChuan().stream()
                        .map(originalMocChuan -> {
                            MocChuan newMocChuan = new MocChuan();
                            newMocChuan.setTenMocChuan(originalMocChuan.getTenMocChuan());
                            newMocChuan.setTieuChi(newTieuChi); // Maintain bi-directional relationship

                            List<GoiY> newGoiYList = originalMocChuan.getGoiY().stream()
                                .map(originalGoiY -> {
                                    GoiY newGoiY = new GoiY();
                                    newGoiY.setTenGoiY(originalGoiY.getTenGoiY());
                                    newGoiY.setBatBuoc(originalGoiY.getBatBuoc());
                                    return newGoiY;
                                }).collect(Collectors.toList());

                            newMocChuan.setGoiY(newGoiYList);
                            return newMocChuan;
                        }).collect(Collectors.toList());

                    newTieuChi.setMocChuan(newMocChuanList);
                    return newTieuChi;
                }).collect(Collectors.toList());

            newTieuChuan.setTieuChi(newTieuChiList);
            return newTieuChuan;
        }).collect(Collectors.toList());

    // Add new TieuChuan to the existing collection
    existingTieuChuanList.addAll(newTieuChuanList);

    // Update and save the new CTDT
    ctdtService.updateCTDTCopy(newCtdt);
    return ResponseEntity.ok("OK");
}
}
