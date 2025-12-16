import 'package:flutter/material.dart';
import 'package:hastane_flutter/pages/Anasayfa.dart';
import 'package:hastane_flutter/pages/KayitSayfasi.dart';
import 'package:hastane_flutter/services/LoginService.dart';
import 'package:lottie/lottie.dart';

class Girissayfa extends StatefulWidget {
  const Girissayfa({super.key});

  @override
  State<Girissayfa> createState() => _GirissayfaState();
}

class _GirissayfaState extends State<Girissayfa> {

  LoginService _loginService = new LoginService();

  var usernameKontrol = TextEditingController();
  var passwordKontrol  = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Giriş Ekranı" , style: TextStyle(color: Colors.white ,fontWeight:  FontWeight.bold),),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
      ),
      body: SingleChildScrollView(
        child: Center(
          child: Column(
            children: [
                Lottie.asset("asset/Login.json" , width: 280 , height: 280),
              Padding(
                padding: const EdgeInsets.only(top: 5 , left: 20 , right: 20),
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
                padding: const EdgeInsets.only(top: 25 , left: 20 , right: 20),
                child: Container(
                  decoration: BoxDecoration(
                    border: Border.all(color: Colors.black),
                    borderRadius: BorderRadius.circular(10),
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(5),
                    child: TextField(
                      style: TextStyle(fontWeight:  FontWeight.bold),
                      controller: passwordKontrol,
                      obscureText: true,
                      keyboardType: TextInputType.text,
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
                padding: const EdgeInsets.only(top: 30),
                child: ElevatedButton(style: ElevatedButton.styleFrom(backgroundColor: Colors.green),onPressed: () async{

                    if(usernameKontrol.text.isEmpty || passwordKontrol.text.isEmpty){
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(content: Text("Tüm alanları doldurunuz !"),
                        action: SnackBarAction(label: "Tamam", onPressed: (){}),)
                      );
                      return;
                    }
        
                    bool result = await _loginService.login(usernameKontrol.text, passwordKontrol.text);

                    if(result){
                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(content: Text("Giriş Başarılı."),
                        action: SnackBarAction(label: "Tamam", onPressed: (){}),)
                      );
                      Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => Anasayfa(username: usernameKontrol.text)));
                    }
                    else{
                      ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(content: Text("Giriş Bilgileri Hatalı !"),
                            action: SnackBarAction(label: "Tamam", onPressed: (){}),
                          )
                      );
                      return;
                    }

                }, child: Text("Giriş Yap",style: TextStyle(color: Colors.white , fontWeight: FontWeight.bold),)),
              ),
              Row( mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text("Hesabınız yok mu?",style: TextStyle(color: Colors.black),),
                  Padding(
                    padding: const EdgeInsets.only(left: 5),
                    child: GestureDetector(
                        onTap: () => Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => Kayitsayfasi())),
                        child: Text("Kayıt Ol" , style: TextStyle(color: Colors.black , fontWeight: FontWeight.bold,decoration: TextDecoration.underline),)),
                  )
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}
