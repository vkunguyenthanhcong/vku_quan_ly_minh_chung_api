package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.repository.ChuanKDCLRepository;

import jakarta.transaction.Transactional;

@Service
public class ChuanKDCLService {

    @Autowired
    private ChuanKDCLRepository chuanKDCLRepository;

    public List<ChuanKDCL> getAllChuanKDCLs() {
        return chuanKDCLRepository.findAll();
    }

    public ChuanKDCL getChuanKdclByMaKdcl(String maKdcl){
        return chuanKDCLRepository.findById(maKdcl).orElse(null);
    }

    @Transactional
    public void insertNewChuanKdcl(String tenKdcl, String namBanHanh) {
        chuanKDCLRepository.insertNewChuanKdcl(tenKdcl, namBanHanh);
    }

    @Transactional
    public void updateTenKdcl(String tenKdcl, String maKdcl){
        chuanKDCLRepository.updateTenKdcl(tenKdcl, maKdcl);
    }
    @Transactional
    public void updateNamBanHanh(String namBanHanh,String maKdcl){
        chuanKDCLRepository.updateNamBanHanh(namBanHanh, maKdcl);
    }

    @Transactional
    public void deleteChuanKDCL(String maKdcl){
        chuanKDCLRepository.deleteChuongTrinhDaoTao(maKdcl);
        chuanKDCLRepository.deleteChuanKDCL(maKdcl);
    }
    
}