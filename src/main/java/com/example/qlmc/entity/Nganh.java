package com.example.qlmc.entity;
    
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "nganh")
public class Nganh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="ma_nganh")
    private String maNganh;

    


    @Column (name="ten_nganh")
    private String tenNganh;

    @Column (name="ma_khoa")
    private String maKhoa;

    @Column (name="trinhdodaotao")
    private String trinhDo;
    public Nganh(String maNganh, String tenNganh, String maKhoa, String trinhDo) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maKhoa = maKhoa;
        this.trinhDo = trinhDo;
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


    @OneToMany(mappedBy = "nganh")
    private List<CTDT> chuongTrinhDaoTao;


    public Nganh(){}
    
}