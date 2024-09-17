package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
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

    public int getIdPhanCong() {
        return idPhanCong;
    }

    public void setIdPhanCong(int idPhanCong) {
        this.idPhanCong = idPhanCong;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public ChuanKDCL getChuanKdcl() {
        return chuanKdcl;
    }

    public void setChuanKdcl(ChuanKDCL chuanKdcl) {
        this.chuanKdcl = chuanKdcl;
    }

    public int getSttTieuChuanBatDau() {
        return sttTieuChuanBatDau;
    }

    public void setSttTieuChuanBatDau(int sttTieuChuanBatDau) {
        this.sttTieuChuanBatDau = sttTieuChuanBatDau;
    }

    public int getSttTieuChuanKetThuc() {
        return sttTieuChuanKetThuc;
    }

    public void setSttTieuChuanKetThuc(int sttTieuChuanKetThuc) {
        this.sttTieuChuanKetThuc = sttTieuChuanKetThuc;
    }
    public PhanCongDanhGia(){
        
    }
    public PhanCongDanhGia(int idPhanCong, PhongBan phongBan, ChuanKDCL chuanKdcl, int sttTieuChuanBatDau,
            int sttTieuChuanKetThuc) {
        this.idPhanCong = idPhanCong;
        this.phongBan = phongBan;
        this.chuanKdcl = chuanKdcl;
        this.sttTieuChuanBatDau = sttTieuChuanBatDau;
        this.sttTieuChuanKetThuc = sttTieuChuanKetThuc;
    }

    public PhanCongDanhGia(PhongBan phongBan, ChuanKDCL chuanKdcl, int sttTieuChuanBatDau, int sttTieuChuanKetThuc) {
        this.phongBan = phongBan;
        this.chuanKdcl = chuanKdcl;
        this.sttTieuChuanBatDau = sttTieuChuanBatDau;
        this.sttTieuChuanKetThuc = sttTieuChuanKetThuc;
    }
    
}
