package com.projekat.services;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Korisnik;
import com.projekat.repository.KorisnikRepository;

@Service
public class KorisnikService{

    @Autowired
    KorisnikRepository korisnikRepository;

    public Collection<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    public Korisnik create(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

   
  
    public Korisnik getOne(String id){

		return korisnikRepository.findOne(id);
		
	}

    public Integer promeneGost(String ime, String prezime, String email) {
		return korisnikRepository.setImePrezimeForKorisnik(ime, prezime, email);
	}
}
