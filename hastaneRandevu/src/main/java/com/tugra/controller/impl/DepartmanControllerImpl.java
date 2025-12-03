package com.tugra.controller.impl;

import com.tugra.controller.DepartmanController;
import com.tugra.dto.DtoDepartman;
import com.tugra.dto.DtoDepartmanUI;
import com.tugra.service.DepartmanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Departman Controller" , description = "Departman API İşlemleri")
@RequestMapping("/departman")
public class DepartmanControllerImpl implements DepartmanController {

    @Autowired
    private DepartmanService departmanService;

    @Override
    @PostMapping("departman-ekle")
    public DtoDepartman createDepartman(@RequestBody DtoDepartmanUI dtoDepartmanUI) {
        return departmanService.createDepartman(dtoDepartmanUI);
    }

}
