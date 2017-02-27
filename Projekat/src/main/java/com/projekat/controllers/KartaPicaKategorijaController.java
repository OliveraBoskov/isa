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
import com.projekat.model.KartaPicaKategorija;
import com.projekat.services.JelovnikKategorijaService;
import com.projekat.services.kartaPIcaKategorijaService;

@RestController
public class KartaPicaKategorijaController {
	
	@Autowired
	private kartaPIcaKategorijaService service;

	
	@RequestMapping(
            value    = "/api/kartaPica/dodajKategoriju",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KartaPicaKategorija> dodajKategoriju(@RequestBody KartaPicaKategorija kartaPicaKategorija) {
    	KartaPicaKategorija dodajKategoriju= service.create(kartaPicaKategorija);
        return new ResponseEntity<KartaPicaKategorija>(dodajKategoriju, HttpStatus.OK);
    }
	
	
	
	@RequestMapping(
            value    = "/api/kartaPica/sveKategorije/{idKartePica}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<KartaPicaKategorija>> sveKategorije(@PathVariable Integer idKartePica) {
		Collection<KartaPicaKategorija> sveKategorije= service.getKategorijaByIdKartePica(idKartePica);
        return new ResponseEntity<Collection<KartaPicaKategorija>>(sveKategorije, HttpStatus.OK);
    }

}
