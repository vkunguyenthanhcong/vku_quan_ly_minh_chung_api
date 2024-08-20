package com.example.qlmc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.entity.MinhChung;
import com.example.qlmc.repository.GoiYRepository;

@Service
public class GoiYService {

    @Autowired
    private GoiYRepository goiYRepository;

    public List<GoiY> getAllGoiY() {
        return goiYRepository.findAll();
    }

    public List<Object[]> getAllGoiYWithIdMocChuan(int idMocChuan) {
        return goiYRepository.findAllByIdMocChuan(idMocChuan);
    }

    public GoiY saveData(GoiY data){
        return goiYRepository.save(data);
    }
    public Optional<GoiY> findById(int idGoiY){
        return goiYRepository.findById(idGoiY);
    }
}