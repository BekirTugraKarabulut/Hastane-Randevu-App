package com.tugra.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    KULLANICI_BULUNAMADI("101", "Kullanıcı bulunamadı !"),
    USERNAME_ZATEN_VAR("102", "Bu kullanıcı adı zaten kayıtlı !"),
    EMAIL_ZATEN_VAR("103", "Bu email zaten kayıtlı !"),
    TELEFON_ZATEN_VAR("104", "Bu telefon numarası zaten kayıtlı !"),
    TOKEN_GEÇERSİZ("105", "Geçersiz token !"),
    TOKEN_SURESI_DOLMUS("106", "Token süresi dolmuş !");


    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
