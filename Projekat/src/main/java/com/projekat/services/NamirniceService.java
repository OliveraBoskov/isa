package com.projekat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Namirnica;
import com.projekat.repository.NamirnicaRepository;



@Service
public class NamirniceService {
	
	@Autowired
	private NamirnicaRepository namirnicaRepository;
	
	
	public Namirnica add(Namirnica namirnica) {
		return namirnicaRepository.save(namirnica);
	}
}
