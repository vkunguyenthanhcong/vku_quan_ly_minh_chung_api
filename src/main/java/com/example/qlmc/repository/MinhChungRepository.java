package com.example.qlmc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.MinhChung;

public interface MinhChungRepository extends JpaRepository<MinhChung, Long> {
    @Query(value = "SELECT mc.*, kmc.sohieu, kmc.ten_mc FROM minhchung mc JOIN khominhchung kmc ON kmc.id_kmc = mc.id_kmc WHERE mc.id_goiy = :idGoiY;", nativeQuery =  true)
    List<Object[]> findAllByIdGoiY(@Param("idGoiY") int idGoiY);

}