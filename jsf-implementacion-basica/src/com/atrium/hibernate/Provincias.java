package com.atrium.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Provincias entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PROVINCIAS")
public class Provincias implements java.io.Serializable {

	// Fields

	private Byte codigoProvincia;
	private String provincia;

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
	@Id
	@Column(name = "CODIGO_PROVINCIA", unique = true, nullable = false, precision = 2, scale = 0)
	public Byte getCodigoProvincia() {
		return this.codigoProvincia;
	}

	public void setCodigoProvincia(Byte codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	@Column(name = "PROVINCIA", nullable = false)
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}