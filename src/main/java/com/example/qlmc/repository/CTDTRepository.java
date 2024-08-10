package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.CTDT;

import jakarta.transaction.Transactional;

public interface CTDTRepository extends JpaRepository<CTDT, Long> {
    @Query(value = "SELECT * FROM chuongtrinhdaotao WHERE ma_kdcl = :maKdcl", nativeQuery =  true)
    List<CTDT> findAllByMaKDCL(@Param("maKdcl") String maKdcl);

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuongtrinhdaotao SET tenC = :namBanHanh WHERE id_kdcl = :idKdcl", nativeQuery = true)
    void updateNamBanHanh(@Param("namBanHanh") String namBanHanh, @Param("idKdcl") int idKdcl);
}