package com.example.qlmc.controller;

import com.example.qlmc.entity.CTDT;
import com.example.qlmc.entity.GoiY;
import com.example.qlmc.service.CTDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ctdt")
public class CTDTController {

    @Autowired
    private CTDTService ctdtLService;

    @GetMapping
    public List<CTDT> getAllCTDT() {
        return ctdtLService.getAllCTDT();
    }

    @GetMapping("/grouped")
    public Map<String, List<CTDT>> getGroupedByMaCtdt() {
        return ctdtLService.getGroupedByMaCtdt();
    }
    @GetMapping("/filter/{maKdcl}")
    public List<CTDT> getAllCTDTByMaKDCL(@PathVariable String maKdcl) {
        return ctdtLService.getAllCTDTByMaKDCL(maKdcl);
    }

}
