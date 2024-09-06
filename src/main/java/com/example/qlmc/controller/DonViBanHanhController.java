package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.DonViBanHanh;
import com.example.qlmc.service.DonViBanHanhService;

@RestController
@RequestMapping("/api/donvibanhanh")
public class DonViBanHanhController {

    @Autowired
    private DonViBanHanhService donViBanHanhService;

    @GetMapping
    public ResponseEntity<List<DonViBanHanh>> getAllDonViBanHanh() {
        return ResponseEntity.ok(donViBanHanhService.getAllDonViBanHanh());
    }

}