con.controller('adminKontroler',['$scope','$location', function($scope,$location){
	
	$scope.dodajRestoran = function(){
		alert("prva tacka");
		$location.path("/dodajRestoran");
	}
	$scope.dodajMenadzera = function(){
		$location.path("/dodajMenadzera");
	}
}]);