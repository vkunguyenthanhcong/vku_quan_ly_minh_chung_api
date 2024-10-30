package com.example.qlmc.dto;

import com.example.qlmc.entity.MinhChung;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MinhChungDTO {
    private MinhChung minhChung;
    private int idTieuChi;
    private String maCtdt;
}
