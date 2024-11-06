package com.example.qlmc.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "minhchung")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMc")
public class MinhChung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mc")
    private int idMc;

    @Column(name = "parent_ma_mc")
    private String parentMaMc;
    @Column(name = "child_ma_mc")
    private String childMaMc;

    @ManyToOne
    @JoinColumn(name = "id_kmc")
    private KhoMinhChung khoMinhChung;

    @Column(name = "id_tieuchuan")
    private int idTieuChuan;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="id_goiy")
    @JsonBackReference
    private GoiY goiY;

    @JsonProperty("idGoiY")
    public int getIdGoiY() {
        return goiY.getIdGoiY();
    }


    @Column(name = "madungchung")
    private int maDungChung;

    @Column(name = "linkluutru")
    private String linkLuuTru;

}
