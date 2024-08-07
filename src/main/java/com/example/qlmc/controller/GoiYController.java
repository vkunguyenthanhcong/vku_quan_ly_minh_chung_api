package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.entity.MinhChung;
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
    public List<Map<String, Object>> getAllWithIdGoiY(@PathVariable int idTieuChi) {
        List<Object[]> result = goiYService.getAllGoiYWithIdTieuChi(idTieuChi);
        return result.stream()
                .map(row -> Map.of(
                    "idGoiY", row[0],
                    "tenGoiY", row[1],
                    "batBuoc", row[2],
                    "idTieuChi", row[3],
                    "total", row[4]))
                .collect(Collectors.toList());
    }
    @PostMapping
    public GoiY saveGoiY(@RequestBody GoiY data) {
        return goiYService.saveData(data);
    }
}
