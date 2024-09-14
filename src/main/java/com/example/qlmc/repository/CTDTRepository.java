package com.example.qlmc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.CTDT;

import jakarta.transaction.Transactional;

public interface CTDTRepository extends JpaRepository<CTDT, Integer> {
    @Query(value = "SELECT * FROM chuongtrinhdaotao WHERE ma_kdcl = :maKdcl", nativeQuery =  true)
    List<CTDT> findAllByMaKDCL(@Param("maKdcl") String maKdcl);

    Optional<CTDT> getThongTinChuongTrinhDaoTao(String maCtdt);

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuongtrinhdaotao SET ten_ctdt = :tenCtdt, ma_khoa = :maKhoa, ma_nganh = :maNganh WHERE id_ctdt = :idCtdt", nativeQuery = true)
    void updateCTDT(@Param("tenCtdt") String tenCtdt, @Param("maKhoa") String maKhoa, @Param("maNganh") String maNganh, @Param("idCtdt") int idCtdt);
    
    

    

    

}