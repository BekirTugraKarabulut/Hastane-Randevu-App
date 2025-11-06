package com.tugra.service.impl;

import com.tugra.dto.DtoKullanici;
import com.tugra.dto.DtoKullaniciUI;
import com.tugra.dto.DtoRefreshToken;
import com.tugra.exception.BaseException;
import com.tugra.exception.ErrorMessage;
import com.tugra.exception.MessageType;
import com.tugra.jwt.AuthRequest;
import com.tugra.jwt.AuthResponse;
import com.tugra.jwt.JwtService;
import com.tugra.model.Kullanici;
import com.tugra.model.RefreshToken;
import com.tugra.model.Role;
import com.tugra.repository.AuthRepository;
import com.tugra.repository.RefreshTokenRepository;
import com.tugra.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Override
    public DtoKullanici register(DtoKullaniciUI dtoKullaniciUI) {

        Kullanici kullanici = new Kullanici();
        kullanici.setUsername(dtoKullaniciUI.getUsername());
        kullanici.setAd(dtoKullaniciUI.getAd());
        kullanici.setSoyad(dtoKullaniciUI.getSoyad());
        kullanici.setEmail(dtoKullaniciUI.getEmail());
        kullanici.setTelefonNo(dtoKullaniciUI.getTelefonNo());
        kullanici.setPassword(bCryptPasswordEncoder.encode(dtoKullaniciUI.getPassword()));
        kullanici.setRole(Role.KULLANICI);

        if(authRepository.findByUsername(kullanici.getUsername()).isPresent()){
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_ZATEN_VAR , kullanici.getUsername()));
        }

        if(authRepository.findByEmail(kullanici.getEmail()).isPresent()){
            throw new BaseException(new ErrorMessage(MessageType.EMAIL_ZATEN_VAR , kullanici.getEmail()));
        }

        if(authRepository.findByTelefonNo(kullanici.getTelefonNo()).isPresent()){
            throw new BaseException(new ErrorMessage(MessageType.TELEFON_ZATEN_VAR , kullanici.getTelefonNo()));
        }

        Kullanici dbKullanici = authRepository.save(kullanici);
        DtoKullanici dtoKullanici = new DtoKullanici();
        BeanUtils.copyProperties(dbKullanici, dtoKullanici);

        return dtoKullanici;
    }

    public RefreshToken createRefreshToken(Kullanici kullanici) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setKullanici(kullanici);
        refreshToken.setCreatedDate(new Date());
        refreshToken.setExpiresDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        refreshToken.setToken(UUID.randomUUID().toString());
        return refreshToken;
    }

    @Override
    public AuthResponse login(AuthRequest authRequest) {

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authenticationProvider.authenticate(token);

        Optional<Kullanici> kullanici = authRepository.findByUsername(authRequest.getUsername());

        if(kullanici.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.KULLANICI_BULUNAMADI , kullanici.get().toString()));
        }

        String accessToken = jwtService.generateToken(kullanici.get());
        RefreshToken refreshToken = createRefreshToken(kullanici.get());
        RefreshToken dbRefreshToken = refreshTokenRepository.save(refreshToken);

        return new AuthResponse(accessToken , dbRefreshToken.getToken());
    }

    public boolean isValidRefreshToken(Date expiredDate){

        return new Date().before(expiredDate);

    }


    @Override
    public AuthResponse refreshToken(DtoRefreshToken dtoRefreshToken) {

        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByToken(dtoRefreshToken.getToken());

        if(refreshToken.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_GEÇERSİZ , refreshToken.get().getToken()));
        }

        if(!isValidRefreshToken(refreshToken.get().getExpiresDate())){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_SURESI_DOLMUS , refreshToken.get().getExpiresDate().toString()));
        }

        Optional<Kullanici> kullanici = authRepository.findByUsername(refreshToken.get().getKullanici().getUsername());
        String accessToken = jwtService.generateToken(kullanici.get());
        RefreshToken createRefresh = createRefreshToken(kullanici.get());
        RefreshToken dbRefreshToken = refreshTokenRepository.save(createRefresh);

        return new AuthResponse(accessToken , dbRefreshToken.getToken());
    }

}
