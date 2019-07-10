package com.atrium.controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ejemplo muy basico de definicion del log4j2 con xml.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Inicio {
	// DECLARACION EN EL SISTEMA DE LOG DE LA CLASE INICIO.
	static Logger log = LogManager.getLogger(Inicio.class);

	public static void main(String arg[]) {
		// LANZAMIENTO DEL MENSAJE A NIVEL DE DEEBUG
		log.debug("Hola mundo");

		System.out.println("");
	}

}
