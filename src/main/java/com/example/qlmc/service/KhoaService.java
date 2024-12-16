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

    public Khoa getKhoaById(String id) {
        return khoaRepository.findById(id).orElse(null);
    }

    public void changeKhoa(Khoa khoa) {
        Khoa khoa1 = khoaRepository.findByMaKhoa(khoa.getMaKhoa());
        if(khoa1 != null) {
            khoaRepository.save(khoa);
        }
    }
    public Khoa findByMaKhoa(String maKhoa) {
        return khoaRepository.findByMaKhoa(maKhoa);
    }
    public List<Khoa> saveKhoa(Khoa khoa){
        khoaRepository.save(khoa);
        return khoaRepository.findAll();
    }
    public List<Khoa> deleteKhoa(Khoa khoa){
         khoaRepository.delete(khoa);
         return khoaRepository.findAll();
    }
    

}
