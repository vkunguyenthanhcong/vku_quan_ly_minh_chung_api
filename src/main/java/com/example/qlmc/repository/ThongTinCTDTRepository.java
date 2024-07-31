package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.qlmc.entity.ChuanKDCL;

@Repository
public interface ThongTinCTDTRepository extends JpaRepository<ChuanKDCL, String> {

    @Query(value = "SELECT kdcl.ten_kdcl, khoa.ten_khoa, khoa.web, khoa.email, khoa.sdt, nganh.ten_nganh, dt.trinhdo, dt.sotinchi " +
                   "FROM chuankdcl kdcl " +
                   "JOIN chuongtrinhdaotao dt ON kdcl.ma_kdcl = dt.ma_kdcl " +
                   "JOIN khoa ON khoa.ma_khoa = dt.ma_khoa " +
                   "JOIN nganh ON nganh.ma_nganh = dt.ma_nganh " +
                   "WHERE dt.ma_ctdt = :maCtdt", nativeQuery = true)
    List<Object[]> findDetailsByCtdt(@Param("maCtdt") String maCtdt);
}