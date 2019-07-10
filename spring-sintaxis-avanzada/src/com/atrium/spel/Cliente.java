package com.atrium.spel;

/**
 * Ejemplo de uso de expresiones dinamicas Spel en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Cliente {
	// PROPIEDADES
	private String nombre;
	private boolean nuevo;
	private String nif;
	private double cifraCompras;

	private static int contador = 1;

	public Cliente() {
	}

	public Cliente(String nombre, boolean nuevo, String nif, double cifraCompras) {
		this.nombre = nombre;
		this.nuevo = nuevo;
		this.nif = nif;
		this.cifraCompras = cifraCompras;
	}

	public static int incrementarContador() {
		return ++contador;
	}

	// ACCESORES PARA SPRING
	public double getCifraCompras() {
		return cifraCompras;
	}

	public void setCifraCompras(double cifraCompras) {
		this.cifraCompras = cifraCompras;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Cliente.contador = contador;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

	@Override
	public String toString() {
		return "Cliente{" + " nombre=" + nombre + " nuevo=" + nuevo + " nif="
				+ nif + " cifraCompras=" + cifraCompras + '}';
	}

}
