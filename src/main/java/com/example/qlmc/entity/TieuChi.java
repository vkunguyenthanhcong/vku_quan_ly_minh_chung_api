package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tieuchi")
public class TieuChi {
    @Id
    @Column (name = "id_tieuchi")
    private int idTieuChi;
    
    @Column (name = "ten_tieuchi")
    private String tenTieuChi;

    @ManyToOne
    @JoinColumn(name = "id_tieuchuan")
    @JsonBackReference
    private TieuChuan tieuChuan;

    @Column (name = "yeucau")
    private String yeuCau;

    @Column (name = "stt")
    private int stt;

    public int getStt() {
        return stt;
    }
    public void setStt(int stt) {
        this.stt = stt;
    }
    public TieuChi(){

    }
    public int getIdTieuChi() {
        return idTieuChi;
    }

    public void setIdTieuChi(int idTieuChi) {
        this.idTieuChi = idTieuChi;
    }

    public String getTenTieuChi() {
        return tenTieuChi;
    }

    public void setTenTieuChi(String tenTieuChi) {
        this.tenTieuChi = tenTieuChi;
    }

  
    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public TieuChuan getTieuChuan() {
        return tieuChuan;
    }

    public void setTieuChuan(TieuChuan tieuChuan) {
        this.tieuChuan = tieuChuan;
    }
}
