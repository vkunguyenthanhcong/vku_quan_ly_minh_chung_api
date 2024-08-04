package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.LoaiMinhChung;
import com.example.qlmc.repository.LoaiMinhChungRepository;

@Service
public class LoaiMinhChungService {
    @Autowired
    private LoaiMinhChungRepository loaiMinhChungRepository;


    public List<LoaiMinhChung> getAllLoaiMinhChung() {
        return loaiMinhChungRepository.findAll();
    }

}
