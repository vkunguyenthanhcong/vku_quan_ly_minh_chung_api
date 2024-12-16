package com.example.qlmc.repository;

import com.example.qlmc.entity.MinhChung;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlmc.entity.Khoa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KhoaRepository extends JpaRepository<Khoa, String>{

    @Query("SELECT k FROM Khoa k WHERE k.maKhoa = :maKhoa")
    Khoa findByMaKhoa(@Param("maKhoa") String maKhoa);
    
}
