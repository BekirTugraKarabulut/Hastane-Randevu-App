import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';

class Firstsayfa extends StatefulWidget {
  const Firstsayfa({super.key});

  @override
  State<Firstsayfa> createState() => _FirstsayfaState();
}

class _FirstsayfaState extends State<Firstsayfa> {

  Future<void> initilizeSettings() async {
    await Future.delayed(const Duration(seconds: 4));
    Navigator.pushReplacementNamed(context, '/pages/KayitSayfasi');
  }

  @override
  void initState() {
    super.initState();
    initilizeSettings();
  }

  @override
  Widget build(BuildContext context)  {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Center(
        child: Column( mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("TuKar Hastanesi", style: TextStyle(color: Colors.black , fontSize: 25 , fontWeight: FontWeight.bold),),
            Lottie.asset("asset/hospital preloaded.json"),
          ],
        ),
      ),
    );
  }
}
