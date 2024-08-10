package com.example.qlmc.service;

import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.repository.ChuanKDCLRepository;

import jakarta.transaction.Transactional;

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
    @Transactional
    public void updateTenKdcl(String tenKdcl, int idKdcl){
        chuanKDCLRepository.updateTenKdcl(tenKdcl, idKdcl);
    }
    @Transactional
    public void updateNamBanHanh(String namBanHanh, int idKdcl){
        chuanKDCLRepository.updateNamBanHanh(namBanHanh, idKdcl);
    }

    @Transactional
    public void deleteChuanKDCL(int idKdcl){
        chuanKDCLRepository.deleteChuanKDCL(idKdcl);
    }
    
}