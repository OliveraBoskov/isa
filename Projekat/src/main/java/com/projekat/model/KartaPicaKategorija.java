package com.projekat.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kartaPicaKategorija")
public class KartaPicaKategorija implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "idKartePica")
    private Integer idKartePica;
	
	@Column(name = "imeKategorije")
    private String imeKategorije;
	
	@OneToMany(mappedBy = "pKategorija", fetch = FetchType.EAGER)
	private Collection<Pice> pica;
	
	public KartaPicaKategorija() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdKartePica() {
		return idKartePica;
	}

	public void setIdKartePica(Integer idKartePica) {
		this.idKartePica = idKartePica;
	}

	public String getImeKategorije() {
		return imeKategorije;
	}

	public void setImeKategorije(String imeKategorije) {
		this.imeKategorije = imeKategorije;
	}

	public Collection<Pice> getPica() {
		return pica;
	}

	public void setPica(Collection<Pice> pica) {
		this.pica = pica;
	}


	
	

}
