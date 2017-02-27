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
@Table(name = "jelovniikKategorija")
public class JelovnikKategorija implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "idJelovnika")
    private Integer idJelovnika;
	
	@Column(name = "imeKategorije")
    private String imeKategorije;
	
	@OneToMany(mappedBy = "jKategorija", fetch = FetchType.EAGER)
	private Collection<Jelo> jela;
	
	public JelovnikKategorija() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdJelovnika() {
		return idJelovnika;
	}

	public void setIdJelovnika(Integer idJelovnika) {
		this.idJelovnika = idJelovnika;
	}

	public String getImeKategorije() {
		return imeKategorije;
	}

	public void setImeKategorije(String imeKategorije) {
		this.imeKategorije = imeKategorije;
	}

	public Collection<Jelo> getJela() {
		return jela;
	}

	public void setJela(Collection<Jelo> jela) {
		this.jela = jela;
	}
	
	

}
