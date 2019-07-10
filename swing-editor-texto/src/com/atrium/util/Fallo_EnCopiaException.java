package com.atrium.util;

/**
 * Excepcion que nos informara del fallo en la copia de seguridad de los
 * ficheros.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 30-6-2015.
 *
 */
public class Fallo_EnCopiaException extends Exception implements
		ITipos_FalloCopias {

	private int causa_fallo;

	public Fallo_EnCopiaException(int causa_fallo) {
		this.causa_fallo = causa_fallo;
	}

	// ACCESORES
	public int getCausa_fallo() {
		return causa_fallo;
	}

	public void setCausa_fallo(int causa_fallo) {
		this.causa_fallo = causa_fallo;
	}

}
