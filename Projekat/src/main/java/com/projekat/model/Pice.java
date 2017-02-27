package com.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "pice")
public class Pice implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "idKategorije")
    private Integer idKategorije;
	
	@Column(name = "imePica")
    private String imePica;
	
	@Column(name = "opisPica")
    private String opisPica;
	
	@Column(name = "cena")
    private Integer cena;
	
	@Column(name = "ocena")
    private Integer ocena;
	
	@ManyToOne
	private KartaPicaKategorija pKategorija;
	
	
	public Pice() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdKategorije() {
		return idKategorije;
	}


	public void setIdKategorije(Integer idKategorije) {
		this.idKategorije = idKategorije;
	}


	public String getImePica() {
		return imePica;
	}


	public void setImePica(String imePica) {
		this.imePica = imePica;
	}


	public String getOpisPica() {
		return opisPica;
	}


	public void setOpisPica(String opisPica) {
		this.opisPica = opisPica;
	}


	public Integer getCena() {
		return cena;
	}


	public void setCena(Integer cena) {
		this.cena = cena;
	}


	public Integer getOcena() {
		return ocena;
	}


	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}


	public KartaPicaKategorija getpKategorija() {
		return pKategorija;
	}

	@JsonIgnore
	public void setpKategorija(KartaPicaKategorija pKategorija) {
		this.pKategorija = pKategorija;
	}
	
	

}
