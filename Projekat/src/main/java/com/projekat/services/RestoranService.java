package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Restoran;
import com.projekat.repository.RestoranRepository;


@Service
public class RestoranService {
	
	@Autowired
	private RestoranRepository restoranRepository;
	
	public Collection<Restoran> getAll(){
		return restoranRepository.findAll();
	}

	
	public Restoran add(Restoran restoran){
		return restoranRepository.save(restoran);
	}
	
	public Restoran getRestaurantById(Integer restoranId){
		return restoranRepository.findOne(restoranId);
	}

}
