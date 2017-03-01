con.controller('konobarPocetnaController',['$scope','$location','registrovanjeMenadzeraService','logovanjeService','$mdDialog','$route', function($scope,$location,registrovanjeMenadzeraService,logovanjeService,$mdDialog,$route){

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

	  						logovanjeService.prvoLogovanje(registrovanjeMenadzeraService.aktivanZaposlen.email, 1, $scope.novaLozinka).then(function(response){

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


if (registrovanjeMenadzeraService.aktivanZaposlen.prviPut == true) {
	$mdDialog.show({
    		controller: PrvoLogovanjeKontroler,
    		templateUrl: '/views/dijalozi/prvoLogovanje.html',
    		parent: angular.element(document.body),
    		scope: $scope,
    		preserveScope: true,
    		clickOutsideToClose:false
    	});
	
	function PrvoLogovanjeKontroler($scope, logovanjeService, $mdDialog, $route,registrovanjeMenadzeraService) {

	  		$scope.apply = function(){	
	  			if ($scope.staraLozinka == registrovanjeMenadzeraService.aktivanZaposlen.lozinka) {
	  				if ($scope.novaLozinka == $scope.novaLozinka2) {
	  					
	  				var confirm = $mdDialog.confirm()
	  		          				.textContent('Lozinka je promenjena!')
	  		          				.ok('Ok');
	  				
	  				logovanjeService.prvoLogovanje(registrovanjeMenadzeraService.aktivanZaposlen.email, false, $scope.novaLozinka).then(function(response){
	  			
	  				});	
	  				
	  				registrovanjeMenadzeraService.aktivanZaposlen.prviPut = false;
	  				
	  				$mdDialog.show(confirm);
	  				$mdDialog.hide();
	  				$route.reload();
	  				
	  				}
	  			}
	  			
	  		}
	  		

	  	}
}


$scope.calendarView = 'month';
$scope.viewDate = new Date();
$scope.calendarTitle = "Schedule";
$scope.eventClicked = function(calendarEvent){
	
}


$scope.activeShift = function() {

	var currentDateAndTime = new Date();
	var curDateString = moment(currentDateAndTime).format('YYYY-MM-DDTHH:mm:ss.sss')+'Z';
	

	smenaService.nadjiSmenuZaZaposlenog(registrovanjeMenadzeraService.aktivanZaposlen.email, registrovanjeMenadzeraService.aktivanZaposlen.restoran, curDateString).then(function(response){

		$scope.activeReon = response.data.reon;
		console.log('Region: ' + response.data.reon);

		stoService.uzmiSveStolove(registrovanjeMenadzeraService.aktivanZaposlen.restoran).then(function(response){
			
			$scope.tables = response.data;

			var canvas = new fabric.Canvas('canvas');

			for (var i = 0; i < $scope.tables.length; i++) {
				var color = {};
				if ($scope.tables[i].reon == $scope.activeReon){
					color = 'green';
				}
				else {
					color = 'red';
				}
			


			var table = new fabric.Circle({ radius: 30, fill: color, originX: 'center', originY: 'center'});
			var text = new fabric.Text($scope.tables[i].number+"",{
				fontFamily: 'Calibri',
				fontSize: 25,
				fill: 'white',
				originX: 'center',
				originY: 'center'
			});

			var group = new fabric.Group([table, text],{
				top: $scope.tables[i].positionTop, left: $scope.tables[i].positionLeft,
				lockMovementX: true,  lockMovementY: true, hasControls: false
			});

			group.on('mousedown', function(e) {

			});

			canvas.getObjects();
			canvas.add(group);
			canvas.selection = false;
			canvas.renderAll();
			canvas.calcOffset();
		}

		});


	});

}




	
}]);