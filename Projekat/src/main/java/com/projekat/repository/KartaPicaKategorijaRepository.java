package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.KartaPicaKategorija;

public interface KartaPicaKategorijaRepository extends JpaRepository<KartaPicaKategorija, Integer> {
	
	public Collection<KartaPicaKategorija> findByIdKartePica(Integer idKartePica);

}
