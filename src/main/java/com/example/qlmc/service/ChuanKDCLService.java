package com.example.qlmc.service;

import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.repository.ChuanKDCLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuanKDCLService {

    @Autowired
    private ChuanKDCLRepository chuanKDCLRepository;

    public List<ChuanKDCL> getAllChuanKDCLs() {
        return chuanKDCLRepository.findAll();
    }
}