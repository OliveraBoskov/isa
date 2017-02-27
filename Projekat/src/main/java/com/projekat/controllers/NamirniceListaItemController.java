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
import com.projekat.model.NamirniceListaItem;
import com.projekat.services.NamirniceListItemService;
import com.projekat.services.NamirniceListService;


@RestController
public class NamirniceListaItemController {
	
	@Autowired
	private NamirniceListItemService namirniceListItemService;
	
	
	@Autowired
	private NamirniceListService namirniceListService;
	
	@RequestMapping(
            value    = "/api/namirnice/dodajListItem/{id}",
            method   = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NamirniceListaItem> addGroceriesListItem(@RequestBody NamirniceListaItem grItem, @PathVariable Integer id) {
		NamirniceLista groceriesList = namirniceListService.getById(id);
		grItem.setNl(groceriesList);
		NamirniceListaItem addingGroceriesLI = namirniceListItemService.add(grItem);
        return new ResponseEntity<NamirniceListaItem>(addingGroceriesLI, HttpStatus.OK);
    }

}
