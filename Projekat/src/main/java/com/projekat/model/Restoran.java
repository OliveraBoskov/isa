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
@Table(name = "restoran")
public class Restoran implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "ime")
    private String ime;
	
	@Column(name = "tip")
    private String tip;
	
	@OneToMany(mappedBy = "restoran" , fetch = FetchType.EAGER)
	private Collection<Sto> stolovi;
	
	public Restoran() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Collection<Sto> getStolovi() {
		return stolovi;
	}

	public void setStolovi(Collection<Sto> stolovi) {
		this.stolovi = stolovi;
	}
	
	
	
}
