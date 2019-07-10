package com.atrium.controlador;

/**
 * Ejemplo de definicion de excepcion propia.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 */
public class ExcepcionPropia_Exception extends Exception {
	// PROPIEDAD AÑADIDA A LA HERENCIA
	public String mensaje;

	// METODO PROPIO AÑADIDO A LA HERENCIA
	public String tratar_Error() {

		return null;
	}
}
