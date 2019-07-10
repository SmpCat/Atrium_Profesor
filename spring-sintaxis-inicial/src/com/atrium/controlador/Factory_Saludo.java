package com.atrium.controlador;

/**
 * Factory para su uso en la creacion de objetos con spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 14-11-2016.
 *
 */
public class Factory_Saludo {

	/**
	 * Constructor del factory
	 */
	public Factory_Saludo() {
		System.out.println("Soy el constructor del factory");
	}

	/**
	 * Metodo de instancia.
	 * 
	 * @return Objeto creado
	 */
	public ISaludo crear_Saludo() {
		System.out
				.println("SOY EL METODO DEL FACTORY QUE LLAMA AL CONSTRUCTOR SIN ARGUMENTOS");
		return new Saludo();
	}

	/**
	 * Metodo de instancia.
	 * 
	 * @param texto
	 *            Parametro para la creacion del objeto.
	 * @return Objeto creado.
	 */
	public ISaludo crear_SaludoConArgumentos(String texto) {
		System.out
				.println("SOY EL METODO DEL FACTORY CON UN PARAMETRO QUE LLAMA AL CONSTRUCTOR CON UN ARGUMENTOS");
		return new Saludo(texto);
	}

}
