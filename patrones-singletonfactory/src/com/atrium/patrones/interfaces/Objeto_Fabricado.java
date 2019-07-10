package com.atrium.patrones.interfaces;

/**
 * Ejemplo de clase cuyo objetos seran fabricados/instaciados por los factory.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 20-10-2016.
 *
 */
public class Objeto_Fabricado implements IObjeto_Fabricado {
	// PROPIEDAD DE CLASE
	private String texto;

	/**
	 * Primera opcion de construccion.
	 */
	public Objeto_Fabricado() {
	}

	/**
	 * Segunda opcion de construccion.
	 * 
	 * @param parametro_paraelobjeto
	 */
	public Objeto_Fabricado(String parametro_paraelobjeto) {
		texto = parametro_paraelobjeto;
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
