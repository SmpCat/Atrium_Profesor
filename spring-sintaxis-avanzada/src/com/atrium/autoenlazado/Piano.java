package com.atrium.autoenlazado;

/**
 * Ejemplo de uso de AUTOWIRED autoenlazado en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */ 
public class Piano implements Instrumento {

	public void tocar() {
		System.out.println("Tocando el piano");
	}

}
