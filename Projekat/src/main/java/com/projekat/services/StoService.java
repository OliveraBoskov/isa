package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Sto;
import com.projekat.repository.StoRepository;


@Service
public class StoService {

	@Autowired
	private StoRepository stoRepository;
	
	public Collection<Sto> getAll(){
		return stoRepository.findAll();
	}

	
	public Sto add(Sto sto){
		return stoRepository.save(sto);
	}
	
	public Sto getStoById(Integer stoId){
		return stoRepository.findOne(stoId);
	}
	
	public Collection<Sto> uzmiSveStoloveIzRestorana(Integer idRestorana){
		return stoRepository.findByIdRestorana(idRestorana);
	}


	public Sto getStoByIdRestoranaAndBroj(Integer idRestorana, String broj) {
		return stoRepository.findByIdRestoranaAndBroj(idRestorana, broj);
	}
}
