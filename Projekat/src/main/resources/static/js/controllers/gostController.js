con.controller('gostPocetnaKontroler',['$scope','$location','logovanjeService', function($scope,$location,logovanjeService){
	
	$scope.ime = logovanjeService.aktivan.ime;
	$scope.prezime = logovanjeService.aktivan.prezime;
	
	$('#kreirajRezervaciju').click(function(){
		$location.path("/kreirajRezervaciju");
    });
	
	$('#listaRestorana').click(function(){
		$location.path("/listaRestorana");
    });
	
	$('#listaPrijatelja').click(function(){
		$location.path("/listaPrijatelja");
    });
	
	$('#profil').click(function(){
		$location.path("/profil");
    });
	
	$('#izlogujSe').click(function(){
		$location.path("/izlogujSe");
    });

}]);


con.controller('gostProfilKontroler',['$scope','$location','logovanjeService','$mdDialog','$route', function($scope,$location,logovanjeService,$mdDialog,$route){
	
	$scope.prezime = logovanjeService.aktivan.prezime;
	$scope.ime = logovanjeService.aktivan.ime;
	
$scope.izmeniPodatke = function(){
		
		$mdDialog.show({
    		controller: IzmeniPodatkeGost,
    		templateUrl: '/views/dijalozi/izmeniPodatkeGost.html',
    		parent: angular.element(document.body),
    		scope: $scope,
    		preserveScope: true,
    		clickOutsideToClose:false
    	});
		
		function IzmeniPodatkeGost($scope, logovanjeService, $mdDialog, $route) {
			 
			$scope.activeForm = 1;
			if ($scope.activeForm == 1) {			
				$scope.ime = logovanjeService.aktivan.ime;
				$scope.prezime = logovanjeService.aktivan.prezime;
				
			}
			
	  		$scope.potvrdi = function(){	
	  			
	  			if ($scope.activeForm == 1) {
	  				
	  				logovanjeService.promeneGost($scope.ime, $scope.prezime,logovanjeService.aktivan.email).then(function(response){

					});	
	  					
	  				logovanjeService.aktivan.ime = $scope.ime;
	  				logovanjeService.aktivan.prezime = $scope.prezime;
	  				
					
					var confirm = $mdDialog.confirm()
						.textContent('Podaci su izmenjeni!')
						.ok('Ok');
					
					$mdDialog.show(confirm);
						$mdDialog.hide();
						
						$route.reload();
	  				
	  			}
	  			
	  			if ($scope.activeForm == 2) {

	  				if ($scope.staraLozinka == logovanjeService.aktivan.lozinka) {
	  					if ($scope.novaLozinka == $scope.novaLozinka2) {

	  						var confirm = $mdDialog.confirm()
	  						.textContent('Lozinka promenjena!')
	  						.ok('Ok');
	  						
	  						logovanjeService.aktivan.lozinka = $scope.staraLozinka;


	  						$mdDialog.show(confirm);
	  						$mdDialog.hide();
	  						$route.reload();

	  					}
	  				}	
	  			}
	  		}
	  		
	  		$scope.promeniLozinku = function(){
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
	
	
}]);


con.controller('rezervacijaKontroler',['$scope','$location','registRestoranService', function($scope,$location,registRestoranService){
	
	registRestoranService.sviRestorani().then(function(response){
		alert("svi restorani:" + response.data)
		$scope.restorani = response.data;
	});
	
	$scope.vremeDolaska = new Date();
	$scope.vremeDolaskaOtvori = false;
	
	$scope.otvoriVremeDolaska = function() {
	    $scope.vremeDolaskaOtvori = true;
	};
	
	
	$scope.vremeDolaskaVreme = new Date();
	$scope.vremeDolaskaVreme.setHours(10);
	$scope.vremeDolaskaVreme.setMinutes(0);
	
	$scope.ostajemSati = 1;
	
	$scope.isVece = false;
	$scope.vremeDolaskaVreme = function(){
		
		var datum = dateFilter($scope.vremeDolaska, 'yyyy-MM-ddT');//dobar
		var vreme = dateFilter($scope.vremeDolaskaVreme, 'HH:mm:00.000');
		var zajedno = datum + vreme + 'Z';
		/*console.log(bpTime);*/
		var datumIVreme = new Date();
		var bpMomenat = moment(zajedno);
		var kraj = moment(bpMomenat).subtract(90, 'm').toDate();
		
		
		var krajString = moment(kraj).format('YYYY-MM-DDTHH:mm:ss.sss')+'Z';
		console.log('New: ' +krajString);
		var datumSad = moment(datumIVreme).format('YYYY-MM-DDTHH:mm:ss.sss')+'Z';
		console.log('Cur: ' + datumSad);
		
		
	}
	
	
	$scope.hstep = 1;
	$scope.mstep = 30;
	
///////////////////////////////////////////////////////////////////////////
///////////////////////////STOLOVI/////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
	
	
	var canvas = new fabric.Canvas('canvas');
	
	canvas.selectionColor = 'rgba(0,255,0,0.3)';
    canvas.selectionBorderColor = 'red';
    canvas.selectionLineWidth = 1;
    
    var rezervisaniStolovi = [];
	
    $scope.nadjiSveRestorane = function(){
    	drinkCategoryService.getAllDrinkCategories($scope.selectedRestaurant.id).then(function(response){
    		$scope.categories = response.data;
    	});
    	
    	if ($scope.selectedRestaurant != undefined) {
    		tableService.getAllRestaurantTables($scope.selectedRestaurant.id).then(function(response){
    			$scope.tables = response.data;
    			console.log('Koliko stolova: '+$scope.tables.length);
    			for (var i = 0; i < $scope.tables.length; i++) {
    				
    				var color = {};
    				if ($scope.tables[i].reon == 'inside'){
    					color = 'red';
    				}
    				else if ($scope.tables[i].reon == 'nonsmoking'){
    					color = 'purple';
    				}
    				else if ($scope.tables[i].reon == 'gardenclosed') {
    					color = 'yellow';
    				}
    				else if ($scope.tables[i].reon == 'gardenopened') {
    					color = 'green';
    				}
    				
    				
    				var table = new fabric.Circle({ radius: 30, fill: color, originX: 'center', originY: 'center'});
    		    	var text = new fabric.Text($scope.tables[i].number,{
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
    		            // Inspect, for a collection of the objects in this group
    		           
    		           console.log(e);
    		           console.log(canvas.getActiveObject().item(1).get('text'));
    		           //ovde se sad korisnik pita da li je siguran da zeli da rezervise taj sto
    		           
    		           
    		          
    		   		    	$mdDialog.show({
    		   		    		controller: TableReservationController,
    		   		    		templateUrl: '/views/dialogs/tableReservationDialog.html',
    		   		    		parent: angular.element(document.body),
    		   		    		
    		   		    		scope: $scope,//?
    		   		    		preserveScope: true,
    		   		    		clickOutsideToClose:true,
    		   		    		fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
    		   		    	})
    		   		    	.then(function(answer) {
    		   		    		$scope.status = 'You said the information was "' + answer + '".';
    		   		    	}, function() {
    		   		    		$scope.status = 'You cancelled the dialog.';
    		   		    	});
    		   		  	
    		   		  	
    		   		  	
    		   		  	function TableReservationController($scope, tableService, $mdDialog) {
    					  
    		   		  		$scope.tableNumber = canvas.getActiveObject().item(1).get('text');
    		   		  		$scope.idr = $scope.selectedRestaurant.ime;
    			 
    		   		  		$scope.apply = function(){
    		   		  			
    		   		  			function containsObject(obj, reservedTables) {
    		   		  				var i;
    		   		  				for (i = 0; i < reservedTables.length; i++) {
    		   		  					if (angular.equals(obj, reservedTables[i])) {
    		   		  						return true;
    		   		  					}
    		   		  				}

    		   		  				return false;
    		   		  			}
    		   		  			
    		   		  			tableService.getTableByRestaurantIdAndNumber($scope.selectedRestaurant.id, $scope.tableNumber+"").then(function(response){
    		   		  				
    		   		  				if(containsObject(response.data, reservedTables) == true) {
    		   		  					alert('Already reserved');
    		   		  				}
    		   		  				else {
    		   		  					reservedTables.push(response.data);
    		   		  				}
    		   		  				
    		   		  			$mdDialog.hide();
    		   		  				
    		   		  			});
    		   		  			
    		   		  		}
    		   		  		
    		   		  		$scope.close = function() {
    		   		  			$mdDialog.cancel();
    		   		  		};

    		   		  	}
    		   		  	
    		           
    		        });
    		    	
    		    	canvas.getObjects();
    		    	canvas.add(group);
    		    	canvas.selection = true;
    		        canvas.renderAll();
    		        canvas.calcOffset();
    		        
    			}
    		});
    	}
    	
    }

}]);

con.controller('listaRestoranaKontroler',['$scope','$location','registRestoranService','orderByFilter', function($scope,$location,registRestoranService,orderBy){
	
	
	registRestoranService.sviRestorani().then(function(response){
		alert(response.data);
		$scope.restorani = response.data;
	});
	
	$scope.sortiraj = function() {
		if ($scope.sortIme == true && $scope.sortTip == true){
			$scope.restorani = orderBy($scope.restorani, ['ime','tip']);
		}
		else if($scope.sortIme == true) {
			$scope.restorani = orderBy($scope.restorani, 'ime');
		}
		else if ($scope.sortTip == true) {
			$scope.restorani = orderBy($scope.restorani, 'tip');
		}
	 };
	


}]);

