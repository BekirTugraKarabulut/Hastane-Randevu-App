package com.tugra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoBolumUI {

    private Long bolumId;

    private String bolumAd;

    private DtoHastane hastane;

    private DtoDepartman departmen;

}
