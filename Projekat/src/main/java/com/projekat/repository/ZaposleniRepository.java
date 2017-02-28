package com.projekat.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projekat.model.Zaposleni;

public interface ZaposleniRepository extends JpaRepository<Zaposleni, String> {

	public Collection<Zaposleni> findByTipOrTipOrTip(String tip,String tip1,String tip2);

	public Collection<Zaposleni> findByRestoranAndTipNotIn(Integer restoran, Collection<String> tipovi);

	
	@Transactional
	@Modifying
	@Query("update Zaposleni z set z.ime = ?1, z.prezime = ?2, z.konfBroj = ?3, z.velicinaObuce= ?4 where z.email = ?5")
	public Integer setImePrezimeKonfBrojVelicinaObuceForZaposleni(String ime, String prezime, String konfBroj,
			Integer velicinaObuce, String email);
	
	
	@Transactional
	@Modifying
	@Query("update Zaposleni z set z.prviPut = ?1, z.lozinka = ?2 where z.email = ?3")
	public Integer setPrviPutForZaposleni(Boolean prviPut, String lozinka, String email);
	
}
