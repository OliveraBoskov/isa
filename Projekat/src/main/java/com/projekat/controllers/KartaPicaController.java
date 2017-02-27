package com.projekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.model.Jelovnik;
import com.projekat.model.KartaPica;
import com.projekat.services.JelovnikService;
import com.projekat.services.kartaPicaService;

@RestController
public class KartaPicaController {
	
	@Autowired
	private kartaPicaService kartaPicaService;
	
	@RequestMapping(
            value    = "/api/kartaPica/dodajKartuPica",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KartaPica> dodajJelovnik(@RequestBody KartaPica karta) {
    	KartaPica dodajKartuPica= kartaPicaService.create(karta);
        return new ResponseEntity<KartaPica>(dodajKartuPica, HttpStatus.OK);
    }
	

}
