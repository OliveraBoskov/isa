con.controller('registRestoranKontroler', ['$scope','$location','registRestoranService','jelovnikService','kartaPicaService', function($scope,$location,registRestoranService,jelovnikService,kartaPicaService){
	
	
	$scope.registRestoran = function(){
		
		alert("kontroler tacka");
		var ime = $scope.ime;
		var tip = $scope.tip;
		registRestoranService.registRestoran(ime, tip).then(function(response){
			jelovnikService.dodajMeni(response.data.id).then(function(response){
				kartaPicaService.dodajKartuPica(response.data.id).then(function(response){
					$location.path("/admin");
				});
				
			});
			
		});
		
	}
	

}]);