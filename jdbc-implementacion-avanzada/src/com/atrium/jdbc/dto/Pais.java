package com.atrium.jdbc.dto;

/**
 * DTO para la tabla pais de oracle.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0
 */
public class Pais {

	// PROPIEDADES CORRESPONDIENTES A LOS CAMPOS DE LA TABLA
	private Long codigo_pais;
	private Integer pais_isonum;
	private String pais_iso2;
	private String pais_iso3;
	private String pais_nombre;

	// ACCESORES DE LAS PROPIEDADES DE CLASE.
	public Long getCodigo_pais() {
		return codigo_pais;
	}

	public void setCodigo_pais(Long codigo_pais) {
		this.codigo_pais = codigo_pais;
	}

	public Integer getPais_isonum() {
		return pais_isonum;
	}

	public void setPais_isonum(Integer pais_isonum) {
		this.pais_isonum = pais_isonum;
	}

	public String getPais_iso2() {
		return pais_iso2;
	}

	public void setPais_iso2(String pais_iso2) {
		this.pais_iso2 = pais_iso2;
	}

	public String getPais_iso3() {
		return pais_iso3;
	}

	public void setPais_iso3(String pais_iso3) {
		this.pais_iso3 = pais_iso3;
	}

	public String getPais_nombre() {
		return pais_nombre;
	}

	public void setPais_nombre(String pais_nombre) {
		this.pais_nombre = pais_nombre;
	}

}
