import 'dart:convert';

import 'package:http/http.dart' as http;

class RandevuAlService {

      Future<bool> randevuAl(String username , String dateTime , String randevuSaati , calisanId) async {

        final url = Uri.parse("http://10.0.2.2:8091/randevu/randevuAl");
        final response = await http.post(

          url,
          headers: {
            "Content-Type": "application/json",
          },
          body: jsonEncode
            (
              {
                "randevuTarihi": dateTime,
                "randevuSaati": randevuSaati,
                "kullanici" :
                    {
                      "username": username,
                    },
                 "calisanlar" :
                    {
                      "calisanId": calisanId,
                    }
              }
            )
        );

        if(response.statusCode == 200){
          final data = jsonDecode(response.body);
          print("API Bilgileri : $data");
          return true;
        }
        else if (response.statusCode == 401){
          return false;
        }
        else{
          return false;
        }

      }

}