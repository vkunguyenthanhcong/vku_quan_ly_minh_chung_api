package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "phancongbaocao")
public class PhanCongDanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int idPhanCong;

    @ManyToOne
    @JoinColumn(name = "id_phongban", referencedColumnName = "id_phongban")
    private PhongBan phongBan;

    @ManyToOne
    @JoinColumn(name = "ma_kdcl", referencedColumnName = "ma_kdcl") 
    private ChuanKDCL chuanKdcl;

    @Column(name="stt_tieuchuan_batdau")
    private int sttTieuChuanBatDau;

    @Column(name="stt_tieuchuan_ketthuc")
    private int sttTieuChuanKetThuc;

    
}
