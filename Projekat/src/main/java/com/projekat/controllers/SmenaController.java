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

import com.projekat.model.Smena;
import com.projekat.model.Zaposleni;
import com.projekat.services.SmenaService;
import com.projekat.services.ZaposleniService;



@RestController
public class SmenaController {
	
	@Autowired
	private SmenaService smenaService;
	
	@Autowired
	private ZaposleniService zaposleniService;
	
	@RequestMapping(
            value    = "/api/smena/dodajSmenu",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Smena> dodajSmenu(@RequestBody Smena smena) {
		Smena dodajSmenu = smenaService.dodajSmenu(smena);
        return new ResponseEntity<Smena>(dodajSmenu, HttpStatus.OK);
    }
	
	@RequestMapping(
    		value = "api/smena/smene/{id}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Smena>> smene(@PathVariable Integer id){
		Collection<Smena> smene = smenaService.smenaRestorana(id);
    	return new ResponseEntity<Collection<Smena>>(smene, HttpStatus.OK);
    }
	
	@RequestMapping(
    		value = "api/smena/nadjiSmenuZaZaposlenog/{email:.+}/{restoranId}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Smena>> nadjiSmenuZaZaposlenog(@PathVariable String email, @PathVariable Integer restoranId){
		Zaposleni zaposleni = zaposleniService.getOne(email);
		Collection<Smena> smena = smenaService.findSmenaForZaposleni(zaposleni, restoranId);
    	return new ResponseEntity<Collection<Smena>>(smena, HttpStatus.OK);
    }
	
	@RequestMapping(
    		value = "api/smena/nadjiAktivnuSmenu/{email:.+}/{restoranId}/{vreme}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Smena> nadjiAktivnuSmenu(@PathVariable String email, @PathVariable Integer restoranId, @PathVariable String vreme){
		Zaposleni zaposleni = zaposleniService.getOne(email);
		Smena smena = smenaService.getAktivnaShift(zaposleni, restoranId, vreme, vreme);
    	return new ResponseEntity<Smena>(smena, HttpStatus.OK);
    }

}
