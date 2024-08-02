package com.example.qlmc.service;

import com.example.qlmc.entity.CTDT;
import com.example.qlmc.entity.ChuanKDCL;
import com.example.qlmc.repository.CTDTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CTDTService {

    @Autowired
    private CTDTRepository ctdtLRepository;

    public List<CTDT> getAllCTDT() {
        return ctdtLRepository.findAll();
    }
    public Map<String, List<CTDT>> getGroupedByMaCtdt() {
        List<CTDT> data = ctdtLRepository.findAll();

        return data.stream()
                .collect(Collectors.groupingBy(CTDT::getMaKdcl));
    }
    public List<CTDT> getAllCTDTByMaKDCL(String maKdcl) {
        return ctdtLRepository.findAllByMaKDCL(maKdcl);
    }
}