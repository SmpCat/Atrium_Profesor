package com.atrium.controlador;

import com.atrium.factory.Fabrica_Objetos;

/**
 * Ejemplo de uso de proxy dinamicos para tareas transversales.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 */
public class Inicio {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREAMOS EL FACTORY
		Fabrica_Objetos factory_traza = new Fabrica_Objetos(false);
		// FABRICAMOS EL OBJETO QUE NOS INTERESA
		ISaludo saludo = (ISaludo) factory_traza.crear_Proxy(Saludo.class);
		// FABRICACION SIN CASTEO
		ISaludo saludo2 = factory_traza.crear_ProxyConTipo(Saludo.class);
		// LLAMAMOS A LOS METODOS
		saludo.saludo();
		saludo.otro_Saludo("prueba traza");
	}

}
