con.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "views/loginZaSve.html",
        controller: 'odaberiUlogu'
    })
    .when("/logovanje", {
        templateUrl : "views/logovanje.html"
    })
    .when("/pocetna", {
        templateUrl : "views/pocetna.html"
    })
    .when("/menadzerPocetna", {
        templateUrl : "views/menadzerPocetna.html"
    })
    .when("/registrovanje", {
        templateUrl : "views/registrovanjeGosta.html"
    })
     .when("/pocetnaGost", {
        templateUrl : "views/pocetnaGost.html"
    })
    .when("/logovanjeZaposleni", {
        templateUrl : "views/logovanjeZaposleni.html"
    })
     .when("/adminPocetna", {
        templateUrl : "views/adminPocetna.html"
    })
    .when("/dodajRestoran", {
        templateUrl : "views/dodajRestoran.html"
    })
    .when("/dodajMenadzera", {
        templateUrl : "views/dodajMenadzera.html"
    })
    .when("/dodajKonobara", {
        templateUrl : "views/dodajKonobara.html"
    })
     .when("/dodajKuvara", {
        templateUrl : "views/dodajKuvara.html"
    })
      .when("/dodajSankera", {
        templateUrl : "views/dodajSankera.html"
    })
    .when("/dodajPonudjaca", {
        templateUrl : "views/dodajPonudjaca.html"
    })
    .when("/dodajJelovnik", {
        templateUrl : "views/dodajJelovnik.html"
    })
     .when("/dodajKartuPica", {
        templateUrl : "views/dodajKartuPica.html"
    })
    .when("/vidiKalendar", {
        templateUrl : "views/kalendar.html"
    })
   .when("/logovanje", {
        templateUrl : "views/logovanje.html"
   })
   .when("/kreirajRezervaciju", {
        templateUrl : "views/rezervacija.html"
   })
    .when("/listaRestorana", {
        templateUrl : "views/restorani.html"
   })
   .when("/listaPrijatelja", {
        templateUrl : "views/prijatelji.html"
   })
    .when("/profil", {
        templateUrl : "views/profil.html"
   })
    .when("/izlogujSe", {
        templateUrl : "views/loginZaSve.html"
   })
     .when("/dodajMenadzeraSistema", {
        templateUrl : "views/menadzerSistema.html"
   })
     .when("/kuvar", {
        templateUrl : "views/kuvarPocetna.html"
   })
     .when("/konobar", {
        templateUrl : "views/konobarPocetna.html"
   })
     .when("/sanker", {
        templateUrl : "views/sankerPocetna.html"
   })
     .when("/ponudjac", {
        templateUrl : "views/ponudjacPocetna.html"
   })
   .when("/listaSaNamirnicama", {
        templateUrl : "views/listaSaNamirnicama.html"
        	
    });
    
    
    
});