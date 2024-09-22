package com.example.qlmc.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "tieuchuan")
public class TieuChuan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_tieuchuan")
    private int idTieuChuan;

    @Column (name = "ten_tieuchuan")
    private String tenTieuChuan;
    
    @Column (name = "stt")
    private int stt;

    @ManyToOne
    @JoinColumn(name = "ma_ctdt", referencedColumnName = "ma_ctdt")
    @JsonBackReference
    private CTDT ctdt;
     
    // One TieuChuan has many TieuChi
    @OneToMany(mappedBy = "tieuChuan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TieuChi> tieuChi;


    public CTDT getCtdt() {
        return ctdt;
    }
    public void setCtdt(CTDT ctdt) {
        this.ctdt = ctdt;
    }
    public int getStt() {
        return stt;
    }
    public void setStt(int stt) {
        this.stt = stt;
    }
    public TieuChuan(){

    }
    public int getIdTieuChuan() {
        return idTieuChuan;
    }

    public void setIdTieuChuan(int idTieuChuan) {
        this.idTieuChuan = idTieuChuan;
    }

    public String getTenTieuChuan() {
        return tenTieuChuan;
    }

    public void setTenTieuChuan(String tenTieuChuan) {
        this.tenTieuChuan = tenTieuChuan;
    }
 

    public List<TieuChi> getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(List<TieuChi> tieuChi) {
        this.tieuChi = tieuChi;
    }
}
