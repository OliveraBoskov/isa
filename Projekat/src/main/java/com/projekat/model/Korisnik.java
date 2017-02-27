package com.projekat.model;



import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "korisnik")
public class Korisnik implements Serializable {

	@Id
	@Column(name = "email")
    private String email;

    

    @Column(name = "prezime")
    private String prezime;
    
    @Column(name = "ime")
    private String ime;

    
    @Column(name = "lozinka")
    private String lozinka;

    @Column(name = "tip")
    private String tip;


    public Korisnik() {
		// TODO Auto-generated constructor stub
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
    
    
}
