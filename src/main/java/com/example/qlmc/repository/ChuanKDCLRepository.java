package com.example.qlmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.ChuanKDCL;

import jakarta.transaction.Transactional;

public interface ChuanKDCLRepository extends JpaRepository<ChuanKDCL, Long> {
    @Modifying
    @Transactional
    @Query (value = "UPDATE chuankdcl SET ten_kdcl = :tenKdcl WHERE id_kdcl = :idKdcl", nativeQuery = true)
    void updateTenKdcl(@Param("tenKdcl") String tenKdcl, @Param("idKdcl") int idKdcl);

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuankdcl SET nambanhanh = :namBanHanh WHERE id_kdcl = :idKdcl", nativeQuery = true)
    void updateNamBanHanh(@Param("namBanHanh") String namBanHanh, @Param("idKdcl") int idKdcl);

    @Modifying
    @Transactional
    @Query (value = "DELETE chuankdcl, chuongtrinhdaotao FROM chuankdcl LEFT JOIN chuongtrinhdaotao ON chuankdcl.ma_kdcl = chuongtrinhdaotao.ma_kdcl WHERE chuankdcl.id_kdcl = :idKdcl; DELETE FROM chuankdcl WHERE id_kdcl = :idKdcl;", nativeQuery = true)
    void deleteChuanKDCL(@Param("idKdcl") int idKdcl);
}