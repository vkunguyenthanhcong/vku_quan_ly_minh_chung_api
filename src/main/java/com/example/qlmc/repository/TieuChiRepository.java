package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.TieuChi;


public interface TieuChiRepository extends JpaRepository<TieuChi, Integer> {
    @Query("SELECT tc FROM TieuChi tc WHERE tc.tieuChuan.idTieuChuan = :idTieuChuan")
    List<TieuChi> findTieuChiByIdTieuChuan(@Param("idTieuChuan") int idTieuChuan);
}