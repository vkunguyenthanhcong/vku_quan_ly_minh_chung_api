package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mocchuan")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMocChuan")
public class MocChuan {
    @Id
    @Column (name = "id_mocchuan")
    private int idMocChuan;
    
    @Column (name = "tenmocchuan")
    private String tenMocChuan;

    @Column ( name = "id_tieuchi")
    private int idTieuChi;

}
