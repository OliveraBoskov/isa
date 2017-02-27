package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.JelovnikKategorija;


public interface JelovnikKategorijaRepository extends JpaRepository<JelovnikKategorija, Integer> {

	public Collection<JelovnikKategorija> findByIdJelovnika(Integer idJelovnika);
}
