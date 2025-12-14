import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';

class ProfilService{

      Future<Map<String , dynamic>> profilBilgileri(String username) async{

        SharedPreferences prefs = await SharedPreferences.getInstance();
        final accessToken = prefs.getString('accessToken');

        final url = Uri.parse("http://10.0.2.2:8091/rest/api/kullanici/$username");
        final response = await http.get(

          url,
          headers: {
            'Content-Type': 'application/json',
            "Authorization": "Bearer $accessToken",
          },
        );

        if(response.statusCode == 200){
          return jsonDecode(response.body);
        }
        else if (response.statusCode == 401){
          throw Exception("Unauthorized");
        }
        else{
          throw Exception("Failed to load profile information");
        }

      }
}