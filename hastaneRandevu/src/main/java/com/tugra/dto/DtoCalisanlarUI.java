package com.tugra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tugra.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCalisanlarUI {

    private Long calisanId;

    private String tcNo;

    private String password;

    private String calisanAd;

    private String calisanSoyad;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dogumTarihi;

    private String telefonNo;

    private DtoBolum bolum;

    private Role role;

}
