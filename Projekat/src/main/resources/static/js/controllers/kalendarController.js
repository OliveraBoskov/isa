con.controller('kalendarKontroler', ['$scope', 'registRestoranService', 'dateFilter', 'smenaService', function($scope, registRestoranService, dateFilter, smenaService){

	smenaService.smene(registRestoranService.aktivanRestoran.id).then(function(response){
		$scope.events = response.data;
		for (var i = 0; i < $scope.events.length; i++) {
			var zavrsetak = {};
			var zavrsetakString = $scope.events[i].zavrsavaU;
			var zavrsetakMoment = moment(zavrsetakString);
			zavrsetak = moment(zavrsetakMoment).format('HH:mm');
			
			var pocetak = {};
			var pocetakString = $scope.events[i].pocinjeU;
			var pocetakMoment = moment(pocetakString);
			pocetak = moment(pocetakMoment).format('HH:mm');
			
			$scope.events[i].title = pocetak + " - " + zavrsetak + " " + $scope.events[i].zaposleni.ime 
			+ " " + $scope.events[i].zaposleni.prezime 
			+ " (" + $scope.events[i].zaposleni.tip + ")" + " " + $scope.events[i].reon;
			
			
		}
	});
	
	
	
	$scope.smenaSati = 1;
	
	$scope.dodajSmenu = function(){
		
		var reon = "";
		if ($scope.selektovanZaposleni.tip == "konobar") {
			reon = $scope.selektovanReon.vrednost;
		}
		
		var boja = {};
		if ($scope.selektovanZaposleni.tip == "konobar") {
			boja = 'blue';
		}
		else if ($scope.selektovanZaposleni.tip == "kuvar"){
			boja = 'white';
		}
		else if ($scope.selektovanZaposleni.tip == "sanker"){
			boja = 'black';
		}
		
		var datumString = dateFilter($scope.smenaPocetak, 'yyyy-MM-ddT');//dobar
		var vremeString = dateFilter($scope.smenaPocetakVreme, 'HH:mm:00.000');
		var smenaPocetakString = datumString + vremeString + 'Z';
		
		var pocetakSmeneMoment = moment(smenaPocetakString);
		var krajSmeneDatum = moment(pocetakSmeneMoment).add($scope.smenaSati - 1, 'h').toDate();
		var zavrsetakSmeneDratum = moment(krajSmeneDatum).format('YYYY-MM-DDTHH:mm:ss.sss')+'Z'; 
		
		
		smenaService.dodajSmenu(registRestoranService.aktivanRestoran.id, $scope.selektovanZaposleni, boja, reon, smenaPocetakString, zavrsetakSmeneDratum).then(function(response){
			alert('Shift added');
		});
		
		
	} 
	
	
	$scope.reoni = [
	               {
	            	   ime: 'Unutra',
	            	   vrednost: 'unutra'
	               },
	               {
	            	   ime: 'Zabranjeno pusenje',
	            	   vrednost: 'zabranjenoPusenje'
	               },
	               {
	            	   ime: 'Basta (zatvorena)',
	            	   vrednost: 'bastaZatvorena'
	               },
	               {
	            	   ime: 'Basta (otvorena)',
	            	   vrednost: 'bastaOtvorena'
	               }
	             ];
	
	registRestoranService.sviZaposleni(registRestoranService.aktivanRestoran.id).then(function(response){
		$scope.zaposleni = response.data;
	});
	
	
	$scope.restoranId = registRestoranService.aktivanRestoran.id;
	console.log('AKt rest .sda: ' + $scope.restoranId);
	
	$scope.smenaPocetak = new Date();
	$scope.smenaPocetakOtvori = false;
	
	$scope.otvoriSmenuPocetak = function() {
	    $scope.smenaPocetakOtvori = true;
	};
	
	
	$scope.smenaPocetakVreme = new Date();
	$scope.smenaPocetakVreme.setHours(10);
	$scope.smenaPocetakVreme.setMinutes(0);
	
	$scope.hstep = 1;
	$scope.mstep = 30;
	
	$scope.kalendar = 'month';
	$scope.datum = new Date();

	$scope.calendarTitle = "Raspored";
	$scope.eventClicked = function(calendarEvent){
		alert('opa');
	}
	
}]);