package com.tugra.service.impl;

import com.tugra.dto.DtoHastane;
import com.tugra.model.Hastane;
import com.tugra.repository.HastaneRepository;
import com.tugra.service.HastaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HastaneServiceImpl implements HastaneService {

    @Autowired
    private HastaneRepository hastaneRepository;


    @Override
    public Hastane createHastane(DtoHastane dtoHastane) {

        Hastane hastane = new Hastane();
        hastane.setHastaneId(dtoHastane.getHastaneId());
        hastane.setHastaneAd(dtoHastane.getHastaneAd());
        Hastane dbHastane = hastaneRepository.save(hastane);

        return dbHastane;
    }
}
