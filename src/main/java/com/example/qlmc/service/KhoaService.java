package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.Khoa;
import com.example.qlmc.repository.KhoaRepository;

@Service
public class KhoaService {
    @Autowired
private KhoaRepository khoaRepository;


    public List<Khoa> getAllKhoa() {
        return khoaRepository.findAll();
    }

}
