package com.tugra.service.impl;

import com.tugra.dto.*;
import com.tugra.model.Bolum;
import com.tugra.model.Calisanlar;
import com.tugra.model.Kullanici;
import com.tugra.model.Randevu;
import com.tugra.repository.RandevuRepository;
import com.tugra.service.RandevuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandevuServiceImpl implements RandevuService {

    @Autowired
    private RandevuRepository randevuRepository;

    @Autowired
    private CalisanlarServiceImpl calisanlarServiceImpl;

    @Autowired
    private KullaniciServiceImpl kullaniciServiceImpl;

    @Override
    public DtoRandevu randevuAl(DtoRandevuUI dtoRandevuUI) {

        Randevu randevu = new Randevu();
        randevu.setRandevuSaati(dtoRandevuUI.getRandevuSaati());
        randevu.setRandevuTarihi(dtoRandevuUI.getRandevuTarihi());

        Kullanici kullanici = new Kullanici();
        kullanici.setUsername(dtoRandevuUI.getKullanici().getUsername());
        Kullanici kullaniciBilgileri = kullaniciServiceImpl.getKullanici(kullanici.getUsername());
        randevu.setKullanici(kullaniciBilgileri);

        Calisanlar calisanlar = new Calisanlar();
        calisanlar.setCalisanId(dtoRandevuUI.getCalisanlar().getCalisanId());
        Calisanlar calisanBilgileri = calisanlarServiceImpl.calisanGetir(calisanlar.getCalisanId());

        Bolum bolum = calisanBilgileri.getBolum();
        randevu.setBolum(bolum);

        randevu.setCalisanlar(calisanBilgileri);

        Randevu dbRandevu = randevuRepository.save(randevu);
        DtoRandevu dtoRandevu = new DtoRandevu();
        BeanUtils.copyProperties(dbRandevu, dtoRandevu);

        DtoKullanici dtoKullanici = new DtoKullanici();
        BeanUtils.copyProperties(dbRandevu.getKullanici(), dtoKullanici);
        dtoRandevu.setKullanici(dtoKullanici);

        DtoCalisanlar dtoCalisanlar = new DtoCalisanlar();
        BeanUtils.copyProperties(dbRandevu.getCalisanlar(), dtoCalisanlar);
        dtoRandevu.setCalisanlar(dtoCalisanlar);

        DtoBolum dtoBolum = new DtoBolum();
        BeanUtils.copyProperties(dbRandevu.getBolum(), dtoBolum);
        dtoCalisanlar.setBolum(dtoBolum);

        return dtoRandevu;
    }

    @Override
    public List<DtoRandevu> getRandevuByUsernmame(String username) {

        Kullanici kullanici = new Kullanici();
        kullanici.setUsername(username);
        Kullanici kullaniciBilgileri = kullaniciServiceImpl.getKullanici(kullanici.getUsername());

        List<Randevu> randevuList = randevuRepository.findByKullanici_Username(kullaniciBilgileri.getUsername());
        List<DtoRandevu> dtoRandevuList = new ArrayList<>();

        for(Randevu randevu : randevuList) {
            DtoRandevu dtoRandevu = new DtoRandevu();
            BeanUtils.copyProperties(randevu, dtoRandevu);

            DtoKullanici dtoKullanici = new DtoKullanici();
            BeanUtils.copyProperties(randevu.getKullanici(), dtoKullanici);
            dtoRandevu.setKullanici(dtoKullanici);

            DtoCalisanlar dtoCalisanlar = new DtoCalisanlar();
            BeanUtils.copyProperties(randevu.getCalisanlar(), dtoCalisanlar);
            DtoBolum dtoBolum = new DtoBolum();
            BeanUtils.copyProperties(randevu.getCalisanlar().getBolum(), dtoBolum);
            dtoCalisanlar.setBolum(dtoBolum);
            dtoRandevu.setCalisanlar(dtoCalisanlar);

            dtoRandevuList.add(dtoRandevu);
        }

        return dtoRandevuList;
    }


}
