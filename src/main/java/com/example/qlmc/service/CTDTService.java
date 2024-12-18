package com.example.qlmc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.CTDT;
import com.example.qlmc.repository.CTDTRepository;

@Service
public class CTDTService {

    @Autowired
    private CTDTRepository ctdtRepository;

    public List<CTDT> getAllCTDT() {
        return ctdtRepository.findAll();
    }
    public List<CTDT> getAllCTDTByMaKDCL(String maKdcl) {
        return ctdtRepository.findAllByMaKDCL(maKdcl);
    }
    public CTDT getThongTinChuongTrinhDaoTao(String maCtdt) {
        return ctdtRepository.getThongTinChuongTrinhDaoTao(maCtdt);
    }
    public List<CTDT> findAllByMaKDCL(String maKdcl){
        return ctdtRepository.findAllByMaKDCL(maKdcl);
    }
    @Modifying
    public void updateCTDT(String maCtdt, String tenCtdt, String maKhoa, String maNganh) {
        ctdtRepository.updateCTDT(tenCtdt, maKhoa, maNganh, maCtdt);
    }
    @Modifying
    public void updateCTDTCopy(CTDT ctdt) {
        ctdtRepository.save(ctdt);
    }
    public void insertCTDT(CTDT ctdt) {
        ctdtRepository.save(ctdt);
    }
    
    public void deleteCTDT(String maCtdt){
        ctdtRepository.deleteById(maCtdt);
    }
}