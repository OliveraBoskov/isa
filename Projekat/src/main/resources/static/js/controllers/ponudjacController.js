con.controller('ponudjacPocetnaController',['$scope','$location','registrovanjeMenadzeraService','logovanjeService','$mdDialog','$route','namirniceService','dateFilter','ponudaService', function($scope,$location,registrovanjeMenadzeraService,logovanjeService,$mdDialog,$route,namirniceService,dateFilter,ponudaService){

	$scope.ime = registrovanjeMenadzeraService.aktivanZaposlen.ime;
	
	$scope.izmeniPodatke = function(){
		
		$mdDialog.show({
    		controller: IzmeniPodatkeKontroler,
    		templateUrl: '/views/dijalozi/izmeniPodatkeKonobar.html',
    		parent: angular.element(document.body),
    		scope: $scope,
    		preserveScope: true,
    		clickOutsideToClose:false
    	});
		
		function IzmeniPodatkeKontroler($scope, logovanjeService, $mdDialog, $route,registrovanjeMenadzeraService) {
			 
			$scope.activeForm = 1;
			if ($scope.activeForm == 1) {			
				$scope.ime = registrovanjeMenadzeraService.aktivanZaposlen.ime;
				$scope.prezime = registrovanjeMenadzeraService.aktivanZaposlen.prezime;
				$scope.velicinaObuce = registrovanjeMenadzeraService.aktivanZaposlen.velicinaObuce;
				$scope.konfBroj = registrovanjeMenadzeraService.aktivanZaposlen.konfBroj;
			}
			
	  		$scope.apply = function(){	
	  			
	  			if ($scope.activeForm == 1) {
	  				
	  				logovanjeService.promene($scope.ime, $scope.prezime, $scope.konfBroj, $scope.velicinaObuce, registrovanjeMenadzeraService.aktivanZaposlen.email).then(function(response){

					});	
	  					
	  				registrovanjeMenadzeraService.aktivanZaposlen.ime = $scope.ime;
	  				registrovanjeMenadzeraService.aktivanZaposlen.prezime = $scope.prezime;
	  				registrovanjeMenadzeraService.aktivanZaposlen.velicinaObuce = $scope.velicinaObuce;
	  				registrovanjeMenadzeraService.aktivanZaposlen.konfBroj = $scope.konfBroj;
					$scope.ime = registrovanjeMenadzeraService.aktivanZaposlen.ime;
					
					var confirm = $mdDialog.confirm()
						.textContent('Podaci su izmenjeni!')
						.ok('Ok');
					
					$mdDialog.show(confirm);
						$mdDialog.hide();
						
						$route.reload();
	  				
	  			}
	  			
	  			if ($scope.activeForm == 2) {

	  				if ($scope.staraLozinka == registrovanjeMenadzeraService.aktivanZaposlen.lozinka) {
	  					if ($scope.novaLozinka == $scope.novaLozinka2) {

	  						var confirm = $mdDialog.confirm()
	  						.textContent('Lozinka promenjena!')
	  						.ok('Ok');
	  						
	  						registrovanjeMenadzeraService.aktivanZaposlen.lozinka = $scope.staraLozinka;

	  						logovanjeService.prvoLogovanje(egistrovanjeMenadzeraService.aktivanZaposlen.email, 1, $scope.novaLozinka).then(function(response){

	  						});	

	  						$mdDialog.show(confirm);
	  						$mdDialog.hide();
	  						$route.reload();

	  					}
	  				}	
	  			}
	  		}
	  		
	  		$scope.changePassword = function(){
	  			$scope.activeForm = 2;
	  		}
	  		
	  		$scope.cancel = function(){
	  			if ($scope.activeForm == 2) {
	  				$scope.activeForm = 1;
	  			}
	  			else if ($scope.activeForm == 1) {
	  				$mdDialog.cancel();
	  			}
	  		}
	  		
	  	}
		
	}

//PONUDE


	$scope.price = 1;
	$scope.deliveryDate = new Date();
	$scope.deliveryDateOpened = false;

	$scope.openDeliveryDate = function() {
    $scope.deliveryDateOpened = true;
};


	$scope.deliveryTime = new Date();
	$scope.deliveryTime.setHours(10);
	$scope.deliveryTime.setMinutes(0);

		$scope.hstep = 1;
		$scope.mstep = 30;

		
		
		var currentDateAndTime = new Date();
		var curDateString = moment(currentDateAndTime).format('YYYY-MM-DDTHH:mm:ss.sss')+'Z';

		namirniceService.getListaByPocinjeU(curDateString).then(function(response){
			alert(response.data);
				$scope.lists = response.data;
		});	
		
		
		
		$scope.confirmOffer = function(){
			
			var dateString = dateFilter($scope.deliveryDate, 'yyyy-MM-ddT');
			var timeString = dateFilter($scope.deliveryTime, 'HH:mm:00.000');
			var bpTime = dateString + timeString + 'Z';
			
	   ponudaService.dodajPonudu($scope.price, bpTime, registrovanjeMenadzeraService.aktivanZaposlen, $scope.selectedList, $scope.warranty).then(function(response){
				
			});
			
   	  $route.reload();
		}
	
}]);