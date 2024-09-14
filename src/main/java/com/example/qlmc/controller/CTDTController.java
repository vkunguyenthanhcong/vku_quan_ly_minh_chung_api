package com.example.qlmc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.qlmc.entity.CTDT;
import com.example.qlmc.service.CTDTService;

@RestController
@RequestMapping("/api/ctdt")
public class CTDTController {

    @Autowired
    private CTDTService ctdtService;

    @GetMapping
    public ResponseEntity<List<CTDT>> getAllCTDT() {
        return ResponseEntity.ok(ctdtService.getAllCTDT());
    }

    @GetMapping("/filter/{maKdcl}")
    public ResponseEntity<List<CTDT>> getAllCTDTByMaKDCL(@PathVariable String maKdcl) {
        return ResponseEntity.ok(ctdtService.getAllCTDTByMaKDCL(maKdcl));
    }

    @GetMapping("/detail/{maCtdt}")
    public ResponseEntity<Optional<CTDT>> getThongTinChuongTrinhDaoTao(@PathVariable String maCtdt) {
        Optional<CTDT> response = ctdtService.getThongTinChuongTrinhDaoTao(maCtdt);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCTDT(@RequestBody CTDT data) {
        try {
            String tenCtdt = data.getTenCtdt();
            String maKhoa = data.getMaKhoa();
            String maNganh = data.getMaNganh();
            int idCtdt = data.getIdCtdt();

            ctdtService.updateCTDT(tenCtdt, maKhoa, maNganh, idCtdt);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{idCtdt}")
    public ResponseEntity<String> deleteCTDT(@PathVariable(value = "idCtdt") int idCtdt) {
        try {
            ctdtService.deleteCTDT(idCtdt);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

}
