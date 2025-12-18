import 'package:flutter/material.dart';
import 'package:hastane_flutter/services/RandevuAlService.dart';
import 'package:intl/intl.dart';

class Randevualsayfasi extends StatefulWidget {
  String username;

  Randevualsayfasi({required this.username});

  @override
  State<Randevualsayfasi> createState() => _RandevualsayfasiState();
}

class _RandevualsayfasiState extends State<Randevualsayfasi> {

  RandevuAlService _randevuAlService = RandevuAlService();

  var username = TextEditingController();
  var calisanId = TextEditingController();
  DateTime? secilenTarih;
  TimeOfDay? secilenSaat;

  String tarihText = "Tarih seçilmedi";
  String saatText = "Saat seçilmedi";

  Future<void> tarihSec(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
      context: context,
      initialDate: DateTime.now(),
      firstDate: DateTime.now(),
      lastDate: DateTime(2035),
      locale: const Locale("tr", "TR"),
    );

    if (picked != null) {
      setState(() {
        secilenTarih = picked;
        tarihText = DateFormat('yyyy-MM-dd').format(picked);
      });
    }
  }

  Future<void> saatSec(BuildContext context) async {
    final TimeOfDay? picked = await showTimePicker(
      context: context,
      initialTime: TimeOfDay.now(),
      builder: (context, child) {
        return MediaQuery(
          data: MediaQuery.of(context).copyWith(
            alwaysUse24HourFormat: true,
          ),
          child: child!,
        );
      },
    );

    if (picked != null) {
      setState(() {
        secilenSaat = picked;
        saatText =
        "${picked.hour.toString().padLeft(2, '0')}:"
            "${picked.minute.toString().padLeft(2, '0')}";
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Randevu Al"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: username,
              decoration: const InputDecoration(
                labelText: "Kullanıcı Adı",
              ),
            ),
            Text(tarihText, style: const TextStyle(fontSize: 18)),
            ElevatedButton(
              onPressed: () => tarihSec(context),
              child: const Text("Tarih Seç"),
            ),
            Text(saatText, style: const TextStyle(fontSize: 18)),
            ElevatedButton(
              onPressed: () => saatSec(context),
              child: const Text("Saat Seç"),
            ),
            TextField(
              controller: calisanId,
              decoration: const InputDecoration(
                labelText: "Çalışan ID",
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(top: 50),
              child: ElevatedButton(onPressed: () async {

                  bool result = await _randevuAlService.randevuAl(username.text, tarihText, saatText, calisanId.text);

                  if(result){
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(content: Text("Randevu başarıyla alındı"),
                      action: SnackBarAction(label: "Tamam", onPressed: () {}),
                      ),
                    );
                  } else {
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(content: Text("Randevu alınamadı"),
                      action: SnackBarAction(label: "Tamam", onPressed: (){}),
                      ),
                    );
                  }

              }, child: Text("Randevu Al")),
            )
          ],
        ),
      ),
    );
  }
}
