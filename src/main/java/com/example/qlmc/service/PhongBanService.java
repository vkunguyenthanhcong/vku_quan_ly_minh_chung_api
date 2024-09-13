package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.PhongBan;
import com.example.qlmc.repository.PhongBanRepository;

import jakarta.transaction.Transactional;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
    @Modifying
    public void createNewPhongBan(PhongBan phongBan){
        phongBanRepository.save(phongBan);
    }
    @Modifying
    public void editTenPhongBan(PhongBan phongBan){
        PhongBan data = phongBanRepository.findById(phongBan.getIdPhongBan()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        data.setTenPhongBan(phongBan.getTenPhongBan());
        phongBanRepository.save(data);
    }
    @Transactional
    public void deletePhongBan(int idPhongBan){
        phongBanRepository.deleteById(idPhongBan);
    }
}
