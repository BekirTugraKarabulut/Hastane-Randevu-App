package com.tugra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bolum",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"bolum_id", "bolum_ad"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bolum {

    @Id
    @Column(name = "bolum_id")
    private Long bolumId;

    @Column(name = "bolum_ad")
    private String bolumAd;

    @ManyToOne
    @JoinColumn(name = "hastane_id", referencedColumnName = "hastane_id")
    private Hastane hastane;

    @ManyToOne
    @JoinColumn(name = "departman_id", referencedColumnName = "departman_id")
    private Departman departmen;

    @OneToMany(mappedBy = "bolum" , cascade = CascadeType.ALL)
    private List<Calisanlar> calisanlar;

}
