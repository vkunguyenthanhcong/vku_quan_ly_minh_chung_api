package com.example.qlmc.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

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
    @Autowired
    private TieuChuanService tieuChuanService;
    @Autowired
    private TieuChiService tieuChiService;
    @Autowired
    private MocChuanService mocChuanService;
    @Autowired
    private GoiYService goiYService;
    @Autowired
    private MinhChungService minhChungService;

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
        try{
            String maCtdt_1 = formData.get("maCtdt_1").asText();// ctdt goc
            CTDT ctdt_1 = ctdtService.getThongTinChuongTrinhDaoTao(maCtdt_1);
            String maCtdt_2 = formData.get("maCtdt_2").asText();// ctdt moi
            CTDT ctdt_2 = ctdtService.getThongTinChuongTrinhDaoTao(maCtdt_2);
            List<TieuChuan> listTieuChuan = tieuChuanService.findByMaCtdt(maCtdt_1);
            for (TieuChuan tc : listTieuChuan) {
                TieuChuan newTieuChuan = new TieuChuan();
                newTieuChuan.setTenTieuChuan(tc.getTenTieuChuan());
                newTieuChuan.setStt(tc.getStt());
                newTieuChuan.setCtdt(ctdt_2);
                try {
                    String tenGoogleDrive = "Tiêu chuẩn " + tc.getStt() + ". " + tc.getTenTieuChuan();
                    Res folderRes = uploadService.createFolder(tenGoogleDrive, ctdt_2.getIdGoogleDrive());
                    newTieuChuan.setIdGoogleDrive(folderRes.getUrl());
                    tieuChuanService.insertNewTieuChuan(newTieuChuan);
                } catch (GeneralSecurityException | IOException e) {
                    throw new RuntimeException("Error processing TieuChuan: " + tc.getTenTieuChuan(), e);
                }
            }
            insertTieuChi(maCtdt_1, maCtdt_2);
            return ResponseEntity.ok("OK");
        }catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    public void insertTieuChi(String maCtdtGoc, String maCtdtMoi) {
        List<TieuChuan> listTieuChuanGoc = tieuChuanService.findByMaCtdt(maCtdtGoc);
        List<TieuChuan> listTieuChuanMoi = tieuChuanService.findByMaCtdt(maCtdtMoi);
        listTieuChuanGoc.forEach(tieuChuanGoc -> {
            TieuChuan matchingTieuChuanMoi = listTieuChuanMoi.stream()
                            .filter(tieuChuanMoi -> tieuChuanMoi.getStt() == tieuChuanGoc.getStt())
                            .findFirst()
                            .orElse(null);
                    if (matchingTieuChuanMoi != null) {
                        List<TieuChi> listTieuChiGoc = tieuChiService.findByIdTieuChuan(tieuChuanGoc.getIdTieuChuan());

                        listTieuChiGoc.forEach(tieuChiGoc -> {
                            TieuChi newTieuChi = new TieuChi();
                            newTieuChi.setTenTieuChi(tieuChiGoc.getTenTieuChi());
                            newTieuChi.setStt(tieuChiGoc.getStt());
                            newTieuChi.setYeuCau(tieuChiGoc.getYeuCau());
                            newTieuChi.setTieuChuan(matchingTieuChuanMoi);
                            try {
                                String tenGoogleDrive = "Tiêu chí " + tieuChiGoc.getStt() + ". " + tieuChiGoc.getTenTieuChi();
                                Res res = uploadService.createFolder(tenGoogleDrive, matchingTieuChuanMoi.getIdGoogleDrive());
                                newTieuChi.setIdGoogleDrive(res.getUrl());
                                tieuChiService.insertNewTieuChi(newTieuChi);

                            } catch (Exception e) {
                                e.printStackTrace();
                                throw new RuntimeException("Error inserting TieuChi", e);
                            }
                        });
                        insertMocChuan(tieuChuanGoc.getIdTieuChuan(), matchingTieuChuanMoi.getIdTieuChuan());

                    } else {
                        System.out.println("No matching TieuChuan found for Stt: " + tieuChuanGoc.getStt());
                    }
        }
        );
    }
    public void insertMocChuan(int idTieuChuanGoc, int idTieuChuanMoi) {
        List<TieuChi> listTieuChiGoc = tieuChiService.findByIdTieuChuan(idTieuChuanGoc);
        List<TieuChi> listTieuChiMoi = tieuChiService.findByIdTieuChuan(idTieuChuanMoi);
        listTieuChiGoc.forEach(tieuChiGoc -> {
                    TieuChi matchingTieuChiMoi = listTieuChiMoi.stream()
                            .filter(tieuChiMoi -> tieuChiMoi.getStt() == tieuChiGoc.getStt())
                            .findFirst()
                            .orElse(null);
                    if (matchingTieuChiMoi != null) {
                        List<MocChuan> listMocChuanGoc = mocChuanService.findByIdTieuChi(tieuChiGoc.getIdTieuChi());

                        listMocChuanGoc.forEach(mocChuanGoc -> {
                            MocChuan newMocChuan = new MocChuan();
                            newMocChuan.setTenMocChuan(mocChuanGoc.getTenMocChuan());
                            newMocChuan.setTieuChi(matchingTieuChiMoi);
                            int idMocChuanMoi = mocChuanService.insertMocChuan(newMocChuan);
                            insertNewGoiY(mocChuanGoc.getIdMocChuan(), idMocChuanMoi);
                        });
                    } else {
                        System.out.println("No matching TieuChuan found for Stt: " + tieuChiGoc.getStt());
                    }


                }
        );
    }
    public void insertNewGoiY(int idMocChuanGoc, int idMocChuanMoi) {
        List<GoiY> listGoiYGoc = goiYService.findByIdMocChuan(idMocChuanGoc);
        MocChuan mocChuanMoi = mocChuanService.findById(idMocChuanMoi);
        listGoiYGoc.forEach(goiY -> {
            GoiY newGoiY = new GoiY();
            newGoiY.setTenGoiY(goiY.getTenGoiY());
            newGoiY.setBatBuoc(goiY.getBatBuoc());
            newGoiY.setMocChuan(mocChuanMoi);
            goiYService.saveData(newGoiY);

            List<MinhChung> listMinhChung = minhChungService.findByIdGoiY(goiY.getIdGoiY());
            listMinhChung.forEach(mc -> {
                
            });
        });
    }

}
