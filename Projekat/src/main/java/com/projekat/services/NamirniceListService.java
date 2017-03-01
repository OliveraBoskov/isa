package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.NamirniceLista;
import com.projekat.repository.NamirnicaLIstRepository;


@Service
public class NamirniceListService {
	
	@Autowired
	private NamirnicaLIstRepository namirnicaLIstRepository;

	public NamirniceLista add(NamirniceLista groceriesList) {
		
		return namirnicaLIstRepository.save(groceriesList);
	}

	public Collection<NamirniceLista> getAllLists(Integer restaurantId, String startingTime, String endingTime) {
		return namirnicaLIstRepository.findByRestoranIdAndPocinjeUGreaterThanAndZavrsavaULessThan(restaurantId, startingTime, endingTime);
	}

	public NamirniceLista getById(Integer id) {
		return namirnicaLIstRepository.findOne(id);
	}

	public Collection<NamirniceLista> getAllOngoingLists(String pocinjeU) {
		return namirnicaLIstRepository.findByZavrsavaUGreaterThan(pocinjeU);
	}

	public Integer setAktivnaToFalse(boolean b, Integer id) {
		return namirnicaLIstRepository.setAktivnaForNamirniceList(b, id);
	}

}
