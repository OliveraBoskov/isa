package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.JelovnikKategorija;
import com.projekat.model.KartaPicaKategorija;
import com.projekat.repository.JelovnikKategorijaRepository;
import com.projekat.repository.KartaPicaKategorijaRepository;

@Service
public class kartaPIcaKategorijaService {
	
	@Autowired
	private KartaPicaKategorijaRepository kartaS;
	
	public Collection<KartaPicaKategorija> findAll() {
        return kartaS.findAll();
    }

    public KartaPicaKategorija create(KartaPicaKategorija karta) {
        return kartaS.save(karta);
    }

   
  
    public KartaPicaKategorija getOne(Integer id){

		return kartaS.findOne(id);
		
	}
    
    public Collection<KartaPicaKategorija> getKategorijaByIdKartePica(Integer idKartePica){
    	return kartaS.findByIdKartePica(idKartePica);
    }

}
