package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.service.GoiYService;

@RestController
@RequestMapping("/api/goiy")
public class GoiYController {

    @Autowired
    private GoiYService goiYService;

    @GetMapping
    public List<GoiY> getAllGoiY() {
        return goiYService.getAllGoiY();
    }

    @GetMapping("/{idTieuChi}")
    public List<GoiY> getAllGoiYWithIdTieuChi(@PathVariable int idTieuChi) {
        return goiYService.getAllGoiYWithIdTieuChi(idTieuChi);
    }
}
