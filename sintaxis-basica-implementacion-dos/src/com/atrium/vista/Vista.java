package com.atrium.vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Procesos de interface grafica del programa.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 27-9-2016.
 * 
 */
public class Vista {

	/**
	 * Visualizacion por pantalla del texto requerido.
	 * 
	 * @param texto
	 *            String a mostrar por consola.
	 */
	public void mostrar_Texto(String texto) {
		System.out.println(texto);
	}

	/**
	 * Proceso de generacion de menu.
	 */
	public void mostrar_Menu() {
		mostrar_Texto("MENU DE LA APLICACION.");
		mostrar_Texto("1 SUMAR.");
		mostrar_Texto("2 RESTAR.");
		mostrar_Texto("3 MULTIPLICAR.");
		mostrar_Texto("4 DIVIDIR.");
		mostrar_Texto("5 INTRODUCIR VALORES NUMERICOS");
		mostrar_Texto("6 SALIR.");
	}

	/**
	 * Proceso de captura de teclado.
	 * 
	 * @return String Conteniendo lo tecleado por el usuario.
	 */
	public String teclear_Texto() {
		// DECLARACION DE FLUJO DE TECLADO
		InputStreamReader flujo = new InputStreamReader(System.in);
		// ENVOLTORIO DE FLUJO
		BufferedReader lector = new BufferedReader(flujo);
		// PROCESO DE LECTURA
		String texto = null;
		try {
			texto = lector.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// RETORNO DEL VALOR TECLEADO
		return texto;
	}

	/**
	 * Proceso de conversion de texto a numero.
	 * 
	 * @param texto
	 *            Texto a convertir.
	 * @return Valor numerico convertido.
	 */
	public int convertir_Texto(String texto) {
		int numero = 0;
		try {
			// CONVERSION DEL TEXTO A ENTERO
			numero = Integer.parseInt(texto);
		} catch (Exception e) {
			// ERROR EN LA CONVERSION
			// SIN IMPLEMENTAR
		}
		// RETORNO DEL VALOR
		return numero;
	}

}
