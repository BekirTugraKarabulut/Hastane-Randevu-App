package com.tugra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "calisanlar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calisanlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calisan_id")
    private Long calisanId;

    @Column(name = "tc_no", unique = true)
    private String tcNo;

    @Column(name = "calisan_ad")
    private String calisanAd;

    @Column(name = "calisan_soyad")
    private String calisanSoyad;

    @Column(name = "dogum_tarihi")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dogumTarihi;

    @Column(name = "telefon_no" , unique = true)
    private String telefonNo;

    @ManyToOne
    @JoinColumn(name = "bolum_id", referencedColumnName = "bolum_id")
    private Bolum bolum;

}
