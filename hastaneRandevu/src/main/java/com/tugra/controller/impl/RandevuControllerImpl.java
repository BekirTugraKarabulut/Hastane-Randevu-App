package com.tugra.controller.impl;

import com.tugra.controller.RandevuController;
import com.tugra.dto.DtoRandevu;
import com.tugra.dto.DtoRandevuUI;
import com.tugra.service.RandevuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/randevu")
@Tag(name = "Randevu Controller", description = "Randevu API İşlemleri")
public class RandevuControllerImpl implements RandevuController {

    @Autowired
    private RandevuService randevuService;

    @Override
    @PostMapping(path = "/randevuAl")
    public DtoRandevu randevuAl(@RequestBody DtoRandevuUI dtoRandevuUI) {
        return randevuService.randevuAl(dtoRandevuUI);
    }

}
