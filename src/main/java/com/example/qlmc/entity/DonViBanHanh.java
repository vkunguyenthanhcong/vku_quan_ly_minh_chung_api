package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="donvibanhanh")
public class DonViBanHanh {
    @Id
    @Column (name = "id_dvbh")
    private int idDvbh;

    @Column (name = "ten_dvbh")
    private String tenDvbh;

    public int getIdDvbh() {
        return idDvbh;
    }

    public void setIdDvbh(int idDvbh) {
        this.idDvbh = idDvbh;
    }

    public String getTenDvbh() {
        return tenDvbh;
    }

    public void setTenDvbh(String tenDvbh) {
        this.tenDvbh = tenDvbh;
    }

    public DonViBanHanh(){
        
    }
}
