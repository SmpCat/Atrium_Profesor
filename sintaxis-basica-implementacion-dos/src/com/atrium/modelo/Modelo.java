package com.atrium.modelo;

/**
 * DTO para la informacion de la calculadora.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 27-9-2016.
 */
public class Modelo {
	// PROPIEDADES DE CLASE
	private int ope1;
	private int ope2;
	private int resultado;

	// ACCESORES PARA LAS PROPIEDADES
	public int getOpe1() {
		return ope1;
	}

	public void setOpe1(int ope1) {
		this.ope1 = ope1;
	}

	public int getOpe2() {
		return ope2;
	}

	public void setOpe2(int ope2) {
		this.ope2 = ope2;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

}
