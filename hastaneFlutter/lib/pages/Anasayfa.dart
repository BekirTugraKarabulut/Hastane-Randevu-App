import 'package:flutter/material.dart';
import 'package:hastane_flutter/pages/HastaneAdresSayfasi.dart';
import 'package:hastane_flutter/pages/ProfilSayfa.dart';
import 'package:hastane_flutter/pages/RandevularimSayfasi.dart';
import 'package:smooth_page_indicator/smooth_page_indicator.dart';

class Anasayfa extends StatefulWidget {

  String username;

  Anasayfa({required this.username});

  @override
  State<Anasayfa> createState() => _AnasayfaState();
}

class _AnasayfaState extends State<Anasayfa> {

  final  _pageController = PageController();
  int _selectedIndex = 0;
  late final List<Widget> _pages;

  @override
  void initState() {
    _selectedIndex = 0;
    _pages = [
      _buildAnasayfa(widget.username),
      Randevularimsayfasi(username: widget.username),
      const Hastaneadressayfasi(),
      Profilsayfa(username: widget.username),
    ];
    super.initState();
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
        child: Center(
          child: Column(
            children: [
              FutureBuilder(
                future: smoothImages(),
                builder: (context, snapshot) {
                  if (snapshot.hasData) {
                    var images = snapshot.data!;
                    return SizedBox(
                      width: 400,
                      height: 315,
                      child: PageView.builder(
                        controller: _pageController,
                        itemCount: images.length,
                        itemBuilder: (context, index) {
                          var image = images[index];
                          return Column(
                            children: [
                              Image.asset(image),
                              Padding(
                                padding: const EdgeInsets.only(top: 15),
                                child: SmoothPageIndicator(
                                  controller: _pageController,
                                  count: images.length,
                                  effect: WormEffect(
                                      dotHeight: 10,
                                      dotWidth: 10,
                                      spacing: 12,
                                      activeDotColor: Colors.blue,
                                      dotColor: Colors.black
                                  ),
                                ),
                              )
                            ],
                          );
                        },
                      ),
                    );
                  } else {
                    return const CircularProgressIndicator();
                  }
                },
              ),
              Padding(
                padding: const EdgeInsets.only(top: 15),
                child: Row(mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Column(
                      children: [
                        ClipRRect(
                            borderRadius: BorderRadiusDirectional.only(
                                topStart: Radius.circular(20),
                                topEnd: Radius.circular(20),
                                bottomStart: Radius.circular(0),
                                bottomEnd: Radius.circular(0))
                            ,
                            child: Image.asset(
                                "images/doktorgulenyuz_ikon.jpeg", height: 160,
                                width: 160)
                        ),
                        Container(
                          height: 40,
                          width: 160,
                          child: ElevatedButton(style: ButtonStyle(
                              backgroundColor: WidgetStatePropertyAll(
                                  Colors.blueAccent
                              ),
                              shape: WidgetStatePropertyAll(
                                  RoundedRectangleBorder(
                                      borderRadius: BorderRadiusDirectional
                                          .only(
                                          bottomStart: Radius.circular(20),
                                          bottomEnd: Radius.circular(20),
                                          topStart: Radius.circular(0),
                                          topEnd: Radius.circular(0))
                                  )
                              )), onPressed: () {

                          }, child: Text("Doktor Kadrosu", style: TextStyle(
                              color: Colors.white),)),
                        )
                      ],
                    ),
                    Column(
                      children: [
                        ClipRRect(
                            borderRadius: BorderRadiusDirectional.only(
                                topStart: Radius.circular(20),
                                topEnd: Radius.circular(20),
                                bottomStart: Radius.circular(0),
                                bottomEnd: Radius.circular(0))
                            ,
                            child: Image.asset(
                                "images/muayne.jpeg", height: 160, width: 160)
                        ),
                        Container(
                          height: 40,
                          width: 160,
                          child: ElevatedButton(style: ButtonStyle(
                              backgroundColor: WidgetStatePropertyAll(
                                  Colors.blueAccent
                              ),
                              shape: WidgetStatePropertyAll(
                                  RoundedRectangleBorder(
                                      borderRadius: BorderRadiusDirectional
                                          .only(
                                          bottomStart: Radius.circular(20),
                                          bottomEnd: Radius.circular(20),
                                          topStart: Radius.circular(0),
                                          topEnd: Radius.circular(0))
                                  )
                              )), onPressed: () {

                          }, child: Text("Muayne Saatleri", style: TextStyle(
                              color: Colors.white),)),
                        )
                      ],
                    ),
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 30),
                child: Row(mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    ClipRRect(
                        borderRadius: BorderRadiusDirectional.only(
                            bottomEnd: Radius.circular(0),
                            bottomStart: Radius.circular(50),
                            topEnd: Radius.circular(0),
                            topStart: Radius.circular(50)
                        )
                        ,
                        child: Image.asset(
                            "images/randevu-alma.jpeg", height: 100,
                            width: 137)),
                    Container(
                      width: 150,
                      height: 100,
                      child: ElevatedButton(style: ButtonStyle(
                        shape: WidgetStatePropertyAll(
                            RoundedRectangleBorder(
                                borderRadius: BorderRadius.only(
                                    bottomLeft: Radius.circular(0),
                                    bottomRight: Radius.circular(50),
                                    topLeft: Radius.circular(0),
                                    topRight: Radius.circular(50))
                            )
                        ),
                        backgroundColor: WidgetStatePropertyAll(
                            Colors.green
                        ),
                      ),
                          onPressed: () {

                          },
                          child: Text("Randevu Al",
                            style: TextStyle(color: Colors.white),)),
                    )
                  ],
                ),
              ),
            ],
          ),
        ),
      );
    }
      @override
      Widget build(BuildContext context) {
        return Scaffold(
          backgroundColor: Colors.white,
          body: IndexedStack(
            index: _selectedIndex,
            children: _pages,
          ),
          bottomNavigationBar: NavigationBar(
            indicatorColor: Colors.blue,
            backgroundColor: Colors.black,
            selectedIndex: _selectedIndex,
            labelTextStyle: WidgetStatePropertyAll(
              TextStyle(
                color: Colors.white
              )
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
                  label: "Ana Sayfa"),
              NavigationDestination(
                  icon: Icon(Icons.bookmark_outlined, color: Colors.white),
                  label: "Randevularım"),
              NavigationDestination(
                  icon: Icon(Icons.home_work_rounded, color: Colors.white),
                  label: "Adres"),
              NavigationDestination(
                  icon: Icon(Icons.account_box_rounded, color: Colors.white),
                  label: "Profilim"),
            ],
          ),
          floatingActionButton: FloatingActionButton(
            backgroundColor: Colors.green,
            onPressed: () {

            },
            child: Image.asset("images/robot-assistant.jpeg"),
          ),
        );
      }
    }