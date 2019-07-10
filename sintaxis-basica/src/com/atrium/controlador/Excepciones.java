package com.atrium.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejemplo de tratamiento de excepciones en una clase.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 */
public class Excepciones {
	// PROPIEDADES DE CLASE QAUE LANZEN EXCEPCIONES
	private InputStreamReader flujo = new InputStreamReader(System.in);
	private BufferedReader buffer = new BufferedReader(flujo);

	/**
	 * Ejemplo de tratamiento dentro del metodo.
	 */
	public void prueba_Excepciones() {

		try {
			buffer.readLine();
			System.out.println("");
		} catch (IOException e) {
			e.getStackTrace();
		} catch (Exception e) {

		}

		System.out.println("");
	}

	/**
	 * Ejemplo de delegacion de tratamiento a nivel superior.
	 * 
	 * @throws IOException
	 *             Tipo de excepcion tratada.
	 */
	public void prueba_Delegacion() throws IOException {
		// METODO QUE LANZA LA EXCEPCION
		buffer.readLine();

	}

	/**
	 * Ejemplo de delegacion de tratamiento a nivel superior de una excepion
	 * propia.
	 * 
	 * @throws ExcepcionPropia_Exception
	 *             Tipo de excepcion propia tratada.
	 */
	public void prueba_ExcepcionPropia() throws ExcepcionPropia_Exception {
		int numero = 5;
		// LANZAMIENTO DE EXCEPCION PROPIA
		if (numero != 5) {
			throw new ExcepcionPropia_Exception();
		}
	}

}
