con.controller('menadzerPocetnaController',['$scope','$location','registrovanjeMenadzeraService','registRestoranService','$mdDialog','$route','stoService', function($scope,$location,registrovanjeMenadzeraService,registRestoranService,$mdDialog,$route,stoService){

	
	$scope.ime = registrovanjeMenadzeraService.aktivanZaposlen.ime;
	
	
	
	
	registRestoranService.menadzerRestoran(registrovanjeMenadzeraService.aktivanZaposlen.restoran).then(function(response){
		$scope.imeRestoran = response.data.ime; 
		$scope.opisRestoran = response.data.tip;
		registRestoranService.aktivanRestoran = response.data;
		
		
	});
	
	$scope.izmeniPodatke = function(ev){
		
		
		
		 $mdDialog.show({
		      controller: izmeniPodatkeRestoranKontroler,
		      templateUrl: '/views/dijalozi/izmeniPodatkeRestoran.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      fullscreen: false 
		    })
		    .then(function(answer) {
		      
		    }, function() {
		     
		    });
		 };
		 
		 function izmeniPodatkeRestoranKontroler($scope, $mdDialog, $route, registRestoranService) {

			 $scope.ime = registRestoranService.aktivanRestoran.ime;
			 $scope.opis = registRestoranService.aktivanRestoran.tip;
			 
				 $scope.izmeniPodatkeRestoran= function(){
					 
					 var ime = $scope.ime;
					 var opis = $scope.opis;
					 
					 registRestoranService.izmeniRestoran(registRestoranService.aktivanRestoran.id,ime, opis).then(function(response){
						 
						 $mdDialog.hide();
						 $route.reload();
						 
					 });
				 }
				 
				 $scope.zatvoriDijalog = function() {
					 $mdDialog.cancel();
				 }
				 
	
	
		
	}
	
	
	$('#dodajKonobara').click(function(){
		$location.path("/dodajKonobara");
    });
	
	$('#dodajKuvara').click(function(){
		$location.path("/dodajKuvara");
    });
	
	$('#dodajSankera').click(function(){
		$location.path("/dodajSankera");
    });
	
	$('#dodajPonudjaca').click(function(){
		$location.path("/dodajPonudjaca");
    });
	
	$('#dodajJelovnik').click(function(){
		$location.path("/dodajJelovnik");
    });
	
	$('#dodajKartuPica').click(function(){
		$location.path("/dodajKartuPica");
    });
	
	$('#vidiKalendar').click(function(){
		$location.path("/vidiKalendar");
    });
	
	$('#vidiListu').click(function(){
		$location.path("/listaSaNamirnicama");
    });
	
	
	
	
	
	var counter = 1;
	var canvas = new fabric.Canvas('canvas');
	
///////////////////////////////////////////////////////////////////////////////////
//--------------------------------Dodaj unutrasnji sto---------------------------------
///////////////////////////////////////////////////////////////////////////////////
	

	$('#dodajUnutrasnjiSto').click(function(){
    	var sto = new fabric.Rect({ height:80, width:80, fill: 'red', originX: 'center', originY: 'center'});
    	var text = new fabric.Text((counter++)+"",{
    		fontFamily: 'Calibri',
    		fontSize: 25,
    		fill: 'white',
    		originX: 'center',
            originY: 'center'
    	});
    	
    	var grupa = new fabric.Group([sto, text],{
    		top: 200, left: 150
    	});
    	
    	canvas.getObjects();
    	canvas.add(grupa);
    	canvas.selection = true;
        canvas.renderAll();
        canvas.calcOffset();
        
        
    	
    });
	
///////////////////////////////////////////////////////////////////////////////////
//--------------------------------Dodaj sto za nepusace---------------------------------
///////////////////////////////////////////////////////////////////////////////////
	    

	$('#nePusenjeSto').click(function(){
    	var sto = new fabric.Rect({ height:80, width:80, fill: 'purple', originX: 'center', originY: 'center'});
    	var text = new fabric.Text((counter++)+"",{
    		fontFamily: 'Calibri',
    		fontSize: 25,
    		fill: 'white',
    		originX: 'center',
            originY: 'center'
    	});
    	
    	var grupa = new fabric.Group([sto, text],{
    		top: 200, left: 150
    	});
    	
    	canvas.getObjects();
    	canvas.add(grupa);
    	canvas.selection = true;
        canvas.renderAll();
        canvas.calcOffset();
        
        
    	
    });
///////////////////////////////////////////////////////////////////////////////////
//--------------------------------Dodaj sto u zatvorenoj basti---------------------------------
///////////////////////////////////////////////////////////////////////////////////	

	$('#dodajBastaZatvorena').click(function(){
    	var sto = new fabric.Rect({ height:80, width:80, fill: 'yellow', originX: 'center', originY: 'center'});
    	var text = new fabric.Text((counter++)+"",{
    		fontFamily: 'Calibri',
    		fontSize: 25,
    		fill: 'white',
    		originX: 'center',
            originY: 'center'
    	});
    	
    	var grupa = new fabric.Group([sto, text],{
    		top: 200, left: 150
    	});
    	
    	canvas.getObjects();
    	canvas.add(grupa);
    	canvas.selection = true;
        canvas.renderAll();
        canvas.calcOffset();
        
        
    	
    });
	
///////////////////////////////////////////////////////////////////////////////////
//--------------------------------Dodaj sto u otvorenoj basti---------------------------------
///////////////////////////////////////////////////////////////////////////////////	
	$('#dodajBastaOtvorena').click(function(){
    	var sto = new fabric.Rect({ height:80, width:80, fill: 'green', originX: 'center', originY: 'center'});
    	var text = new fabric.Text((counter++)+"",{
    		fontFamily: 'Calibri',
    		fontSize: 25,
    		fill: 'white',
    		originX: 'center',
            originY: 'center'
    	});
    	
    	var grupa = new fabric.Group([sto, text],{
    		top: 200, left: 150
    	});
    	
    	canvas.getObjects();
    	canvas.add(grupa);
    	canvas.selection = true;
        canvas.renderAll();
        canvas.calcOffset();

    });
	
	$('#sacuvajKonfiguraciju').click(function(){
		var broj = {};
		var levo = {};
		var gore = {};
		var reon = {};
		for (var i = 0; i < canvas.getObjects().length; i++){
			if(canvas.getObjects()[i].get('left') != 150) {
				
				levo = canvas.getObjects()[i].get('left');
				gore = canvas.getObjects()[i].get('top');
				broj = canvas.getObjects()[i].item(1).get('text');
				
				if (canvas.getObjects()[i].item(0).get('fill') == 'red'){
					reon = 'unutra';
				}
				else if (canvas.getObjects()[i].item(0).get('fill') == 'purple'){
					reon = 'zabranjenoPusenje';
				}
				else if (canvas.getObjects()[i].item(0).get('fill') == 'yellow') {
					reon = 'zatvorenaBasta';
				}
				else if (canvas.getObjects()[i].item(0).get('fill') == 'green') {
					reon = 'otvorenaBasta';
				}
				
				stoService.dodajSto(broj, registRestoranService.aktivanRestoran.id, reon, registRestoranService.aktivanRestoran, levo, gore).then(function(response){	
					
				});
				
			}
		}

    });

	
	canvas.selectionColor = 'rgba(0,255,0,0.3)';
    canvas.selectionBorderColor = 'red';
    canvas.selectionLineWidth = 1;
 
	
    

}]);
