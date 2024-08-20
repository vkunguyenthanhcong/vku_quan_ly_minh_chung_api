package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.service.TieuChiService;


@RestController
@RequestMapping("/api/tieuchi")
public class TieuChiController {

    @Autowired
    private TieuChiService tieuChiService;

    @GetMapping
    public List<TieuChi> getAllTieuChi() {
        return tieuChiService.getAllTieuChi();
    }
    @GetMapping("/{idTieuChuan}")
    public List<TieuChi> getAllTieuChiWithIdTieuChuan(@PathVariable int idTieuChuan) {
        return tieuChiService.getAllTieuChiWithIdTieuChuan(idTieuChuan);
    }

    @GetMapping("/findById/{idTieuChi}")
    public Optional<TieuChi> findById(@PathVariable int idTieuChi) {
        return tieuChiService.findById(idTieuChi);
    }
    @GetMapping("/findByMaCtdt/{maCtdt}")
    public List<TieuChi> findByMaCtdt(@PathVariable String maCtdt) {
        return tieuChiService.findByMaCtdt(maCtdt);
    }


    
}