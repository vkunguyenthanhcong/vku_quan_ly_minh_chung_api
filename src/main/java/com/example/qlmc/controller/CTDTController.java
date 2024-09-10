package com.example.qlmc.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Map<String, Object>>> getThongTinChuongTrinhDaoTao(@PathVariable String maCtdt) {
        List<Object[]> result = ctdtService.getThongTinChuongTrinhDaoTao(maCtdt);

        List<Map<String, Object>> response = result.stream()
                .map(row -> Map.of(
                "tenCtdt", row[0],
                "tenKdcl", row[1],
                "tenKhoa", row[2],
                "web", row[3],
                "soDienThoai", row[4],
                "email", row[5],
                "tenNganh", row[6],
                "trinhDo", row[7],
                "soTinChi", row[8],
                "idCtdt", row[9]
        ))
                .collect(Collectors.toList());

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
    public ResponseEntity<String> deleteCTDT(@RequestParam(value = "idCtdt") int idCtdt) {
        try {
            ctdtService.deleteCTDT(idCtdt);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing: " + e.getMessage());
        }
    }

}
