package com.example.qlmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.PhieuDanhGiaTieuChi;


public interface PhieuDanhGiaTieuChiRepository extends JpaRepository<PhieuDanhGiaTieuChi, Integer> {
    @Query("SELECT p FROM PhieuDanhGiaTieuChi p WHERE p.tieuChuan.idTieuChuan = :idTieuChuan AND p.tieuChi.idTieuChi = :idTieuChi")
    PhieuDanhGiaTieuChi findByTieuChuanAndTieuChi(@Param("idTieuChuan") int idTieuChuan, @Param("idTieuChi") int idTieuChi);    
}