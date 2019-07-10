package com.atrium.controlador;

/**
 * Clase de ejemplo para la creacion de objetos en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 14-11-2016.
 *
 */
public class Saludo implements ISaludo {
	// PORPIEDADES DE CLASE
	private String texto;
	private Saludo otro_saludo;

	/**
	 * Constructor sin argumentos
	 */
	public Saludo() {
		System.out.println("SOY EL CONSTRUCTOR SIN ARGUMENTOS "
				+ this.hashCode());
	}

	/**
	 * Segundo constructor con un argumento
	 * 
	 * @param texto_constructor
	 *            Valor para una propiedad de la clase.
	 */
	public Saludo(String texto_constructor) {
		texto = texto_constructor;
		System.out.println("SOY EL CONSTRUCTOR CON ARGUMENTOS "
				+ this.hashCode());
	}

	/**
	 * Tercer constructor con dos argumentos.
	 * 
	 * @param texto_uno
	 *            Valor para una propiedad de la clase.
	 * @param texto_dos
	 *            Valor para una propiedad de la clase.
	 */

	public Saludo(String texto_uno, Saludo texto_dos) {
		texto = texto_uno;
		otro_saludo = texto_dos;
		System.out.println("SOY EL CONSTRUCTOR CON DOS ARGUMENTOS "
				+ this.hashCode());
	}

	/**
	 * Proceso de clase.
	 */
	@Override
	public void mostrar_Texto() {
		System.out.println(texto);
	}

	/**
	 * Metodo de inicio.
	 */
	public void soy_Inicio() {
		System.out.println("PASO POR EL METODO DE INICIO");
		texto = "Soy el metodo de inicio";
	}

	/**
	 * Metodo de instancia de la clase sin argumentos.
	 * 
	 * @return
	 */
	public static ISaludo metodo_Instancia() {
		System.out
				.println("SOY EL METODO DE INSTANCIA QUE LLAMA AL CONSTRUCTOR CON UN ARGUMENTO");
		return new Saludo("metodo de instancia");
	}

	/**
	 * Metodo de isntancia de la clase con argumentos.
	 * 
	 * @param texto
	 * @return
	 */
	public static ISaludo metodo_InstanciaConArgumento(String texto) {
		System.out
				.println("SOY EL METODO DE INSTANCIA CON ARGUMENTOS QUE LLAMA AL CONSTRUCTOR CON UN ARGUMENTO");
		return new Saludo(texto);
	}

	// ACCESORES PARA SPRING
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setOtro_saludo(Saludo otro_saludo) {
		this.otro_saludo = otro_saludo;
	}

}
