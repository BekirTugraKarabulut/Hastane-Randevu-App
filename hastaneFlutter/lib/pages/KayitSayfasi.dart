import 'package:flutter/material.dart';
import 'package:hastane_flutter/model/Kullanici.dart';
import 'package:hastane_flutter/pages/GirisSayfa.dart';
import 'package:hastane_flutter/services/AuthService.dart';

class Kayitsayfasi extends StatefulWidget {
  const Kayitsayfasi({super.key});

  @override
  State<Kayitsayfasi> createState() => _KayitsayfasiState();
}

class _KayitsayfasiState extends State<Kayitsayfasi> {

  final AuthService _authService = AuthService();
  late Kullanici kullanici;

  var usernameKontrol = TextEditingController();
  var adKontrol = TextEditingController();
  var soyadKontrol  = TextEditingController();
  var telefonNoKontrol  = TextEditingController();
  var emailKontrol  = TextEditingController();
  var passwordKontrol  = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Kayıt Ekranı" , style: TextStyle(color: Colors.white ,fontWeight:  FontWeight.bold),),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.only(top: 20),
        child: SingleChildScrollView(
          child: Center(
            child: Column(
              children: [
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(5),
                      child: TextField(
                        style: TextStyle(fontWeight:  FontWeight.bold),
                        controller: usernameKontrol,
                        keyboardType: TextInputType.number,
                        decoration: InputDecoration(
                            contentPadding: EdgeInsets.only(top: 15),
                            hintText: "Tc No",
                            hintStyle: TextStyle(fontWeight: FontWeight.bold),
                            enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.black)
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.black)
                            ),
                            disabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.black)
                            ),
                          suffixIcon: Icon(Icons.account_box_rounded , color: Colors.blueAccent,)
                        ),
                      ),
                    ),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(5),
                      child: TextField(
                        controller: adKontrol,
                        keyboardType: TextInputType.text,
                        decoration: InputDecoration(
                            contentPadding: EdgeInsets.only(top: 15),
                            hintText: "Ad",
                            hintStyle: TextStyle(fontWeight: FontWeight.bold),
                            enabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            focusedBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            disabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            suffixIcon: Icon(Icons.account_box_rounded , color: Colors.blueAccent,)
                        ),
                      ),
                    ),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(5),
                      child: TextField(
                        controller: soyadKontrol,
                        keyboardType: TextInputType.text,
                        decoration: InputDecoration(
                            contentPadding: EdgeInsets.only(top: 15),
                            hintText: "Soyad",
                            hintStyle: TextStyle(fontWeight: FontWeight.bold),
                            enabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            focusedBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            disabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            suffixIcon: Icon(Icons.account_box_rounded , color: Colors.blueAccent,)
                        ),
                      ),
                    ),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(5),
                      child: TextField(
                        controller: telefonNoKontrol,
                        keyboardType: TextInputType.number,
                        decoration: InputDecoration(
                            contentPadding: EdgeInsets.only(top: 15),
                            hintText: "Telefon No",
                            hintStyle: TextStyle(fontWeight: FontWeight.bold),
                            enabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            focusedBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            disabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            suffixIcon: Icon(Icons.phone , color: Colors.blueAccent,)
                        ),
                      ),
                    ),
                  ),
                ),Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(5),
                      child: TextField(
                        controller: emailKontrol,
                        keyboardType:  TextInputType.text,
                        decoration: InputDecoration(
                            contentPadding: EdgeInsets.only(top: 15),
                            hintText: "E-mail",
                            hintStyle: TextStyle(fontWeight: FontWeight.bold),
                            enabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            focusedBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            disabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            suffixIcon: Icon(Icons.mail , color: Colors.blueAccent,)
                        ),
                      ),
                    ),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Padding(
                      padding: const EdgeInsets.all(5),
                      child: TextField(
                        controller: passwordKontrol,
                        keyboardType: TextInputType.text,
                        obscureText: true,
                        decoration: InputDecoration(
                            contentPadding: EdgeInsets.only(top: 15),
                            hintText: "Password",
                            hintStyle: TextStyle(fontWeight: FontWeight.bold),
                            enabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            focusedBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            disabledBorder: UnderlineInputBorder(
                                borderSide: BorderSide(color: Colors.black)
                            ),
                            suffixIcon: Icon(Icons.key , color: Colors.blueAccent,)
                        ),
                      ),
                    ),
                  ),
                ),
                Padding(
                  padding: const EdgeInsets.only(top: 35),
                  child: ElevatedButton( style: ElevatedButton.styleFrom(backgroundColor: Colors.green) ,onPressed: (){
          
                    if(usernameKontrol.text.isEmpty ||
                       adKontrol.text.isEmpty ||
                        soyadKontrol.text.isEmpty ||
                        telefonNoKontrol.text.isEmpty ||
                        emailKontrol.text.isEmpty ||
                        passwordKontrol.text.isEmpty
                    ){
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(content: Text("Lütfen Tüm Alanları Doldurunuz"),
                        action: SnackBarAction(label: "Tamam", onPressed: (){}),
                        )
                      );
                      return;
                    }
          
                    _authService.register(
                        usernameKontrol.text,
                        adKontrol.text,
                        soyadKontrol.text,
                        telefonNoKontrol.text,
                        emailKontrol.text,
                        passwordKontrol.text,
                    ).then((value) {
                      if(value != null){
                        kullanici = value;
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(content: Text("Kayıt Başarılı Hoşgeldiniz ${kullanici.ad}") ,)
                        );
                        Navigator.push(context, MaterialPageRoute(builder: (context) => Girissayfa()));
                      } else {
                        ScaffoldMessenger.of(context).showSnackBar(
                            SnackBar(content: Text("Kayıt Başarısız Tekrar Deneyiniz !"),)
                        );
                        return;
                      }
                    });
                  }, child: Text("Kayıt Ol" , style: TextStyle(color: Colors.white),)),
                ),
                Padding(
                  padding: const EdgeInsets.only(top: 15),
                  child: Row(mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text("Hesabınız var mı? ", style: TextStyle(color: Colors.black , fontWeight: FontWeight.w600),),
                      GestureDetector(
                          onTap: () => Navigator.push(context, MaterialPageRoute(builder: (context) => Girissayfa())),
                          child: Text("Giriş Yap" , style: TextStyle(color: Colors.black , fontWeight: FontWeight.bold , decoration: TextDecoration.underline),))
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
