package com.atrium.logica;

import java.util.Arrays;
import java.util.Collections;

/**
 * Proceso de uso con tablas, tanto desordenada com ordenada por el contenido.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Logica {

	// ******* PROCESOS EN TABLA DESORDENADA
	/**
	 * Obtencion del valor mayor de la tabla desordenada.
	 * 
	 * @param tabla
	 *            Tabla con los elementos.
	 * @return Valor mayor de la tabla.
	 */
	public int calcular_MayorD(int tabla[]) {
		int elementos = tabla.length;
		int mayor = tabla[0];
		for (int i = 1; i < elementos; i++) {
			if (tabla[i] > mayor) {
				mayor = tabla[i];
			}
		}
		return mayor;
	}

	/**
	 * Obtencion del valor menor de la tabla desordenada.
	 * 
	 * @param tabla
	 *            Tabla con los elementos.
	 * @return Valor menor de la tabla.
	 */
	public int calcular_MenorD(int tabla[]) {
		int elementos = tabla.length;
		int menor = tabla[0];
		for (int i = 1; i < elementos; i++) {
			if (tabla[i] < menor) {
				menor = tabla[i];
			}
		}
		return menor;
	}

	/**
	 * Calculo de media del contenido de la tabla desordenada.
	 * 
	 * @param tabla
	 *            Tabla con los elementos.
	 * @return Valor medio.
	 */
	public int calcular_MediaD(int tabla[]) {
		int elementos = tabla.length;
		int total = 0;
		for (int i = 0; i < elementos; i++) {
			total = total + tabla[i];
		}
		return total / elementos;
	}

	// ******* FIN PROCESOS EN TABLA DESORDENADA

	// ******* PROCESOS EN TABLA ORDENADA
	/**
	 * Obtencion del valor mayor de la tabla ordenada.
	 * 
	 * @param tabla
	 *            Tabla con los elementos.
	 * @return Valor mayor de la tabla.
	 */
	public int calcular_Mayor(int tabla[]) {
		return ordenar_Tabla(tabla)[tabla.length - 1];
	}

	/**
	 * Obtencion del valor menor de la tabla ordenada.
	 * 
	 * @param tabla
	 *            Tabla con los elementos.
	 * @return Valor menor de la tabla.
	 */
	public int calcular_Menor(int tabla[]) {
		return ordenar_Tabla(tabla)[0];
	}

	/**
	 * Calculo de media del contenido de la tabla ordenada.
	 * 
	 * @param tabla
	 *            Tabla con los elementos.
	 * @return Valor medio.
	 */
	public int calcular_Media(int tabla[]) {
		int elementos = tabla.length;
		int total = 0;
		for (int i = 0; i < elementos; i++) {
			total = total + tabla[i];
		}
		return total / elementos;
	}

	/**
	 * Proceso de ordenacion de tabla mediante Arrays
	 * 
	 * @param tabla
	 *            Tabla con los elementos a ordenar.
	 * @return Tabla con elementos ordenados.
	 */
	private int[] ordenar_Tabla(int tabla[]) {
		Arrays.sort(tabla);
		return tabla;
	}
	// ******* PROCESOS EN TABLA ORDENADA
}
