package com.example.qlmc.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.KhoMinhChung;

public interface KhoMinhChungRepository extends JpaRepository<KhoMinhChung, Integer> , JpaSpecificationExecutor<KhoMinhChung>{
    @Query(value = "SELECT * FROM khominhchung WHERE ten_mc LIKE %:tenMc% AND sohieu LIKE %:soHieu% AND id_loai LIKE %:idLoai%", nativeQuery =  true)
    List<KhoMinhChung> searchByNotDate(@Param("tenMc") String tenMc, @Param("soHieu") String soHieu, @Param("idLoai") String idLoai);

    @Query(value = "SELECT * FROM khominhchung WHERE ten_mc LIKE %:tenMc% AND sohieu LIKE %:soHieu% AND id_loai LIKE %:idLoai% AND thoigian BETWEEN :startDate AND :endDate", nativeQuery =  true)
    List<KhoMinhChung> searchByDate(@Param("tenMc") String tenMc, @Param("soHieu") String soHieu, @Param("idLoai") String idLoai, @Param("startDate") Date startDate , @Param("endDate") Date endDate);
    
}