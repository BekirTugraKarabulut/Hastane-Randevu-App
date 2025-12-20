import 'package:flutter/material.dart';
import 'package:hastane_flutter/services/CalisanlarService.dart';

class Calisanlarsayfasi extends StatefulWidget {

  const Calisanlarsayfasi({super.key});

  @override
  State<Calisanlarsayfasi> createState() => _CalisanlarsayfasiState();
}

class _CalisanlarsayfasiState extends State<Calisanlarsayfasi> {

  CalisanlarService _calisanlarService = new CalisanlarService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(onPressed: (){
          Navigator.pop(context);
        }, icon: Icon(Icons.arrow_back_ios_new , color: Colors.white,)),
        title: Text("Kadromuz" , style: TextStyle(color: Colors.white ,fontWeight:  FontWeight.bold),),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          children: [
            FutureBuilder(
                future: _calisanlarService.calisanlariGetir(),
                builder: (context, snapshot) {
                  if(snapshot.hasData){
                    var calisanlarListesi = snapshot.data!;
                    return ListView.builder(
                        shrinkWrap: true,
                        physics: NeverScrollableScrollPhysics(),
                        itemCount: calisanlarListesi.length,
                        itemBuilder: (context, index) {
                          var calisan = calisanlarListesi[index];
                          return Card(
                            child: Row(mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Column(crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    Text("Çalışan Ad : " + calisan["calisanAd"]),
                                    Text("Çalışan Soyad : " + calisan["calisanSoyad"]),
                                  ],
                                ),
                                Column(
                                  children: [
                                    Text("Unvan : " + calisan["role"]),
                                    Text("Bölüm : " + calisan["bolum"]["bolumAd"] )
                                  ],
                                ),
                              ],
                            )
                          );
                        },
                    );
                  }else{
                    return const CircularProgressIndicator();
                  }
                },
            )
          ],
        ),
      ),
    );
  }
}
