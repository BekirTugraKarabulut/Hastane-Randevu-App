package com.tugra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoRandevu {

    private Long randevuId;

    private Date randevuTarihi;

    private String randevuSaati;

    private DtoKullanici kullanici;

    private DtoCalisanlar calisanlar;

}
