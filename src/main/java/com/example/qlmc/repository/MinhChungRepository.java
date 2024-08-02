package com.example.qlmc.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlmc.entity.MinhChung;

public interface MinhChungRepository extends JpaRepository<MinhChung, Long> {
    
}