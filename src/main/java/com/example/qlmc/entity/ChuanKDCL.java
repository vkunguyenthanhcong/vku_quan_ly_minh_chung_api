package com.example.qlmc.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ChuanKDCL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kdcl")
    private String maKdcl;
    @Column(name = "ten_kdcl")
    private String tenKdcl;
    @Column(name = "nambanhanh")
    private String namBanHanh;
    @Column(name = "soluongtieuchuan")
    private int soLuongTieuChuan;
    
    
    public ChuanKDCL(String maKdcl, String tenKdcl, String namBanHanh, int soLuongTieuChuan) {
        this.maKdcl = maKdcl;
        this.tenKdcl = tenKdcl;
        this.namBanHanh = namBanHanh;
        this.soLuongTieuChuan = soLuongTieuChuan;
    }

    public int getSoLuongTieuChuan() {
        return soLuongTieuChuan;
    }

    public void setSoLuongTieuChuan(int soLuongTieuChuan) {
        this.soLuongTieuChuan = soLuongTieuChuan;
    }

    public ChuanKDCL(String maKdcl, String tenKdcl, String namBanHanh) {
        this.maKdcl = maKdcl;
        this.tenKdcl = tenKdcl;
        this.namBanHanh = namBanHanh;
    }

    public ChuanKDCL() {
    }
     
    @OneToMany(mappedBy = "chuanKdcl", fetch = FetchType.LAZY)
    private List<CTDT> chuongTrinhDaoTao;

    public String getMaKdcl() {
        return maKdcl;
    }

    public void setMaKdcl(String maKdcl) {
        this.maKdcl = maKdcl;
    }

    public String getTenKdcl() {
        return tenKdcl;
    }

    public void setTenKdcl(String tenKdcl) {
        this.tenKdcl = tenKdcl;
    }

    public String getNamBanHanh() {
        return namBanHanh;
    }

    public void setNamBanHanh(String namBanHanh) {
        this.namBanHanh = namBanHanh;
    }

    
}