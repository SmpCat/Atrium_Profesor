package com.atrium.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.atrium.log4j.Traza_Log;

/**
 * Ejecucion de la tarea transversal a partir de las llamdas de los proxy
 * dinamicos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2016.
 * 
 */
public class Proxy_Traza implements InvocationHandler {
	// PROPIEDAD QUE REPRESENTARA EL OBJETO A TRATAR
	public Object objeto_atratar;

	/**
	 * Creacion del tratamiento.
	 * 
	 * @param objeto_externo
	 */
	public Proxy_Traza(Object objeto_externo) {
		objeto_atratar = objeto_externo;
	}

	/**
	 * Proceso de trazado para el seguimiento del programa.
	 */
	@Override
	public Object invoke(Object proxy_definido, Method metodo_llamado, Object[] parametros_metodo) throws Throwable {
		// TRAZA INICIAL ANTES DE LA EJECUCION DEL METODO
		Traza_Log.registro("Se inicia el metodo .. " + metodo_llamado.getName());
		// LLAMADA AL METODO DE LA CLASE
		Object valor_retorno = metodo_llamado.invoke(objeto_atratar, parametros_metodo);
		// TRAZA POSTERIOR A LA EJECUCION DEL METODO
		Traza_Log.registro("Finaliza el metodo .. " + metodo_llamado.getName());
		return valor_retorno;
	}

}
