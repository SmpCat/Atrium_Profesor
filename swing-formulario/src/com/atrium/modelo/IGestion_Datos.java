package com.atrium.modelo;

/**
 * Interface de ocultacion para la fachada de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-3-2016.
 * 
 */
public interface IGestion_Datos {

	// DEFINICION DE LA FIRMA DE LOS METODOS A MOSTRAR
	public Datos_DTO leer_Datos();

	public abstract boolean escribir_Datos(Datos_DTO datos);

}