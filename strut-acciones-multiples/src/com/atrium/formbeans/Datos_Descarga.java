package com.atrium.formbeans;

import org.apache.struts.action.ActionForm;

/**
 * Objeto de dominio de los procesos de descarga ficheros y borrado ficheros.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 6-11-2017.
 * 
 */
public class Datos_Descarga extends ActionForm{

	private String fichero;

	// ACCESORES PARA STRUT
	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}
	
}
