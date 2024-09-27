package com.example.qlmc.controller;

import java.util.List;
import java.util.Optional;

import com.example.qlmc.entity.*;
import com.example.qlmc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;

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

    @GetMapping("/filter/{maKdcl}")
    public ResponseEntity<List<CTDT>> getAllCTDTByMaKDCL(@PathVariable String maKdcl) {
        return ResponseEntity.ok(ctdtService.getAllCTDTByMaKDCL(maKdcl));
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
            Res res = uploadService.createFolderChuongTrinhDaoTao(tenCtdt, chuanKDCL.getIdGoogleDrive());
            ctdt.setIdGoogleDrive(res.getUrl());

            ctdtService.insertCTDT(ctdt);
            return ResponseEntity.ok("OK");
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
            uploadService.deleteChuongTrinhDaoTao(ctdt.getIdGoogleDrive());
            ctdtService.deleteCTDT(maCtdt);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

}
