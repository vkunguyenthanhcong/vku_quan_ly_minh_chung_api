package com.example.qlmc.controller;

import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.service.ChuanKDCLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chuankdcl")
public class UserController {

    @Autowired
    private ChuanKDCLService chuanKDCLService;

    @GetMapping
    public List<ChuanKDCL> getAllChuanKDCL() {
        return chuanKDCLService.getAllChuanKDCLs();
    }
}
