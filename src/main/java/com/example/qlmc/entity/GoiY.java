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
@Table(name = "goiynguonmc")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idGoiY")
public class GoiY {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goiy")
    private int idGoiY;

    @Column(name = "ten_goiy")
    private String tenGoiY;

    @Column(name = "batbuoc")
    private int batBuoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="id_mocchuan")
    @JsonBackReference
    private MocChuan mocChuan;

    @JsonProperty("idMocChuan")
    public int getIdMocChuan() {
        return mocChuan.getIdMocChuan();
    }

    @OneToMany(mappedBy = "goiY", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<MinhChung> minhChung;
}
