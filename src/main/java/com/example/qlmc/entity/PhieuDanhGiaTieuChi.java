package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phieudanhgiatieuchi")
public class            PhieuDanhGiaTieuChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phieudanhgiatieuchi")
    private int idPhieuDanhGiaTieuChi;


    @Column(name = "id_phongban")
    private int idPhongBan;
    @Column(name = "id_tieuchuan")
    private int idTieuChuan;

    @Column(name = "kehoach")
    private String keHoach;

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

    @Column(name = "mucdanhgia")
    private int mucDanhGia;
    @Column(name = "nguoivietbaocao")
    @Nullable
    private String nguoiVietBaoCao;

}
