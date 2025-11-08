package com.tugra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "hastane")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hastane {

    @Id
    @Column(name = "hastane_id")
    private Long hastaneId;

    @Column(name = "hastane_ad")
    private String hastaneAd;

    @OneToMany(mappedBy = "hastane", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Departman> departmen;

    @OneToMany(mappedBy = "hastane", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bolum> bolum;

}
