package com.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Jelovnik;

public interface JelovnikRepository extends JpaRepository<Jelovnik, Integer>{
	
	public Jelovnik findByIdRestorana(Integer idRestorana);

}
