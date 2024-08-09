package com.example.qlmc.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.repository.KhoMinhChungRepository;

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
    public List<KhoMinhChung> searchByNotDate(String tenMc, String soHieu, String idLoai){
        if(tenMc != null && soHieu != null && idLoai != null){
            return khoMinhChungRepository.searchByNotDate(tenMc, soHieu, idLoai);
        } else {
            if (tenMc == null) {
                tenMc = "";
            }
            if (soHieu == null) {
                soHieu = "";
            }
            if (idLoai == null) {
                idLoai = "";
            }
            return khoMinhChungRepository.searchByNotDate(tenMc, soHieu, idLoai);
        }
    }
    public List<KhoMinhChung> searchByDate(String tenMc, String soHieu, String idLoai, Date startDate, Date endDate){
        if(tenMc != null && soHieu != null && idLoai != null){
            return khoMinhChungRepository.searchByDate(tenMc, soHieu, idLoai,startDate, endDate);
        } else {
            if (tenMc == null) {
                tenMc = "";
            }
            if (soHieu == null) {
                soHieu = "";
            }
            if (idLoai == null) {
                idLoai = "";
            }
            return khoMinhChungRepository.searchByDate(tenMc, soHieu, idLoai, startDate, endDate);
        }
    }
    public Optional<KhoMinhChung> findAllById(int idKmc){
        return khoMinhChungRepository.findById(idKmc);
    }
    
    public KhoMinhChung updateKhoMinhChung(int idKmc, KhoMinhChung data) {
        data.setIdKhoMinhChung(idKmc);
        return khoMinhChungRepository.save(data);
    }
}