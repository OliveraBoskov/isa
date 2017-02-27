package com.projekat.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Zaposleni;
import com.projekat.repository.ZaposleniRepository;

@Service
public class ZaposleniService {
	
	
	@Autowired
	private ZaposleniRepository zaposleniRepository;
	
	public Collection<Zaposleni> findAll() {
        return zaposleniRepository.findAll();
    }

    public Zaposleni create(Zaposleni zaposleni) {
        return zaposleniRepository.save(zaposleni);
    }

   
  
    public Zaposleni getOne(String id){

		return zaposleniRepository.findOne(id);
		
	}
    
	public Collection<Zaposleni> nadjiSveZaposlene() {
		return zaposleniRepository.findByTipOrTipOrTip("konobar", "kuvar", "sanker");
	}

	public Collection<Zaposleni> nadjiSveZaposleneURestoranu(Integer restoran) {
		ArrayList<String> tipoviKojiNeOdgovaraju = new ArrayList<String>();
		tipoviKojiNeOdgovaraju.add("menadzer");
		tipoviKojiNeOdgovaraju.add("ponudjac");
		Collection<String> tipovi = tipoviKojiNeOdgovaraju;
		return zaposleniRepository.findByRestoranAndTipNotIn(restoran, tipovi);
	}


}
