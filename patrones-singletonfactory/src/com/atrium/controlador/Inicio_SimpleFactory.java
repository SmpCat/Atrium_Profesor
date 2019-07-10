package com.atrium.controlador;

import com.atrium.patrones.Simple_Factory;
import com.atrium.patrones.interfaces.Objeto_Fabricado;

/**
 * Ejemplo de creacion de objetos mediante simple-factory
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 24-10-2016.
 *
 */
public class Inicio_SimpleFactory {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREAMOS EL FACTORY
		Simple_Factory simple_factory = new Simple_Factory();
		// PEDIMOS OBJETOS AL FACTORY
		Objeto_Fabricado primer_objeto = simple_factory.metodo_Factoria();
		Objeto_Fabricado segundo_objeto = simple_factory.metodo_Factoria("valor");
	}

}
