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

import com.projekat.model.Jelovnik;
import com.projekat.services.JelovnikService;

@RestController
public class JelovnikController {
	
	
	@Autowired
	private JelovnikService jelovnikService;
	
	@RequestMapping(
            value    = "/api/jelovnik/dodajJelovnik",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Jelovnik> dodajJelovnik(@RequestBody Jelovnik jelovnik) {
		Jelovnik dodajJelovnik= jelovnikService.create(jelovnik);
        return new ResponseEntity<Jelovnik>(dodajJelovnik, HttpStatus.OK);
    }
	
	
	

}
