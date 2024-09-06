package com.example.qlmc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlmc.entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}