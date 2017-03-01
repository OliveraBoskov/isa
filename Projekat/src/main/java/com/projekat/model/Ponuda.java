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
@Table(name = "ponuda")
public class Ponuda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "cena")
    private Integer cena;
	
	@Column(name = "datumIsporuke")
    private String datumIsporuke;
	
	@ManyToOne
    private Zaposleni ponudjac;
	
	@ManyToOne
	private NamirniceLista nl;
	
	@Column(name = "garancija")
    private Boolean garancija;
	
	@Column(name = "prihvaceno")
    private Boolean prihvaceno;
	
	
	public Ponuda() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCena() {
		return cena;
	}


	public void setCena(Integer cena) {
		this.cena = cena;
	}


	public String getDatumIsporuke() {
		return datumIsporuke;
	}


	public void setDatumIsporuke(String datumIsporuke) {
		this.datumIsporuke = datumIsporuke;
	}


	public Zaposleni getPonudjac() {
		return ponudjac;
	}


	public void setPonudjac(Zaposleni ponudjac) {
		this.ponudjac = ponudjac;
	}


	public NamirniceLista getNl() {
		return nl;
	}


	public void setNl(NamirniceLista nl) {
		this.nl = nl;
	}


	public Boolean getGarancija() {
		return garancija;
	}


	public void setGarancija(Boolean garancija) {
		this.garancija = garancija;
	}


	public Boolean getPrihvaceno() {
		return prihvaceno;
	}


	public void setPrihvaceno(Boolean prihvaceno) {
		this.prihvaceno = prihvaceno;
	}
	
	

}
