package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Smena;
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

}
