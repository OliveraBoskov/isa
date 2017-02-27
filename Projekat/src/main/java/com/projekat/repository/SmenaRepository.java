package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Smena;


public interface SmenaRepository extends JpaRepository<Smena, Integer> {
	public Collection<Smena> findByRestoranId(Integer restoranId);
}
