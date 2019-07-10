package com.atrium.componentes;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Ejemplo de definicion de componente FILTER dentro de una aplicacion WEB.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 15-11-2016.
 */
public class Ejemplo_Filtro implements Filter {

	/**
	 * Metodo inicial llamado al crear el filtro.
	 * 
	 * @param filterConfig
	 *            Acceso a la informacion de configuracion del web.xml
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// SIN IMPLEMENTACION
	}

	/**
	 * Metodo llamada en cada peticion que tiene que ser procesada por el
	 * filtro.
	 * 
	 * @param peticion
	 *            Contexto de peticion.
	 * @param respuesta
	 *            Contexto de respuesta.
	 * @param encadenamiento_peticion
	 *            Siguiente paso en el tratamiento de la peticion.
	 */
	@Override
	public void doFilter(ServletRequest peticion, ServletResponse respuesta,
			FilterChain encadenamiento_peticion) throws IOException,
			ServletException {
		// SIN IMPLEMENTACION
	}

	/**
	 * Metodo final llamado antes de destruir el filtro.
	 */
	@Override
	public void destroy() {
		// SIN IMPLEMENTACION
	}

}
