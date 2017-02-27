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
import com.projekat.model.Zaposleni;
import com.projekat.services.ZaposleniService;

@RestController
public class ZaposleniController {
	
	@Autowired
	private ZaposleniService zaposleniService;
	
	 @RequestMapping(
	            value    = "/api/zaposleni/zaposlen",
	            method   = RequestMethod.POST,
	            produces = MediaType.APPLICATION_JSON_VALUE
	    )
	    public ResponseEntity<Zaposleni> registZaposlenog(@RequestBody Zaposleni zaposleni) {
		 Zaposleni kreirajZaposlenog = zaposleniService.create(zaposleni);
	        return new ResponseEntity<Zaposleni>(kreirajZaposlenog, HttpStatus.OK);
	    }
	 
	 @RequestMapping(
	            value    = "/api/zaposleni/{email:.+}",
	            method   = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE
	    )
	    public ResponseEntity<Zaposleni> emailZaposlenog(@PathVariable String email) {
		 Zaposleni zaposleni = zaposleniService.getOne(email);
	        return new ResponseEntity<Zaposleni>(zaposleni, HttpStatus.OK);
	    }
	 
	 @RequestMapping(
	    		value = "api/zaposleni/sviZaposleni/{id}",
	    		method = RequestMethod.GET,
	    		produces = MediaType.APPLICATION_JSON_VALUE
	    )
	    public ResponseEntity<Collection<Zaposleni>> sviZaposleni(@PathVariable Integer id){
	    	Collection<Zaposleni> sviZaposleni = zaposleniService.nadjiSveZaposleneURestoranu(id);
	    	return new ResponseEntity<Collection<Zaposleni>>(sviZaposleni, HttpStatus.OK);
	    }

}
