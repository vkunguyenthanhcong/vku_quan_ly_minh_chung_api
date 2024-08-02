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

    @Column (name = "id_tieuchi")
    private int idTieuChi;

    private int total;

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
    public int getIdTieuChi() {
        return idTieuChi;
    }

    public void setIdTieuChi(int idTieuChi) {
        this.idTieuChi = idTieuChi;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

