package com.example.qlmc.repository;

import java.util.List;

import com.example.qlmc.entity.MocChuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.GoiY;

public interface GoiYRepository extends JpaRepository<GoiY, Integer> {
    @Query("SELECT gy FROM GoiY gy WHERE gy.mocChuan.tieuChi.tieuChuan.ctdt.maCtdt = :maCtdt")
    List<GoiY> findByMaCtdt(@Param("maCtdt") String maCtdt);
    @Query("SELECT gy FROM GoiY gy WHERE gy.mocChuan.idMocChuan = :idMocChuan")
    List<GoiY> findByIdMocChuan(@Param("idMocChuan") int idMocChuan);
}