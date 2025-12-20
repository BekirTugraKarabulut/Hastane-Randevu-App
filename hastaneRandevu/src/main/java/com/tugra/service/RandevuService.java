package com.tugra.service;

import com.tugra.dto.DtoRandevu;
import com.tugra.dto.DtoRandevuUI;

import java.util.List;

public interface RandevuService {

    public DtoRandevu randevuAl(DtoRandevuUI dtoRandevuUI);

    public List<DtoRandevu> getRandevuByUsernmame(String username);

}
