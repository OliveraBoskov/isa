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

import com.projekat.model.Korisnik;
import com.projekat.model.Restoran;
import com.projekat.services.RestoranService;

@RestController
public class RestoranContoller {
	
	@Autowired
	private RestoranService restoranService;
	
	@RequestMapping(
            value    = "/api/restorani/restoran",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Restoran> dodajRestoran(@RequestBody Restoran restoran) {
		Restoran kreirajRestoran = restoranService.add(restoran);
        return new ResponseEntity<Restoran>(kreirajRestoran, HttpStatus.OK);
    }
	
	@RequestMapping(
            value    = "/api/restorani/sviRestorani",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Restoran>> uzmiRestorane() {
	Collection<Restoran> sviRestorani = restoranService.getAll();
        return new ResponseEntity<Collection<Restoran>>(sviRestorani,HttpStatus.OK);
    }
	
	@RequestMapping(
            value    = "/api/restorani/restoran/{idRestorana}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Restoran> uzmiRestoran(@PathVariable Integer idRestorana) {
	Restoran jedanRestoran = restoranService.getRestaurantById(idRestorana);
        return new ResponseEntity<Restoran>(jedanRestoran,HttpStatus.OK);
    }
	
	
	@RequestMapping(
            value    = "/api/restorani/izmeniRestoran",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Restoran> izmeniRestoran(@RequestBody Restoran restoran) {
		Restoran kreirajRestoran = restoranService.add(restoran);
        return new ResponseEntity<Restoran>(kreirajRestoran, HttpStatus.OK);
    }
	
	
	
	

}
