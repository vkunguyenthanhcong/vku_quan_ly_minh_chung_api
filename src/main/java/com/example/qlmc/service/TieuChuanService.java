package com.example.qlmc.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.TieuChuan;
import com.example.qlmc.repository.TieuChuanRepository;

@Service
public class TieuChuanService {

    @Autowired
    private TieuChuanRepository tieuChuanRepository;

    public List<TieuChuan> getAllTieuChuan() {
        return tieuChuanRepository.findAll();
    }
    public void deleteTieuChuan(int id){
        tieuChuanRepository.deleteById(id);
    }
    public TieuChuan findById(int id) {
        return tieuChuanRepository.findById(id).orElse(null);
    }
    public Boolean insertNewTieuChuan(TieuChuan tieuChuan) {
        try {
            tieuChuanRepository.save(tieuChuan);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TieuChuan> findByMaCtdt(String maCtdt) {
        return tieuChuanRepository.findByMaCtdt(maCtdt);
    }
    public TieuChuan findByIdGoogleDrive(String idGoogleDrive) {
        return tieuChuanRepository.findByIdGoogleDrive(idGoogleDrive);
    }
    public void updateTieuChuan(JsonNode formData){
        TieuChuan tc = tieuChuanRepository.findById(formData.get("id").asInt()).orElseThrow(() -> new RuntimeException("Product not found"));
        tc.setTenTieuChuan(formData.get("ten").asText());
        tc.setStt(formData.get("stt").asInt());
        tieuChuanRepository.save(tc);
    }
}