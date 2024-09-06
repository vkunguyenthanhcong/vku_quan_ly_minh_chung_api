package com.example.qlmc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.TieuChi;
import com.example.qlmc.service.TieuChiService;


@RestController
@RequestMapping("/api/tieuchi")
public class TieuChiController {

    @Autowired
    private TieuChiService tieuChiService;

    @GetMapping
    public ResponseEntity<List<TieuChi>> getAllTieuChi() {
        return ResponseEntity.ok(tieuChiService.getAllTieuChi());
    }

    @GetMapping("/{idTieuChuan}")
    public ResponseEntity<List<TieuChi>> getAllTieuChiWithIdTieuChuan(@PathVariable int idTieuChuan){   
        return ResponseEntity.ok(tieuChiService.getAllTieuChiWithIdTieuChuan(idTieuChuan)); 
    }


    @GetMapping("/findById/{idTieuChi}")
    public ResponseEntity<Optional<TieuChi>> findById(@PathVariable int idTieuChi) {
        return ResponseEntity.ok(tieuChiService.findById(idTieuChi));
    }
    @GetMapping("/findByMaCtdt/{maCtdt}")
    public ResponseEntity<List<TieuChi>> findByMaCtdt(@PathVariable String maCtdt) {
        return ResponseEntity.ok(tieuChiService.findByMaCtdt(maCtdt));
    }


    
}