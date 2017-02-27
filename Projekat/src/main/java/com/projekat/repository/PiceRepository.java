package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Pice;

public interface PiceRepository extends JpaRepository<Pice, Integer> {
	
	public Collection<Pice> findByIdKategorije (Integer id);

}
