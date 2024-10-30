package com.example.qlmc.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "khominhchung")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idKhoMinhChung")
public class KhoMinhChung {
    @Id
    @Column (name = "id_kmc")
    private int idKhoMinhChung;

    @Column (name = "ten_mc")
    private String tenMinhChung;
    
    @Column (name = "sohieu")
    private String soHieu;

    @Column (name = "thoigian")
    private Date thoigian;

    @Column (name = "id_loai")
    private int idLoai;

    @Column (name = "id_dvbh")
    private int idDvbh;
    @Column (name = "linkluutru")
    private String linkLuuTru;


}
