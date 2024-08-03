package com.example.qlmc.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "khominhchung")
public class KhoMinhChung {
    @Id
    @Column (name = "id_kmc")
    private int idKhoMinhChung;

    @Column (name = "ten_mc")
    private String tenMinhChung;
    @Column (name = "sohieu")
    private String soHieu;

    @Column (name = "thoigian")
    private Date thoigian;

    @Column (name = "id_loai")
    private int idLoai;

    @Column (name = "id_dvbh")
    private int idDvbh;
    @Column (name = "linkluutru")
    private String linkLuuTru;
    
    public KhoMinhChung(){
        
    }

public int getIdKhoMinhChung() {
        return idKhoMinhChung;
    }

    public void setIdKhoMinhChung(int idKhoMinhChung) {
        this.idKhoMinhChung = idKhoMinhChung;
    }

    public String getTenMinhChung() {
        return tenMinhChung;
    }

    public void setTenMinhChung(String tenMinhChung) {
        this.tenMinhChung = tenMinhChung;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public int getIdDvbh() {
        return idDvbh;
    }

    public void setIdDvbh(int idDvbh) {
        this.idDvbh = idDvbh;
    }

    public String getLinkLuuTru() {
        return linkLuuTru;
    }

    public void setLinkLuuTru(String linkLuuTru) {
        this.linkLuuTru = linkLuuTru;
    }
}
