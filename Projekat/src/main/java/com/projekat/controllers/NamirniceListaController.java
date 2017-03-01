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

import com.projekat.model.NamirniceLista;
import com.projekat.services.NamirniceListService;


@RestController
public class NamirniceListaController {
	
	@Autowired
	private NamirniceListService namirniceListService;
	
	@RequestMapping(
            value    = "/api/namirnice/dodajListu",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NamirniceLista> addGroceriesList(@RequestBody NamirniceLista gl) {
		NamirniceLista addingGroceriesList = namirniceListService.add(gl);
        return new ResponseEntity<NamirniceLista>(addingGroceriesList, HttpStatus.OK);
    }
	
	
	@RequestMapping(
            value    = "/api/namirnice/getListe/{restoranId}/{pocinjeU}/{zavrsavaU}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<NamirniceLista>> getGroceriesLists(@PathVariable Integer restoranId, @PathVariable String pocinjeU, @PathVariable String zavrsavaU) {
		Collection<NamirniceLista> groceriesLists = namirniceListService.getAllLists(restoranId, pocinjeU, zavrsavaU);
        return new ResponseEntity<Collection<NamirniceLista>>(groceriesLists, HttpStatus.OK);
    }
	
	@RequestMapping(
            value    = "/api/namirnice/getListaByPocinjeU/{pocinjeU}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<NamirniceLista>> getListaByPocinjeU(@PathVariable String pocinjeU) {
		Collection<NamirniceLista> groceriesLists = namirniceListService.getAllOngoingLists(pocinjeU);
        return new ResponseEntity<Collection<NamirniceLista>>(groceriesLists, HttpStatus.OK);
    }
	
	@RequestMapping(
            value    = "/api/namirnice/dodajAktivnuListu/{id}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> addGroceriesListActive(@PathVariable Integer id) {
		Integer indexOfUpdatedList = namirniceListService.setAktivnaToFalse(false, id);
        return new ResponseEntity<Integer>(indexOfUpdatedList, HttpStatus.OK);
    }

}
