import 'package:flutter/material.dart';
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
      body: Center(
        child: Column(
          children: [
              Padding(
                padding: const EdgeInsets.only(top: 25 , right: 10),
                child: Container(
                  height: 15,
                  child: Row(mainAxisAlignment: MainAxisAlignment.end,
                    children: [
                      IconButton(onPressed: (){}, icon: Icon(Icons.logout,size: 25,color: Colors.red,))
                    ],
                  ),
                ),
              ),
              FutureBuilder(
                  future: _profilService.profilBilgileri(widget.username), 
                  builder: (context, snapshot) {
                    if(snapshot.hasData){
                      var bilgiler = snapshot.data!;
                      return Padding(
                        padding: const EdgeInsets.only(top: 5),
                        child: Column(
                          children: [
                                Padding(
                                  padding: const EdgeInsets.only(top: 45),
                                  child: Image.asset("images/profile (1).jpeg" , width: 200, height: 200,),
                                ),
                                Padding(
                                  padding: const EdgeInsets.only(top: 35),
                                  child: Column(crossAxisAlignment: CrossAxisAlignment.start,
                                    children: [
                                      Container(
                                        width: 320,
                                        height: 45,
                                        decoration: BoxDecoration(
                                            borderRadius: BorderRadius.all(Radius.circular(10))
                                            ,border: Border.all(
                                            color: Colors.black
                                        )
                                        ),
                                        child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                          children: [
                                            Padding(
                                              padding: const EdgeInsets.only(left: 12),
                                              child: Text("TC Kimlik No : " + bilgiler["username"]),
                                            ),
                                            Padding(
                                              padding: const EdgeInsets.only(right: 12),
                                              child: Icon(Icons.account_box_rounded),
                                            )
                                          ],
                                        ),
                                      ),
                                      Padding(
                                        padding: const EdgeInsets.only(top: 10),
                                        child: Container(
                                          width: 320,
                                          height: 45,
                                          decoration: BoxDecoration(
                                              borderRadius: BorderRadius.all(Radius.circular(10))
                                              ,border: Border.all(
                                              color: Colors.black
                                          )
                                          ),
                                          child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.only(left: 12),
                                                child: Text("Ad : " + bilgiler["ad"]),
                                              ),
                                              Padding(
                                                padding: const EdgeInsets.only(right: 12),
                                                child: Icon(Icons.account_box_rounded),
                                              )
                                            ],
                                          ),
                                        ),
                                      ),
                                      Padding(
                                        padding: const EdgeInsets.only(top: 10),
                                        child: Container(
                                          width: 320,
                                          height: 45,
                                          decoration: BoxDecoration(
                                              borderRadius: BorderRadius.all(Radius.circular(10))
                                              ,border: Border.all(
                                              color: Colors.black
                                          )
                                          ),
                                          child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.only(left: 12),
                                                child: Text("Soyad : " + bilgiler["soyad"]),
                                              ),
                                              Padding(
                                                padding: const EdgeInsets.only(right: 12),
                                                child: Icon(Icons.account_box_rounded),
                                              )
                                            ],
                                          ),
                                        ),
                                      ),
                                      Padding(
                                        padding: const EdgeInsets.only(top: 10),
                                        child: Container(
                                          width: 320,
                                          height: 45,
                                          decoration: BoxDecoration(
                                              borderRadius: BorderRadius.all(Radius.circular(10))
                                              ,border: Border.all(
                                              color: Colors.black
                                          )
                                          ),
                                          child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.only(left: 12),
                                                child: Text("E-mail  : " + bilgiler["email"]),
                                              ),
                                              Padding(
                                                padding: const EdgeInsets.only(right: 12),
                                                child: Icon(Icons.email),
                                              )
                                            ],
                                          ),
                                        ),
                                      ),
                                      Padding(
                                        padding: const EdgeInsets.only(top: 10),
                                        child: Container(
                                          width: 320,
                                          height: 45,
                                          decoration: BoxDecoration(
                                              borderRadius: BorderRadius.all(Radius.circular(10))
                                              ,border: Border.all(
                                              color: Colors.black
                                          )
                                          ),
                                          child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                            children: [
                                              Padding(
                                                padding: const EdgeInsets.only(left: 12),
                                                child: Text("Telefon No : " + bilgiler["telefonNo"]),
                                              ),
                                              Padding(
                                                padding: const EdgeInsets.only(right: 12),
                                                child: Icon(Icons.call),
                                              )
                                            ],
                                          ),
                                        ),
                                      ),
                                    ],
                                  ),
                                ),
                            Padding(
                              padding: const EdgeInsets.only(top: 45),
                              child: Container(
                                width: 150,
                                height: 40,
                                child: ElevatedButton(style: ButtonStyle(
                                  backgroundColor: WidgetStatePropertyAll(
                                    Colors.green
                                  ),
                                  shape: WidgetStatePropertyAll(
                                    RoundedRectangleBorder(
                                      borderRadius: BorderRadius.all(Radius.circular(10))
                                    )
                                  )
                                ),onPressed: (){

                                }, child: Text("Güncelle",style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),)),
                              ),
                            )
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
