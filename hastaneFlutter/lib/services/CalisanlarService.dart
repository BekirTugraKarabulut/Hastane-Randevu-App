import 'dart:convert';
import 'package:http/http.dart' as http;

class CalisanlarService {
  
     Future<List<dynamic>> calisanlariGetir()  async {
       
       final url = Uri.parse("http://10.0.2.2:8091/calisanlar/allCalisanlar");

       final response = await http.get(

          url,
          headers: {
            "Content-Type": "application/json",
          }

       );

       if(response.statusCode == 200){
          final data = jsonDecode(response.body);
          return data;
       }else{
          throw Exception("Çalışanlar getirilemedi");
       }
     }

}