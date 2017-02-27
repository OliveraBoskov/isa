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
@Table(name = "jelo")
public class Jelo implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "idKategorije")
    private Integer idKategorije;
	
	@Column(name = "imeJela")
    private String imeJela;
	
	@Column(name = "opisJela")
    private String opisJela;
	
	@Column(name = "cena")
    private Integer cena;
	
	@Column(name = "ocena")
    private Integer ocena;
	
	@ManyToOne
	private JelovnikKategorija jKategorija;
	
	public Jelo() {
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

	public String getImeJela() {
		return imeJela;
	}

	public void setImeJela(String imeJela) {
		this.imeJela = imeJela;
	}

	public String getOpisJela() {
		return opisJela;
	}

	public void setOpisJela(String opisJela) {
		this.opisJela = opisJela;
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

	public JelovnikKategorija getjKategorija() {
		return jKategorija;
	}
	
	@JsonIgnore
	public void setjKategorija(JelovnikKategorija jKategorija) {
		this.jKategorija = jKategorija;
	}
	
	
	
}
