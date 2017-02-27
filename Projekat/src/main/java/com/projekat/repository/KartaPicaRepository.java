package com.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.KartaPica;

public interface KartaPicaRepository extends JpaRepository<KartaPica, Integer> {

	public KartaPica findByIdRestorana(Integer idRestorana);
}
