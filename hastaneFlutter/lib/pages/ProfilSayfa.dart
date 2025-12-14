import 'package:flutter/material.dart';
import 'package:hastane_flutter/pages/GirisSayfa.dart';
import 'package:hastane_flutter/services/ProfilService.dart';

class Profilsayfa extends StatefulWidget {

    String username;

    Profilsayfa({super.key, required this.username});

  @override
  State<Profilsayfa> createState() => _ProfilsayfaState();
}

class _ProfilsayfaState extends State<Profilsayfa> {

  ProfilService _profilService = new ProfilService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Profil Sayfası" , style: TextStyle(color: Colors.white ,fontWeight:  FontWeight.bold),),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
        actions: [
          Padding(
            padding: const EdgeInsets.only(right: 15),
            child: IconButton(onPressed: (){
                Navigator.pushReplacement(context, MaterialPageRoute(builder: (context) => Girissayfa()));
            }, icon: Icon(Icons.logout,color: Colors.red,)),
          )
        ],
      ),
      body: Center(
        child: Column(
          children: [
              FutureBuilder(
                  future: _profilService.profilBilgileri(widget.username), 
                  builder: (context, snapshot) {
                    if(snapshot.hasData){
                      var bilgiler = snapshot.data!;
                      return Padding(
                        padding: const EdgeInsets.only(top: 25),
                        child: Column(
                          children: [
                                Image.asset("images/profile (1).jpeg" , width: 200, height: 200,),
                                Padding(
                                  padding: const EdgeInsets.only(top: 35),
                                  child: Column(crossAxisAlignment: CrossAxisAlignment.start,
                                    children: [
                                      Text("TC NO : " + bilgiler["username"]),
                                      Text("Ad : " + bilgiler["ad"]),
                                      Text("Soyad : " + bilgiler["soyad"]),
                                      Text("Telefon Numarası : " + bilgiler["telefonNo"]),
                                      Text("Email : " + bilgiler["email"]),
                                    ],
                                  ),
                                ),
                          ],
                        ),
                      );
                    }
                    else{
                      return CircularProgressIndicator();
                    }
                  },
              )
          ],
        ),
      ),
    );
  }
}
