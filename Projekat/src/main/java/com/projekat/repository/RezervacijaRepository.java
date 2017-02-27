package com.projekat.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Rezervacija;


public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {
	
	public Collection<Rezervacija> findByGostIdAndVremeDolaskaGreaterThan(String gostId, String vremeDolaska);
	public Collection<Rezervacija> findByGostIdAndRestoranIdAndVremeDolaskaAndVremeOdlaska(String gostId, Integer restoranId, String vremeDolaska, String vremeOdlaska);
	
	@Transactional
	public Integer deleteByGostIdAndRestoranIdAndVremeDolaskaAndVremeOdlaska(String gostId, Integer restoranId, String vremeDolaska, String vremeOdlaska);

}
