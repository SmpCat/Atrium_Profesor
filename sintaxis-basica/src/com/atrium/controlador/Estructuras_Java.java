package com.atrium.controlador;

/**
 * Ejemplo de sintaxis de estructuras en java.
 * 
 * @author Juan Antonio Solves Garcia.
 * 
 * @version 1.0.
 * @since 23-9-2016.
 */

public class Estructuras_Java {
	// PROPIEDADES DE CLASE
	private int numero = 5;

	private String texto = "Hola mundo";

	/**
	 * Metodo donde se escriben las diferentes extructuras alternativas de java.
	 */
	public void prueba_Estructuras() {
		int otro_numero = 2;
		// ALTERNATIVA SIMPLE
		if (numero == 6) {
			// SI SE CUMPLE LA CONDICION
			System.out.println("se cumple la condicion");
		} else {
			// NO SE CUMPLE LA CONDICION
			System.out.println("no se cumple la condicion");
		}
		// > MAYOR
		// < MENOR
		// >= MAYOR O IGUAL
		// <= MENOR O IGUAL
		// != NO IGUAL

		if (texto == null) {

		}

		if (texto.equals("texto a comparar")) {

		} else if (numero > 10) {

		}

		if (texto.equals("texto a comparar") && numero == 5) {

		}

		// ALTERNATIVA COMPUESTAS
		switch (numero) {
		case 1:
			// ORDENES
			break;
		case 2:
			// ORDENES
			break;
		case 3:
			// ORDENES
			break;
		default:
			// ORDENES
			break;
		}

	}

	/**
	 * Metodo donde se escriben las diferentes extructuras repetitivas de java.
	 */
	public void prueba_Repetitivas() {
		// REPETITIVAS
		for (int i = 0; i < 10; i++) {
			// ORDENES
			numero = 19;
		}

		while (numero < 7) {
			// ORDENES 0

		}

		do {
			// ORDENES 1
		} while (texto == null);

		for (;;) {
			// BUCLE INFINITO
		}
	}
}
