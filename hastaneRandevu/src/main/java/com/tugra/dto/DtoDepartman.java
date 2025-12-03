package com.tugra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoDepartman {

    private Long departmanId;

    private String departmanAd;

    private DtoHastane hastane;

}
