package com.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projekat.model.Korisnik;


public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
}
