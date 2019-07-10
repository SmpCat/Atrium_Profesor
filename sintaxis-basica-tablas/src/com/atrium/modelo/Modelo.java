package com.atrium.modelo;

/**
 * DTO para el transporte de datos de la aplicacion. En este caso una tabla de
 * nuemros enteros. <br/>
 * Se añade un metodo para iniciar la tablaa cualquier numero de elementos
 * necesarios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Modelo {

	/**
	 * Tabla de valores numericos enteros, sin elementos creados.
	 */
	private int tabla[];

	/**
	 * Proceso de creacion de elementos de una tabla.
	 * 
	 * @param numero_elementos
	 *            Numero de elementos de la tabla.
	 */
	public void crear_Tabla(int numero_elementos) {
		tabla = new int[numero_elementos];
	}

	// ACCESORES PARA LA TABLA
	public int[] getTabla() {
		return tabla;
	}

	public void setTabla(int[] tabla) {
		this.tabla = tabla;
	}
}
