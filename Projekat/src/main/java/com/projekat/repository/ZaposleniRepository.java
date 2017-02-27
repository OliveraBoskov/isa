package com.projekat.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Zaposleni;

public interface ZaposleniRepository extends JpaRepository<Zaposleni, String> {

	public Collection<Zaposleni> findByTipOrTipOrTip(String tip,String tip1,String tip2);

	public Collection<Zaposleni> findByRestoranAndTipNotIn(Integer restoran, Collection<String> tipovi);

}
