import 'dart:convert';

import 'package:http/http.dart' as http;

class KullaniciRandevuGetirService {

      Future<List<dynamic>> getAllRandevu(String username) async {
        
        final url = Uri.parse("http://10.0.2.2:8091/randevu/getRandevuByUsername/$username");

        final response = await http.get(

          url,
          headers:
                      {"Content-Type": "application/json"},
        );

        if(response.statusCode == 200){
          final data = jsonDecode(response.body);
          return data;
        }else{
          throw Exception("Failed to load randevu");
        }
      }

}