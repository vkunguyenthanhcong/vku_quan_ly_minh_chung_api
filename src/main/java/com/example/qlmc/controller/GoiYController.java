package com.example.qlmc.controller;

import java.util.List;
import java.util.Optional;

import com.example.qlmc.entity.MocChuan;
import com.example.qlmc.service.MocChuanService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.service.GoiYService;

@RestController
@RequestMapping("/api/goiy")
public class GoiYController {

    @Autowired
    private GoiYService goiYService;
    @Autowired
    private MocChuanService mocChuanService;

    @GetMapping
    public ResponseEntity<List<GoiY>> getAllGoiY() {
        return ResponseEntity.ok(goiYService.getAllGoiY());
    }

    @PostMapping
    public ResponseEntity<String> saveGoiY(@RequestBody JsonNode formData) {
        try{
            GoiY goiY = new GoiY();
            String goiYString = formData.get("ten").asText();
            int idMocChuan = Integer.parseInt(formData.get("idParent").asText());
            int batBuoc = formData.get("batBuoc").asInt();
            goiY.setTenGoiY(goiYString);
            goiY.setIdMocChuan(idMocChuan);
            goiY.setBatBuoc(batBuoc);

            goiYService.saveData(goiY);
            return ResponseEntity.ok("OK");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }
    @PutMapping
    public ResponseEntity<String> updateGoiY(@RequestBody JsonNode formData) {
        try{
            int idGoiY = formData.get("id").asInt();
            GoiY goiY =  goiYService.findById(idGoiY);

            String goiYString = formData.get("ten").asText();
            int batBuoc = formData.get("batBuoc").asInt();

            goiY.setTenGoiY(goiYString);
            goiY.setBatBuoc(batBuoc);

            goiYService.saveData(goiY);
            return ResponseEntity.ok("OK");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @GetMapping("/findById/{idGoiY}")
    public ResponseEntity<GoiY> findById(@PathVariable int idGoiY){
        return ResponseEntity.ok(goiYService.findById(idGoiY));
    }
}
