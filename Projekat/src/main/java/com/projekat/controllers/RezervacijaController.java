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

import com.projekat.model.Rezervacija;
import com.projekat.services.RezervacijaService;


@RestController
public class RezervacijaController {

	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	
	@RequestMapping(
            value    = "/api/rezervacija/dodajRezervaciju",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Rezervacija> dodajRezervaciju(@RequestBody Rezervacija rezervacija) {
		Rezervacija dodajRezervaciju = rezervacijaService.addReservation(rezervacija);
        return new ResponseEntity<Rezervacija>(dodajRezervaciju, HttpStatus.OK);
    }
	
	@RequestMapping(
            value    = "/api/rezervacija/getByGostIdAndVremeDolaska/{gostId:.+}/{vremeDolaska}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Rezervacija>> getByGuestIdAndVremeDolaska(@PathVariable String gostId, @PathVariable String vremeDolaska) {
		Collection<Rezervacija> rezervacije = rezervacijaService.getByGostIdAndVremeDolaska(gostId, vremeDolaska);
        return new ResponseEntity<Collection<Rezervacija>>(rezervacije, HttpStatus.OK);
    }
	
	
	@RequestMapping(
    		value = "api/rezervacija/otkaziRezervaciju/{id}",
    		method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> otkaziRezervaciju(@PathVariable Integer id){
		Rezervacija rezervacija = rezervacijaService.getReservationById(id);
		Integer restoranId = rezervacija.getRestoranId();
		String vremeDolaska = rezervacija.getVremeDolaska();
		String vremeOdlaska = rezervacija.getVremeOdlaska();
		String gostId = rezervacija.getGostId();
		Integer deletedReservation = rezervacijaService.otkaziRezervaciju(gostId, restoranId, vremeDolaska, vremeOdlaska);
    	return new ResponseEntity<Integer>(deletedReservation, HttpStatus.OK);
    }
	
	@RequestMapping(
    		value = "api/rezervacija/getSveTermRezervacije/{id}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Rezervacija>> getSveTermRezervacije(@PathVariable Integer id){
		Rezervacija rezervacija = rezervacijaService.getReservationById(id);
		String gostId = rezervacija.getGostId();
		String restoranId = rezervacija.getVremeDolaska();
		String vremeDolaska = rezervacija.getVremeOdlaska();
		Integer vremeOdlaska = rezervacija.getRestoranId();
		Collection<Rezervacija> rez = rezervacijaService.getSveTermRezervacije(gostId, vremeOdlaska, vremeDolaska, restoranId);
    	return new ResponseEntity<Collection<Rezervacija>>(rez, HttpStatus.OK);
    }
	
}
