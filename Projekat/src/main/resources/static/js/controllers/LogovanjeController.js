var con = angular.module('Model',['ngRoute','ngMaterial','ngAnimate', 'ngAria','mwl.calendar','ui.bootstrap', 'ngCookies']);

con.controller('odaberiUlogu',['$scope','$location','logovanjeService', function($scope,$location,logovanjeService){
	
	$scope.logZaZaposlene = function(){
		$location.path("/logovanjeZaposleni");
	}
	
	$scope.logZaGoste = function (){
		$location.path("/logovanje");
	}
	
}]);

con.controller('LogovanjeController',['$scope','$location','logovanjeService', function($scope,$location,logovanjeService){

	$scope.logovanje = function(){
		//alert("ajde");
		
	$scope.email = "m@g.com";
	$scope.lozinka = "m";
		
		var email = $scope.email;
		var lozinka = $scope.lozinka;
		
		
		logovanjeService.uzmiKorisnika(email).then(function(response){	
			//alert(response.data);
			if(response.data == ''){
				$location.path("/logovanje");
				alert("ne postoji takav korisnik");
				
			}else {
				if(response.data.lozinka == $scope.lozinka){
					logovanjeService.aktivan = response.data;
					alert("poklapa se")	
					if(response.data.tip == "admin"){
						
						$location.path("/adminPocetna");
					}else{
						
						$location.path("/pocetnaGost");
					}
					
			}
				
			}
		});
	}
	
	$scope.registrovanjeGosta = function(){
		$location.path("/registrovanje");
	}

}]);

con.controller('logovanjeZaposleniController',['$scope','$location','registrovanjeMenadzeraService', function($scope,$location,registrovanjeMenadzeraService){
	
	$scope.pokaziSe = {'visibility': 'hidden'};
	
	$scope.logZaposleni = function(){
		
		
		var email = $scope.emailZaposleni;
		var lozinka = $scope.lozinkaZaposleni;
		
		
		//u servisu registrovanjeMenadzeraService vec postoji funkcija koja kupi email iz tabele zaposleni
		registrovanjeMenadzeraService.proveraEmailMenadzera(email).then(function(response){	
			
			
			if(response.data == ''){
				$scope.pokaziSe = {'visibility': 'visible'};
				$scope.emailZaposleni = null;
				$scope.lozinkaZaposleni = null;
				$location.path("/logovanjeZaposleni");
	
			}else {
				if(response.data.lozinka == $scope.lozinkaZaposleni){
					alert("poklapa se")	
					
					registrovanjeMenadzeraService.aktivanZaposlen = response.data;
					alert(registrovanjeMenadzeraService.aktivanZaposlen.ime);
					
					if(response.data.tip == "menadzer"){
						$scope.pokaziSe = {'visibility': 'hidden'};
						$location.path("/menadzerPocetna");
					}else if(response.data.tip == "ponudjac"){
						$location.path("/ponudjac");
					}else if(response.data.tip == "konobar"){
						$location.path("/konobar");
					}else if(response.data.tip == "kuvar"){
						$location.path("/kuvar");
					}else if(response.data.tip == "sanker"){
						$location.path("/sanker");
					}else{
						
						$location.path("/logovanje");
						
					}
					
			}
				
			}
		});
	}

	
}]);

