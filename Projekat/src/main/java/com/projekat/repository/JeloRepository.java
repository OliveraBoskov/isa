package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Jelo;

public interface JeloRepository extends JpaRepository<Jelo, Integer> {
	
	public Collection<Jelo> findByIdKategorije(Integer idKategorije);

}
