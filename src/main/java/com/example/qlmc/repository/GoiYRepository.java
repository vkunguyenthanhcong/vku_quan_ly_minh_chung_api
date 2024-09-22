package com.example.qlmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.GoiY;

public interface GoiYRepository extends JpaRepository<GoiY, Integer> {

    @Query(value = "SELECT * FROM goiynguonmc gy WHERE gy.id_mocchuan = :idMocChuan;", nativeQuery =  true)
    List<GoiY> findAllByIdMocChuan(@Param("idMocChuan") int idMocChuan);
}