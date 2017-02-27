con.controller('registrovanjeGostaController',['$scope','$location','registovanjeService', function($scope,$location,registovanjeService){
	
	$scope.logovanje = function(){
		$location.path("/logovanje");
	}
	
	
	$scope.enableOrDisable = true;
	
	$scope.regisrovanje = function(){
		
		var email = $scope.email;
		var ime = $scope.ime;
		var prezime = $scope.prezime;
		var lozinka = $scope.lozinka1;
		var lozinka2 = $scope.lozinka2;
		
		registovanjeService.registrovanje(email, prezime, ime, lozinka).then(function(response){
			
			$location.path("/logovanje");
			
		});
			
		
		
	}
	

}]);

con.controller('registrovanjeMenadzeraController',['$scope','$location','registrovanjeMenadzeraService','registRestoranService', function($scope,$location,registrovanjeMenadzeraService,registRestoranService){
	
	alert("dosla sam do kontrolera");
	$scope.postojiMenadzer = false;
	$scope.registovanjeDugme = true;
	
	$scope.pokaziSe = {'visibility': 'hidden'};
	
	$scope.emailProvera = function(){
		
		var email = $scope.email;
		
		registrovanjeMenadzeraService.proveraEmailMenadzera(email).then(function(response){
			
			if(response.data == ''){
				$scope.pokaziSe = {'visibility': 'hidden'};
			}else if($scope.email == response.data.email){
					alert("postiji takav m");
					$scope.pokaziSe = {'visibility': 'visible'};
				}
			
			
		});
	}
	
	
	$scope.registrovanje = function(){
		
		var ime = $scope.ime;
		var prezime = $scope.prezime;
		var email = $scope.email;
		var lozinka1 = $scope.lozinka1;
		var restoran = $scope.odabranRestoran.id;
		
	
		registrovanjeMenadzeraService.dodajMenadzera(ime,prezime, email, lozinka1, $scope.odabranRestoran.id).then(function(response){
			alert("Uspesno je dodat menadzer");
			$scope.ime = null;
			$scope.prezime = null;
			$scope.email = null;
			$scope.lozinka1 = null; 
			$scope.lozinka2 = null;
			$scope.odabranRestoran = null;
		});

	}	
	
	registRestoranService.sviRestorani().then(function(response){
		
		$scope.restorani = response.data;
		alert(response.data);
	});
}]);


con.controller('registrovanjeKonobaraController',['$scope','$location','registrovanjeKonobaraService','registrovanjeMenadzeraService', function($scope,$location,registrovanjeKonobaraService,registrovanjeMenadzeraService){
	
	alert("dosla sam do kontrolera");
	
	$scope.dodajKonobara = function(){
		
		var ime = $scope.ime;
		var prezime = $scope.prezime;
		var email = $scope.email;
		var lozinka = $scope.lozinka1;
		var datumRodjenja = $scope.datumRodjenja;
		var konfBroj = $scope.konfBroj;
		var velicinaObuce = $scope.velicinaObuce;
		var restoran = registrovanjeMenadzeraService.aktivanZaposlen.restoran;
		
		alert(restoran);
		
		registrovanjeKonobaraService.registrovanjeKonobara(ime, prezime,email,lozinka,datumRodjenja,konfBroj,velicinaObuce,restoran).then(function(response){
			alert("kreiran je konobar");
			
		});
		
		
	}
	
	
	

}]);


con.controller('registrovanjeKuvaraController',['$scope','$location','registrovanjeKuvaraService','registrovanjeMenadzeraService', function($scope,$location,registrovanjeKuvaraService,registrovanjeMenadzeraService){
	
	alert("usla sam u kontroler");

$scope.dodajKuvara = function(){
		
		var ime = $scope.ime;
		var prezime = $scope.prezime;
		var email = $scope.email;
		var lozinka = $scope.lozinka1;
		var datumRodjenja = $scope.datumRodjenja;
		var konfBroj = $scope.konfBroj;
		var velicinaObuce = $scope.velicinaObuce;
		var restoran = registrovanjeMenadzeraService.aktivanZaposlen.restoran;
		
		alert(restoran);
		
		registrovanjeKuvaraService.registrovanjeKuvara(ime, prezime,email,lozinka,datumRodjenja,konfBroj,velicinaObuce,restoran).then(function(response){
			alert("kreiran je kuvar");
			
		});
		
		
	}

}]);

con.controller('registrovanjeSankeraController',['$scope','$location','registrovanjeSankeraService','registrovanjeMenadzeraService', function($scope,$location,registrovanjeSankeraService,registrovanjeMenadzeraService){
	
	alert("usla sam u kontroler");

	$scope.dodajSankera = function(){
			
			var ime = $scope.ime;
			var prezime = $scope.prezime;
			var email = $scope.email;
			var lozinka = $scope.lozinka1;
			var datumRodjenja = $scope.datumRodjenja;
			var konfBroj = $scope.konfBroj;
			var velicinaObuce = $scope.velicinaObuce;
			var restoran = registrovanjeMenadzeraService.aktivanZaposlen.restoran;
			
			alert(restoran);
			
			registrovanjeSankeraService.registrovanjeSankera(ime, prezime,email,lozinka,datumRodjenja,konfBroj,velicinaObuce,restoran).then(function(response){
				alert("kreiran je kuvar");
				
			});
			
			
		}
	

}]);

con.controller('dodajPonudjacaController',['$scope','$location','registrovanjePonudjacaService', function($scope,$location,registrovanjePonudjacaService){
	
	alert("usla sam u kontroler");

	$scope.dodajPonudjaca = function(){
			
			var ime = $scope.ime;
			var email = $scope.email;
			var lozinka = $scope.lozinka1;
	
			
			registrovanjePonudjacaService.registrovanjePonudjaca(ime,email,lozinka).then(function(response){
				alert("kreiran je ponudjac");
				
			});
			
			
		}
	
	

}]);