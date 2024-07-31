package com.example.qlmc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.service.ThongTinCTDTService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ThongTinCTDTController {

    @Autowired
    private ThongTinCTDTService service;

    @GetMapping("/details/{maCtdt}")
    public List<Map<String, Object>> getDetails(@PathVariable String maCtdt) {
        List<Object[]> result = service.getDetails(maCtdt);
        return result.stream()
                .map(row -> Map.of(
                    "ten_kdcl", row[0],
                    "ten_khoa", row[1],
                    "web", row[2],
                    "email", row[3],
                    "sdt", row[4],
                    "ten_nganh", row[5],
                    "trinhdo", row[6],
                    "sotinchi", row[7]))
                .collect(Collectors.toList());
    }
}
