package com.example.qlmc.repository;
import java.util.List;

import com.example.qlmc.entity.MinhChung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.TieuChuan;

public interface TieuChuanRepository extends JpaRepository<TieuChuan, Integer> {

    @Query("SELECT tc FROM TieuChuan tc WHERE tc.ctdt.maCtdt = :maCtdt")
    List<TieuChuan> findByMaCtdt(String maCtdt);
    @Query("SELECT tc FROM TieuChuan tc WHERE tc.idGoogleDrive = :idGoogleDrive")
    TieuChuan findByIdGoogleDrive(String idGoogleDrive);
}