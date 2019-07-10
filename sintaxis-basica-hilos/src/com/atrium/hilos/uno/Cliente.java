package com.atrium.hilos.uno;

/**
 * Deficion de la clase cliente. Los objetos de esta clase van a ser procesados
 * por objetos de la clase cajera.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-2-2017.
 *
 */
public class Cliente {
	// PROPIEDADES DE LA CLASE
	private String nombre;
	private int[] carroCompra;
	
	// ******** CONSTRUCTORES
	public Cliente() {
	}
	public Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}

	// ACCESORES PARA LAS PROPIEDADES
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}

}
