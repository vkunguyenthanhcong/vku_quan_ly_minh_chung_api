package com.example.qlmc.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chuongtrinhdaotao")
public class CTDT {

    @Id
    @Column(name = "ma_ctdt")
    private String maCtdt;

    @Column(name = "ten_ctdt")
    private String tenCtdt;

    @Column(name = "sotinchi")
    private int soTinChi;

    @Column(name = "trinhdo")
    private String trinhDo;

    @ManyToOne
    @JoinColumn (name="ma_kdcl")
    private ChuanKDCL chuanKdcl;

    @ManyToOne
    @JoinColumn(name = "ma_khoa")
    private Khoa khoa;

    @ManyToOne
    @JoinColumn(name = "ma_nganh")
    private Nganh nganh;

    @Column(name = "id_ggdrive")
    private String idGoogleDrive;

    @Column(name = "loai")
    private int loai;

        @OneToMany(mappedBy = "ctdt", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        private List<TieuChuan> tieuChuan;
}