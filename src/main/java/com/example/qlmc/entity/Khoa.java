package com.example.qlmc.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
    @Column(name="id_khoa")
    private int idKhoa;
    @Column(name="ma_khoa")
    private String maKhoa;
    @Column(name="ten_khoa")
    private String tenKhoa;
    @Column(name="web")
    private String web;
    @Column(name="email")
    private String email;
    @Column(name="sdt")
    private String sdt;

    @OneToMany(mappedBy = "khoa")
    private List<CTDT> chuongTrinhDaoTao;

    public Khoa(){

    }

    public int getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(int idKhoa) {
        this.idKhoa = idKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
