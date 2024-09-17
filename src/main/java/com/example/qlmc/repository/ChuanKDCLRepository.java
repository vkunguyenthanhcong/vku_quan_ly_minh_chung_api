package com.example.qlmc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.ChuanKDCL;

import jakarta.transaction.Transactional;

public interface ChuanKDCLRepository extends JpaRepository<ChuanKDCL, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO chuankdcl (ten_kdcl, nambanhanh, ma_kdcl) " +
                   "SELECT :tenKdcl, :namBanHanh, " +
                   "IFNULL(CONCAT('ckd', CAST(SUBSTRING_INDEX(MAX(ma_kdcl), 'ckd', -1) + 1 AS UNSIGNED)), 'ckd1') " +
                   "FROM chuankdcl", nativeQuery = true)
    void insertNewChuanKdcl(@Param("tenKdcl") String tenKdcl, @Param("namBanHanh") String namBanHanh);         

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuankdcl SET ten_kdcl = :tenKdcl WHERE ma_kdcl = :maKdcl", nativeQuery = true)
    void updateTenKdcl(@Param("tenKdcl") String tenKdcl, @Param("maKdcl") String maKdcl);

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuankdcl SET nambanhanh = :namBanHanh WHERE ma_kdcl = :maKdcl", nativeQuery = true)
    void updateNamBanHanh(@Param("namBanHanh") String namBanHanh, @Param("maKdcl") String maKdcl);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM chuongtrinhdaotao WHERE ma_kdcl IN (SELECT ma_kdcl FROM chuankdcl WHERE ma_kdcl = :maKdcl)", nativeQuery = true)
    void deleteChuongTrinhDaoTao(@Param("maKdcl") String maKdcl);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM chuankdcl WHERE ma_kdcl = :maKdcl", nativeQuery = true)
    void deleteChuanKDCL(@Param("maKdcl") String maKdcl);
}