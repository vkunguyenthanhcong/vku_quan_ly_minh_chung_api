package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.Nganh;
import com.example.qlmc.service.NganhService;



@RestController
@RequestMapping("/api/nganh")
public class NganhController {

    @Autowired
    private  NganhService nganhService;

    @GetMapping
    public ResponseEntity<List<Nganh>> getAllNganh() {
        return ResponseEntity.ok(nganhService.getAllNganh());
    }
}