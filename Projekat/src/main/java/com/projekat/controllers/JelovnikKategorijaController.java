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

import com.projekat.model.JelovnikKategorija;
import com.projekat.services.JelovnikKategorijaService;

@RestController
public class JelovnikKategorijaController {
	
	@Autowired
	private JelovnikKategorijaService jelovnikKategorijaService;

	
	@RequestMapping(
            value    = "/api/jelovnik/dodajKategoriju",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<JelovnikKategorija> dodajKategoriju(@RequestBody JelovnikKategorija jelovnikKategorija) {
		JelovnikKategorija dodajKategoriju= jelovnikKategorijaService.create(jelovnikKategorija);
        return new ResponseEntity<JelovnikKategorija>(dodajKategoriju, HttpStatus.OK);
    }
	
	
	
	@RequestMapping(
            value    = "/api/jelovnik/sveKategorije/{idJelovnika}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<JelovnikKategorija>> sveKategorije(@PathVariable Integer idJelovnika) {
		Collection<JelovnikKategorija> sveKategorije= jelovnikKategorijaService.getKategorijaByIdJelovnika(idJelovnika);
        return new ResponseEntity<Collection<JelovnikKategorija>>(sveKategorije, HttpStatus.OK);
    }
	
	
	
}
