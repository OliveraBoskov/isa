package com.projekat.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.model.Restoran;
import com.projekat.model.Sto;
import com.projekat.services.RestoranService;
import com.projekat.services.StoService;




@RestController
public class StoController {
	
	@Autowired
	private StoService stoService;
	
	@Autowired
	private RestoranService restoranService;
	
	@RequestMapping(
            value    = "/api/restoran/dodajSto",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Sto> addDrink(@RequestBody Sto sto) {
		Restoran restoran = restoranService.getRestaurantById(sto.getIdRestorana());
		sto.setRestoran(restoran);
		Sto dodajSto = stoService.add(sto);
        return new ResponseEntity<Sto>(dodajSto, HttpStatus.OK);
    }
	
	@RequestMapping(
    		value = "/api/restoran/uzmiSveStolove/{restoranId}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Sto>> getRestoranById(@PathVariable Integer restoranId){
    	Collection<Sto> restaurantTables = stoService.uzmiSveStoloveIzRestorana(restoranId);
    	return new ResponseEntity<Collection<Sto>>(restaurantTables, HttpStatus.OK);
    }
	
	@RequestMapping(
    		value = "/api/restoran/uzmiSto/{restoranId}/{stoBroj}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Sto> getStoByIdRestoranaAndBroj(@PathVariable Integer restoranId, @PathVariable String stoBroj){
		Sto stoIzRestorana = stoService.getStoByIdRestoranaAndBroj(restoranId, stoBroj);
    	return new ResponseEntity<Sto>(stoIzRestorana, HttpStatus.OK);
    }
	

}
