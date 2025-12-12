package com.tugra.service.impl;

import com.tugra.dto.DtoBolum;
import com.tugra.dto.DtoBolumUI;
import com.tugra.dto.DtoDepartman;
import com.tugra.dto.DtoHastane;
import com.tugra.model.Bolum;
import com.tugra.model.Departman;
import com.tugra.model.Hastane;
import com.tugra.repository.BolumRepository;
import com.tugra.repository.DepartmanRepository;
import com.tugra.repository.HastaneRepository;
import com.tugra.service.BolumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BolumServiceImpl implements BolumService {

    @Autowired
    private BolumRepository bolumRepository;

    @Autowired
    private DepartmanRepository departmanRepository;

    @Autowired
    private HastaneRepository hastaneRepository;

    @Override
    public DtoBolum createBolum(DtoBolumUI dtoBolumUI) {

        Bolum bolum = new Bolum();
        bolum.setBolumId(dtoBolumUI.getBolumId());
        bolum.setBolumAd(dtoBolumUI.getBolumAd());

        Departman departman = new Departman();
        departman.setDepartmanId(dtoBolumUI.getDepartmen().getDepartmanId());
        Optional<Departman> departmanOptional = departmanRepository.findByDepartmanId(departman.getDepartmanId());

        if(departmanOptional.isPresent()) {
            bolum.setDepartmen(departmanOptional.get());
        }

        Hastane hastane = new Hastane();
        hastane.setHastaneId(dtoBolumUI.getHastane().getHastaneId());
        Optional<Hastane> hastaneOptional = hastaneRepository.findByHastaneId(hastane.getHastaneId());

        if(hastaneOptional.isPresent()) {
            bolum.setHastane(hastaneOptional.get());
        }

        Bolum dbBolum = bolumRepository.save(bolum);

        DtoBolum dtoBolum = new DtoBolum();
        BeanUtils.copyProperties(dbBolum,dtoBolum);

        DtoDepartman dtoDepartman = new DtoDepartman();
        dtoDepartman.setDepartmanId(dbBolum.getDepartmen().getDepartmanId());
        dtoDepartman.setDepartmanAd(dbBolum.getDepartmen().getDepartmanAd());
        dtoBolum.setDepartmen(dtoDepartman);

        DtoHastane dtoHastane = new DtoHastane();
        dtoHastane.setHastaneId(dbBolum.getHastane().getHastaneId());
        dtoHastane.setHastaneAd(dbBolum.getHastane().getHastaneAd());
        dtoBolum.setHastane(dtoHastane);

        return dtoBolum;
    }

    public Bolum bolumKontrol(Long bolumId){

        Optional<Bolum> bolumOptional = bolumRepository.findByBolumId(bolumId);

        if(bolumOptional.isPresent()){
            return bolumOptional.get();
        } else {
            return null;
        }
    }

}
