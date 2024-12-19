package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.Nganh;
import com.example.qlmc.repository.NganhRepository;

@Service
public class NganhService {
    @Autowired
    private NganhRepository nganhRepository;


    public List<Nganh> getAllNganh() {
        return nganhRepository.findAll();
    }

    public Nganh getNganhById(String id) {
        return nganhRepository.findById(id).orElse(null);
    }
    public List<Nganh> insertNew(Nganh nganh) {
        nganhRepository.save(nganh);
        return nganhRepository.findAll();
    }
    public List<Nganh> updateNganh(Nganh nganh){
        nganhRepository.save(nganh);
        return nganhRepository.findAll();
    }
    public List<Nganh> deleteNganh(Nganh nganh){
        nganhRepository.delete(nganh);
        return nganhRepository.findAll();
    }

}
