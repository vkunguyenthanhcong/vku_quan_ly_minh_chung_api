package com.example.qlmc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.CTDT;

import jakarta.transaction.Transactional;

public interface CTDTRepository extends JpaRepository<CTDT, String> {
    @Query(value = "SELECT * FROM chuongtrinhdaotao WHERE ma_kdcl = :maKdcl", nativeQuery =  true)
    List<CTDT> findAllByMaKDCL(@Param("maKdcl") String maKdcl);

    @Query(value = "SELECT * FROM chuongtrinhdaotao c WHERE c.ma_ctdt = :maCtdt", nativeQuery = true)
    Optional<CTDT> getThongTinChuongTrinhDaoTao(String maCtdt);

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuongtrinhdaotao SET ten_ctdt = :tenCtdt, ma_khoa = :maKhoa, ma_nganh = :maNganh WHERE ma_ctdt = :maCtdt", nativeQuery = true)
    void updateCTDT(@Param("tenCtdt") String tenCtdt, @Param("maKhoa") String maKhoa, @Param("maNganh") String maNganh, @Param("maCtdt") String maCtdt);
    
    

    

    

}