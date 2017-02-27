package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Jelovnik;
import com.projekat.model.Korisnik;
import com.projekat.repository.JelovnikRepository;

@Service
public class JelovnikService {
	
	@Autowired
	private JelovnikRepository jelovnikRepository;
	
	public Collection<Jelovnik> findAll() {
        return jelovnikRepository.findAll();
    }

    public Jelovnik create(Jelovnik jelovnik) {
        return jelovnikRepository.save(jelovnik);
    }

   
  
    public Jelovnik getOne(Integer id){

		return jelovnikRepository.findOne(id);
		
	}
    
    public Jelovnik getByIdRestorana(Integer idRestorana){
    	
    	return jelovnikRepository.findByIdRestorana(idRestorana);
    }


}
