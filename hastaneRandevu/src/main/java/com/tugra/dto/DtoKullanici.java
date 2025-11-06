package com.tugra.dto;

import com.tugra.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoKullanici {

    private String username;

    private String ad;

    private String soyad;

    private String telefonNo;

    private String email;

    private Role role;

    private String password;


}
