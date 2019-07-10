package com.atrium.hibernate.ext;

import java.util.Set;

/**
 * Provincias entity. @author MyEclipse Persistence Tools
 */

public class Provincias implements java.io.Serializable {

	// Fields

	private Byte codigoProvincia;
	private String provincia;
	private Set<Municipios> municipios;

	// Constructors

	/** default constructor */
	public Provincias() {
	}

	/** full constructor */
	public Provincias(Byte codigoProvincia, String provincia) {
		this.codigoProvincia = codigoProvincia;
		this.provincia = provincia;
	}

	// Property accessors

	public Byte getCodigoProvincia() {
		return this.codigoProvincia;
	}

	public void setCodigoProvincia(Byte codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Set<Municipios> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(Set<Municipios> municipios) {
		this.municipios = municipios;
	}

}