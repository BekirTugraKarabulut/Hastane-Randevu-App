package com.tugra.service.impl;

import com.tugra.exception.BaseException;
import com.tugra.exception.ErrorMessage;
import com.tugra.exception.MessageType;

public class TcknDogrulama {

    public static String tcknDogrulama(String tckn){

        String dogrulanacakTckn = tckn;

        if (dogrulanacakTckn.length() != 11){
            throw new BaseException(new ErrorMessage(MessageType.TCKN_UZUNLUK_HATASI,tckn.toString()));
        }

        if (Character.getNumericValue(dogrulanacakTckn.charAt(0)) == 0){
            throw new BaseException(new ErrorMessage(MessageType.TCKN_ILK_RAKAM_HATASI,tckn.toString()));
        }

        if(Character.getNumericValue(dogrulanacakTckn.charAt(10)) % 2 == 1){
            throw new BaseException(new ErrorMessage(MessageType.TCKN_SON_RAKAM_HATASI,tckn.toString()));
        }

        Integer[] tcknDogrulama = new Integer[11];

        for (int i = 0; i < 11; i++){

            tcknDogrulama[i] = Character.getNumericValue(dogrulanacakTckn.charAt(i));

        }

        Integer tekBasamakToplamlari = tcknDogrulama[0] + tcknDogrulama[2] + tcknDogrulama[4] + tcknDogrulama[6] + tcknDogrulama[8];
        Integer ciftBasamakToplamlari = tcknDogrulama[1] + tcknDogrulama[3] + tcknDogrulama[5] + tcknDogrulama[7];
        Integer tekBasamakCarpimSonucu = tekBasamakToplamlari * 7;

        Integer eldeEdilenSonuc = tekBasamakCarpimSonucu - ciftBasamakToplamlari;

        if(eldeEdilenSonuc % 10 != tcknDogrulama[9]){
            throw new BaseException(new ErrorMessage(MessageType.TCKN_ONUNCU_RAKAM_HATASI,tckn.toString()));
        }

        Integer ilk10BasamakToplami = tekBasamakToplamlari + ciftBasamakToplamlari + tcknDogrulama[9];

        if(ilk10BasamakToplami % 10 != tcknDogrulama[10]){
            throw new BaseException(new ErrorMessage(MessageType.TCKN_ONBIRINCI_RAKAM_HATASI,tckn.toString()));
        }

        return tckn;
    }

}
