package com.example.qlmc.entity;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "khoa")
public class Khoa {
    @Id
    @Column(name="ma_khoa")
    private String maKhoa;
    @Column(name="ten_khoa")
    private String tenKhoa;
    @Column(name="web")
    private String web;
    @Column(name="email")
    private String email;
    @Column(name="sdt")
    private String sdt;

    @OneToMany(mappedBy = "khoa")
    @JsonIgnore
    private List<CTDT> chuongTrinhDaoTao;

}
