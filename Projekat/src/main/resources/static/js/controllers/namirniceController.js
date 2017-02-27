con.controller('listaSaNamirnicamaKontroler',['$scope','$location','namirniceService','$mdDialog','$route','registRestoranService','dateFilter', function($scope,$location,namirniceService,$mdDialog,$route,registRestoranService,dateFilter){

	namirniceService.sveKategorije().then(function(response){
		
		$scope.kategorije = response.data;
		
	});
	
	
	
	$('#dodajKategoriju').click(function(ev){
		
			 $mdDialog.show({
			      controller: dodajKategorijuKontroler,
			      templateUrl: '/views/dijalozi/dodajKategorijuNamirnice.html',
			      parent: angular.element(document.body),
			      targetEvent: ev,
			      clickOutsideToClose:true,
			      fullscreen: false 
			    })
			    .then(function(answer) {
			      
			    }, function() {
			     
			    });
			
			 function dodajKategorijuKontroler($scope, $mdDialog, $route, namirniceService) {
				 
					 $scope.dodajKategoriju= function(){
						 
						 var ime = $scope.ime;
						 
						 
						 namirniceService.dodajNamirniceKategoriju(ime).then(function(response){
							 
							 $mdDialog.hide();
							 $route.reload();
							 
						 });
					 }
					 
					 $scope.zatvoriDijalog = function() {
						 $mdDialog.cancel();
					 }	
					 
		}
		
    });
	

	
	$scope.potvrdi = function() {
			
		var pdatumString = dateFilter($scope.vremePocetka, 'yyyy-MM-ddT');
		var pvremeString = dateFilter($scope.vremePocetkaVreme, 'HH:mm:00.000');
		var vremeP = pdatumString + pvremeString + 'Z';
				
		var datumString = dateFilter($scope.vremeZavrsetka, 'yyyy-MM-ddT');
		var vremeString = dateFilter($scope.vremeZavrsetkaVreme, 'HH:mm:00.000');
		var vremeK = datumString + vremeString + 'Z';
		
		var listaIme = $scope.listaIme;
		
		
		namirniceService.dodajListu(listaIme, registRestoranService.aktivanRestoran.id, vremeP, vremeK).then(function(response){
			for(var i = 0; i < $scope.namirnicaLista.length; i++) {
				namirniceService.dodajListaItem(response.data.id, $scope.namirnicaLista[i], $scope.namirnicaLista[i].brojac, response.data).then(function(response){
					
				});
			}
			$route.reload();
			
		});	
		
	}
	
	$scope.vremePocetka = new Date();
	$scope.vremePocetkaOtvori = false;
	
	$scope.vremePocetkaOtv = function() {
	    $scope.vremePocetkaOtvori = true;
	};
	
	
	$scope.vremePocetka = new Date();
	$scope.vremePocetka.setHours(10);
	$scope.vremePocetka.setMinutes(0);
	
	$scope.hstep = 1;
	$scope.mstep = 30;
	
	//ENDING DATE
	$scope.vremeZavrsetka = new Date();
	$scope.vremeZavrsetkaOtvori = false;
	
	$scope.otvoriVremeZavrsetka = function() {
	    $scope.vremeZavrsetkaOtvori = true;
	};
	
	
	$scope.vremeZavrsetka = new Date();
	$scope.vremeZavrsetka.setHours(10);
	$scope.vremeZavrsetka.setMinutes(0);
	
	$scope.ehstep = 1;
	$scope.emstep = 30;
	
	
	$scope.namirnicaLista = [];
	
	$scope.obrisiIzListe = function(namirnica) {
		var index = $scope.namirnicaLista.indexOf(namirnica);
		if (index != -1) {
			if (namirnica.brojac == 1) {
				$scope.namirnicaLista.splice( index, 1 );
			}
			else {
				namirnica.brojac = namirnica.brojac - 1;
			}
		}
		
		
	}
	
	$scope.dodajNamirnicuLista= function(namirnica){
		var index = $scope.namirnicaLista.indexOf(namirnica);
		if (index != -1) {
			namirnica.brojac = namirnica.brojac + 1;
		}
		else {
			namirnica.brojac = 1;
			$scope.namirnicaLista.push(namirnica);
		}
		
		
	};
	
	$scope.dodajNamirnicu = function(kategorija) {
	    $mdDialog.show({
	      controller: DodajNamirnicuKontroler,
	      templateUrl: '/views/dijalozi/dodajNamirnicu.html',
	      parent: angular.element(document.body),
	      clickOutsideToClose:true,
	      fullscreen: false // Only for -xs, -sm breakpoints.
	    })
	    .then(function(answer) {
	      
	    }, function() {
	     
	    });
	    
	    namirniceService.aktivnaKategorija = kategorija;
	 };
	 
	 function DodajNamirnicuKontroler($scope, $mdDialog, namirniceService, $route) {
		
		
			 $scope.dodaj = function(){
				 		 
				 var namirnicaIme = $scope.namirnicaIme;				
				 namirniceService.dodajNamirnicu(namirnicaIme, namirniceService.aktivnaKategorija).then(function(response){
					
					 $mdDialog.hide();
					 $route.reload();
					 
				 });
			 }

			 $scope.zatvoriDijalog = function() {
				 $mdDialog.cancel();
			 }
			 
	 }
	
	
	

}]);