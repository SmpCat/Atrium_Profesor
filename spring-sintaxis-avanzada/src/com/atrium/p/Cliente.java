package com.atrium.p;

/**
 * Ejemplo de uso de P en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Cliente {

	private String nombre;
	private String nif;
	private Direccion direccion;

	public Cliente() {
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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

	@Override
	public String toString() {
		return "Cliente{" + " nombre=" + nombre + " nif=" + nif + " direccion="
				+ direccion + '}';
	}

}
