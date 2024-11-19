package com.example.qlmc.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.repository.TieuChiRepository;

@Service
public class TieuChiService {

    @Autowired
    private TieuChiRepository tieuChiRepository;
  

    public List<TieuChi> findAll() {
        return tieuChiRepository.findAll();
    }
    public void deleteTieuChi(int id){
        tieuChiRepository.deleteById(id);
    }

    public TieuChi findById(int idTieuChi){
        return tieuChiRepository.findById(idTieuChi).orElse(null);
    }

    public List<TieuChi> findByIdTieuChuan(int idTieuChuan){
        return tieuChiRepository.findTieuChiByIdTieuChuan(idTieuChuan);
    }

    public void insertNewTieuChi(TieuChi tieuChi){
        tieuChiRepository.save(tieuChi);
    }
    public void updateTieuChi(JsonNode formData){
        TieuChi tc = tieuChiRepository.findById(formData.get("id").asInt()).orElse(null);
        tc.setTenTieuChi(formData.get("ten").asText());
        tc.setStt(formData.get("stt").asInt());
        tc.setYeuCau(formData.get("yeuCau").asText());
        tieuChiRepository.save(tc);
    }

}