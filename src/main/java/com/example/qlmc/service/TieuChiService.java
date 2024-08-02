package com.example.qlmc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.entity.TieuChuan;
import com.example.qlmc.repository.TieuChiRepository;
import com.example.qlmc.repository.TieuChuanRepository;

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

}