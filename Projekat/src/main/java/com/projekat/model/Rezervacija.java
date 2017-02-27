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
@Table(name = "rezervacija")
public class Rezervacija implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "gostId")
    private String gostId;
	
	@Column(name = "restoranId")
    private Integer restoranId;
	
	@ManyToOne
    private Sto sto;
	
	@Column(name = "vremeDolaska")
    private String vremeDolaska;
	
	@Column(name = "vremeOdlaska")
    private String vremeOdlaska;
	
	public Rezervacija() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGostId() {
		return gostId;
	}

	public void setGostId(String gostId) {
		this.gostId = gostId;
	}

	public Integer getRestoranId() {
		return restoranId;
	}

	public void setRestoranId(Integer restoranId) {
		this.restoranId = restoranId;
	}

	public Sto getSto() {
		return sto;
	}

	public void setSto(Sto sto) {
		this.sto = sto;
	}

	public String getVremeDolaska() {
		return vremeDolaska;
	}

	public void setVremeDolaska(String vremeDolaska) {
		this.vremeDolaska = vremeDolaska;
	}

	public String getVremeOdlaska() {
		return vremeOdlaska;
	}

	public void setVremeOdlaska(String vremeOdlaska) {
		this.vremeOdlaska = vremeOdlaska;
	}
	
	

}
