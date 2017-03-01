package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Smena;
import com.projekat.model.Zaposleni;
import com.projekat.repository.SmenaRepository;



@Service
public class SmenaService {
	
	@Autowired
	private SmenaRepository smenaRepository;
	
	public Smena dodajSmenu(Smena smena){
		return smenaRepository.save(smena);
	}
	
	public Collection<Smena> smenaRestorana(Integer restaurantId){
		return smenaRepository.findByRestoranId(restaurantId);
	}

	public Collection<Smena> findSmenaForZaposleni(Zaposleni zaposleni, Integer restoranId) {
		return smenaRepository.findByZaposleniAndRestoranId(zaposleni, restoranId);
	}

	public Smena getAktivnaShift(Zaposleni zaposleni, Integer restoranId, String pocinjeU, String zavrsavaU) {
		return smenaRepository.findByZaposleniAndRestoranIdAndPocinjeULessThanAndZavrsavaUGreaterThan(zaposleni, restoranId, pocinjeU, zavrsavaU);
	}
	


}
