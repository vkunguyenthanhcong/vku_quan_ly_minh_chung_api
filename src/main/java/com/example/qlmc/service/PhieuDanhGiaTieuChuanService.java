package com.example.qlmc.service;

import com.example.qlmc.entity.PhieuDanhGiaTieuChuan;
import com.example.qlmc.repository.PhieuDanhGiaTieuChuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuDanhGiaTieuChuanService {
    @Autowired
    private PhieuDanhGiaTieuChuanRepository phieuDanhGiaTieuChuanRepository;

    public List<PhieuDanhGiaTieuChuan> getAllPhieuDanhGiaTieuChuan (){
        return phieuDanhGiaTieuChuanRepository.findAll();
    }
    public PhieuDanhGiaTieuChuan findById(int id){
        return phieuDanhGiaTieuChuanRepository.findById(id).get();
    }
    public void savePhieuDanhGia (PhieuDanhGiaTieuChuan phieuDanhGiaTieuChuan){
        phieuDanhGiaTieuChuanRepository.save(phieuDanhGiaTieuChuan);
    }
}
