package com.example.qlmc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.TieuChuan;

public interface TieuChuanRepository extends JpaRepository<TieuChuan, Integer> {
    List<TieuChuan> findByMaCtdt(String maCtdt);
}