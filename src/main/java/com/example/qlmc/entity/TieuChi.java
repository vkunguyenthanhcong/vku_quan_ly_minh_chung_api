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
public class TieuChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tieuchi")
    private int idTieuChi;

    @Column(name = "ten_tieuchi")
    private String tenTieuChi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="id_tieuchuan")
    @JsonBackReference
    private TieuChuan tieuChuan;

    @JsonProperty("idTieuChuan")
    public int getIdTieuChuan() {
        return tieuChuan.getIdTieuChuan();
    }

    @Column(name = "stt")
    private int stt;

    @Column (name ="yeucau")
    private String yeuCau;

    @Column(name = "id_ggdrive" , nullable = true)
    private String idGoogleDrive;

    @OneToMany(mappedBy = "tieuChi", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<MocChuan> mocChuan;

}
