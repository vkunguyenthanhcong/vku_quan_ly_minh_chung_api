package com.example.qlmc.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="id_dvbh")
    @JsonBackReference
    private DonViBanHanh donViBanHanh;

    @JsonProperty("idDvbh")
    public int getIdDv() {
        return donViBanHanh.getIdDvbh();
    }

    @Column (name = "linkluutru")
    private String linkLuuTru;


}
