package com.projekat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.NamirniceListaItem;
import com.projekat.repository.NamirnicaListaItemRepository;


@Service
public class NamirniceListItemService {
	
	@Autowired
	NamirnicaListaItemRepository namirnicaListaItemRepository;

	public NamirniceListaItem add(NamirniceListaItem namirniceLista) {
		return namirnicaListaItemRepository.save(namirniceLista);
	}

}
