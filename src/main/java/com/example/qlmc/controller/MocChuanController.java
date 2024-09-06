package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.MocChuan;
import com.example.qlmc.service.MocChuanService;


@RestController
@RequestMapping("/api/mocchuan")
public class MocChuanController {
    @Autowired
    private MocChuanService service;

    @GetMapping
    public ResponseEntity<List<MocChuan>> getAllMocChuan() {
        return ResponseEntity.ok(service.getAllMocChuan());
    }
    
    @GetMapping("/findByIdTieuChi/{idTieuChi}")
    public ResponseEntity<List<MocChuan>> findByIdTieuChi(@PathVariable int idTieuChi) {
        return ResponseEntity.ok(service.findByTieuChi(idTieuChi));
    }
}
