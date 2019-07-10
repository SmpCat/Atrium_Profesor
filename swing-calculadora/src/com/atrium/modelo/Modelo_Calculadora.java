package com.atrium.modelo;

/**
 * Procesos para los datos de la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 11-7-2017.
 *
 */
public class Modelo_Calculadora {
	// PROPIEDADES DE CLASE PARA LOS DATOS
	private int ope_1;
	private int ope_2;
	private int resultado;

	// ACCESORES PARA LOS DATOS
	public int getOpe_1() {
		return ope_1;
	}

	public void setOpe_1(int ope_1) {
		this.ope_1 = ope_1;
	}

	public int getOpe_2() {
		return ope_2;
	}

	public void setOpe_2(int ope_2) {
		this.ope_2 = ope_2;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

}
