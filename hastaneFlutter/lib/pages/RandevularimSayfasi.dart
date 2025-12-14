import 'package:flutter/material.dart';

class Randevularimsayfasi extends StatefulWidget {

  String username;

  Randevularimsayfasi({super.key, required this.username});

  @override
  State<Randevularimsayfasi> createState() => _RandevularimsayfasiState();
}

class _RandevularimsayfasiState extends State<Randevularimsayfasi> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Randevularım"),
      ),
    );
  }
}
