package com.example.qlmc.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.service.KhoMinhChungService;

@RestController
@RequestMapping("/api/khominhchung")
public class KhoMinhChungController {
    @Autowired
    private KhoMinhChungService khoMinhChungService;

    @GetMapping
    public List<KhoMinhChung> getAllKhoMinhChung() {
        return khoMinhChungService.getAllKhoMinhChung();
    }

    @PostMapping
    public KhoMinhChung saveMinhChung(@RequestBody KhoMinhChung data) {
        return khoMinhChungService.saveData(data);
    }
    @GetMapping("/searchByNotDate")
    public List<KhoMinhChung> searchByNotDate(@RequestParam(value = "tenMc") String tenMc, @RequestParam(value = "soHieu") String soHieu,@RequestParam(value = "idLoai") String idLoai) {
        
        return khoMinhChungService.searchByNotDate(tenMc, soHieu, idLoai);
    }
    @GetMapping("/searchByDate")
    public List<KhoMinhChung> searchByDate(@RequestParam(value = "tenMc") String tenMc, @RequestParam(value = "soHieu") String soHieu,@RequestParam(value = "idLoai") String idLoai, @RequestParam(value = "startDate") Date startDate, @RequestParam(value = "endDate") Date endDate) {
        
        return khoMinhChungService.searchByDate(tenMc, soHieu, idLoai, startDate, endDate);
    }
}
