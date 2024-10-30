package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tieuchuan")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTieuChuan")
public class TieuChuan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tieuchuan")
    private int idTieuChuan;

    @Column(name = "ten_tieuchuan")
    private String tenTieuChuan;

    @Column(name = "stt")
    private int stt;

    @Column(name = "ma_ctdt")
    private String maCtdt;

    @Column(name = "id_ggdrive", nullable = true)
    private String idGoogleDrive;

}
