package com.tugra.dto;

import com.tugra.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoKullaniciUI {

    @Size(min = 11, max = 11 , message = "TC Kimlik Numarası 11 haneli olmalıdır.")
    private String username;

    @Size(min = 0 , max = 45 , message = "Ad en fazla 45 karakter olabilir.")
    private String ad;

    @Size(min = 0 , max = 50 , message = "Soyad en fazla 50 karakter olabilir.")
    private String soyad;

    @Size(min = 11, max = 11 , message = "Telefon numarası 11 haneli olmalıdır.")
    private String telefonNo;

    @Email(message = "Geçerli bir email adresi giriniz.")
    private String email;

    private Role role;

    private String password;

}
