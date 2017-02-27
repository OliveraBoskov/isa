package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.JelovnikKategorija;
import com.projekat.repository.JelovnikKategorijaRepository;

@Service
public class JelovnikKategorijaService {
	
	@Autowired
	private JelovnikKategorijaRepository jelovnikKategorijaRepository;
	
	public Collection<JelovnikKategorija> findAll() {
        return jelovnikKategorijaRepository.findAll();
    }

    public JelovnikKategorija create(JelovnikKategorija jelovnik) {
        return jelovnikKategorijaRepository.save(jelovnik);
    }

   
  
    public JelovnikKategorija getOne(Integer id){

		return jelovnikKategorijaRepository.findOne(id);
		
	}
    
    public Collection<JelovnikKategorija> getKategorijaByIdJelovnika(Integer idJelovnika){
    	return jelovnikKategorijaRepository.findByIdJelovnika(idJelovnika);
    }

}
