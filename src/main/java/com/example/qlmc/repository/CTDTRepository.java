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

    @Query(value = "SELECT \n" + //
                "    ctdt.ten_ctdt ,  \n" + //
                "    chuankdcl.ten_kdcl , \n" + //
                "    khoa.ten_khoa , \n" + //
                "    khoa.web , \n" + //
                "    khoa.sdt , \n" + //
                "    khoa.email , \n" + //
                "    nganh.ten_nganh , \n" + //
                "    ctdt.trinhdo , \n" + //
                "    ctdt.sotinchi\n" + //
                "FROM \n" + //
                "    chuongtrinhdaotao ctdt\n" + //
                "JOIN \n" + //
                "    chuankdcl ON ctdt.ma_kdcl = chuankdcl.ma_kdcl\n" + //
                "JOIN \n" + //
                "    khoa ON ctdt.ma_khoa = khoa.ma_khoa\n" + //
                "JOIN \n" + //
                "    nganh ON ctdt.ma_nganh = nganh.ma_nganh\n" + //
                "WHERE  \n" + //
                "    ctdt.ma_ctdt = :maCtdt;\n" + //
                "", nativeQuery =  true)
    List<Object[]> getThongTinChuongTrinhDaoTao(@Param("maCtdt") String maCtdt);

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuongtrinhdaotao SET tenC = :namBanHanh WHERE id_kdcl = :idKdcl", nativeQuery = true)
    void updateNamBanHanh(@Param("namBanHanh") String namBanHanh, @Param("idKdcl") int idKdcl);

    

}