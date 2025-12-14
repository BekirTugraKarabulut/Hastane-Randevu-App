package com.tugra.controller.impl;

import com.tugra.controller.KullaniciController;
import com.tugra.dto.DtoKullanici;
import com.tugra.service.KullaniciService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.tugra.config.RestApis.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api")
@Tag(name = "Kullanici Controller" , description = "Kullanici API İşlemleri")
public class KullaniciControllerImpl implements KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;

    @GetMapping(GET_ALL_KULLANICI)
    @Override
    public List<DtoKullanici> getAllKullanici() {
        return kullaniciService.getAllKullanici();
    }

    @DeleteMapping(DELETE_KULLANICI_BY_USERNAME)
    @Override
    public void deleteKullaniciByUsername(@PathVariable(name = "username" , required = true) String username) {
        kullaniciService.deleteKullaniciByUsername(username);
    }

    @GetMapping(GET_KULLANICI_BY_USERNAME)
    @Override
    public DtoKullanici getKullaniciByUsername(@PathVariable(name = "username" , required = true) String username) {
        return kullaniciService.getKullaniciByUsername(username);
    }

    @Override
    @GetMapping(path = "/countKullanici")
    public Long countKullanici() {
        return kullaniciService.countKullanici();
    }

}
