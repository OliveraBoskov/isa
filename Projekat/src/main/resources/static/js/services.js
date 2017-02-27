angular.module('Model').factory('registovanjeService' , function registovanjeService($http){
	registovanjeService.registrovanje = function (email, prezime, ime, lozinka){
		return $http({
			method: 'POST',
			url: 'api/korisnici/korisnik',
			data: {
				"email" : email,
				"prezime" : prezime,
				"ime" : ime,
				"lozinka" : lozinka,
				"tip" : "gost"
			}
			
		});	
	}
	
	
	return registovanjeService;
});

angular.module('Model').factory('logovanjeService' , function logovanjeService($http){
	
	logovanjeService.uzmiKorisnika = function(email){
		return $http ({
			method: 'GET',
			url: 'api/korisnici/' + email
		});	
	}
	
	var aktivan = {};
	
	return logovanjeService;
	

});


angular.module('Model').factory('registRestoranService' , function registRestoranService($http){
	registRestoranService.registRestoran = function (ime, tip){
		return $http({
			method: 'POST',
			url: 'api/restorani/restoran',
			data: {
				"ime" : ime,
				"tip" : tip
			}
			
		});	
	}
	
	registRestoranService.izmeniRestoran = function (id,ime, tip){
		return $http({
			method: 'POST',
			url: 'api/restorani/izmeniRestoran/',
			data: {
				"id" : id,
				"ime" : ime,
				"tip" : tip
			}
			
		});	
	}
	
	registRestoranService.sviRestorani = function(){
		
		return $http ({
			method: 'GET',
			url: 'api/restorani/sviRestorani' 
			
		});
	}
	
	registRestoranService.menadzerRestoran = function(idRestorana){
		return $http ({
			method: 'GET',
			url: 'api/restorani/restoran/' + idRestorana
			
		});
		
	}

	var aktivanRestoran = {};
	
	
	registRestoranService.sviZaposleni = function(id){
		return $http({
			method: 'GET',
			url: 'api/zaposleni/sviZaposleni/' + id
		});
	}
	
	
	return registRestoranService;
	
});

angular.module('Model').factory('registrovanjeMenadzeraService' , function registrovanjeMenadzeraService($http){
	
	alert("dosla sam do servisa");
	registrovanjeMenadzeraService.dodajMenadzera = function(ime ,prezime, email, lozinka1, restoran){
		return $http({
			method: 'POST',
			url: 'api/zaposleni/zaposlen',
			data: {
				"ime" : ime,
				"prezime" : prezime,
				"email" : email,
				"lozinka" : lozinka1,
				"restoran" : restoran,
				"tip" : "menadzer",
				"prviPut" : true
			}
			
		});
	
	}
	
	registrovanjeMenadzeraService.proveraEmailMenadzera = function(email){
		return $http ({
			method: 'GET',
			url: 'api/zaposleni/' + email
			
		});
	}
	
	var aktivanZaposlen = {};
	
	return registrovanjeMenadzeraService;
	

});

angular.module('Model').factory('registrovanjeKonobaraService' , function registrovanjeKonobaraService($http){
	
	alert("dosla sam do servisa");
	registrovanjeKonobaraService.registrovanjeKonobara = function(ime ,prezime, email, lozinka,datumRodjenja,konfBroj,velicinaObuce,restoran){
		return $http({
			method: 'POST',
			url: 'api/zaposleni/zaposlen',
			data: {
				"ime" : ime,
				"prezime" : prezime,
				"email" : email,
				"lozinka" : lozinka,
				"restoran" : restoran,
				"tip" : "konobar",
				"prviPut" : true,
				"datumRodjenja" : datumRodjenja,
				"konfBroj" : konfBroj,
				"velicinaObuce" : velicinaObuce
				
			}
			
		});
	
	}
	
	return registrovanjeKonobaraService;
	

});

angular.module('Model').factory('registrovanjeKuvaraService' , function registrovanjeKuvaraService($http){
	
	alert("dosla sam do servisa");
	registrovanjeKuvaraService.registrovanjeKuvara = function(ime ,prezime, email, lozinka,datumRodjenja,konfBroj,velicinaObuce,restoran){
		return $http({
			method: 'POST',
			url: 'api/zaposleni/zaposlen',
			data: {
				"ime" : ime,
				"prezime" : prezime,
				"email" : email,
				"lozinka" : lozinka,
				"restoran" : restoran,
				"tip" : "kuvar",
				"prviPut" : true,
				"datumRodjenja" : datumRodjenja,
				"konfBroj" : konfBroj,
				"velicinaObuce" : velicinaObuce
				
			}
			
		});
	
	}
	
	return registrovanjeKuvaraService;
	

});


angular.module('Model').factory('registrovanjeSankeraService' , function registrovanjeSankeraService($http){
	
	alert("dosla sam do servisa");
	registrovanjeSankeraService.registrovanjeSankera= function(ime ,prezime, email, lozinka,datumRodjenja,konfBroj,velicinaObuce,restoran){
		return $http({
			method: 'POST',
			url: 'api/zaposleni/zaposlen',
			data: {
				"ime" : ime,
				"prezime" : prezime,
				"email" : email,
				"lozinka" : lozinka,
				"restoran" : restoran,
				"tip" : "kuvar",
				"prviPut" : true,
				"datumRodjenja" : datumRodjenja,
				"konfBroj" : konfBroj,
				"velicinaObuce" : velicinaObuce
				
			}
			
		});
	
	}
	
	return registrovanjeSankeraService;
	

});

angular.module('Model').factory('registrovanjePonudjacaService' , function registrovanjePonudjacaService($http){
	
	alert("dosla sam do servisa");
	registrovanjePonudjacaService.registrovanjePonudjaca= function(ime , email, lozinka){
		return $http({
			method: 'POST',
			url: 'api/zaposleni/zaposlen',
			data: {
				"ime" : ime,
				"email" : email,
				"lozinka" : lozinka,
				"tip" : "ponudjac",
				"prviPut" : true,
			
				
			}
			
		});
	
	}
	
	return registrovanjePonudjacaService;
	

});

////////////////////////////////////////////////////////////////////////////////////////
/////////////////SERVISI ZA JELOVNIK //////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////


angular.module('Model').factory('jelovnikService' , function jelovnikService($http){
	
	
	jelovnikService.dodajMeni = function(idRestorana){
		return $http({
			method: 'POST',
			url: 'api/jelovnik/dodajJelovnik',
			data: {
				"id" : null,
				"idRestorana" : idRestorana
			}
			
		});
		
	}
	
	jelovnikService.sveKategorije = function(idRestaurant) {
		
		return $http ({
			method: 'GET',
			url: 'api/jelovnik/sveKategorije/' + idRestaurant
			
		});
		
	}
	
	return jelovnikService;
});

angular.module('Model').factory('jelaKategorijaService' , function jelaKategorijaService($http){
	
	

	jelaKategorijaService.dodajKategoriju = function(idJelovnika, ime){
		return $http({
			method: 'POST',
			url: 'api/jelovnik/dodajKategoriju',
			data: {
				"id" : null,
				"idJelovnika" : idJelovnika,
				"imeKategorije" : ime
			}
			
		});
		
	}
	
	var aktivnaKategorija = {};

	
	return jelaKategorijaService;
});

angular.module('Model').factory('jelaService' , function jelaService($http){
	
	jelaService.aktivnaKategorijaJela = {};
	jelaService.aktivnoJelo = {};


	jelaService.dodajJelo = function(idKategorije, ime, opis, cena){
		return $http({
			method: 'POST',
			url: 'api/jelovnik/dodajJelo',
			data: {
				"id" : null,
				"idKategorije" : idKategorije,
				"imeJela" : ime,
				"opisJela" : opis,
				"cena" : cena
			}
			
		});
		
	}
	

	jelaService.izmeniJelo = function(idKategorije, ime, opis, cena, jeloId, jeloKategorija){
		alert(jeloId);
		alert(idKategorije);
		return $http({
			method: 'POST',
			url: 'api/jelovnik/izmeniJelo/'+idKategorije,
			data: {
				"id" : jeloId,
				"idKategorije" : idKategorije,
				"imeJela" : ime,
				"opisJela" : opis,
				"cena" : cena,
				"jKategorija" : jeloKategorija
				
			}
			
		});
		
	}
	
	jelaService.idKategorije = {};
	jelaService.jeloKategorija = {};

	
	return jelaService;
});


////////////////////////////////////////////////////////////////////////////////////////
/////////////////SERVISI ZA KARTU PICA //////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////


angular.module('Model').factory('kartaPicaService' , function kartaPicaService($http){
	
	
	kartaPicaService.dodajKartuPica = function(idRestorana){
		return $http({
			method: 'POST',
			url: 'api/kartaPica/dodajKartuPica',
			data: {
				"id" : null,
				"idRestorana" : idRestorana
			}
			
		});
		
	}
	
	kartaPicaService.sveKategorije = function(idRestaurant) {
		
		return $http ({
			method: 'GET',
			url: 'api/kartaPica/sveKategorije/' + idRestaurant
			
		});
		
	}
	
	return kartaPicaService;
});

angular.module('Model').factory('kartaPicaKategorijaService' , function kartaPicaKategorijaService($http){
	
	

	kartaPicaKategorijaService.dodajKategoriju = function(idKartePica, ime){
		return $http({
			method: 'POST',
			url: 'api/kartaPica/dodajKategoriju',
			data: {
				"id" : null,
				"idKartePica" : idKartePica,
				"imeKategorije" : ime
			}
			
		});
		
	}
	
	var aktivnaKategorija = {};

	
	return kartaPicaKategorijaService;
});

angular.module('Model').factory('picaService' , function picaService($http){
	
	picaService.aktivnaKategorijaPica = {};
	picaService.aktivnoPice = {};


	picaService.dodajPice = function(idKategorije, ime, opis, cena){
		return $http({
			method: 'POST',
			url: 'api/kartaPica/dodajPice',
			data: {
				"id" : null,
				"idKategorije" : idKategorije,
				"imePica" : ime,
				"opisPica" : opis,
				"cena" : cena
			}
			
		});
		
	}
	

	picaService.izmeniPice = function(idKategorije, ime, opis, cena, piceId, piceKategorija){
		alert(piceId);
		alert(idKategorije);
		return $http({
			method: 'POST',
			url: 'api/kartaPica/izmeniPice/' + idKategorije,
			data: {
				"id" : piceId,
				"idKategorije" : idKategorije,
				"imePica" : ime,
				"opisPica" : opis,
				"cena" : cena,
				"pKategorija" : piceKategorija
				
			}
			
		});
		
	}
	
	picaService.idKategorije = {};

	
	return picaService;
});

angular.module('Model').factory('stoService' , function stoService($http){
	
	
	stoService.dodajSto = function(broj, idRestorana, reon, restoran, levo, gore){
		return $http({
			method: 'POST',
			url: 'api/restoran/dodajSto',
			data: {
				"id" : null,
				"broj" : broj,
				"idRestorana" : idRestorana,
				"reon" : reon,
				"restoran" : restoran,
				"levo" : levo,
				"gore" : gore
			}
			
		});
	}
	
	stoService.uzmiSveStolove = function(restoranId){
		return $http({
			method: 'GET',
			url: '/api/restoran/uzmiSveStolove/' + restoranId
		});
	}
	
	stoService.getStoByIdRestoranaAndBroj = function(restoranId, broj){
		return $http({
			method: 'GET',
			url: '/api/restoran/uzmiSto/' + restoranId +'/'+broj
		});
	}
	

	
	return stoService;
});

angular.module('Model').factory('smenaService' , function smenaService($http){
	
	smenaService.dodajSmenu = function(restoranId, zaposleni, boja, reon, pocinjeU, zavrsavaSe){
		return $http({
			method: 'POST',
			url: 'api/smena/dodajSmenu',
			data: {
				"id" : null,
				"restoranId": restoranId,
				"zaposleni" : zaposleni,
				"boja" : boja,
				"reon" : reon,
				"pocinjeU" : pocinjeU,
				"zavrsavaSe" : zavrsavaSe			
			}
			
		});
	}
	
	smenaService.smene = function(id){
		return $http ({
			method: 'GET',
			url: 'api/smena/smene/' + id
		});
	}
	
	return smenaService;
	
});


angular.module('Model').factory('namirniceService' , function namirniceService($http){
	
	namirniceService.dodajNamirniceKategoriju = function(imeKategorije){
		return $http({
			method: 'POST',
			url: 'api/namirniceKategorija/dodajNamirniceKategoriju',
			data: {
				"id" : null,
				"imeKategorije": imeKategorije	
			}
			
		});
	}
	
	namirniceService.sveKategorije = function(){
		return $http({
			method: 'GET',
			url: 'api/namirniceKategorija/sveKategorije'
		});
	}
	
	namirniceService.getListeByPocinjeU = function(pocinjeU){
		return $http({
			method: 'GET',
			url: 'api/namirnice/getListeByPocinjeU/'+pocinjeU
		});
	}
	
	
	
	namirniceService.dodajNamirnicu = function(imeNamirnice, nKategorija){
		return $http({
			method: 'POST',
			url: 'api/namirnice/dodajNamirnicu/' + nKategorija.id,
			data: {
				"id" : null,
				"imeNamirnice": imeNamirnice,
				"nKategorija" : nKategorija
			}
			
		});
	}
	
	namirniceService.dodajListu = function(listaIme, restoranId, pocinjeU, zavrsavaU){
		return $http({
			method: 'POST',
			url: 'api/namirnice/dodajListu',
			data: {
				"id" : null,
				"restoranId" : restoranId,
				"listaIme": listaIme,
				"pocinjeU" : pocinjeU,
				"zavrsavaU" : zavrsavaU,
				"aktivna" :true
			}
			
		});
	}
	
	namirniceService.dodajAktivnuListu = function(id){
		return $http({
			method: 'POST',
			url: 'api/namirnice/dodajAktivnuListu/' + id
		});
	}
	
	namirniceService.dodajListaItem = function(nlListaId, namirnica, kolicina, nl){
		return $http({
			method: 'POST',
			url: 'api/namirnice/dodajListItem/' + nlListaId,
			data: {
				"id" : null,
				"namirnica": namirnica,
				"kolicina" : kolicina,
				"nl" : nl
			}
			
		});
	}
	
	namirniceService.aktivnaKategorija = {};
	
	
	
	return namirniceService;
	
});


