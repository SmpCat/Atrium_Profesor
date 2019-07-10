package com.atrium.controlador;

/**
 * Primer ejemplo de sintaxis de una clase siguiendo patrones y recondeaciones
 * de buenas practicas.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Primera_Clase {

	// PROPIEDADES DE CLASE
	private byte numero_entero_byte;
	private short numero_entero_short;
	private int numero_entero;
	private long numero_entero_long;
	private float numero_decimal;
	private double numero_decimal_double;

	private boolean valor_booleano;
	private char valor_char;

	private String texto;

	// METODOS CONSTRUCTORES
	/**
	 * Constructor sin argumentos
	 */
	public Primera_Clase() {
		String texto = "Adios";
		texto.length();
		System.out.println(texto);
	}

	/**
	 * Constructor con argumentos
	 * 
	 * @param parametro_constructor
	 *            Parametro de tipo String.
	 */
	public Primera_Clase(String parametro_constructor) {
		numero_entero = 15;
		texto = "HOLA";
		valor_char = 'd';
	}

	// RESTO DE METODOS - LOGICA
	/**
	 * Metodo de acciuon/logica.
	 */
	public void sumar() {

	}

	/**
	 * Sobrecarga del metodo anterior añadiendo parametros
	 * 
	 * @param ope1
	 *            Primer parametro de tipo entero.
	 * @param ope2
	 *            Segundo parametro de tipo entero.
	 */
	public void sumar(int ope1, int ope2) {

	}

	/**
	 * Metodo de accion con devolucion de un calor.
	 * 
	 * @return Valor retornado de tipo entero.
	 */
	public int prueba_Devolucion() {
		return 25;
	}

	/**
	 * Metodo de accion con devolucion de valor y recibiendo parametros.
	 * 
	 * @param parametro_texto
	 *            Primer paramtro de tipo entero.
	 * @param parametro_dos
	 *            Segundo parametro de tipo entero.
	 * @return Valor de retorno de tipo String.
	 */
	public String prueba_Parametros(String parametro_texto, String parametro_dos) {
		return null;
	}

}
