con.controller('adminKontroler',['$scope','$location','logovanjeService', function($scope,$location,logovanjeService){
	
	$scope.dodajRestoran = function(){
		alert("prva tacka");
		$location.path("/dodajRestoran");
	}
	$scope.dodajMenadzera = function(){
		$location.path("/dodajMenadzera");
	}
	
	$scope.menadzerSistema = false;
	
	if(logovanjeService.aktivan.email == "a@g.com"){
		alert("aktivan email "+logovanjeService.aktivan.email);
		$scope.menadzerSistema = true;
		$scope.dodajMenadzeraSistema = function(){
			
			$location.path("/dodajMenadzeraSistema")
		}
	}
	
	
	
}]);