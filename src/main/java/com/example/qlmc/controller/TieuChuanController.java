package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TieuChuan>> getAllTieuChuan() {
        return ResponseEntity.ok(tieuChuanService.getAllTieuChuan());
    }
    @GetMapping("/listandcount/{maCtdt}")
    public ResponseEntity<List<Map<String, Object>>> getListTieuChuanAndCount(@PathVariable String maCtdt){
        List<Object[]> result = tieuChuanService.getListTieuChuanAndCount(maCtdt);
        List<Map<String, Object>> response = result.stream()
                .map(row -> Map.of(
                    "idTieuChuan", row[0],
                    "tenTieuChuan", row[1],
                    "total", row[2],
                    "stt", row[3]))
                .collect(Collectors.toList());
                return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TieuChuan> findById(@PathVariable int id) {
        return ResponseEntity.ok(tieuChuanService.findById(id));
    }
    
}