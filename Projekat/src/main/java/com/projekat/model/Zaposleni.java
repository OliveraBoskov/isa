package com.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zaposlen")
public class Zaposleni implements Serializable{
	

	@Id
	@Column(name = "email")
    private String email;
	
	@Column(name = "ime")
    private String ime;
	
	@Column(name = "prezime")
    private String prezime;
	
	@Column(name="restoran")
	private Integer restoran;
	
	@Column(name="loznika")
	private String lozinka;
	
	@Column(name="tip")
	private String tip;
	
	@Column(name="prviPut")
	private boolean prviPut;
	
	@Column(name="datumRodjenja")
    private String datumRodjenja;
    
    @Column(name = "konfBroj")
    private String konfBroj;
    
    @Column(name="velicinaObuce")
    private Integer velicinaObuce;
	
	
	

	public Zaposleni() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Integer getRestoran() {
		return restoran;
	}

	public void setRestoran(Integer restoran) {
		this.restoran = restoran;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public boolean isPrviPut() {
		return prviPut;
	}

	public void setPrviPut(boolean prviPut) {
		this.prviPut = prviPut;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getKonfBroj() {
		return konfBroj;
	}

	public void setKonfBroj(String konfBroj) {
		this.konfBroj = konfBroj;
	}

	public Integer getVelicinaObuce() {
		return velicinaObuce;
	}

	public void setVelicinaObuce(Integer velicinaObuce) {
		this.velicinaObuce = velicinaObuce;
	}
	
	

}
