package com.projekat.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.model.NamirniceKategorija;
import com.projekat.services.NamirniceKategorijaService;


@RestController
public class NamirniceKategorijaController {

	
	@Autowired
	NamirniceKategorijaService namirniceKategorijaService;
	
	@RequestMapping(
            value    = "/api/namirniceKategorija/dodajNamirniceKategoriju",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NamirniceKategorija> dodajNamirniceKategoriju(@RequestBody NamirniceKategorija namirniceKategorija) {
		NamirniceKategorija dodajNamirniceKategoriju = namirniceKategorijaService.add(namirniceKategorija);
        return new ResponseEntity<NamirniceKategorija>(dodajNamirniceKategoriju, HttpStatus.OK);
    }

	@RequestMapping(
			value = "/api/namirniceKategorija/sveKategorije",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Collection<NamirniceKategorija>> sveKategorije(){
		Collection<NamirniceKategorija> sveKategorije = namirniceKategorijaService.allCategories();
		return new ResponseEntity<Collection<NamirniceKategorija>>(sveKategorije, HttpStatus.OK);
	}
}
