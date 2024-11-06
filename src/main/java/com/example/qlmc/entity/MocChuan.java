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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="id_tieuchi")
    @JsonBackReference
    private TieuChi tieuChi;
    @JsonProperty("idTieuChi")
    public int getIdTieuChi() {
        return tieuChi.getIdTieuChi();
    }


    @OneToMany(mappedBy = "mocChuan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<GoiY> goiY;
}
