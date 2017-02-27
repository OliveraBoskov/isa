package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Pice;
import com.projekat.repository.PiceRepository;

@Service
public class PiceService {
	
	@Autowired
	private PiceRepository piceRepository;
	
	
	
	public Collection<Pice> findAll() {
        return piceRepository.findAll();
    }

    public Pice create(Pice pice) {
        return piceRepository.save(pice);
    }

   
  
    public Pice getOne(Integer id){

		return piceRepository.findOne(id);
		
	}
    
    
    public Collection<Pice> getPiceByIdKategorije(Integer idKategorije){

  		return piceRepository.findByIdKategorije(idKategorije);
  		
  	}
    
	public Pice update(Pice jelo){
		return piceRepository.save(jelo);
	}

}
