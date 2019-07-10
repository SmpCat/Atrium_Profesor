package com.atrium.vista;

/**
 * Procesos de interface grafica del programa.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 27-9-2016.
 * 
 */
public class Vista {

	/**
	 * Ejemplo de visualizacion por pantalla de un texto fijo.
	 */
	public void mostrar_Texto() {
		System.out.println("HOLA DE MUNDO JAVA");
	}

	/**
	 * Ejemplo de visualizacion por pantalla del texto requerido. Sobrecarga el
	 * metodo anterior.
	 * 
	 * @param texto
	 *            String a mostrar por consola.
	 */
	public void mostrar_Texto(String texto) {
		System.out.println(texto);
	}
}
