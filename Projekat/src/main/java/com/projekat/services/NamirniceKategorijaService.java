package com.projekat.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projekat.model.NamirniceKategorija;
import com.projekat.repository.NamirnicaKategorijaRepository;


@Service
public class NamirniceKategorijaService {
	
	@Autowired
	private NamirnicaKategorijaRepository namirnicaKategorijaRepository;

	public NamirniceKategorija add(NamirniceKategorija namirniceKategorija) {
		
		return namirnicaKategorijaRepository.save(namirniceKategorija);
	}

	public Collection<NamirniceKategorija> allCategories() {
		return namirnicaKategorijaRepository.findAll();
	}
	
	public NamirniceKategorija getById(Integer id) {
		return namirnicaKategorijaRepository.findOne(id);
	}
	
	
}
