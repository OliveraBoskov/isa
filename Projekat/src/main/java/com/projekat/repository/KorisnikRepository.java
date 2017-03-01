package com.projekat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projekat.model.Korisnik;


public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
	
	@Transactional
	@Modifying
	@Query("update Korisnik k set k.ime = ?1, k.prezime = ?2 where k.email = ?3")
	public Integer setImePrezimeForKorisnik(String ime, String prezime, String email);
	
}
