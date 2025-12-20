package com.tugra.controller;

import com.tugra.dto.DtoCalisanlar;
import com.tugra.dto.DtoCalisanlarUI;
import com.tugra.jwt.AuthResponse;
import com.tugra.jwt.CalisanRequest;

import java.util.List;

public interface CalisanlarController {

    public DtoCalisanlar kayitOl(DtoCalisanlarUI dtoCalisanlarUI);

    public AuthResponse girisYap(CalisanRequest calisanRequest);

    public List<DtoCalisanlar> allCalisanlar();

}
