package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.MocChuan;

public interface MocChuanRepository extends JpaRepository<MocChuan, Integer>{
    @Query("SELECT mc FROM MocChuan mc WHERE mc.tieuChi.idTieuChi = :idTieuChi")
    List<MocChuan> findByIdTieuChi(@Param("idTieuChi") int idTieuChi);
}
