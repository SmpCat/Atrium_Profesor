package com.atrium.modelo;

/**
 * DTO -- Persistencia de Municipios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 * 
 */
public class Municipio {
	// PROPIEDADES DE CLASE
	private Long codigoMunicipio;
	private Byte provincia;
	private String municipio;

	// ACCESORES DE LAS PROPIEDADES
	public Long getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(Long codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
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

	// SOBREESCRITURA DE METODOS PARA LA GESTION DE PRUEBAS.
	@Override
	public String toString() {
		return "Municipio [codigoMunicipio=" + codigoMunicipio + ", provincia=" + provincia + ", municipio=" + municipio
				+ "]";
	}
}
