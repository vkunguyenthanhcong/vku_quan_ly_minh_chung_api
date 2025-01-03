package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.PhieuDanhGiaTieuChi;
import com.example.qlmc.repository.PhieuDanhGiaTieuChiRepository;

@Service
public class PhieuDanhGiaTieuChiService {
    @Autowired
    private PhieuDanhGiaTieuChiRepository phieuDanhGiaTieuChiRepository;

    public List<PhieuDanhGiaTieuChi> getAllPhieuDanhGia(){
        return phieuDanhGiaTieuChiRepository.findAll();
    }
    public PhieuDanhGiaTieuChi findById(int id){
        return phieuDanhGiaTieuChiRepository.findById(id).orElse(null);
    }
    public void deletePhieuDanhGia(int idPhieuDanhGia){
        phieuDanhGiaTieuChiRepository.deleteById(idPhieuDanhGia);
    }

    public void insertPhieuDanhGia(PhieuDanhGiaTieuChi phieuDanhGiaTieuChi){
        phieuDanhGiaTieuChiRepository.save(phieuDanhGiaTieuChi);
    }

    public void updatePhieuDanhGia(PhieuDanhGiaTieuChi phieuDanhGiaTieuChi){
        phieuDanhGiaTieuChiRepository.save(phieuDanhGiaTieuChi);
    }

}
