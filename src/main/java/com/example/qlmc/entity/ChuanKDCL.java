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
    @Column(name = "ma_kdcl")
    private String maKdcl;
    @Column(name = "ten_kdcl")
    private String tenKdcl;
    @Column(name = "nambanhanh")
    private String namBanHanh;
    @Column(name = "soluongtieuchuan")
    private int soLuongTieuChuan;

    public ChuanKDCL(String maKdcl, String tenKdcl, String namBanHanh, int soLuongTieuChuan, String idGoogleDrive) {
        this.maKdcl = maKdcl;
        this.tenKdcl = tenKdcl;
        this.namBanHanh = namBanHanh;
        this.soLuongTieuChuan = soLuongTieuChuan;
        this.idGoogleDrive = idGoogleDrive;
    }

    public ChuanKDCL(String tenKdcl, String namBanHanh, String idGoogleDrive, int soLuongTieuChuan) {
        this.tenKdcl = tenKdcl;
        this.namBanHanh = namBanHanh;

        this.idGoogleDrive = idGoogleDrive;
        this.soLuongTieuChuan = soLuongTieuChuan;
    }

    @Column(name = "id_ggdrive")
    private String idGoogleDrive;


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

    public int getSoLuongTieuChuan() {
        return soLuongTieuChuan;
    }

    public void setSoLuongTieuChuan(int soLuongTieuChuan) {
        this.soLuongTieuChuan = soLuongTieuChuan;
    }

    public String getIdGoogleDrive() {
        return idGoogleDrive;
    }

    public void setIdGoogleDrive(String idGoogleDrive) {
        this.idGoogleDrive = idGoogleDrive;
    }

    public ChuanKDCL() {
    }

    @OneToMany(mappedBy = "chuanKdcl", fetch = FetchType.LAZY)
    private List<CTDT> chuongTrinhDaoTao;


}