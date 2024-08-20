package com.example.qlmc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.TieuChuan;   
import com.example.qlmc.repository.TieuChuanRepository;

@Service
public class TieuChuanService {

    @Autowired
    private TieuChuanRepository tieuChuanRepository;
  
    
    private List<TieuChuan> tieuChuanList;

    public List<TieuChuan> getAllTieuChuan() {
        return tieuChuanRepository.findAll();
    }

    public TieuChuan findById(int id) {
        return tieuChuanRepository.findById(id).orElse(null);
    }
    public List<TieuChuan> getTieuChuanByMaCtdt(String maCtdt) {
        return tieuChuanRepository.findByMaCtdt(maCtdt);
    }
    public List<Object[]> getListTieuChuanAndCount(String maCtdt){
        return tieuChuanRepository.getListTieuChuanAndCount(maCtdt);
    }
    
}