package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phieudanhgiatieuchi")
public class PhieuDanhGiaTieuChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phieudanhgiatieuchi")
    private int idPhieuDanhGiaTieuChi;


    @Column(name = "id_phongban")
    private int idPhongBan;
    @Column(name = "id_tieuchuan")
    private int idTieuChuan;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="id_tieuchi")
    @JsonBackReference
    private TieuChi tieuChi;

    @JsonProperty("idTieuChi")
    public int getIdTieuChi() {
        return tieuChi.getIdTieuChi();
    }

    @Column(name = "mota")
    private String moTa;

    @Column(name = "diemmanh")
    private String diemManh;

    @Column(name = "diemtontai")
    private String diemTonTai;

    @Column(name = "noidungkhacphuc")
    private String noiDungKhacPhuc;

    @Column(name = "donvikhacphuc")
    private String donViKhacPhuc;

    @Column(name = "thoigiankhacphuc")
    private String thoiGianKhacPhuc;

    @Column(name = "ghichukhacphuc")
    private String ghiChuKhacPhuc;

    @Column(name = "noidungphathuy")
    private String noiDungPhatHuy;

    @Column(name = "donviphathuy")
    private String donViPhatHuy;

    @Column(name = "thoigianphathuy")
    private String thoiGianPhatHuy;

    @Column(name = "ghichuphathuy")
    private String ghiChuPhatHuy;

    @Column(name = "mucdanhgia")
    private int mucDanhGia;
}
