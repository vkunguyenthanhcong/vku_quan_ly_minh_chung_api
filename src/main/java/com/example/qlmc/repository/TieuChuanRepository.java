package com.example.qlmc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.TieuChuan;

public interface TieuChuanRepository extends JpaRepository<TieuChuan, Integer> {
    List<TieuChuan> findByMaCtdt(String maCtdt);

    @Query (value = "SELECT tc.id_tieuchuan, tc.ten_tieuchuan, (SELECT COUNT(*) FROM minhchung mc WHERE mc.id_tieuchuan = tc.id_tieuchuan), tc.stt total FROM tieuchuan tc WHERE tc.ma_ctdt = :maCtdt", nativeQuery = true)
    List<Object[]> getListTieuChuanAndCount(@Param("maCtdt") String maCtdt);
}