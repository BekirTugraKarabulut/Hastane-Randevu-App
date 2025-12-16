package com.tugra.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    KULLANICI_BULUNAMADI("101", "Kullanıcı bulunamadı !"),
    USERNAME_ZATEN_VAR("102", "Bu kullanıcı adı zaten kayıtlı !"),
    EMAIL_ZATEN_VAR("103", "Bu email zaten kayıtlı !"),
    TELEFON_ZATEN_VAR("104", "Bu telefon numarası zaten kayıtlı !"),
    TOKEN_GEÇERSİZ("105", "Geçersiz token !"),
    TOKEN_SURESI_DOLMUS("106", "Token süresi dolmuş !"),
    TCKN_UZUNLUK_HATASI("201", "Geçersiz TCKN: Uzunluk 11 haneli olmalıdır."),
    TCKN_ILK_RAKAM_HATASI("202", "Geçersiz TCKN: İlk hane 0 olamaz."),
    TCKN_SON_RAKAM_HATASI("203", "Geçersiz TCKN: Son hane çift sayı olmalıdır."),
    TCKN_ONUNCU_RAKAM_HATASI("204", "Geçersiz TCKN: 10. hane doğrulaması başarısız."),
    TCKN_ONBIRINCI_RAKAM_HATASI("205", "Geçersiz TCKN: 11. hane doğrulaması başarısız.");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
