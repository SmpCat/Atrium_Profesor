package com.atrium.vista;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Clase que cubre el rol de vista en el programa atraves de la consola.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Vista {

	/**
	 * Proceso para sacar por consola cualquier string recibido.
	 * 
	 * @param texto
	 *            String a mostar en la consola.
	 */
	public void mostrar_Pantalla(String texto) {
		System.out.println(texto);
	}

	/**
	 * Proceso para la lectura de los valores tecleados por el usuario. Finaliza
	 * la introduccion del texto pulsando return.
	 * 
	 * @return Cadena de texto tecleada
	 */
	public String captura_Valor() {
		// FLUJO DE LECTURA DEL TECLADO
		InputStreamReader flujo = new InputStreamReader(System.in);
		BufferedReader lector = new BufferedReader(flujo);
		String texto = null;
		try {
			// PROCESO DE CAPTURA/LECTURA DE LAS PULSACIONES DEL TECLADO
			texto = lector.readLine();
		} catch (IOException e) {
		}
		return texto;
	}

	/**
	 * Proceso de conversion de String a valor numerico entero. En caso de error
	 * en la conversion se devuelve cero.
	 * 
	 * @param cadena
	 *            String a convertir en numero.
	 * @return Valor entero resultante de la conversion.
	 */
	public int cambio_Tipo(String cadena) {
		int salida = 0;
		try {
			// CONVERSION DE VALOR CON TRATAMIENTO DE ERROR
			salida = Integer.parseInt(cadena);
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR -- SIN IMPLEMENTAR
		}
		return salida;
	}

}
