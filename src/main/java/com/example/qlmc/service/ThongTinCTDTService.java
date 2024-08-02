package com.example.qlmc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.repository.ThongTinCTDTRepository;

import java.util.List;

@Service
public class ThongTinCTDTService {

    @Autowired
    private ThongTinCTDTRepository repository;

    public List<Object[]> getDetails(String maCtdt) {
        return repository.findDetailsByCtdt(maCtdt);
    }
}