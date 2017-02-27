package com.projekat.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projekat.model.NamirniceLista;

public interface NamirnicaLIstRepository extends JpaRepository<NamirniceLista, Integer> {

	public Collection<NamirniceLista> findByRestoranIdAndPocinjeUGreaterThanAndZavrsavaULessThan(Integer restoranId, String pocinjeU, String zavrsavaU);
	public Collection<NamirniceLista> findByZavrsavaUGreaterThan(String pocinjeU);
	
	
	@Transactional
	@Modifying
	@Query("update NamirniceLista nl set nl.aktivna = ?1 where nl.id = ?2")
	public Integer setAktivnaForNamirniceList(Boolean aktivna, Integer id);
	
}
