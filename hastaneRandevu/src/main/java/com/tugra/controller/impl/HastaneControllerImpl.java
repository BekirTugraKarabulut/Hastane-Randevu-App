package com.tugra.controller.impl;

import com.tugra.controller.HastaneController;
import com.tugra.dto.DtoHastane;
import com.tugra.model.Hastane;
import com.tugra.service.HastaneService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hastane Controller" , description = "Hastane API İşlemleri")
@RequestMapping("/hastane")
public class HastaneControllerImpl implements HastaneController {

    @Autowired
    private HastaneService hastaneService;

    @Override
    @PostMapping(path = "hastane-ekle")
    public Hastane createHastane(@RequestBody DtoHastane dtoHastane) {
        return hastaneService.createHastane(dtoHastane);
    }

}
