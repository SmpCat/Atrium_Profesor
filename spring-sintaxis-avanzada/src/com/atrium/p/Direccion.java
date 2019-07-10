package com.atrium.p;

/**
 * Ejemplo de uso de P en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Direccion {

	private String calle;
	private String poblacion;
	private int cp;

	public Direccion() {
	}

	public Direccion(String calle, String poblacion, int cp) {
		this.calle = calle;
		this.poblacion = poblacion;
		this.cp = cp;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "Direccion{" + " calle=" + calle + " poblacion=" + poblacion
				+ " cp=" + cp + '}';
	}
}
