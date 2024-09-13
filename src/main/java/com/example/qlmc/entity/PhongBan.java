package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name = "phongban")
public class PhongBan {
    @Id
    @Column (name = "id")
    private int idPhongBan;

    @Column (name = "tenphongban")
    private String tenPhongBan;

    public PhongBan(){
        
    }

    public PhongBan(int idPhongBan, String tenPhongBan) {
        this.idPhongBan = idPhongBan;
        this.tenPhongBan = tenPhongBan;
    }

    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public int getIdPhongBan() {
        return idPhongBan;
    }

    public void setIdPhongBan(int idPhongBan) {
        this.idPhongBan = idPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }
}
