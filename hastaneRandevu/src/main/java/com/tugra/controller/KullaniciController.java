package com.tugra.controller;

import com.tugra.dto.DtoKullanici;

import java.util.List;

public interface KullaniciController {

    public List<DtoKullanici> getAllKullanici();

    public void deleteKullaniciByUsername(String username);

    public DtoKullanici getKullaniciByUsername(String username);

    Long countKullanici();

}
