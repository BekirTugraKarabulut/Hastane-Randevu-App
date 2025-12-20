import 'package:flutter/material.dart';
import 'package:hastane_flutter/services/KullaniciRandevuGetirService.dart';

class Randevularimsayfasi extends StatefulWidget {

  String username;

  Randevularimsayfasi({super.key, required this.username});

  @override
  State<Randevularimsayfasi> createState() => _RandevularimsayfasiState();
}

class _RandevularimsayfasiState extends State<Randevularimsayfasi> {

  KullaniciRandevuGetirService _kullaniciRandevuGetirService = new KullaniciRandevuGetirService();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        centerTitle: true,
        backgroundColor: Colors.white,
        title: Text("Randevularım"),
      ),
      body: Center(
        child: Column(
          children: [
              FutureBuilder(
                  future: _kullaniciRandevuGetirService.getAllRandevu(widget.username),
                  builder: (context, snapshot) {
                    if(snapshot.hasData){
                      var randevuList = snapshot.data!;
                      return ListView.builder(
                          physics: NeverScrollableScrollPhysics(),
                          shrinkWrap: true,
                          itemCount: randevuList.length,
                          itemBuilder: (context, index) {
                            var randevu = randevuList[index];
                            return Card(
                              child: Column( crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text("Randevu Tarihi : " + randevu["randevuTarihi"]),
                                  Text("Randevu Saati : " + randevu["randevuSaati"]),
                                  Text("Doktor Adı : " + randevu["calisanlar"]["calisanAd"] +" " +  randevu["calisanlar"]["calisanSoyad"]),
                                  Text("Doktor Unvan : " + randevu["calisanlar"]["role"]),
                                  Text("Bölüm : " + randevu["calisanlar"]["bolum"]["bolumAd"]),
                                ],
                              ),
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
