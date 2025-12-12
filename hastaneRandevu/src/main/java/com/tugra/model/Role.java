package com.tugra.model;

import lombok.Getter;

@Getter
public enum Role {

    KULLANICI("KULLANICI"),
    ADMIN("ADMIN"),
    DOKTOR("DOKTOR"),
    HEMSIRE("HEMSIRE"),
    CERRAH("CERRAH"),
    STAJYER("STAJYER"),
    HIZMETLI("HIZMETLI");

    private String value;

    Role(String value) {
        this.value = value;
    }


}
