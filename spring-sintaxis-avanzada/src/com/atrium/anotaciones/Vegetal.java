package com.atrium.anotaciones;

/**
 * Ejemplo de uso de anotaciones de spring.<br/>
 * Clase padre del resto de beans.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public abstract class Vegetal {

	private float peso;
	private String color;

	public abstract boolean maduro();

	public Vegetal() {
	}

	public Vegetal(float peso, String color) {
		this.peso = peso;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return " ==> " + this.color + " " + this.peso + " <=== "
				+ super.toString();
	}

}
