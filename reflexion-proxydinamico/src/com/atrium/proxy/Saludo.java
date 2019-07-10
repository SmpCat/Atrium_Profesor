package com.atrium.proxy;

/**
 * Clase de ejemplo para la ser gestionada por elproxy.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-10-2016.
 *
 */
public class Saludo implements ISaludo {

	/**
	 * Primer metodo de prueba.
	 */
	public String saludo() {
		System.out.println("hola");
		return "Hola";
	}

	/**
	 * Segundo metodo de prueba
	 */
	public String otro_Saludo(String texto) {
		System.out.println("Holita " + texto);
		return "Holita " + texto;
	}
}
