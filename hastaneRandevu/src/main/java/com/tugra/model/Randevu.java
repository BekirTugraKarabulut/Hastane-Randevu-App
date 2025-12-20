package com.tugra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "randevu",
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"randevu_tarihi", "randevu_saati", "tc_no", "calisan_id"})
            }
        )
@Schema(description = "Randevu Bilgileri")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Randevu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "randevu_id")
    private Long randevuId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "randevu_tarihi")
    private Date randevuTarihi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    @Column(name = "randevu_saati")
    private String randevuSaati;

    @ManyToOne
    @JoinColumn(name = "tc_no" , referencedColumnName = "tc_no")
    private Kullanici kullanici;

    @ManyToOne
    @JoinColumn(name = "calisan_id" , referencedColumnName = "calisan_id")
    private Calisanlar calisanlar;

    @ManyToOne
    @JoinColumn(name = "bolum_id", referencedColumnName = "bolum_id")
    private Bolum bolum;

}
