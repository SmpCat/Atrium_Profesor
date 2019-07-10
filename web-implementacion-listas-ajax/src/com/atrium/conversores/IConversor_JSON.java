package com.atrium.conversores;

import java.util.List;

public interface IConversor_JSON {

	/**
	 * Proceso general de serializacion de cualquier coleccion a formato JSON.
	 * 
	 * @param lista
	 *            Coleccion a seralizar.
	 * @return Texto con el formato pedido.
	 */
	public String convertir_Coleccion(List<?> lista);

}