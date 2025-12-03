package com.tugra.controller.impl;

import com.tugra.controller.BolumController;
import com.tugra.dto.DtoBolum;
import com.tugra.dto.DtoBolumUI;
import com.tugra.service.BolumService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Bolum Controller" , description = "Bolum API İşlemleri")
@RequestMapping(path = "/bolum")
public class BolumControllerImpl implements BolumController {

    @Autowired
    private BolumService bolumService;


    @Override
    @PostMapping(path = "/bolum-ekle")
    public DtoBolum createBolum(@RequestBody DtoBolumUI dtoBolumUI) {
        return bolumService.createBolum(dtoBolumUI);
    }

}
