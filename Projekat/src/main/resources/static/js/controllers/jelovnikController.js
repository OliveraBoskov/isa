con.controller('jelovnikKontroler',['$scope','$location','$mdDialog','$route','registrovanjeMenadzeraService','jelaKategorijaService','jelovnikService','jelaService', function($scope,$location,$mdDialog,$route,registrovanjeMenadzeraService,jelaKategorijaService,jelovnikService,jelaService){
	
	
	jelovnikService.sveKategorije(registrovanjeMenadzeraService.aktivanZaposlen.restoran).then(function(response){
		
		$scope.kategorije = response.data;
		
	});
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////			 
///DIJALOG ZA DODAVANJE JELA
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	$scope.dodajJelo = function(kategorija){
		
		    $mdDialog.show({
			      controller: dodajJeloKontroler,
			      templateUrl: '/views/dijalozi/dodajJelo.html',
			      parent: angular.element(document.body),
			     // targetEvent: kategorija,
			      clickOutsideToClose:true,
			      fullscreen: false 
			    })
			    .then(function(answer) {
			    	
			    	
			      
			    }, function() {
			     
			    });
		    
		    jelaKategorijaService.aktivnaKategorija = kategorija.id;
		    jelaService.jeloKategorija = kategorija;
		    
			 };
			 
			
			 
			 function dodajJeloKontroler($scope, $mdDialog, $route, registrovanjeMenadzeraService,jelaService,jelaKategorijaService) {

					 $scope.dodajJelo= function(){
						 
						 var idKategorije = jelaKategorijaService.aktivnaKategorija;
						 var ime = $scope.ime;
						 var opis = $scope.opis;
						 var cena = $scope.cena;
						 
						 alert($scope.kategorija);
						 
						 jelaService.dodajJelo(idKategorije, ime, opis, cena).then(function(response){
						
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
						      templateUrl: '/views/dijalozi/dodajKategoriju.html',
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
									 
									 jelaKategorijaService.dodajKategoriju(registrovanjeMenadzeraService.aktivanZaposlen.restoran,ime).then(function(response){
									
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
					
						 
		$scope.izmeniJelo = function(ev, kategorija, jelo){
			
			jelaService.aktivnaKategorija= kategorija;
			jelaService.jelo = jelo;
								
			$mdDialog.show({
			controller: izmeniJeloKontroler,
			templateUrl: '/views/dijalozi/izmeniJelo.html',
			parent: angular.element(document.body),
			targetEvent: ev,
		    clickOutsideToClose:true,
			fullscreen: false 
			})
			.then(function(answer) {
								      
			}, function() {
				
				
								     
			});
			
			jelaKategorijaService.aktivnaKategorija = kategorija.id;
			jelaService.aktivnoJelo = jelo;
			
			};
								 
			function izmeniJeloKontroler($scope, $mdDialog, $route, registrovanjeMenadzeraService,jelaService,jelaKategorijaService) {
				
				 $scope.ime = jelaService.aktivnoJelo.imeJela;
				 $scope.opis = jelaService.aktivnoJelo.opisJela;
				 $scope.cena = jelaService.aktivnoJelo.cena;
				
				
				 $scope.izmeniJelo= function(){
					 
					 var idKategorije = jelaKategorijaService.aktivnaKategorija;
					 var ime = $scope.ime;
					 var opis = $scope.opis;
					 var cena = $scope.cena;
					 var jeloId = jelaService.aktivnoJelo.id;
					 var jeloKategorija = jelaService.aktivnaKategorijaJela.id;
					
					 
					 
					 jelaService.izmeniJelo(idKategorije, ime, opis, cena, jeloId, jeloKategorija).then(function(response){
					
						 $mdDialog.hide();
						 $route.reload();
						 
					 });
				 }
				 
				 $scope.zatvoriDijalog = function() {
					 $mdDialog.cancel();
				 }
				 
	
}							
						
			 
			 
			 
	
}]);