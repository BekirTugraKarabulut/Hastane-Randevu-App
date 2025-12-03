package com.tugra.service.impl;

import com.tugra.dto.DtoDepartman;
import com.tugra.dto.DtoDepartmanUI;
import com.tugra.dto.DtoHastane;
import com.tugra.model.Departman;
import com.tugra.model.Hastane;
import com.tugra.repository.DepartmanRepository;
import com.tugra.repository.HastaneRepository;
import com.tugra.service.DepartmanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmanServiceImpl implements DepartmanService {

    @Autowired
    private DepartmanRepository departmanRepository;

    @Autowired
    private HastaneRepository hastaneRepository;


    @Override
    public DtoDepartman createDepartman(DtoDepartmanUI dtoDepartmanUI) {

        Departman departman = new Departman();
        departman.setDepartmanId(dtoDepartmanUI.getDepartmanId());
        departman.setDepartmanAd(dtoDepartmanUI.getDepartmanAd());

        Hastane hastane = new Hastane();
        hastane.setHastaneId(dtoDepartmanUI.getHastane().getHastaneId());

        Optional<Hastane> optionalHastane = hastaneRepository.findByHastaneId(hastane.getHastaneId());

        if (optionalHastane.isPresent()) {

            departman.setHastane(optionalHastane.get());
            Departman dbDepartman = departmanRepository.save(departman);
            DtoDepartman dtoDepartman = new DtoDepartman();
            BeanUtils.copyProperties(dbDepartman, dtoDepartman);

            DtoHastane dtoHastane = new DtoHastane();
            dtoHastane.setHastaneId(dbDepartman.getHastane().getHastaneId());
            dtoHastane.setHastaneAd(dbDepartman.getHastane().getHastaneAd());
            dtoDepartman.setHastane(dtoHastane);

            return dtoDepartman;
        }else{
            return null;
        }

    }
}


