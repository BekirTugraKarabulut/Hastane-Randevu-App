package com.tugra.controller;

import com.tugra.dto.DtoRandevu;
import com.tugra.dto.DtoRandevuUI;

import java.util.List;

public interface RandevuController {

    public DtoRandevu randevuAl(DtoRandevuUI dtoRandevuUI);

    public List<DtoRandevu> getRandevuByUsernmame(String username);

}
