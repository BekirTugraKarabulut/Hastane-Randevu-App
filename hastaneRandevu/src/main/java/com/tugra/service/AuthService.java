package com.tugra.service;

import com.tugra.dto.DtoKullanici;
import com.tugra.dto.DtoKullaniciUI;
import com.tugra.dto.DtoRefreshToken;
import com.tugra.jwt.AuthRequest;
import com.tugra.jwt.AuthResponse;

public interface AuthService {

    public DtoKullanici register(DtoKullaniciUI dtoKullaniciUI);

    public AuthResponse login(AuthRequest authRequest);

    public AuthResponse refreshToken(DtoRefreshToken dtoRefreshToken);
}
