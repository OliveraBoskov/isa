package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Jelovnik;
import com.projekat.model.KartaPica;
import com.projekat.repository.JelovnikRepository;
import com.projekat.repository.KartaPicaRepository;

@Service
public class kartaPicaService {
	
	@Autowired
	private KartaPicaRepository kartaPicaRepository;
	
	public Collection<KartaPica> findAll() {
        return kartaPicaRepository.findAll();
    }

    public KartaPica create(KartaPica karta) {
        return kartaPicaRepository.save(karta);
    }

   
  
    public KartaPica getOne(Integer id){

		return kartaPicaRepository.findOne(id);
		
	}
    
    public KartaPica getByIdRestorana(Integer idRestorana){
    	
    	return kartaPicaRepository.findByIdRestorana(idRestorana);
    }

}
