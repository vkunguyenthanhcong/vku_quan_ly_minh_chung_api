package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.GoiY;
import com.example.qlmc.service.GoiYService;

@RestController
@RequestMapping("/api/goiy")
public class GoiYController {

    @Autowired
    private GoiYService goiYService;

    @GetMapping
    public ResponseEntity<List<GoiY>> getAllGoiY() {
        return ResponseEntity.ok(goiYService.getAllGoiY());
    }

    @GetMapping("/{idMocChuan}")
    public List<Map<String, Object>> getAllWithIdGoiY(@PathVariable int idMocChuan) {
        List<Object[]> result = goiYService.getAllGoiYWithIdMocChuan(idMocChuan);
        return result.stream()
                .map(row -> Map.of(
                    "idGoiY", row[0],
                    "tenGoiY", row[1],
                    "batBuoc", row[2],
                    "idMocChuan", row[3]))
                .collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<String> saveGoiY(@RequestBody GoiY data) {
        try{
            goiYService.saveData(data);
            return ResponseEntity.ok("OK");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @GetMapping("/findById/{idGoiY}")
    public ResponseEntity<Optional<GoiY>> findById(@PathVariable int idGoiY){
        return ResponseEntity.ok(goiYService.findById(idGoiY));
    }
}
