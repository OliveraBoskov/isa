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
import com.projekat.services.SmenaService;


@RestController
public class SmenaController {
	
	@Autowired
	private SmenaService smenaService;
	
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

}
