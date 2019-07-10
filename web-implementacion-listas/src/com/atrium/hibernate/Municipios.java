package com.atrium.hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Municipios entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MUNICIPIOS")
public class Municipios implements java.io.Serializable {

	// Fields

	private MunicipiosId id;
	private String municipio;

	// Constructors

	/** default constructor */
	public Municipios() {
	}

	/** full constructor */
	public Municipios(MunicipiosId id, String municipio) {
		this.id = id;
		this.municipio = municipio;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoMunicipio", column = @Column(name = "CODIGO_MUNICIPIO", nullable = false, precision = 11, scale = 0)),
			@AttributeOverride(name = "provincia", column = @Column(name = "PROVINCIA", nullable = false, precision = 2, scale = 0)) })
	public MunicipiosId getId() {
		return this.id;
	}

	public void setId(MunicipiosId id) {
		this.id = id;
	}

	@Column(name = "MUNICIPIO", nullable = false)
	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

}