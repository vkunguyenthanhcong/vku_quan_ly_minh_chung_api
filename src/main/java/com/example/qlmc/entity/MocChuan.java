package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mocchuan")
public class MocChuan {
    @Id
    @Column (name = "id_mocchuan")
    private int idMocChuan;
    
    @Column (name = "tenmocchuan")
    private String tenMocChuan;

    @Column (name = "id_tieuchi")
    private int idTieuChi;

    public MocChuan(int idMocChuan, String tenMocChuan, int idTieuChi) {
        this.idMocChuan = idMocChuan;
        this.tenMocChuan = tenMocChuan;
        this.idTieuChi = idTieuChi;
    }

    public MocChuan(String tenMocChuan, int idTieuChi) {
        this.tenMocChuan = tenMocChuan;
        this.idTieuChi = idTieuChi;
    }

    public MocChuan() {
    }

    public int getIdMocChuan() {
        return idMocChuan;
    }

    public void setIdMocChuan(int idMocChuan) {
        this.idMocChuan = idMocChuan;
    }

    public String getTenMocChuan() {
        return tenMocChuan;
    }

    public void setTenMocChuan(String tenMocChuan) {
        this.tenMocChuan = tenMocChuan;
    }

    public int getIdTieuChi() {
        return idTieuChi;
    }

    public void setIdTieuChi(int idTieuChi) {
        this.idTieuChi = idTieuChi;
    }
}
