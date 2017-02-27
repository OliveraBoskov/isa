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

import com.projekat.model.Jelo;

import com.projekat.model.JelovnikKategorija;
import com.projekat.services.JeloService;
import com.projekat.services.JelovnikKategorijaService;


@RestController
public class JeloController {
	
	@Autowired
	private JeloService jeloService;
	
	@Autowired
	private JelovnikKategorijaService jelovnikKategorijaService;
	
	
	@RequestMapping(
            value    = "/api/jelovnik/dodajJelo",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Jelo> dodajJelo(@RequestBody Jelo jelo) {
		JelovnikKategorija jeloKategorija = jelovnikKategorijaService.getOne(jelo.getIdKategorije());
		jelo.setjKategorija(jeloKategorija);
		Jelo dodajJelo= jeloService.create(jelo);
        return new ResponseEntity<Jelo>(dodajJelo, HttpStatus.OK);
    }
	

	@RequestMapping(
            value    = "/api/jelovnik/svaJela/{idKategorije}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Jelo>> svaJela(@PathVariable Integer idKategorije) {
		Collection<Jelo> svaJela= jeloService.getJeloByIdKategorije(idKategorije);
        return new ResponseEntity<Collection<Jelo>>(svaJela, HttpStatus.OK);
    }
	
	
	@RequestMapping(
            value    = "/api/jelovnik/izmeniJelo/{idKategorije}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Jelo> updateJelo(@RequestBody Jelo jelo, @PathVariable Integer idKategorije) {
		JelovnikKategorija jeloKategorija = jelovnikKategorijaService.getOne(idKategorije);
		jelo.setjKategorija(jeloKategorija);
		Jelo dodajJelo = jeloService.update(jelo);
        return new ResponseEntity<Jelo>(dodajJelo, HttpStatus.OK);
    }

}
