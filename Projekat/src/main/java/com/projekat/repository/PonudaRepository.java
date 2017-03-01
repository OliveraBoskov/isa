package com.projekat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projekat.model.Ponuda;

public interface PonudaRepository extends JpaRepository<Ponuda, Integer>{


	@Transactional
	@Modifying
	@Query("update Ponuda p set p.cena = ?1, p.datumIsporuke= ?2, p.garancija = ?3 where p.id = ?4")
	public Integer setCenaDatumIsporukeGarancijaForPonuda(Integer cena, String datumIsporuke, Boolean garancija, Integer id);

	
}
