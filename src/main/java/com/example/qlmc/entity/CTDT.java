package com.example.qlmc.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "chuongtrinhdaotao")
public class CTDT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ctdt")
    private String maCtdt;

    @Column(name = "ten_ctdt")
    private String tenCtdt;

    @Column(name = "sotinchi")
    private int soTinChi; 

    @ManyToOne
    @JoinColumn(name = "ma_kdcl")       
    private ChuanKDCL chuanKdcl;

    @ManyToOne
    @JoinColumn(name = "ma_khoa")
    private Khoa khoa;

    @ManyToOne
    @JoinColumn(name = "ma_nganh")
    private Nganh nganh;
 

    @OneToMany(mappedBy = "ctdt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TieuChuan> tieuChuan;

  
    public CTDT(String maCtdt, String tenCtdt, int soTinChi, ChuanKDCL chuanKdcl, Khoa khoa, Nganh nganh) {
        this.maCtdt = maCtdt;
        this.tenCtdt = tenCtdt;
        this.soTinChi = soTinChi;
        this.chuanKdcl = chuanKdcl;
        this.khoa = khoa;
        this.nganh = nganh;
    }

    public String getMaCtdt() {
        return maCtdt;
    }

    public void setMaCtdt(String maCtdt) {
        this.maCtdt = maCtdt;
    }

    public String getTenCtdt() {
        return tenCtdt;
    }

    public void setTenCtdt(String tenCtdt) {
        this.tenCtdt = tenCtdt;
    }

    public ChuanKDCL getChuanKdcl() {
        return chuanKdcl;
    }

    public void setChuanKdcl(ChuanKDCL chuanKdcl) {
        this.chuanKdcl = chuanKdcl;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public CTDT(){
        
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
 
}