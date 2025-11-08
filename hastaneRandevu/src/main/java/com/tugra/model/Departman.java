package com.tugra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "departman",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"departman_id", "departman_ad"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departman {

    @Id
    @Column(name = "departman_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmanId;

    @Column(name = "departman_ad")
    private String departmanAd;

    @ManyToOne
    @JoinColumn(name = "hastane_id", referencedColumnName = "hastane_id")
    private Hastane hastane;

    @OneToMany(mappedBy = "departmen", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Bolum> bolum;

}
