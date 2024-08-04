package com.example.qlmc.controller;

import java.util.List;
import com.example.qlmc.entity.LoaiMinhChung;
import com.example.qlmc.service.LoaiMinhChungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/loaiminhchung")
public class LoaiMinhChungController {

    @Autowired
    private LoaiMinhChungService loaiMinhChungService;

    @GetMapping
    public List<LoaiMinhChung> getAllLoaiMinhChung() {
        return loaiMinhChungService.getAllLoaiMinhChung();
    }

    
}