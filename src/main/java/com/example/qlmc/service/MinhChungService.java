package com.example.qlmc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.MinhChung;
import com.example.qlmc.entity.TieuChuan;
import com.example.qlmc.repository.MinhChungRepository;
import com.example.qlmc.repository.TieuChuanRepository;

@Service
public class MinhChungService {

    @Autowired
    private MinhChungRepository minhChungRepository;


    public List<MinhChung> getAllMinhChung() {
        return minhChungRepository.findAll();
    }

    public List<Object[]> getAllWithIdGoiY(int idGoiY) {
        return minhChungRepository.findAllByIdGoiY(idGoiY);
    }
}