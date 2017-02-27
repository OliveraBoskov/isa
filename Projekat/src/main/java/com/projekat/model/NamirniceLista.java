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
@Table(name = "namirniceLista")
public class NamirniceLista implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	
	@Column(name = "listaIme")
    private String listaIme;
	
	@Column(name = "restoranId")
    private Integer restoranId;
	
	
	@Column(name = "pocinjeU")
    private String pocinjeU;
	
	@Column(name = "zavrsavaU")
    private String zavrsavaU;
	
	@OneToMany(mappedBy = "nl", fetch = FetchType.EAGER)
	private Collection<NamirniceListaItem> items;
	
	/*@OneToMany(mappedBy = "nl", fetch = FetchType.LAZY)
	private Collection<Ponuda> ponude;*/
	
	@Column(name = "aktivna")
    private Boolean aktivna;
	
	public NamirniceLista() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getListaIme() {
		return listaIme;
	}

	public void setListaIme(String listaIme) {
		this.listaIme = listaIme;
	}

	public Integer getRestoranId() {
		return restoranId;
	}

	public void setRestoranId(Integer restoranId) {
		this.restoranId = restoranId;
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


/*
	public Collection<Ponuda> getPonude() {
		return ponude;
	}

	public void setPonude(Collection<Ponuda> ponude) {
		this.ponude = ponude;
	}*/

	public Boolean getAktivna() {
		return aktivna;
	}

	public void setAktivna(Boolean aktivna) {
		this.aktivna = aktivna;
	}

	public Collection<NamirniceListaItem> getItems() {
		return items;
	}

	public void setItems(Collection<NamirniceListaItem> items) {
		this.items = items;
	}


	
	

}
