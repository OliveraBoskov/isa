package com.projekat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.Ponuda;
import com.projekat.repository.PonudaRepository;

@Service
public class PonudaService {
	
	@Autowired
	private PonudaRepository ponudaRepository;
	
	
	public Ponuda add(Ponuda ponuda) {
		return ponudaRepository.save(ponuda);
	}
	
	public Integer update(Integer cena, String datumIsporuke, Boolean garancija, Integer id) {
		return ponudaRepository.setCenaDatumIsporukeGarancijaForPonuda(cena, datumIsporuke, garancija, id);
	}

}
