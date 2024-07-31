package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "minhchung")
public class MinhChung {
    @Id
    @Column (name = "id_mc")
    private int idMc;

    @Column (name = "ma_mc")
    private String maMc;

    @Column (name = "id_kmc")
    private int idKmc;

    @Column (name = "id_tieuchuan")
    private String idTieuChuan;

    public MinhChung() {
    }

    // Getters and Setters
    public int getIdMc() {
        return idMc;
    }

    public void setIdMc(int idMc) {
        this.idMc = idMc;
    }

    public String getMaMc() {
        return maMc;
    }

    public void setMaMc(String maMc) {
        this.maMc = maMc;
    }

    public int getIdKmc() {
        return idKmc;
    }

    public void setIdKmc(int idKmc) {
        this.idKmc = idKmc;
    }

    public String getIdTieuChuan() {
        return idTieuChuan;
    }

    public void setIdTieuChuan(String idTieuChuan) {
        this.idTieuChuan = idTieuChuan;
    }
}
