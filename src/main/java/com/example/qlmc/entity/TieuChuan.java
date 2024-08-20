package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tieuchuan")
public class TieuChuan {
    
    @Id
    @Column (name = "id_tieuchuan")
    private int idTieuChuan;

    @Column (name = "ten_tieuchuan")
    private String tenTieuChuan;

    @Column (name = "ma_ctdt")
    private String maCtdt;
    @Column (name = "stt")
    private int stt;

    public int getStt() {
        return stt;
    }
    public void setStt(int stt) {
        this.stt = stt;
    }
    public TieuChuan(){

    }
    public int getIdTieuChuan() {
        return idTieuChuan;
    }

    public void setIdTieuChuan(int idTieuChuan) {
        this.idTieuChuan = idTieuChuan;
    }

    public String getTenTieuChuan() {
        return tenTieuChuan;
    }

    public void setTenTieuChuan(String tenTieuChuan) {
        this.tenTieuChuan = tenTieuChuan;
    }

    public String getMaCtdt() {
        return maCtdt;
    }

    public void setMaCtdt(String maCtdt) {
        this.maCtdt = maCtdt;
    }
}
