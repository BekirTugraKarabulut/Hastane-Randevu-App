import 'package:flutter/material.dart';

class Anasayfa extends StatefulWidget {

  String username;

  Anasayfa({required this.username});

  @override
  State<Anasayfa> createState() => _AnasayfaState();
}

class _AnasayfaState extends State<Anasayfa> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Anasayfa"),
      ),
      body: Center(
        child: Column(
          children: [
            Text("Merhaba Sn. " + widget.username)
          ],
        ),
      ),
    );
  }
}
