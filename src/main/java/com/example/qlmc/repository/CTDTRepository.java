package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.CTDT;

import jakarta.transaction.Transactional;

public interface CTDTRepository extends JpaRepository<CTDT, Integer> {
    @Query(value = "SELECT * FROM chuongtrinhdaotao WHERE ma_kdcl = :maKdcl", nativeQuery =  true)
    List<CTDT> findAllByMaKDCL(@Param("maKdcl") String maKdcl);

    @Query(value = "SELECT \n" + //
                "    ctdt.ten_ctdt,  \n" + //
                "    chuankdcl.ten_kdcl, \n" + //
                "    khoa.ten_khoa, \n" + //
                "    khoa.web, \n" + //
                "    khoa.sdt, \n" + //
                "    khoa.email, \n" + //
                "    nganh.ten_nganh, \n" + //
                "    ctdt.trinhdo, \n" + //
                "    ctdt.sotinchi,\n" + //
                "    ctdt.id_ctdt\n" + //
                "FROM \n" + //
                "    chuongtrinhdaotao ctdt\n" + //
                "LEFT JOIN \n" + //
                "    chuankdcl ON ctdt.ma_kdcl = chuankdcl.ma_kdcl\n" + //
                "LEFT JOIN \n" + //
                "    khoa ON ctdt.ma_khoa = khoa.ma_khoa\n" + //
                "LEFT JOIN \n" + //
                "    nganh ON ctdt.ma_nganh = nganh.ma_nganh\n" + //
                "WHERE  \n" + //
                "    ctdt.ma_ctdt = :maCtdt;", nativeQuery =  true)
    List<Object[]> getThongTinChuongTrinhDaoTao(@Param("maCtdt") String maCtdt);

    @Modifying
    @Transactional
    @Query (value = "UPDATE chuongtrinhdaotao SET ten_ctdt = :tenCtdt, ma_khoa = :maKhoa, ma_nganh = :maNganh WHERE id_ctdt = :idCtdt", nativeQuery = true)
    void updateCTDT(@Param("tenCtdt") String tenCtdt, @Param("maKhoa") String maKhoa, @Param("maNganh") String maNganh, @Param("idCtdt") int idCtdt);
    
    

    

    

}