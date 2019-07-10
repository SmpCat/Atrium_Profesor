package com.atrium.cliente;

/**
 * DTO para la gestion de la informacion del cliente.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 13-2-2018.
 *
 */
public class Datos {

	private String nombre;
	private String clave;

	public Datos() {
	}

	public Datos(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
