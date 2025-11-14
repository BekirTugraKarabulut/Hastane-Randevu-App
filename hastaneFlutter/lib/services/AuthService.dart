import 'dart:convert';
import 'package:hastane_flutter/model/Kullanici.dart';
import 'package:http/http.dart' as http;

class AuthService {

  late Kullanici kullanici;

  Future<Kullanici?> register(String username , String ad , String soyad , String telefonNo , String email , String password) async{

    final url = Uri.parse("http://10.0.2.2:8091/register");

    final response = await http.post(
      url,
      headers: {'Content-Type': 'application/json'},
      body: json.encode
        (
          {
            "username" : username,
            "ad" : ad,
            "soyad" : soyad,
            "telefonNo" : telefonNo,
            "email" : email,
            "password" : password
          }
        )
    );

    if(response.statusCode == 200){

      final responseData = json.decode(response.body);

      return Kullanici(
        responseData['username'],
        responseData['ad'],
        responseData['soyad'],
        responseData['telefonNo'],
        responseData['email'],
        responseData['password'],
      );

    } else if (response.statusCode == 401){
      throw Exception('Giriş Bilgileri Hatalı');
    }else{
      return null;
    }
  }

}