package com.projekat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projekat.model.Namirnica;
import com.projekat.model.NamirniceKategorija;
import com.projekat.services.NamirniceKategorijaService;
import com.projekat.services.NamirniceService;


@RestController
public class NamirnicaController {
	
	@Autowired
	private NamirniceService namirniceService;
	
	@Autowired
	private NamirniceKategorijaService namirniceKategorijaService;
	
	
	@RequestMapping(
            value    = "/api/namirnice/dodajNamirnicu/{id}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Namirnica> addGroceries(@RequestBody Namirnica namirnice, @PathVariable Integer id) {
		NamirniceKategorija nKategorija = namirniceKategorijaService.getById(id);
		namirnice.setnKategorija(nKategorija);
		Namirnica addingGroceries = namirniceService.add(namirnice);
        return new ResponseEntity<Namirnica>(addingGroceries, HttpStatus.OK);
    }

}
