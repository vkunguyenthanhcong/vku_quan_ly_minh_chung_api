package com.example.qlmc.entity;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Khoa(String maKhoa, String tenKhoa, String web, String email, String sdt) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.web = web;
        this.email = email;
        this.sdt = sdt;
    }

    @OneToMany(mappedBy = "khoa")
    private List<CTDT> chuongTrinhDaoTao;

    public Khoa(){

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

    public Optional<Khoa> findById(String maKhoa2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
