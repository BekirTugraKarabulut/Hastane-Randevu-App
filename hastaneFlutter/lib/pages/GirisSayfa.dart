import 'package:flutter/material.dart';

class Girissayfa extends StatefulWidget {
  const Girissayfa({super.key});

  @override
  State<Girissayfa> createState() => _GirissayfaState();
}

class _GirissayfaState extends State<Girissayfa> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Giriş Sayfası"),
      ),
    );
  }
}
