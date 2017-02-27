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
import com.projekat.model.Pice;
import com.projekat.model.KartaPicaKategorija;
import com.projekat.services.JeloService;
import com.projekat.services.JelovnikKategorijaService;
import com.projekat.services.PiceService;
import com.projekat.services.kartaPIcaKategorijaService;

@RestController
public class PiceController {
	
	@Autowired
	private PiceService piceService;
	
	@Autowired
	private kartaPIcaKategorijaService kartaPicaKategorijaService;
	
	
	@RequestMapping(
            value    = "/api/kartaPica/dodajPice",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Pice> dodajPice(@RequestBody Pice pice) {
		KartaPicaKategorija piceKategorija = kartaPicaKategorijaService.getOne(pice.getIdKategorije());
		pice.setpKategorija(piceKategorija);
		Pice dodajPice= piceService.create(pice);
        return new ResponseEntity<Pice>(dodajPice, HttpStatus.OK);
    }
	

	@RequestMapping(
            value    = "/api/kartaPica/svaPica/{idKategorije}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Pice>> svaPica(@PathVariable Integer idKategorije) {
		Collection<Pice> svaPica= piceService.getPiceByIdKategorije(idKategorije);
        return new ResponseEntity<Collection<Pice>>(svaPica, HttpStatus.OK);
    }
	
	
	@RequestMapping(
            value    = "/api/kartaPica/izmeniPice/{idKategorije}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Pice> updatePice(@RequestBody Pice pice, @PathVariable Integer idKategorije) {
		KartaPicaKategorija kartaPicaKategorija = kartaPicaKategorijaService.getOne(idKategorije);
		pice.setpKategorija(kartaPicaKategorija);
		Pice dodajPice = piceService.update(pice);
        return new ResponseEntity<Pice>(dodajPice, HttpStatus.OK);
    }

}
