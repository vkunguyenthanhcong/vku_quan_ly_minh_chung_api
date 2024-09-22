package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "minhchung")
public class MinhChung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mc")
    private int idMc;

    @Column(name = "parent_ma_mc")
    private String parentMaMc;
    @Column(name = "child_ma_mc")
    private String childMaMc;

    @Column(name = "id_kmc")
    private int idKmc;

    @Column(name = "id_tieuchuan")
    private int idTieuChuan;

    @Column(name = "id_goiy")
    private int idGoiY;

    @Column(name = "madungchung")
    private int maDungChung;

    public MinhChung(int idMc, String parentMaMc, String childMaMc, int idKmc, int idTieuChuan, int idGoiY, int maDungChung) {
        this.idMc = idMc;
        this.parentMaMc = parentMaMc;
        this.childMaMc = childMaMc;
        this.idKmc = idKmc;
        this.idTieuChuan = idTieuChuan;
        this.idGoiY = idGoiY;
        this.maDungChung = maDungChung;
    }

    public MinhChung(String parentMaMc, String childMaMc, int idKmc, int idTieuChuan, int idGoiY, int maDungChung) {
        this.parentMaMc = parentMaMc;
        this.childMaMc = childMaMc;
        this.idKmc = idKmc;
        this.idTieuChuan = idTieuChuan;
        this.idGoiY = idGoiY;
        this.maDungChung = maDungChung;
    }

    public MinhChung(int idKmc, int idTieuChuan, int idGoiY, int maDungChung) {
        this.idKmc = idKmc;
        this.idTieuChuan = idTieuChuan;
        this.idGoiY = idGoiY;
        this.maDungChung = maDungChung;
    }

    public int getIdMc() {
        return idMc;
    }

    public void setIdMc(int idMc) {
        this.idMc = idMc;
    }

    public String getParentMaMc() {
        return parentMaMc;
    }

    public void setParentMaMc(String parentMaMc) {
        this.parentMaMc = parentMaMc;
    }

    public String getChildMaMc() {
        return childMaMc;
    }

    public void setChildMaMc(String childMaMc) {
        this.childMaMc = childMaMc;
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

    public int getMaDungChung() {
        return maDungChung;
    }

    public void setMaDungChung(int maDungChung) {
        this.maDungChung = maDungChung;
    }

    public MinhChung() {
    }

}
