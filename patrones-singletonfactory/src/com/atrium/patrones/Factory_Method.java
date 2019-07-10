package com.atrium.patrones;

import com.atrium.patrones.interfaces.IObjeto_Fabricado;
import com.atrium.patrones.interfaces.Objeto_Fabricado;
import com.atrium.patrones.interfaces.Otro_ObjetoFabricado;

/**
 * Ejemplo de factory-method. La clase que implementa la interface solo es
 * conocida por el factory y por lo tanto se puede cambiar dicha clase sin
 * perjuicio al programa que lo solicita.<br/>
 * Flexibilidad, extensibilidad para los evolutivos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 24-10-2016.
 *
 */
public class Factory_Method {
	// CONSTANTES DE CLASE
	public static int TIPO_UNO = 1;
	public static int TIPO_DOS = 2;

	/**
	 * Proceso de creacion de un objeto a partir de otro. Al definirlo via
	 * interface el tipo concreto puede ser distinto en cada momento
	 * 
	 * @return
	 */
	public IObjeto_Fabricado metodo_Factoria() {
		return new Objeto_Fabricado();
	}

	/**
	 * Proceso de creacion de un objeto a partir de otro. Al definirlo via
	 * interface el tipo concreto puede ser distinto en cada momento.<br/>
	 * En este metodo se cubre la opcion de devolver distintos objetos segun se
	 * pida.
	 * 
	 * @return
	 */
	public IObjeto_Fabricado metodo_Factoria(int tipo_implementacion) {
		IObjeto_Fabricado salida = null;
		if (tipo_implementacion == TIPO_UNO) {
			salida = new Objeto_Fabricado();
		}
		if (tipo_implementacion == TIPO_DOS) {
			salida = new Otro_ObjetoFabricado();
		}
		return salida;
	}
}
