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
        title: Text("Hastane Bilgileri"),
      ),
    );
  }
}
