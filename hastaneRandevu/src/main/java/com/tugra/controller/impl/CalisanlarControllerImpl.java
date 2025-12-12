package com.tugra.controller.impl;

import com.tugra.controller.CalisanlarController;
import com.tugra.dto.DtoCalisanlar;
import com.tugra.dto.DtoCalisanlarUI;
import com.tugra.jwt.AuthResponse;
import com.tugra.jwt.CalisanRequest;
import com.tugra.service.CalisanlarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calisanlar")
@Tag(name = "Calisanlar Controller", description = "Calisanlarin API Islemleri")
public class CalisanlarControllerImpl implements CalisanlarController {

    @Autowired
    private CalisanlarService calisanlarService;


    @Override
    @PostMapping(path = "/kayitOl")
    public DtoCalisanlar kayitOl(@RequestBody DtoCalisanlarUI dtoCalisanlarUI) {
        return calisanlarService.kayitOl(dtoCalisanlarUI);
    }

    @Override
    @PostMapping(path = "/girisYap")
    public AuthResponse girisYap(@RequestBody CalisanRequest calisanRequest) {
        return calisanlarService.girisYap(calisanRequest);
    }

}
