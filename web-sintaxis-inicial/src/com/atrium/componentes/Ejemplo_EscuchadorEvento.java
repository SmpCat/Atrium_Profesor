package com.atrium.componentes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Ejemplo de definicion de componente LISTENER dentro de una aplicacion WEB.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 15-11-2016.
 */
public class Ejemplo_EscuchadorEvento implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent evento) {
		// SIN IMPLEMENTACION
	}

	@Override
	public void contextInitialized(ServletContextEvent evento) {
		// SIN IMPLEMENTACION
	}

}
