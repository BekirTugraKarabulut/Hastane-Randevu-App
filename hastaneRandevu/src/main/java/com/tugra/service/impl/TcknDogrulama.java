package com.tugra.service.impl;

public class TcknDogrulama {

    public static String tcknDogrulama(String tckn){

        String dogrulanacakTckn = tckn;

        if (dogrulanacakTckn.length() != 11){
            return "Geçersiz TCKN: Uzunluk 11 haneli olmalıdır.";
        }

        if (Character.getNumericValue(dogrulanacakTckn.charAt(0)) == 0){
            return "Geçersiz TCKN: İlk hane 0 olamaz.";
        }

        if(Character.getNumericValue(dogrulanacakTckn.charAt(10)) % 2 == 1){
            return "Geçersiz TCKN: Son hane çift sayı olmalıdır.";
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
            return "Geçersiz TCKN: 10. hane doğrulaması başarısız.";
        }

        Integer ilk10BasamakToplami = tekBasamakToplamlari + ciftBasamakToplamlari + tcknDogrulama[9];

        if(ilk10BasamakToplami % 10 != tcknDogrulama[10]){
            return "Geçersiz TCKN: 11. hane doğrulaması başarısız.";
        }

        return tckn;
    }

}
