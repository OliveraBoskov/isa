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
@Table(name = "namirnice")
public class Namirnica implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "imeNamirnice")
    private String imeNamirnice;
	
	@ManyToOne
	private NamirniceKategorija nKategorija;
	
	public Namirnica() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImeNamirnice() {
		return imeNamirnice;
	}

	public void setImeNamirnice(String imeNamirnice) {
		this.imeNamirnice = imeNamirnice;
	}

	public NamirniceKategorija getnKategorija() {
		return nKategorija;
	}
	@JsonIgnore
	public void setnKategorija(NamirniceKategorija nKategorija) {
		this.nKategorija = nKategorija;
	}
	
	

}
