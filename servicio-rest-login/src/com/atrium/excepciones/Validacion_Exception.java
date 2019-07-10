package com.atrium.excepciones;

/**
 * Excepcion personalizada para el tratamiento de la validacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1.
 * @since 14-2-2018.
 * 
 */
public class Validacion_Exception extends ServicioWeb_Exception {
	/**
	 * Constructor para recibir la informacion del error de validacion
	 * encontrado
	 * 
	 * @param mensaje
	 *            Texto explicativo del error
	 * @param codigo
	 *            Codigo numerico del error.
	 */
	public Validacion_Exception(String mensaje, int codigo) {
		setMensaje_error(mensaje);
		setCodigo_error(codigo);
	}
}
