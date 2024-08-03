package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.entity.MinhChung;
import com.example.qlmc.service.MinhChungService;


@RestController
@RequestMapping("/api/minhchung")
public class MinhChungController {
    @Autowired
    private MinhChungService service;

    @GetMapping
    public List<MinhChung> getAllMinhChung() {
        return service.getAllMinhChung();
    }
    @GetMapping("/{idGoiY}")
    public List<Map<String, Object>> getAllWithIdGoiY(@PathVariable int idGoiY) {
        List<Object[]> result = service.getAllWithIdGoiY(idGoiY);
        return result.stream()
                .map(row -> Map.of(
                    "idMc", row[0],
                    "maMc", row[1],
                    "idKmc", row[2],
                    "idTieuChuan", row[3],
                    "idGoiY", row[4],
                    "soHieu", row[5],
                    "tenMinhChung", row[6]))
                .collect(Collectors.toList());
    }
}
