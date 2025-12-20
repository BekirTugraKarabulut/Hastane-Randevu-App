import 'package:flutter/material.dart';

class Hastaneadressayfasi extends StatefulWidget {
  const Hastaneadressayfasi({super.key});

  @override
  State<Hastaneadressayfasi> createState() => _HastaneadressayfasiState();
}

class _HastaneadressayfasiState extends State<Hastaneadressayfasi> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: Text("Hastane Adres Bilgileri"),
      ),
      body: Center(
        child: Column(
          children: [
              Image.asset("images/map.jpeg"),
              Padding(
                padding: const EdgeInsets.only(top: 15),
                child: Text("Hastane Konum Adresimiz : Mevlana Mahallesi Atatürk Sokak No:18 Ataşehir/İstanbul" , style: TextStyle(color: Colors.black , fontWeight: FontWeight.bold),),
              ),
          Padding(
            padding: const EdgeInsets.only(top: 200 , left: 50),
            child: Text("TuKar Hastanesi Sizlere Hizmet Vermekten Mutluluk Duyar !" , style: TextStyle(color: Colors.green , fontWeight: FontWeight.bold , fontSize: 20),),
          )
          ],
        ),
      ),
    );
  }
}
