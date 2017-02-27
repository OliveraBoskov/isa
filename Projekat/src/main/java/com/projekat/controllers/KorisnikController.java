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

import com.projekat.model.Korisnik;
import com.projekat.services.KorisnikService;

@RestController
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;
    


    @RequestMapping(
            value    = "/api/korisnici/korisnik",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Korisnik> registKorisnika(@RequestBody Korisnik korisnik) {
        Korisnik registrovan = korisnikService.create(korisnik);
        return new ResponseEntity<Korisnik>(registrovan, HttpStatus.OK);
    }
    

    @RequestMapping(
            value    = "/api/korisnici/{email:.+}",
            method   = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Korisnik> emailKorisnika(@PathVariable String email) {
        Korisnik korisnik = korisnikService.getOne(email);
        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
    }

   

}
