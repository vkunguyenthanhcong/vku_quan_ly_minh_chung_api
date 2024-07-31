package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.GoiY;

public interface GoiYRepository extends JpaRepository<GoiY, Long> {
    @Query(value = "SELECT * FROM goiynguonmc WHERE id_tieuchi = :idTieuChi", nativeQuery =  true)
    List<GoiY> findAllByIdTieuChi(@Param("idTieuChi") int idTieuChi);
}