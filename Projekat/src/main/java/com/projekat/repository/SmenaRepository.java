package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Smena;
import com.projekat.model.Zaposleni;


public interface SmenaRepository extends JpaRepository<Smena, Integer> {
	public Collection<Smena> findByRestoranId(Integer restoranId);

	public Collection<Smena> findByZaposleniAndRestoranId(Zaposleni zaposleni, Integer restoranId);

	public Smena findByZaposleniAndRestoranIdAndPocinjeULessThanAndZavrsavaUGreaterThan(Zaposleni zaposleni,
			Integer restoranId, String pocinjeU, String zavrsavaU);
}
