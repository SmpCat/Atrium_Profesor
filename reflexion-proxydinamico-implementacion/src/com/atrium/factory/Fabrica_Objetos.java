package com.atrium.factory;

import java.lang.reflect.Proxy;

/**
 * Factory de proxy dinamicos para la creacion de la traza como una operacion
 * transversal.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2016.
 * 
 */
public class Fabrica_Objetos {
	// BANDERA PARA ESTABLECER SI SE DEVUELVE UN PROXY O EL OBJETO
	private boolean proxy_activo;

	/**
	 * Constructor para indicar
	 * 
	 * @param activar_proxy
	 */
	public Fabrica_Objetos(boolean activar_proxy) {
		proxy_activo = activar_proxy;
	}

	/**
	 * Fabricacion del proxy dinamico segun creacion definicion del factory.
	 * 
	 * @param objeto_atratar
	 *            Tipo del objeto a tratar.
	 * @return Objeto retornado, proxy dinamico u objeto pedido.
	 */
	public Object crear_Proxy(Class objeto_atratar) {
		Object objeto_retorno = null;
		// SI EL INDICADOR ES TRUE SE CREA EL PROXY
		Object instancia_objeto = null;
		try {
			instancia_objeto = objeto_atratar.newInstance();
		} catch (Exception e) {
			// SIN TRATAMIENTO
		}
		// EN FUNCION DEL VALOR ESTABLECIDO CREACION DEL PROXY O DEL OBJETO
		if (proxy_activo) {
			objeto_retorno = Proxy.newProxyInstance(instancia_objeto.getClass().getClassLoader(),
					instancia_objeto.getClass().getInterfaces(), new Proxy_Traza(instancia_objeto));
		} else {
			// SI EL INDICADOR ES FALSE SE CREA EL OBJETO
			objeto_retorno = instancia_objeto;
		}
		return objeto_retorno;
	}

	/**
	 * Fabricacion del proxy dinamico segun creacion definicion del factory.
	 * 
	 * @param objeto_atratar
	 *            Tipo del objeto a tratar.
	 * @return Objeto retornado, proxy dinamico u objeto pedido, casteado segun
	 *         el tipo de entrada.
	 */
	public <T> T crear_ProxyConTipo(Class<T> objeto_atratar) {
		Object objeto_retorno = null;
		// SI EL INDICADOR ES TRUE SE CREA EL PROXY
		Object instancia_objeto = null;
		try {
			instancia_objeto = objeto_atratar.newInstance();
		} catch (Exception e) {
			// SIN TRATAMIENTO
		}
		// EN FUNCION DEL VALOR ESTABLECIDO CREACION DEL PROXY O DEL OBJETO
		if (proxy_activo) {
			objeto_retorno = Proxy.newProxyInstance(instancia_objeto.getClass().getClassLoader(),
					instancia_objeto.getClass().getInterfaces(), new Proxy_Traza(instancia_objeto));
		} else {
			// SI EL INDICADOR ES FALSE SE CREA EL OBJETO
			objeto_retorno = instancia_objeto;
		}
		// CASTEO AL TIPO DE ENTRADA
		return (T) objeto_retorno;
	}
}
