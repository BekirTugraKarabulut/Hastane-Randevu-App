package com.tugra.service.impl;

import com.tugra.dto.DtoKullanici;
import com.tugra.exception.BaseException;
import com.tugra.exception.ErrorMessage;
import com.tugra.exception.MessageType;
import com.tugra.model.Kullanici;
import com.tugra.repository.KullaniciRepository;
import com.tugra.service.KullaniciService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KullaniciServiceImpl implements KullaniciService {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Override
    public List<DtoKullanici> getAllKullanici() {

        List<Kullanici> kullaniciList = kullaniciRepository.findAll();
        ArrayList<DtoKullanici> dtoKullaniciList = new ArrayList<>();

        for (Kullanici kullanici : kullaniciList) {
            DtoKullanici dtoKullanici = new DtoKullanici();
            BeanUtils.copyProperties(kullanici, dtoKullanici);
            dtoKullaniciList.add(dtoKullanici);
        }

        return dtoKullaniciList;
    }

    @Override
    public void deleteKullaniciByUsername(String username) {

        Optional<Kullanici> kullanici = kullaniciRepository.findKullaniciByUsername(username);

        if(kullanici.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.KULLANICI_BULUNAMADI , username));
        }

        kullaniciRepository.delete(kullanici.get());

    }

    @Override
    public DtoKullanici getKullaniciByUsername(String username) {

        Optional<Kullanici> kullanici = kullaniciRepository.findKullaniciByUsername(username);

        if(kullanici.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.KULLANICI_BULUNAMADI , username));
        }

        DtoKullanici dtoKullanici = new DtoKullanici();
        BeanUtils.copyProperties(kullanici.get(), dtoKullanici);
        return dtoKullanici;
    }

    @Cacheable(value = "kullaniciCache")
    public Long countKullanici(){
        return kullaniciRepository.count();
    }



}
