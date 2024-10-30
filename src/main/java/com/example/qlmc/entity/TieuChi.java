package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tieuchi")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTieuChi")
public class TieuChi {
    @Id
    @Column(name = "id_tieuchi")
    private int idTieuChi;

    @Column(name = "ten_tieuchi")
    private String tenTieuChi;

    @Column(name = "id_tieuchuan")
    private int idTieuChuan;

    @Column(name = "stt")
    private int stt;

    @Column (name ="yeucau")
    private String yeuCau;

    @Column(name = "id_ggdrive" , nullable = true)
    private String idGoogleDrive;

}
