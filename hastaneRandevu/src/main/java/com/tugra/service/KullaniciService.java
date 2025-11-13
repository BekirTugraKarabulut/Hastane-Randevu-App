package com.tugra.service;

import com.tugra.dto.DtoKullanici;

import java.util.List;

public interface KullaniciService {

    public List<DtoKullanici> getAllKullanici();

    public void deleteKullaniciByUsername(String username);

    public DtoKullanici getKullaniciByUsername(String username);

}
