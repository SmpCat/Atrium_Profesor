package com.atrium.patrones;

import com.atrium.patrones.interfaces.IObjeto_Fabricado;
import com.atrium.patrones.interfaces.Objeto_Fabricado;

/**
 * Ejemplo de creacion de un simple factory. Objeto encargado de crear otros
 * objetos.<br/>
 * Esta opcion es la mas simple de las factorias y descarga el codigo de
 * creacion de los objetos que son llamados.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 20-10-2016.
 *
 */
public class Simple_Factory {

	/**
	 * Primer metodo de creacion de objetos
	 * 
	 * @return
	 */
	public Objeto_Fabricado metodo_Factoria() {
		return new Objeto_Fabricado();
	}

	/**
	 * Segundo metodo de creacion de objetos.
	 * 
	 * @param parametro_paraelobjeto
	 *            Valor para la creacion del objeto.
	 * @return Objeto fabricado.
	 */
	public Objeto_Fabricado metodo_Factoria(String parametro_paraelobjeto) {
		return new Objeto_Fabricado(parametro_paraelobjeto);
	}
}
