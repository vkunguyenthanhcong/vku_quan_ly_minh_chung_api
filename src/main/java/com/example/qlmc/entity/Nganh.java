package com.example.qlmc.entity;
    
import java.util.List;

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
@Table(name = "nganh")
public class Nganh {
    @Id
    @Column (name="ma_nganh")
    private String maNganh;

    @Column (name="ten_nganh")
    private String tenNganh;

    @Column (name="ma_khoa")
    private String maKhoa;

    @Column (name="trinhdodaotao")
    private String trinhDo;

    @OneToMany(mappedBy = "nganh")
    @JsonIgnore
    private List<CTDT> chuongTrinhDaoTao;

    
}