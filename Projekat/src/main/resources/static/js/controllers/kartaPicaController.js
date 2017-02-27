con.controller('kartaPicaKontroler',['$scope','$location','$mdDialog','$route','registrovanjeMenadzeraService','kartaPicaKategorijaService','kartaPicaService','picaService', function($scope,$location,$mdDialog,$route,registrovanjeMenadzeraService,kartaPicaKategorijaService,kartaPicaService,picaService){
	
	
	kartaPicaService.sveKategorije(registrovanjeMenadzeraService.aktivanZaposlen.restoran).then(function(response){
		
		$scope.kategorije = response.data;
		
	});
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////			 
///DIJALOG ZA DODAVANJE JELA
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	$scope.dodajKartuPica = function(kategorija){
		
		    $mdDialog.show({
			      controller: dodajPiceKontroler,
			      templateUrl: '/views/dijalozi/dodajPice.html',
			      parent: angular.element(document.body),
			     // targetEvent: kategorija,
			      clickOutsideToClose:true,
			      fullscreen: false 
			    })
			    .then(function(answer) {
			    	
			    	
			      
			    }, function() {
			     
			    });
		    
		    kartaPicaKategorijaService.aktivnaKategorija = kategorija.id;
		    picaService.piceKategorija = kategorija;
		    
			 };
			 
			
			 
			 function dodajPiceKontroler($scope, $mdDialog, $route, registrovanjeMenadzeraService,picaService,kartaPicaKategorijaService) {

					 $scope.dodajPice= function(){
						 
						 var idKategorije = kartaPicaKategorijaService.aktivnaKategorija;
						 var ime = $scope.ime;
						 var opis = $scope.opis;
						 var cena = $scope.cena;
						 
						 alert($scope.kategorija);
						 
						 picaService.dodajPice(idKategorije, ime, opis, cena).then(function(response){
						
							 $mdDialog.hide();
							 $route.reload();
							 
						 });
					 }
					 
					 $scope.zatvoriDijalog = function() {
						 $mdDialog.cancel();
					 }
					 
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////			 
///DIJALOG ZA DODAVANJE KATEGORIJE
///////////////////////////////////////////////////////////////////////////////////////////////////
				
				$scope.dodajKategoriju = function(ev){
					
					    $mdDialog.show({
						      controller: dodajKategorijuKontroler,
						      templateUrl: '/views/dijalozi/dodajKategorijuPica.html',
						      parent: angular.element(document.body),
						      targetEvent: ev,
						      clickOutsideToClose:true,
						      fullscreen: false 
						    })
						    .then(function(answer) {
						      
						    }, function() {
						     
						    });
						 };
						 
						 function dodajKategorijuKontroler($scope, $mdDialog, $route, registrovanjeMenadzeraService) {

								 $scope.dodajKategoriju= function(){
									 
									 var ime = $scope.ime;
									 
									 kartaPicaKategorijaService.dodajKategoriju(registrovanjeMenadzeraService.aktivanZaposlen.restoran,ime).then(function(response){
									
										 $mdDialog.hide();
										 $route.reload();
										 
									 });
								 }
								 
								 $scope.closeDialog = function() {
									 $mdDialog.cancel();
								 }
								 
					
				}		
						 
///////////////////////////////////////////////////////////////////////////////////////////////////			 
///DIJALOG ZA IZMENU JELA
///////////////////////////////////////////////////////////////////////////////////////////////////					 
					
						 
		$scope.izmeniPice = function(ev, kategorija, pice){
			
			console.log('Id kategorije: ' + kategorija.id);
			picaService.aktivnaKategorija= kategorija;
			picaService.pice = pice;
								
			$mdDialog.show({
			controller: izmeniPiceKontroler,
			templateUrl: '/views/dijalozi/izmeniPice.html',
			parent: angular.element(document.body),
			targetEvent: ev,
		    clickOutsideToClose:true,
			fullscreen: false 
			})
			.then(function(answer) {
								      
			}, function() {
				
				
								     
			});
			
			kartaPicaKategorijaService.aktivnaKategorija = kategorija.id;
			picaService.aktivnoPice = pice;
			
			};
								 
			function izmeniPiceKontroler($scope, $mdDialog, $route, registrovanjeMenadzeraService,picaService,kartaPicaKategorijaService) {
				
				 $scope.ime = picaService.aktivnoPice.imePica;
				 $scope.opis = picaService.aktivnoPice.opisPica;
				 $scope.cena = picaService.aktivnoPice.cena;
				
				
				 $scope.izmeniPice= function(){
					 
					 var idKategorije = kartaPicaKategorijaService.aktivnaKategorija;
					 var ime = $scope.ime;
					 var opis = $scope.opis;
					 var cena = $scope.cena;
					 var piceId = picaService.aktivnoPice.id;
					 var piceKategorija = picaService.aktivnaKategorijaPica.id;
					
					 
					 
					 picaService.izmeniPice(idKategorije, ime, opis, cena, piceId, piceKategorija).then(function(response){
					
						 $mdDialog.hide();
						 $route.reload();
						 
					 });
				 }
				 
				 $scope.zatvoriDijalog = function() {
					 $mdDialog.cancel();
				 }
				 
	
}							
						
			 
			 
			 
	
}]);