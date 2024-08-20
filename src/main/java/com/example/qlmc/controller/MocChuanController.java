package com.example.qlmc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<MocChuan> getAllMocChuan() {
        return service.getAllMocChuan();
    }
    
    @GetMapping("/findByIdTieuChi/{idTieuChi}")
    public List<MocChuan> findByIdTieuChi(@PathVariable int idTieuChi) {
        return service.findByTieuChi(idTieuChi);
    }
}
