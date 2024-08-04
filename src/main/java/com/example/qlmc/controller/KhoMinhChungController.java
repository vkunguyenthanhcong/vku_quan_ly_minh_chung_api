package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.service.GoiYService;
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
}
