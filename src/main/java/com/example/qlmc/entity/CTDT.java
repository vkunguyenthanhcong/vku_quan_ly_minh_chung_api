package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="chuongtrinhdaotao")
public class CTDT {
    @Id
    @Column(name = "id_ctdt")
    private int idCtdt;
    @Column(name = "ten_ctdt")
    private String tenCtdt;
    @Column(name = "ma_ctdt")
    private String maCtdt;
    @Column(name = "ma_kdcl")
    private String maKdcl;
    @Column(name = "ma_khoa")
    private String maKhoa;

    public CTDT(String tenCtdt, String maCtdt, String maKdcl, String maKhoa) {
        this.tenCtdt = tenCtdt;
        this.maCtdt = maCtdt;
        this.maKdcl = maKdcl;
        this.maKhoa = maKhoa;
    }
    public CTDT(int idCtdt, String tenCtdt, String maCtdt, String maKdcl, String maKhoa) {
        this.idCtdt = idCtdt;
        this.tenCtdt = tenCtdt;
        this.maCtdt = maCtdt;
        this.maKdcl = maKdcl;
        this.maKhoa = maKhoa;
    }
    public CTDT() {
    }
    // Getters and Setters
    public int getIdCtdt() {
        return idCtdt;
    }

    public void setIdCtdt(int idCtdt) {
        this.idCtdt = idCtdt;
    }

    public String getTenCtdt() {
        return tenCtdt;
    }

    public void setTenCtdt(String tenCtdt) {
        this.tenCtdt = tenCtdt;
    }

    public String getMaCtdt() {
        return maCtdt;
    }

    public void setMaCtdt(String maCtdt) {
        this.maCtdt = maCtdt;
    }

    public String getMaKdcl() {
        return maKdcl;
    }

    public void setMaKdcl(String maKdcl) {
        this.maKdcl = maKdcl;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

}