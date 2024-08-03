package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.repository.GoiYRepository;

@Service
public class GoiYService {

    @Autowired
    private GoiYRepository goiYRepository;

    public List<GoiY> getAllGoiY() {
        return goiYRepository.findAll();
    }

    public List<Object[]> getAllGoiYWithIdTieuChi(int idTieuChi) {
        return goiYRepository.findAllByIdTieuChi(idTieuChi);
    }
}