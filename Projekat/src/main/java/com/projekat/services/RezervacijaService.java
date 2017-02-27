package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Rezervacija;
import com.projekat.repository.RezervacijaRepository;



@Service
public class RezervacijaService {
	

	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	
	public Collection<Rezervacija> getAll(){
		return rezervacijaRepository.findAll();
	}
	
	public Rezervacija getReservationById(Integer id){
		return rezervacijaRepository.getOne(id);
	}

	
	public Rezervacija addReservation(Rezervacija rezervacija){
		return rezervacijaRepository.save(rezervacija);
	}
	
	public Collection<Rezervacija> getByGostIdAndVremeDolaska(String gostId, String vremeDolaska){
		return rezervacijaRepository.findByGostIdAndVremeDolaskaGreaterThan(gostId, vremeDolaska);
	}
	
	public Collection<Rezervacija> getSveTermRezervacije(String gostId, Integer restoranId, String vremeDolaska, String vremeOdlaska) {
		return rezervacijaRepository.findByGostIdAndRestoranIdAndVremeDolaskaAndVremeOdlaska(gostId, restoranId, vremeDolaska, vremeOdlaska);
	}

	public Integer otkaziRezervaciju(String gostId, Integer restoranId, String vremeDolaska, String vremeOdlaska) {
		return rezervacijaRepository.deleteByGostIdAndRestoranIdAndVremeDolaskaAndVremeOdlaska(gostId, restoranId, vremeDolaska, vremeOdlaska);
	}

}
