package com.example.qlmc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.PhanCongDanhGia;
import com.example.qlmc.repository.PhanCongDanhGiaRepository;

@Service
public class PhanCongDanhGiaService {
    @Autowired
    private PhanCongDanhGiaRepository phanCongDanhGiaRepository;

    public List<PhanCongDanhGia> getAllPhanCongDanhGia(){
        return phanCongDanhGiaRepository.findAll();
    }
    public void insertNew(PhanCongDanhGia data){
        phanCongDanhGiaRepository.save(data);
    }
    public void deletePhanCong(int idPhanCong){
        phanCongDanhGiaRepository.deleteById(idPhanCong);
    }
    public void updatePhanCong(PhanCongDanhGia data){
        phanCongDanhGiaRepository.save(data);
    }
    public List<PhanCongDanhGia> findAllPhanCongByIdPhongBan(int idPhongBan, String maKdcl){
        return phanCongDanhGiaRepository.findAllByIdPhongBanAndMaKdcl(idPhongBan, maKdcl);
    }
}

