package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.TieuChi;


public interface TieuChiRepository extends JpaRepository<TieuChi, Integer> {

    @Query(value = "SELECT * FROM tieuchi WHERE id_tieuchuan = :idTieuChuan", nativeQuery = true)
    List<TieuChi> findByIdTieuChuan(@Param("idTieuChuan") int idTieuChuan);

    @Query(value = "SELECT tieuchi.* FROM tieuchi, tieuchuan WHERE tieuchuan.ma_ctdt = :maCtdt AND tieuchuan.id_tieuchuan = tieuchi.id_tieuchuan; ", nativeQuery = true)
    List<TieuChi> findByMaCtdt(@Param("maCtdt") String maCtdt);
}