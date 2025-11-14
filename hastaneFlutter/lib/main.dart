import 'package:flutter/material.dart';
import 'package:hastane_flutter/pages/FirstSayfa.dart';
import 'package:hastane_flutter/pages/KayitSayfasi.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      routes:
      {
        '/pages/FirstSayfa': (context) => const Firstsayfa(),
        "/pages/KayitSayfasi": (context) => const Kayitsayfasi(),
      },
      theme: ThemeData(

        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const Firstsayfa(),
    );
  }
}
