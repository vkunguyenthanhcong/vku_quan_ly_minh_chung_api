    package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nganh")
public class Nganh {
    @Id
    @Column (name="id_nganh")
    private int idNganh;

    @Column (name="ma_nganh")
    private String maNganh;

    @Column (name="ten_nganh")
    private String tenNganh;

    @Column (name="ma_khoa")
    private String maKhoa;

    @Column (name="trinhdodaotao")
    private String trinhDo;

    public Nganh(){}
    public Nganh(int idNganh, String maKhoa, String maNganh, String tenNganh, String trinhDo) {
        this.idNganh = idNganh;
        this.maKhoa = maKhoa;
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.trinhDo = trinhDo;
    }

    public int getIdNganh() {
        return idNganh;
    }

    public void setIdNganh(int idNganh) {
        this.idNganh = idNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public Nganh(String maNganh, String tenNganh, String maKhoa, String trinhDo) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maKhoa = maKhoa;
        this.trinhDo = trinhDo;
    }
}