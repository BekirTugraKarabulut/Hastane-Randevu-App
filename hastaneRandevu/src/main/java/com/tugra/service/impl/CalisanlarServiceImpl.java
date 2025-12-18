package com.tugra.service.impl;

import com.tugra.dto.DtoBolum;
import com.tugra.dto.DtoCalisanlar;
import com.tugra.dto.DtoCalisanlarUI;
import com.tugra.exception.BaseException;
import com.tugra.exception.ErrorMessage;
import com.tugra.exception.MessageType;
import com.tugra.jwt.AuthResponse;
import com.tugra.jwt.CalisanRequest;
import com.tugra.jwt.JwtService;
import com.tugra.model.*;
import com.tugra.repository.CalisanRefreshTokenRepository;
import com.tugra.repository.CalisanlarRepository;
import com.tugra.service.CalisanlarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class CalisanlarServiceImpl implements CalisanlarService {

    private Logger logger = Logger.getLogger(CalisanlarServiceImpl.class.getName());

    @Autowired
    private CalisanlarRepository calisanlarRepository;

    @Autowired
    private BolumServiceImpl bolumServiceImpl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private CalisanRefreshTokenRepository calisanRefreshTokenRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public DtoCalisanlar kayitOl(DtoCalisanlarUI dtoCalisanlarUI) {

        Calisanlar calisanlar = new Calisanlar();
        calisanlar.setCalisanId(dtoCalisanlarUI.getCalisanId());
        calisanlar.setCalisanAd(dtoCalisanlarUI.getCalisanAd());
        calisanlar.setCalisanSoyad(dtoCalisanlarUI.getCalisanSoyad());
        calisanlar.setTelefonNo(dtoCalisanlarUI.getTelefonNo());
        calisanlar.setPassword(bCryptPasswordEncoder.encode(dtoCalisanlarUI.getPassword()));
        calisanlar.setRole(dtoCalisanlarUI.getRole());

        Bolum bolum = new Bolum();
        bolum.setBolumId(dtoCalisanlarUI.getBolum().getBolumId());
        bolumServiceImpl.bolumKontrol(bolum.getBolumId());

        calisanlar.setBolum(bolum);
        Calisanlar dbCalisanlar = calisanlarRepository.save(calisanlar);

        DtoCalisanlar dtoCalisanlar = new DtoCalisanlar();
        BeanUtils.copyProperties(dbCalisanlar, dtoCalisanlar);

        DtoBolum dtoBolum = new DtoBolum();
        BeanUtils.copyProperties(dbCalisanlar.getBolum(), dtoBolum);
        dtoCalisanlar.setBolum(dtoBolum);

        return dtoCalisanlar;
    }

    public RefreshTokenCalisanlar createRefreshToken(Calisanlar calisanlar) {
        RefreshTokenCalisanlar refreshTokenCalisanlar = new RefreshTokenCalisanlar();
        refreshTokenCalisanlar.setCalisanlar(calisanlar);
        refreshTokenCalisanlar.setToken(UUID.randomUUID().toString());
        refreshTokenCalisanlar.setCreatedDate(new Date());
        refreshTokenCalisanlar.setExpiresDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
        return refreshTokenCalisanlar;
    }

    @Override
    public AuthResponse girisYap(CalisanRequest calisanRequest) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(calisanRequest.getCalisanId(), calisanRequest.getPassword());
        authenticationProvider.authenticate(authenticationToken);

        Optional<Calisanlar> calisan = calisanlarRepository.findByCalisanId(calisanRequest.getCalisanId());

        if(calisan.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.KULLANICI_BULUNAMADI , calisan.get().getCalisanId().toString()));
        }

        String accessToken = jwtService.generateToken(calisan.get());
        RefreshTokenCalisanlar refreshTokenCalisanlar = createRefreshToken(calisan.get());
        RefreshTokenCalisanlar dbRefreshTokenCalisanlar = calisanRefreshTokenRepository.save(refreshTokenCalisanlar);

        return new AuthResponse(accessToken , dbRefreshTokenCalisanlar.getToken());
    }

    public Calisanlar calisanGetir(Long calisanId){

        Optional<Calisanlar> calisanlar = calisanlarRepository.findByCalisanId(calisanId);

        if(calisanlar.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.CALISAN_BULUNAMADI , calisanId.toString()));
        }

        return calisanlar.get();
    }

}
