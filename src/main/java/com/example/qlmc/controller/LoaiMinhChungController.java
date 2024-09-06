package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.LoaiMinhChung;
import com.example.qlmc.service.LoaiMinhChungService;



@RestController
@RequestMapping("/api/loaiminhchung")
public class LoaiMinhChungController {

    @Autowired
    private LoaiMinhChungService loaiMinhChungService;

    @GetMapping
    public ResponseEntity<List<LoaiMinhChung>> getAllLoaiMinhChung() {
        return ResponseEntity.ok(loaiMinhChungService.getAllLoaiMinhChung());
    }

    
}