package com.atrium.conversores;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * Conjunto de procesos con el formato JSON.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.2
 * @since 9-1-2018.
 */
public class Conversor_JSON implements IConversor_JSON {

	/**
	 * Proceso general de serializacion de cualquier coleccion a formato JSON.
	 * 
	 * @param lista
	 *            Coleccion a seralizar.
	 * @return Texto con el formato pedido.
	 */
	@Override
	public String convertir_Coleccion(List<?> lista) {
		String respuesta_json = null;
		if (lista != null && !lista.isEmpty()) {
			// CONVERSION A TEXTO PARA LA RESPUESTA AL CLIENTE
			// DEFINICION DE LOS ELEMENTOS DE LA LISTA
			JsonConfig configurador = new JsonConfig();
			configurador.setRootClass(lista.get(0).getClass());
			// CONVERSION DE LA LISTA A TEXTO SEGUN SU CONTENIDO
			respuesta_json = JSONArray.fromObject(lista, configurador)
					.toString();
		}
		return respuesta_json;
	}

}
