import 'package:flutter/material.dart';
import 'package:hastane_flutter/pages/HastaneAdresSayfasi.dart';
import 'package:hastane_flutter/pages/ProfilSayfa.dart';
import 'package:hastane_flutter/pages/RandevuAlSayfasi.dart';
import 'package:hastane_flutter/pages/RandevularimSayfasi.dart';
import 'package:smooth_page_indicator/smooth_page_indicator.dart';

class Anasayfa extends StatefulWidget {
  String username;

  Anasayfa({required this.username});

  @override
  State<Anasayfa> createState() => _AnasayfaState();
}

class _AnasayfaState extends State<Anasayfa> {
  final _pageController = PageController();
  int _selectedIndex = 0;

  @override
  void initState() {
    super.initState();
    _selectedIndex = 0;
  }

  List<Widget> get _pages => [
    _buildAnasayfa(widget.username),
    Randevularimsayfasi(username: widget.username),
    const Hastaneadressayfasi(),
    Profilsayfa(username: widget.username),
  ];

  @override
  void dispose() {
    _pageController.dispose();
    super.dispose();
  }

  Future<List<String>> smoothImages() async {
    List<String> images = [
      'images/hastane.jpeg',
      'images/kadin.jpeg',
      'images/doktor.jpeg',
      'images/yazi.jpeg',
    ];
    return images;
  }

  Widget _buildAnasayfa(String username) {
    return SingleChildScrollView(
      child: Padding(
        padding: const EdgeInsets.only(bottom: 75.0),
        child: Center(
          child: Column(
            children: [
              const SizedBox(height: 0),
              FutureBuilder(
                future: smoothImages(),
                builder: (context, snapshot) {
                  if (snapshot.hasData) {
                    var images = snapshot.data!;
                    return SizedBox(
                      width: 400,
                      height: 300,
                      child: Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          SizedBox(
                            width: 400,
                            height: 260,
                            child: PageView.builder(
                              controller: _pageController,
                              itemCount: images.length,
                              itemBuilder: (context, index) {
                                var image = images[index];
                                return Padding(
                                  padding: const EdgeInsets.symmetric(horizontal: 0),
                                  child: ClipRRect(
                                    child: Image.asset(
                                      image,
                                      width: 400,
                                      height: 220,
                                      fit: BoxFit.cover,
                                    ),
                                  ),
                                );
                              },
                            ),
                          ),
                          const SizedBox(height: 15),
                          SmoothPageIndicator(
                            controller: _pageController,
                            count: images.length,
                            effect: const WormEffect(
                              dotHeight: 10,
                              dotWidth: 10,
                              spacing: 12,
                              activeDotColor: Colors.blue,
                              dotColor: Colors.black,
                            ),
                          ),
                        ],
                      ),
                    );
                  } else {
                    return const SizedBox(
                      height: 250,
                      child: Center(child: CircularProgressIndicator()),
                    );
                  }
                },
              ),
              const SizedBox(height: 15),
              Padding(
                padding: const EdgeInsets.only(left: 8, right: 8),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Container(
                      decoration: BoxDecoration(
                        borderRadius:  BorderRadius.all(
                          Radius.circular(20)
                        ),
                        border: Border.all(
                          color: Colors.black
                        )
                      ),
                      child: Column(
                        children: [
                          ClipRRect(
                            borderRadius: const BorderRadius.only(
                              topLeft: Radius.circular(20),
                              topRight: Radius.circular(20),
                            ),
                            child: Image.asset(
                              "images/doktorgulenyuz_ikon.jpeg",
                              height: 160,
                              width: 160,
                              fit: BoxFit.cover,
                            ),
                          ),
                          Container(
                            height: 40,
                            width: 160,
                            child: ElevatedButton(
                              style: ButtonStyle(
                                backgroundColor:
                                const WidgetStatePropertyAll(Colors.blueAccent),
                                elevation: const WidgetStatePropertyAll(6),
                                shadowColor:
                                const WidgetStatePropertyAll(Colors.black54),
                                shape: WidgetStatePropertyAll(
                                  RoundedRectangleBorder(
                                    side: const BorderSide(
                                      color: Colors.white,
                                      width: 1.5,
                                    ),
                                    borderRadius: const BorderRadius.only(
                                      bottomLeft: Radius.circular(20),
                                      bottomRight: Radius.circular(20),
                                    ),
                                  ),
                                ),
                              ),
                              onPressed: () {},
                              child: const Text(
                                "Doktor Kadrosu",
                                style: TextStyle(color: Colors.white),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                    Container(
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.all(
                          Radius.circular(20)
                        ),
                        border: Border.all(
                          color: Colors.black
                        )
                      ),
                      child: Column(
                        children: [
                          ClipRRect(
                            borderRadius: const BorderRadius.only(
                              topLeft: Radius.circular(20),
                              topRight: Radius.circular(20),
                            ),
                            child: Image.asset(
                              "images/muayne.jpeg",
                              height: 160,
                              width: 160,
                              fit: BoxFit.cover,
                            ),
                          ),
                          Container(
                            height: 40,
                            width: 160,
                            child: ElevatedButton(
                              style: ButtonStyle(
                                backgroundColor:
                                const WidgetStatePropertyAll(Colors.blueAccent),
                                elevation: const WidgetStatePropertyAll(6),
                                shadowColor:
                                const WidgetStatePropertyAll(Colors.black54),
                                shape: WidgetStatePropertyAll(
                                  RoundedRectangleBorder(
                                    side: const BorderSide(
                                      color: Colors.white,
                                      width: 1.5,
                                    ),
                                    borderRadius: const BorderRadius.only(
                                      bottomLeft: Radius.circular(20),
                                      bottomRight: Radius.circular(20),
                                    ),
                                  ),
                                ),
                              ),
                              onPressed: () {},
                              child: const Text(
                                "Muayene Saatleri",
                                style: TextStyle(color: Colors.white),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 30),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  ClipRRect(
                    borderRadius: const BorderRadius.only(
                      bottomLeft: Radius.circular(50),
                      topLeft: Radius.circular(50),
                    ),
                    child: Image.asset(
                      "images/randevu-alma.jpeg",
                      height: 100,
                      width: 137,
                      fit: BoxFit.cover,
                    ),
                  ),
                  Container(
                    width: 150,
                    height: 100,
                    child: ElevatedButton(
                      style: ButtonStyle(
                        shape: WidgetStatePropertyAll(
                          RoundedRectangleBorder(
                            borderRadius: const BorderRadius.only(
                              bottomRight: Radius.circular(50),
                              topRight: Radius.circular(50),
                            ),
                          ),
                        ),
                        backgroundColor: const WidgetStatePropertyAll(Colors.green),
                      ),
                      onPressed: () {
                        Navigator.push(context, MaterialPageRoute(builder: (context) => Randevualsayfasi(username: widget.username)));
                      },
                      child: const Text(
                        "Randevu Al",
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: IndexedStack(
          index: _selectedIndex,
          children: _pages,
        ),
      ),
      bottomNavigationBar: NavigationBar(
        indicatorColor: Colors.blue,
        backgroundColor: Colors.black,
        selectedIndex: _selectedIndex,
        labelTextStyle: const WidgetStatePropertyAll(
          TextStyle(color: Colors.white),
        ),
        onDestinationSelected: (index) {
          setState(() {
            _selectedIndex = index;
          });
        },
        height: 60,
        destinations: const [
          NavigationDestination(
            icon: Icon(Icons.home, color: Colors.white),
            label: "Ana Sayfa",
          ),
          NavigationDestination(
            icon: Icon(Icons.bookmark_outlined, color: Colors.white),
            label: "Randevularım",
          ),
          NavigationDestination(
            icon: Icon(Icons.home_work_rounded, color: Colors.white),
            label: "Adres",
          ),
          NavigationDestination(
            icon: Icon(Icons.account_box_rounded, color: Colors.white),
            label: "Profilim",
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.green,
        onPressed: () {},
        child: Image.asset("images/robot-assistant.jpeg"),
      ),
    );
  }
}