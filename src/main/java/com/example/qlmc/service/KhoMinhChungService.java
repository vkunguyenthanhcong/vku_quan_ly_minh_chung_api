package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.entity.LoaiMinhChung;
import com.example.qlmc.repository.KhoMinhChungRepository;
import com.example.qlmc.repository.LoaiMinhChungRepository;

@Service
public class KhoMinhChungService {
    @Autowired
    private KhoMinhChungRepository khoMinhChungRepository;


    public List<KhoMinhChung> getAllKhoMinhChung() {
        return khoMinhChungRepository.findAll();
    }

    public KhoMinhChung saveData(KhoMinhChung data){
        return khoMinhChungRepository.save(data);
    }
}
