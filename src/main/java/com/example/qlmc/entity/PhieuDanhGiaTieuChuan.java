package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phieudanhgiatieuchuan")
public class PhieuDanhGiaTieuChuan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phieudanhgiatieuchuan")
    private int idPhieuDanhGiaTieuChuan;

    @Column(name = "id_phongban")
    private int idPhongBan;

    @Column(name = "id_tieuchuan")
    private int idTieuChuan;

    @Column(name = "kehoach")
    private String keHoach;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "diemmanh")
    private String diemManh;

    @Column(name = "diemtontai")
    private String diemTonTai;

    @Column(name = "mucdanhgia")
    private String mucDanhGia;

}
