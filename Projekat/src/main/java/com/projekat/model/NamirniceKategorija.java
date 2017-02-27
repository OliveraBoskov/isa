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
@Table(name = "namirniceKategorija")
public class NamirniceKategorija implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "imeKategorije")
    private String imeKategorije;
	
	@OneToMany(mappedBy = "nKategorija", fetch = FetchType.EAGER)
	private Collection<Namirnica> namirnice;
	
	public NamirniceKategorija() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImeKategorije() {
		return imeKategorije;
	}

	public void setImeKategorije(String imeKategorije) {
		this.imeKategorije = imeKategorije;
	}

	public Collection<Namirnica> getNamirnice() {
		return namirnice;
	}

	public void setNamirnice(Collection<Namirnica> namirnice) {
		this.namirnice = namirnice;
	}
	
	

}
