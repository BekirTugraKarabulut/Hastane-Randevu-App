package com.tugra.controller.impl;

import com.tugra.controller.AuthController;
import com.tugra.dto.DtoKullanici;
import com.tugra.dto.DtoKullaniciUI;
import com.tugra.dto.DtoRefreshToken;
import com.tugra.jwt.AuthRequest;
import com.tugra.jwt.AuthResponse;
import com.tugra.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static com.tugra.config.RestApis.*;

@RestController
@Tag(name = "Auth Controller", description = "Kullanıcı Kayıt, Giriş ve Token Yenile")
public class AuthControllerImpl implements AuthController {

    @Autowired
    private AuthService authService;

    @Override
    @PostMapping(path = REGISTER)
    public DtoKullanici register(@Valid @RequestBody DtoKullaniciUI dtoKullaniciUI) {
        return authService.register(dtoKullaniciUI);
    }

    @Override
    @PostMapping(path = LOGIN)
    public AuthResponse login(@Valid @RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @Override
    @PostMapping(path = REFRESH_TOKEN)
    public AuthResponse refreshToken(@RequestBody DtoRefreshToken dtoRefreshToken) {
        return authService.refreshToken(dtoRefreshToken);
    }

}
