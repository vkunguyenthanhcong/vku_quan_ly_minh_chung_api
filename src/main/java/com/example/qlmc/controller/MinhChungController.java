package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.entity.Res;
import com.example.qlmc.service.GoiYService;
import com.example.qlmc.service.KhoMinhChungService;
import com.example.qlmc.service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.MinhChung;
import com.example.qlmc.service.MinhChungService;


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

    @GetMapping
    public ResponseEntity<List<MinhChung>> getAllMinhChung() {
        return ResponseEntity.ok(service.getAllMinhChung());
    }
    @GetMapping("/delete")
    public ResponseEntity<String> processMinhChung(@RequestParam(value = "idMc") int idMc,@RequestParam (value = "parentMaMc") String parentMaMc) {
        try {
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

            MinhChung minhChung = new MinhChung();
            minhChung.setParentMaMc(parentMaMc);
            minhChung.setChildMaMc(childMaMc);
            minhChung.setKhoMinhChung(khoMinhChung);
            minhChung.setIdTieuChuan(idTieuChuan);
            minhChung.setLinkLuuTru(res.getUrl());

            minhChung.setIdGoiY(idGoiY);

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
    
}
