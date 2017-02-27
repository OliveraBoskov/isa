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
@Table(name = "sto")
public class Sto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "broj")
    private String broj;
	
	@Column(name = "levo")
    private Integer levo;
	
	@Column(name = "gore")
    private Integer gore;
	
	@Column(name = "idRestorana")
    private Integer idRestorana;
	
	@Column(name = "reon")
    private String reon;
	
	@ManyToOne 
	private Restoran restoran;

	
	public Sto() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBroj() {
		return broj;
	}


	public void setBroj(String broj) {
		this.broj = broj;
	}


	public Integer getLevo() {
		return levo;
	}


	public void setLevo(Integer levo) {
		this.levo = levo;
	}


	public Integer getGore() {
		return gore;
	}


	public void setGore(Integer gore) {
		this.gore = gore;
	}


	public Integer getIdRestorana() {
		return idRestorana;
	}


	public void setIdRestorana(Integer idRestorana) {
		this.idRestorana = idRestorana;
	}


	public String getReon() {
		return reon;
	}


	public void setReon(String reon) {
		this.reon = reon;
	}


	public Restoran getRestoran() {
		return restoran;
	}

	@JsonIgnore
	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}
	
	
}
