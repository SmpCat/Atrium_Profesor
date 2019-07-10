package com.atrium.controlador;

import com.atrium.patrones.Factory_Method;
import com.atrium.patrones.interfaces.IObjeto_Fabricado;

/**
 * Ejemplo de creacion de objetos mediante factory-method.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 24-10-2016.
 *
 */
public class Inicio_FactoryMethod {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREAMOS EL FACTORY
		Factory_Method factory_method = new Factory_Method();
		// PEDIMOS OBJETOS AL FACTORY
		IObjeto_Fabricado primer_objeto = factory_method.metodo_Factoria();
		IObjeto_Fabricado segundo_objeto = factory_method.metodo_Factoria(Factory_Method.TIPO_DOS);
		IObjeto_Fabricado tercer_objeto = factory_method.metodo_Factoria(Factory_Method.TIPO_UNO);
	}

}
