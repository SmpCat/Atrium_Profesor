package com.atrium.patrones.interfaces;

/**
 * Ejemplo segundo de clase cuyo objetos seran fabricados/instanciados por los
 * factory.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 20-10-2016.
 *
 */
public class Otro_ObjetoFabricado implements IObjeto_Fabricado {

	/**
	 * Constructor de la clase.
	 */
	public Otro_ObjetoFabricado() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implementacion de la interface. Metodo vacio.
	 */
	@Override
	public String metodo_Comun() {
		return null;
	}

	/**
	 * Implementacion de la interface.
	 */
	@Override
	public void segundo_MetodoComun() {
		// METODO SIN IMPLEMENTAR
	}

}
