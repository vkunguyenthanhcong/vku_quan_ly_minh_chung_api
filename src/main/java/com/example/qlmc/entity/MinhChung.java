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
    private int idTieuChuan;

    @Column (name = "id_goiy")
    private int idGoiY;


    public MinhChung(int idMc, String maMc, int idKmc, int idTieuChuan, int idGoiY) {
        this.idMc = idMc;
        this.maMc = maMc;
        this.idKmc = idKmc;
        this.idTieuChuan = idTieuChuan;
        this.idGoiY = idGoiY;
    }



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

    public int getIdTieuChuan() {
        return idTieuChuan;
    }

    public void setIdTieuChuan(int idTieuChuan) {
        this.idTieuChuan = idTieuChuan;
    }

    public int getIdGoiY() {
        return idGoiY;
    }

    public void setIdGoiY(int idGoiY) {
        this.idGoiY = idGoiY;
    }
}
