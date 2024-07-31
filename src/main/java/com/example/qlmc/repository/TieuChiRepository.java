package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.TieuChi;


public interface TieuChiRepository extends JpaRepository<TieuChi, Long> {

    @Query(value = "SELECT * FROM tieuchi WHERE id_tieuchuan = :idTieuChuan", nativeQuery = true)
    List<TieuChi> findByIdTieuChuan(@Param("idTieuChuan") int idTieuChuan);

}