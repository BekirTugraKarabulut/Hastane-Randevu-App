package com.tugra.service;

import com.tugra.dto.DtoKullanici;
import com.tugra.dto.DtoKullaniciUI;
import com.tugra.exception.BaseException;
import com.tugra.model.Kullanici;
import com.tugra.model.Role;
import com.tugra.repository.AuthRepository;
import com.tugra.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AuthServiceImplTest {

    @Mock
    private AuthRepository authRepository;

    @InjectMocks
    private AuthServiceImpl authServiceImpl;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void register_success() {

        DtoKullaniciUI ui = new DtoKullaniciUI();
        ui.setUsername("testuser");
        ui.setPassword("plainPwd");
        ui.setAd("Ad");
        ui.setSoyad("Soyad");
        ui.setEmail("test@example.com");
        ui.setTelefonNo("5551230000");

        Mockito.when(authRepository.findByUsername(ui.getUsername())).thenReturn(Optional.empty());
        Mockito.when(authRepository.findByEmail(ui.getEmail())).thenReturn(Optional.empty());
        Mockito.when(authRepository.findByTelefonNo(ui.getTelefonNo())).thenReturn(Optional.empty());
        Mockito.when(bCryptPasswordEncoder.encode(ui.getPassword())).thenReturn("encodedPwd");

        ArgumentCaptor<Kullanici> captor = ArgumentCaptor.forClass(Kullanici.class);
        Mockito.when(authRepository.save(any(Kullanici.class))).thenAnswer(invocation -> invocation.getArgument(0));

        DtoKullanici result = authServiceImpl.register(ui);

        assertNotNull(result);
        assertEquals(ui.getUsername(), result.getUsername());
        assertEquals(ui.getEmail(), result.getEmail());
        verify(bCryptPasswordEncoder, times(1)).encode(ui.getPassword());
        verify(authRepository, times(1)).save(captor.capture());

        Kullanici saved = captor.getValue();
        assertEquals(ui.getUsername(), saved.getUsername());
        assertEquals("encodedPwd", saved.getPassword());
        assertEquals(Role.KULLANICI, saved.getRole());
        assertEquals(ui.getAd(), saved.getAd());
        assertEquals(ui.getSoyad(), saved.getSoyad());
        assertEquals(ui.getTelefonNo(), saved.getTelefonNo());
    }

    @Test
    void register_usernameAlreadyExists_throws() {

        DtoKullaniciUI ui = new DtoKullaniciUI();
        ui.setUsername("existingUser");
        ui.setPassword("pwd");
        ui.setAd("Ad");
        ui.setSoyad("Soyad");
        ui.setEmail("e@mail.com");
        ui.setTelefonNo("5550000000");

        Mockito.when(authRepository.findByUsername(ui.getUsername())).thenReturn(Optional.of(new Kullanici()));

        assertThrows(BaseException.class, () -> authServiceImpl.register(ui));
        verify(authRepository, never()).save(any());
    }

}
