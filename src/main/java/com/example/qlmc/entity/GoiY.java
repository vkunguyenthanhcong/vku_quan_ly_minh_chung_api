package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "goiynguonmc")
public class GoiY {
    @Id
    @Column (name = "id_goiy")
    private int idGoiY;

    @Column (name = "ten_goiy")
    private String tenGoiY;

    @Column (name = "batbuoc")
    private int batBuoc;

    @Column (name = "id_mocchuan")
    private int idMocChuan;

    public GoiY(String tenGoiY, int batBuoc, int idMocChuan) {
        this.tenGoiY = tenGoiY;
        this.batBuoc = batBuoc;
        this.idMocChuan = idMocChuan;
    }
    public GoiY(){

    }
    public int getIdGoiY() {
        return idGoiY;
    }

    public void setIdGoiY(int idGoiY) {
        this.idGoiY = idGoiY;
    }

    // Getter and Setter for tenGoiY
    public String getTenGoiY() {
        return tenGoiY;
    }

    public void setTenGoiY(String tenGoiY) {
        this.tenGoiY = tenGoiY;
    }

    // Getter and Setter for batBuoc
    public int getBatBuoc() {
        return batBuoc;
    }

    public void setBatBuoc(int batBuoc) {
        this.batBuoc = batBuoc;
    }

    // Getter and Setter for idTieuChi
    public int getIdMocChuan() {
        return idMocChuan;
    }

    public void setIdMocChuan(int idMocChuan) {
        this.idMocChuan = idMocChuan;
    }
}
