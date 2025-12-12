package com.tugra.dto;

import com.tugra.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCalisanlar {

    private Long calisanId;

    private String tcNo;

    private String password;

    private String calisanAd;

    private String calisanSoyad;

    private Date dogumTarihi;

    private String telefonNo;

    private Role role;

    private DtoBolum bolum;

}
