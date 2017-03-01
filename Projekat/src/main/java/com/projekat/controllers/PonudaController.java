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

import com.projekat.model.NamirniceLista;
import com.projekat.model.Ponuda;
import com.projekat.services.NamirniceListService;
import com.projekat.services.PonudaService;



@RestController
public class PonudaController {
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private NamirniceListService namirniceListService;
	
	
	@RequestMapping(
            value    = "/api/ponuda/updatePonuda/{price}/{deliveryDate}/{warranty}/{id}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> updateOffer(@PathVariable Integer price, @PathVariable String deliveryDate, @PathVariable Boolean warranty, @PathVariable Integer id) {
		Integer addingOffer = ponudaService.update(price, deliveryDate, warranty, id);
        return new ResponseEntity<Integer>(addingOffer, HttpStatus.OK);
    }
	
	
	@RequestMapping(
            value    = "/api/ponuda/dodajPonudu/{id}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Ponuda> addOffer(@RequestBody Ponuda ponuda, @PathVariable Integer id) {
		NamirniceLista groceriesList = namirniceListService.getById(id);
		ponuda.setNl(groceriesList);
		Ponuda addingOffer = ponudaService.add(ponuda);
        return new ResponseEntity<Ponuda>(addingOffer, HttpStatus.OK);
    }
	


}
