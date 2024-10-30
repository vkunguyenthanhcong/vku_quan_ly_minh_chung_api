package com.example.qlmc.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.DonViBanHanh;
import com.example.qlmc.entity.MocChuan;
import com.example.qlmc.repository.MocChuanRepository;

@Service
public class MocChuanService {
    @Autowired
    private MocChuanRepository repository;
    @Autowired
    private MocChuanRepository mocChuanRepository;

    public List<MocChuan> getAllMocChuan() {
        return repository.findAll();
    }

    public MocChuan findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void insertMocChuan(MocChuan mocChuan) {
        repository.save(mocChuan);
    }
    public void updateMocChuan(JsonNode formData) {
        MocChuan mocChuan = mocChuanRepository.findById(formData.get("id").asInt()).orElse(null);
        mocChuan.setTenMocChuan(formData.get("ten").asText());
        mocChuanRepository.save(mocChuan);
    }
}
