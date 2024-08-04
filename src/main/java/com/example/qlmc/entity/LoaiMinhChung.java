package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loaimc")
public class LoaiMinhChung {
    @Id
    @Column (name = "id_loai")
    private int idLoai;

    @Column (name = "ten_loai")
    private String tenLoai;

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiMinhChung(){

    }
    
}
