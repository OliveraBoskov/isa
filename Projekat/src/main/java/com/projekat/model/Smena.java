package com.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="smena")
public class Smena implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name="restoranId")
	private Integer restoranId;
	
	@ManyToOne
	private Zaposleni zaposleni;
	
	@Column(name="boja")
	private String boja;
	
	@Column(name="reon")
	private String reon;
	
	@Column(name="pocinjeU")
	private String pocinjeU;
	
	@Column(name="zavrsavaU")
	private String zavrsavaU;
	
	public Smena() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRestoranId() {
		return restoranId;
	}

	public void setRestoranId(Integer restoranId) {
		this.restoranId = restoranId;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public String getReon() {
		return reon;
	}

	public void setReon(String reon) {
		this.reon = reon;
	}

	public String getPocinjeU() {
		return pocinjeU;
	}

	public void setPocinjeU(String pocinjeU) {
		this.pocinjeU = pocinjeU;
	}

	public String getZavrsavaU() {
		return zavrsavaU;
	}

	public void setZavrsavaU(String zavrsavaU) {
		this.zavrsavaU = zavrsavaU;
	}
	
	


}
