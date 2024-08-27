package com.example.qlmc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.repository.TieuChiRepository;

@Service
public class TieuChiService {

    @Autowired
    private TieuChiRepository tieuChiRepository;
  


    public List<TieuChi> getAllTieuChi() {
        return tieuChiRepository.findAll();
    }
    public List<TieuChi> getAllTieuChiWithIdTieuChuan(int idTieuChuan) {
        return tieuChiRepository.findByIdTieuChuan(idTieuChuan);
    }
    
    public Optional<TieuChi> findById(int idTieuChi){
        return tieuChiRepository.findById(idTieuChi);
    }
    public List<TieuChi> findByMaCtdt(String maCtdt) {
        return tieuChiRepository.findByMaCtdt(maCtdt);
    }

}