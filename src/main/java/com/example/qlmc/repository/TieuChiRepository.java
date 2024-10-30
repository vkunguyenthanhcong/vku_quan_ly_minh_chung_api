package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.TieuChi;


public interface TieuChiRepository extends JpaRepository<TieuChi, Integer> {

    @Query(value = "SELECT t FROM TieuChi t WHERE t.idTieuChuan = :idTieuChuan")
    List<TieuChi> findByIdTieuChuan(@Param("idTieuChuan") int idTieuChuan);

    @Query(value = "SELECT tieuchi.* FROM tieuchi INNER JOIN tieuchuan ON tieuchi.id_tieuchuan = tieuchuan.id_tieuchuan WHERE tieuchuan.ma_ctdt = :maCtdt", nativeQuery = true)
    List<TieuChi> findByMaCtdt(@Param("maCtdt") String maCtdt);

}