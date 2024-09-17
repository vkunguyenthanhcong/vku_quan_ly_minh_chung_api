package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.PhanCongDanhGia;

public interface PhanCongDanhGiaRepository extends JpaRepository<PhanCongDanhGia, Integer>{
    @Query("SELECT pc FROM PhanCongDanhGia pc WHERE pc.phongBan.idPhongBan = :idPhongBan AND pc.chuanKdcl.maKdcl = :maKdcl")
List<PhanCongDanhGia> findAllByIdPhongBanAndMaKdcl(@Param("idPhongBan") int idPhongBan, @Param("maKdcl") String maKdcl);




}
