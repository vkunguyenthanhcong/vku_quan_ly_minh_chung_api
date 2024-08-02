package com.example.qlmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
