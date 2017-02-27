package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Restoran;
import com.projekat.model.Sto;


public interface StoRepository extends JpaRepository<Sto, Integer> {
	
	public Collection<Sto> findByIdRestorana(Integer idRestorana);
	public Restoran findById(Integer id);
	public Sto findByIdRestoranaAndBroj(Integer idRestorana, String broj);
}
