package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/listandcount/{maCtdt}")
    public List<Map<String, Object>> getListTieuChuanAndCount(@PathVariable String maCtdt){
        List<Object[]> result = tieuChuanService.getListTieuChuanAndCount(maCtdt);
        return result.stream()
                .map(row -> Map.of(
                    "idTieuChuan", row[0],
                    "tenTieuChuan", row[1],
                    "total", row[2]))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TieuChuan findById(@PathVariable int id) {
        return tieuChuanService.findById(id);
    }
    
}