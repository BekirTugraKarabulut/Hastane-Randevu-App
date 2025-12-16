package com.tugra.service;

import com.tugra.repository.AuthRepository;
import com.tugra.service.impl.TcknDogrulama;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class TcknDogrulamaTest {

    @InjectMocks
    private TcknDogrulama tcknDogrulama;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void basariliTcknDogrulamaTest(){
        String tckn = "10000000146";
        String result = TcknDogrulama.tcknDogrulama(tckn);
        assert(result.equals(tckn));
    }


}
