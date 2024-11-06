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
@Table(name = "tieuchuan")
public class TieuChuan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tieuchuan")
    private int idTieuChuan;

    @Column(name = "ten_tieuchuan")
    private String tenTieuChuan;

    @Column(name = "stt")
    private int stt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="ma_ctdt")
    @JsonBackReference
    private CTDT ctdt;

    @JsonProperty("maCtdt")
    public String getMaCtdt() {
        return ctdt.getMaCtdt();
    }

    @Column(name = "id_ggdrive", nullable = true)
    private String idGoogleDrive;

    @OneToMany(mappedBy = "tieuChuan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TieuChi> tieuChi;
}
