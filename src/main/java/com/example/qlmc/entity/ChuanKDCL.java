package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ChuanKDCL {

    @Id
    @Column(name = "id_kdcl")
    private int idKdcl;
    @Column(name = "ten_kdcl")
    private String tenKdcl;
    @Column(name = "nambanhanh")
    private String namBanHanh;
    @Column(name = "ma_kdcl")
    private String maKdcl;

    public ChuanKDCL() {
    }

    public ChuanKDCL(int idKdcl, String tenKdcl, String namBanHanh, String maKdcl) {
        this.idKdcl = idKdcl;
        this.tenKdcl = tenKdcl;
        this.namBanHanh = namBanHanh;
        this.maKdcl = maKdcl;
    }

    public ChuanKDCL(String tenKdcl, String namBanHanh, String maKdcl) {
        this.tenKdcl = tenKdcl;
        this.namBanHanh = namBanHanh;
        this.maKdcl = maKdcl;
    }

    // Getters and setters
    public int getIdKdcl() {
        return idKdcl;
    }

    public void setIdKdcl(int idKdcl) {
        this.idKdcl = idKdcl;
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

    public String getMaKdcl() {
        return maKdcl;
    }

    public void setMaKdcl(String maKdcl) {
        this.maKdcl = maKdcl;
    }
}