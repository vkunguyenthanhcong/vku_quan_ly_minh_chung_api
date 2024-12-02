package com.example.qlmc.service;

import java.util.List;

import com.example.qlmc.entity.MocChuan;
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

    public void saveData(GoiY data){
        goiYRepository.save(data);
    }
    public GoiY findById(int idGoiY){
        return goiYRepository.findById(idGoiY).orElse(null);
    }
    public void deleteById(int idGoiY){
        goiYRepository.deleteById(idGoiY);
    }
    public List<GoiY> findByMaCtdt(String maCtdt){
        return goiYRepository.findByMaCtdt(maCtdt);
    }
    public List<GoiY> findByIdMocChuan(int idMocChuan){
        return goiYRepository.findByIdMocChuan(idMocChuan);
    }
}