package com.atrium.excepciones;

/**
 * Padre comun de las excepciones propias del servicio.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 14-2-2018.
 * 
 */
public class ServicioWeb_Exception extends Exception {
	// PROPIEDADES INFORMATIVAS DEL ERROR DE VALIDACION
	private int codigo_error;
	private String mensaje_error;

	// ACCESORES DE LA INFORMCION
	public int getCodigo_error() {
		return codigo_error;
	}

	public String getMensaje_error() {
		return mensaje_error;
	}

	public void setCodigo_error(int codigo_error) {
		this.codigo_error = codigo_error;
	}

	public void setMensaje_error(String mensaje_error) {
		this.mensaje_error = mensaje_error;
	}
}
