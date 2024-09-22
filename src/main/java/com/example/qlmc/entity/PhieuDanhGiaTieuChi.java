package com.example.qlmc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phieudanhgiatieuchi")
public class PhieuDanhGiaTieuChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phieudanhgiatieuchi")
    private int idPhieuDanhGiaTieuChi;

    @ManyToOne
    @JoinColumn(name = "id_phongban", referencedColumnName = "id_phongban")
    private PhongBan phongBan;

    @ManyToOne
    @JoinColumn(name = "id_tieuchuan", referencedColumnName = "id_tieuchuan")
    private TieuChuan tieuChuan;

    @ManyToOne
    @JoinColumn(name = "id_tieuchi", referencedColumnName = "id_tieuchi")
    private TieuChi tieuChi;

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

    public PhieuDanhGiaTieuChi() {
    }

    public PhieuDanhGiaTieuChi(String diemManh, String diemTonTai, String donViKhacPhuc, String donViPhatHuy, String ghiChuKhacPhuc, String ghiChuPhatHuy, int idPhieuDanhGiaTieuChi, String moTa, int mucDanhGia, String noiDungKhacPhuc, String noiDungPhatHuy, PhongBan phongBan, String thoiGianKhacPhuc, String thoiGianPhatHuy, TieuChi tieuChi, TieuChuan tieuChuan) {
        this.diemManh = diemManh;
        this.diemTonTai = diemTonTai;
        this.donViKhacPhuc = donViKhacPhuc;
        this.donViPhatHuy = donViPhatHuy;
        this.ghiChuKhacPhuc = ghiChuKhacPhuc;
        this.ghiChuPhatHuy = ghiChuPhatHuy;
        this.idPhieuDanhGiaTieuChi = idPhieuDanhGiaTieuChi;
        this.moTa = moTa;
        this.mucDanhGia = mucDanhGia;
        this.noiDungKhacPhuc = noiDungKhacPhuc;
        this.noiDungPhatHuy = noiDungPhatHuy;
        this.phongBan = phongBan;
        this.thoiGianKhacPhuc = thoiGianKhacPhuc;
        this.thoiGianPhatHuy = thoiGianPhatHuy;
        this.tieuChi = tieuChi;
        this.tieuChuan = tieuChuan;
    }

    public int getIdPhieuDanhGiaTieuChi() {
        return idPhieuDanhGiaTieuChi;
    }

    public void setIdPhieuDanhGiaTieuChi(int idPhieuDanhGiaTieuChi) {
        this.idPhieuDanhGiaTieuChi = idPhieuDanhGiaTieuChi;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public TieuChuan getTieuChuan() {
        return tieuChuan;
    }

    public void setTieuChuan(TieuChuan tieuChuan) {
        this.tieuChuan = tieuChuan;
    }

    public TieuChi getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(TieuChi tieuChi) {
        this.tieuChi = tieuChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getDiemManh() {
        return diemManh;
    }

    public void setDiemManh(String diemManh) {
        this.diemManh = diemManh;
    }

    public String getDiemTonTai() {
        return diemTonTai;
    }

    public void setDiemTonTai(String diemTonTai) {
        this.diemTonTai = diemTonTai;
    }

    public String getNoiDungKhacPhuc() {
        return noiDungKhacPhuc;
    }

    public void setNoiDungKhacPhuc(String noiDungKhacPhuc) {
        this.noiDungKhacPhuc = noiDungKhacPhuc;
    }

    public String getDonViKhacPhuc() {
        return donViKhacPhuc;
    }

    public void setDonViKhacPhuc(String donViKhacPhuc) {
        this.donViKhacPhuc = donViKhacPhuc;
    }

    public String getThoiGianKhacPhuc() {
        return thoiGianKhacPhuc;
    }

    public void setThoiGianKhacPhuc(String thoiGianKhacPhuc) {
        this.thoiGianKhacPhuc = thoiGianKhacPhuc;
    }

    public String getGhiChuKhacPhuc() {
        return ghiChuKhacPhuc;
    }

    public void setGhiChuKhacPhuc(String ghiChuKhacPhuc) {
        this.ghiChuKhacPhuc = ghiChuKhacPhuc;
    }

    public String getNoiDungPhatHuy() {
        return noiDungPhatHuy;
    }

    public void setNoiDungPhatHuy(String noiDungPhatHuy) {
        this.noiDungPhatHuy = noiDungPhatHuy;
    }

    public String getDonViPhatHuy() {
        return donViPhatHuy;
    }

    public void setDonViPhatHuy(String donViPhatHuy) {
        this.donViPhatHuy = donViPhatHuy;
    }

    public String getThoiGianPhatHuy() {
        return thoiGianPhatHuy;
    }

    public void setThoiGianPhatHuy(String thoiGianPhatHuy) {
        this.thoiGianPhatHuy = thoiGianPhatHuy;
    }

    public String getGhiChuPhatHuy() {
        return ghiChuPhatHuy;
    }

    public void setGhiChuPhatHuy(String ghiChuPhatHuy) {
        this.ghiChuPhatHuy = ghiChuPhatHuy;
    }

    public int getMucDanhGia() {
        return mucDanhGia;
    }

    public void setMucDanhGia(int mucDanhGia) {
        this.mucDanhGia = mucDanhGia;
    }

}
