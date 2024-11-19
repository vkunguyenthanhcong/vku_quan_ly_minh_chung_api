package com.example.qlmc.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.example.qlmc.entity.*;
import com.example.qlmc.service.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/minhchung")
public class MinhChungController {
    @Autowired
    private MinhChungService service;
    @Autowired
    private KhoMinhChungService khoMinhChungService;
    @Autowired
    private GoiYService goiYService;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private TieuChuanService tieuChuanService;
    @Autowired
    private TieuChiService tieuChiService;
    @Autowired
    private MocChuanService mocChuanService;

    @GetMapping
    public ResponseEntity<List<MinhChung>> getAllMinhChung() {
        return ResponseEntity.ok(service.getAllMinhChung());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> processMinhChung(@RequestParam(value = "idMc") int idMc,@RequestParam (value = "parentMaMc") String parentMaMc) {
        try {
            MinhChung minhChung = service.findById(idMc);
            AtomicInteger firstStt = new AtomicInteger(1000);
            AtomicInteger idTieuChuan = new AtomicInteger(0);
            List<MinhChung> listDungChung = service.findByMaDungChung(minhChung.getIdMc());

            if(!listDungChung.isEmpty()) {
                listDungChung.forEach(item -> {
                    TieuChuan tieuChuan = tieuChuanService.findById(item.getIdTieuChuan());
                    if(tieuChuan.getStt() < firstStt.get()) {
                        firstStt.set(tieuChuan.getStt());
                        idTieuChuan.set(tieuChuan.getIdTieuChuan());
                    }
                });//tim duoc stt tieu chuan nho nhat

                List<MinhChung> filterWithIdTieuChuanNew = listDungChung.stream()
                        .filter(item -> item.getIdTieuChuan() == idTieuChuan.get())
                        .collect(Collectors.toList());

                Optional<MinhChung> minSttItem = filterWithIdTieuChuanNew.stream().min(Comparator.comparing(MinhChung::getSttTieuChi));

                MinhChung changeMinhChung = minSttItem.get();
                TieuChi tieuChi = tieuChiService.findById(changeMinhChung.getIdTieuChi());

                changeMinhChung.setParentMaMc("H"+firstStt.get()+"."+String.format("%02d", firstStt.get())+"."+String.format("%02d", changeMinhChung.getSttTieuChi())+".");
                int totalMinhChungofTieuChi = service.totalMinhChungOfTieuChi(changeMinhChung.getIdTieuChi()) + 1;
                changeMinhChung.setChildMaMc(String.format("%02d", totalMinhChungofTieuChi));
                changeMinhChung.setMaDungChung(0);

                service.UpdateNewMaDungChung(changeMinhChung.getIdMc(), minhChung.getIdMc());
                String newNameFile = changeMinhChung.getParentMaMc()+changeMinhChung.getChildMaMc()+". "+ minhChung.getTenMinhChung();
                Res res = uploadService.createShortcut(newNameFile, tieuChi.getIdGoogleDrive(), changeMinhChung.getKhoMinhChung().getLinkLuuTru());
                changeMinhChung.setLinkLuuTru(res.getUrl());
                service.saveData(changeMinhChung);
            }
            uploadService.removeShortcut(minhChung.getLinkLuuTru());
            service.processMinhChung(idMc, parentMaMc);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> saveMinhChung(@RequestBody JsonNode formData) {
        try {
            Integer idKmc = Integer.parseInt(formData.get("idKmc").asText());
            String folderIdParent = formData.get("folderIdParent").asText();
            String parentMaMc = formData.get("parentMaMc").asText();
            String childMaMc = formData.get("childMaMc").asText();
            KhoMinhChung khoMinhChung = khoMinhChungService.findAllById(idKmc);
            UploadService uploadService = new UploadService();
            String fileName = parentMaMc + childMaMc + ". " + khoMinhChung.getTenMinhChung();
            Res res = uploadService.createShortcut(fileName, folderIdParent, khoMinhChung.getLinkLuuTru());

            Integer idTieuChuan = Integer.parseInt(formData.get("idTieuChuan").asText());
            Integer idGoiY = Integer.parseInt(formData.get("idGoiY").asText());
            GoiY goiY = goiYService.findById(idGoiY);

            MinhChung minhChung = new MinhChung();
            minhChung.setParentMaMc(parentMaMc);
            minhChung.setChildMaMc(childMaMc);
            minhChung.setKhoMinhChung(khoMinhChung);
            minhChung.setIdTieuChuan(idTieuChuan);
            minhChung.setLinkLuuTru(res.getUrl());

            minhChung.setGoiY(goiY);

            service.saveData(minhChung);

            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @PostMapping("/dungchung")
    public ResponseEntity<String> createMinhChung(@RequestBody JsonNode formData) {
        try {
            int idKmc = Integer.parseInt(formData.get("idKmc").asText());
            int idTieuChuan = Integer.parseInt(formData.get("idTieuChuan").asText());
            int idGoiY = Integer.parseInt(formData.get("idGoiY").asText());
            int maDungChung = Integer.parseInt(formData.get("maDungChung").asText());
            service.addMinhChungDungChung(idKmc, idTieuChuan,idGoiY, maDungChung);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping("/down/{idMc}")
    public ResponseEntity<String> downMaMinhChung(@PathVariable int idMc) {
        try{
            MinhChung mc1 = service.findById(idMc);
            String childMaMc = mc1.getChildMaMc();
            int num = Integer.parseInt(childMaMc);
            num = num + 1;
            String childMaMcNext = String.format("%02d", num);
            MinhChung mc2 = service.findByParentChildMaMcInTieuChuan(mc1.getParentMaMc(), childMaMcNext, mc1.getIdTieuChuan());
            service.SwapData(mc1.getIdMc(), mc2.getIdMc());
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping("/up/{idMc}")
    public ResponseEntity<String> upMaMinhChung(@PathVariable int idMc) {
        try{
            MinhChung mc1 = service.findById(idMc);
            String childMaMc = mc1.getChildMaMc();
            int num = Integer.parseInt(childMaMc);
            num = num - 1;
            String childMaMcNext = String.format("%02d", num);
            MinhChung mc2 = service.findByParentChildMaMcInTieuChuan(mc1.getParentMaMc(), childMaMcNext, mc1.getIdTieuChuan());
            service.SwapData(mc1.getIdMc(), mc2.getIdMc());
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }


}
