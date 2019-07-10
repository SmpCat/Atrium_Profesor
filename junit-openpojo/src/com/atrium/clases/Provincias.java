package com.atrium.clases;

/**
 * DTO para la tabla provincias de oracle.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0
 * @since 11-10-2016.
 */
public class Provincias {
	// PROPIEDADES CORRESPONDIENTES A LOS CAMPOS DE LA TABLA
	private String provincia;
	private Byte codigo_provincia;

	// ACCESORES DE LAS PROPIEDADES DE CLASE.
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Byte getCodigo_provincia() {
		return codigo_provincia;
	}

	public void setCodigo_provincia(Byte codigo_provincia) {
		this.codigo_provincia = codigo_provincia;
	}

}
