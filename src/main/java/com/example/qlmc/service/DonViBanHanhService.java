package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.DonViBanHanh;
import com.example.qlmc.repository.DonViBanHanhRepository;

@Service
public class DonViBanHanhService {

    @Autowired
    private DonViBanHanhRepository donViBanHanhRepository;

    public List<DonViBanHanh> getAllDonViBanHanh() {
        return donViBanHanhRepository.findAll();
    }
    public DonViBanHanh findById(int id){
        return donViBanHanhRepository.findById(id).orElse(null);
    }
    
}