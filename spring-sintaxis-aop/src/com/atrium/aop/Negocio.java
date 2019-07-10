package com.atrium.aop;

/**
 * Ejemplo de uso de AOP en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-3-2017.
 *
 */
public class Negocio {

	private String nombre;
	private int edad;
	private String dato;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public void HazAlgo(String nombre, int edad, String dato) {
		System.out.println("Declaro que ===> Nombre: " + nombre + " edad: "
				+ edad + " dato: " + dato + "\n");
	}

	public void HazAlgo(String nombre, int edad) {
		System.out.println("Declaro que ===> Nombre: " + nombre + " edad: "
				+ dato + "\n");
	}

	public void HazAlgo(String nombre, String dato) {
		System.out.println("Declaro que ===> Nombre: " + nombre + " dato: "
				+ dato + "\n");
	}

	public void HazAlgo() {
		System.out.println("Declaro que ===> Nombre: " + nombre + " edad: "
				+ edad + " dato: " + dato + "\n");
	}

}
