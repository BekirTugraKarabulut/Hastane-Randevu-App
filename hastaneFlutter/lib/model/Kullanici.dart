class Kullanici{

  late String _username;
  late String _ad;
  late String _soyad;
  late String _telefonNo;
  late String _email;
  late String _password;

  Kullanici(this._username, this._ad, this._soyad, this._telefonNo, this._email,
      this._password);

  String get password => _password;

  set password(String value) {
    _password = value;
  }

  String get email => _email;

  set email(String value) {
    _email = value;
  }

  String get telefonNo => _telefonNo;

  set telefonNo(String value) {
    _telefonNo = value;
  }

  String get soyad => _soyad;

  set soyad(String value) {
    _soyad = value;
  }

  String get ad => _ad;

  set ad(String value) {
    _ad = value;
  }

  String get username => _username;

  set username(String value) {
    _username = value;
  }

}