package com.example.qlmc.entity;

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
@Table(name = "goiynguonmc")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idGoiY")
public class GoiY {
    @Id
    @Column(name = "id_goiy")
    private int idGoiY;

    @Column(name = "ten_goiy")
    private String tenGoiY;

    @Column(name = "batbuoc")
    private int batBuoc;

    @Column (name="id_mocchuan")
    private int idMocChuan;


}
