package com.atrium.ciclovida;

/**
 * Ejemplo de uso ciclo de vida en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Factoria {

	static Factoria obj;

	// SPRING PUEDE ACCEDER AL CONSTRUCTOR AUNQUE SEA PRIVADO
	private Factoria() {
	}

	public static Factoria crearBean() {
		if (obj == null) {
			obj = new Factoria();
		}
		return obj;
	}

	public void saludar() {
		System.out.println("HOLA ..................");
	}

}
