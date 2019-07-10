package com.atrium.dominio;

import org.springframework.web.multipart.MultipartFile;

/**
 * Objeto de dominio para la informacion de la gestion de ficheros.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1.
 * @since 9-2-2018.
 * 
 */
public class Datos_Subida {
	// PROPIEDAD PARA RECIBIR EL FICHERO SUBIDO
	private MultipartFile fichero_subido;
	private String fichero;

	// ACCESORES PARA SPRING
	public MultipartFile getFichero_subido() {
		return fichero_subido;
	}

	public void setFichero_subido(MultipartFile fichero_subido) {
		this.fichero_subido = fichero_subido;
	}

	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

}
