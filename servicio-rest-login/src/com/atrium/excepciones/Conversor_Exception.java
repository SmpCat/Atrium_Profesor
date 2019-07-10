package com.atrium.excepciones;

/**
 * Excepcion personalizada para el tratamiento de la conversion de tipos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1.
 * @since 14-2-2018.
 * 
 */
public class Conversor_Exception extends ServicioWeb_Exception {
	/**
	 * Constructor para recibir la informacion del error de conversion
	 * encontrado
	 * 
	 * @param mensaje
	 *            Texto explicativo del error
	 * @param codigo
	 *            Codigo numerico del error.
	 */
	public Conversor_Exception(String mensaje, int codigo) {
		setMensaje_error(mensaje);
		setCodigo_error(codigo);
	}
}
