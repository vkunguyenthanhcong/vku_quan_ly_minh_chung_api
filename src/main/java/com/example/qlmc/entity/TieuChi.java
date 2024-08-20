package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tieuchi")
public class TieuChi {
    @Id
    @Column (name = "id_tieuchi")
    private int idTieuChi;
    
    @Column (name = "ten_tieuchi")
    private String tenTieuChi;

    @Column (name = "id_tieuchuan")
    private int idTieuChuan;

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

    public int getIdTieuChuan() {
        return idTieuChuan;
    }

    public void setIdTieuChuan(int idTieuChuan) {
        this.idTieuChuan = idTieuChuan;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }
}
