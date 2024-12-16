package com.example.qlmc.controller;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.qlmc.entity.Khoa;
import com.example.qlmc.service.KhoaService;



@RestController
@RequestMapping("/api/khoa")
public class KhoaController {

    @Autowired
    private KhoaService khoaService;

    @GetMapping
    public ResponseEntity<List<Khoa>> getAllKhoa() {
        return ResponseEntity.ok(khoaService.getAllKhoa());
    }

    @PutMapping("/{maKhoa}")
    public ResponseEntity<String> updateKhoa(@PathVariable String maKhoa, @RequestBody JsonNode khoa) {
        System.out.println(maKhoa);
        try {
            String fieldName = khoa.fieldNames().next();
            System.out.println(fieldName);
            String fieldValue = khoa.get(fieldName).asText();
            System.out.println(fieldValue);
            Khoa khoa1 = khoaService.findByMaKhoa(maKhoa);
            if (khoa1 != null) {
                switch (fieldName) {
                    case "tenKhoa":
                        khoa1.setTenKhoa(fieldValue);
                        break;
                    case "web":
                        khoa1.setWeb(fieldValue);
                        break;
                    case "email":
                        khoa1.setEmail(fieldValue);
                        break;
                    case "sdt":
                        khoa1.setSdt(fieldValue);
                        break;
                    // Add other fields as necessary
                    default:
                        return ResponseEntity.badRequest().body("Invalid field: " + fieldName);
                }
                khoaService.changeKhoa(khoa1);
                return ResponseEntity.ok("Khoa updated successfully");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<List<Khoa>> addKhoa(@RequestBody JsonNode khoa) {
        Khoa newKhoa = new Khoa();
        String maKhoa = convertToAcronym(khoa.get("tenKhoa").asText());

        // Check if Khoa with the same maKhoa already exists
        if (khoaService.findByMaKhoa(maKhoa) != null) {
            return ResponseEntity.badRequest().body(null);  // Return 400 Bad Request if maKhoa already exists
        }

        newKhoa.setTenKhoa(khoa.get("tenKhoa").asText());
        newKhoa.setWeb(khoa.get("web").asText());
        newKhoa.setEmail(khoa.get("email").asText());
        newKhoa.setSdt(khoa.get("sdt").asText());
        newKhoa.setMaKhoa(maKhoa);

        // Save the new Khoa
        List<Khoa> khoaList = khoaService.saveKhoa(newKhoa);
        return ResponseEntity.ok(khoaList);
    }
    @DeleteMapping("/{maKhoa}")
    public ResponseEntity<List<Khoa>> deleteKhoa(@PathVariable String maKhoa){
        Khoa khoa = khoaService.findByMaKhoa(maKhoa);
        if(khoa != null){
            return ResponseEntity.ok(khoaService.deleteKhoa(khoa));
        }else{
            return ResponseEntity.badRequest().body(null);
        }
    }

    public String convertToAcronym(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String[] words = input.split("\\s+");
        StringBuilder acronym = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                acronym.append(word.charAt(0));
            }
        }

        return acronym.toString().toUpperCase();
    }


}