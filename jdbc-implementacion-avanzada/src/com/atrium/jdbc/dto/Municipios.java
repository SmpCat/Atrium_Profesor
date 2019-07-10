package com.atrium.jdbc.dto;

/**
 * DTO para la tabla MUNICIPIOS de oracle.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0
 * 
 */
public class Municipios {
	// PROPIEDADES CORRESPONDIENTES A LOS CAMPOS DE LA TABLA
	private Long codigo_municipio;
	private Byte provincia;
	private String municipio;

	// ACCESORES DE LAS PROPIEDADES DE CLASE.
	public Long getCodigo_municipio() {
		return codigo_municipio;
	}

	public void setCodigo_municipio(Long codigo_municipio) {
		this.codigo_municipio = codigo_municipio;
	}

	public Byte getProvincia() {
		return provincia;
	}

	public void setProvincia(Byte provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
}
