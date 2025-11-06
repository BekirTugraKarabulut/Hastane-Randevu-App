package com.tugra.model;

import lombok.Getter;

@Getter
public enum Role {

    KULLANICI("KULLANICI"),
    ADMIN("ADMIN"),
    HASTANE_CALISANI("HASTANE_CALISANI");

    private String value;

    Role(String value) {
        this.value = value;
    }


}
