package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.DonViBanHanh;
import com.example.qlmc.entity.MocChuan;
import com.example.qlmc.repository.MocChuanRepository;

@Service
public class MocChuanService {
    @Autowired
    private MocChuanRepository repository;

    public List<MocChuan> getAllMocChuan() {
        return repository.findAll();
    }

    public List<MocChuan> findByTieuChi(int idTieuChi){
        return repository.findByIdTieuChi(idTieuChi);
    } 
}
