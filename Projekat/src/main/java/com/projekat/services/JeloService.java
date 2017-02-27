package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Jelo;
import com.projekat.repository.JeloRepository;


@Service
public class JeloService {
	
	@Autowired
	private JeloRepository jeloRepository;
	
	public Collection<Jelo> findAll() {
        return jeloRepository.findAll();
    }

    public Jelo create(Jelo jelo) {
        return jeloRepository.save(jelo);
    }

   
  
    public Jelo getOne(Integer id){

		return jeloRepository.findOne(id);
		
	}
    
    
    public Collection<Jelo> getJeloByIdKategorije(Integer idKategorije){

  		return jeloRepository.findByIdKategorije(idKategorije);
  		
  	}
    
	public Jelo update(Jelo jelo){
		return jeloRepository.save(jelo);
	}
    

}
