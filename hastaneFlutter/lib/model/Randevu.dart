import 'dart:ffi';

class Randevu{

    late String _username;
    late String _randevuTarihi;
    late String _randevuSaati;
    late Long _calisanId;

    Randevu(this._username, this._randevuTarihi, this._randevuSaati, this._calisanId);

    Long get calisanId => _calisanId;

    set calisanId(Long value) {
      _calisanId = value;
    }

    String get randevuSaati => _randevuSaati;

    set randevuSaati(String value) {
      _randevuSaati = value;
    }

    String get randevuTarihi => _randevuTarihi;

    set randevuTarihi(String value) {
      _randevuTarihi = value;
    }

    String get username => _username;

    set username(String value) {
      _username = value;
    }


}