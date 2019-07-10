package com.atrium.util.foco;

/**
 * Conjunto de constantes que definen las normalizacion de texto posibles a
 * aplicar.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2016..
 * 
 */
public interface ITipo_Normalizacion {
	/**
	 * La primera letra de cada palabra en mayuscula
	 */
	public static final int CAPITALIZAR = 10;
	/**
	 * La primera letra de cada frase en mayuscula, resto de frase minuscula. la
	 * frase de delimita por intros.
	 */
	public static final int FRASEAR = 20;
	/**
	 * Todo el texto en mayusculas.
	 */
	public static final int MAYUSCULAS = 30;
	/**
	 * Todo el texto en minuscula.
	 */
	public static final int MINUSCULAS = 40;

}
