package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.TieuChuan;
import com.example.qlmc.service.TieuChuanService;

@RestController
@RequestMapping("/api/tieuchuan")
public class TieuChuanController {

    @Autowired
    private TieuChuanService tieuChuanService;

    @GetMapping
    public List<TieuChuan> getAllTieuChuan() {
        return tieuChuanService.getAllTieuChuan();
    }

    @GetMapping("/{id}")
    public TieuChuan getTieuChuanById(@PathVariable int id) {
        return tieuChuanService.getTieuChuanById(id);
    }
    @GetMapping("/filterMaCtdt/{maCtdt}")
    public List<TieuChuan> getTieuChuanByMaCtdt(@PathVariable String maCtdt) {
        return tieuChuanService.getTieuChuanByMaCtdt(maCtdt);
    }
    
    // @PostMapping
    // public TieuChuan createTieuChuan(@RequestBody TieuChuan tieuChuan) {
    //     return tieuChuanService.saveTieuChuan(tieuChuan);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteTieuChuan(@PathVariable int id) {
    //     tieuChuanService.deleteTieuChuan(id);
    // }
}