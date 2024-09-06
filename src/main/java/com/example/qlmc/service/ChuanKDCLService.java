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

    @Transactional
    public void insertNewChuanKdcl(String tenKdcl, String namBanHanh) {
        chuanKDCLRepository.insertNewChuanKdcl(tenKdcl, namBanHanh);
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
        chuanKDCLRepository.deleteChuongTrinhDaoTao(idKdcl);
        chuanKDCLRepository.deleteChuanKDCL(idKdcl);
    }
    
}