package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.Khoa;
import com.example.qlmc.service.KhoaService;



@RestController
@RequestMapping("/api/khoa")
public class KhoaController {

    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public ResponseEntity<List<Khoa>> getAllKhoa() {
        return ResponseEntity.ok(khoaService.getAllKhoa());
    }
}