package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="chuankdcl")
public class ChuanKDCL {

    @Id
    @Column(name = "ma_kdcl")
    private String maKdcl;
    @Column(name = "ten_kdcl")
    private String tenKdcl;
    @Column(name = "nambanhanh")
    private String namBanHanh;
    @Column(name = "soluongtieuchuan")
    private int soLuongTieuChuan;

    @Column(name = "id_ggdrive")
    private String idGoogleDrive;

}