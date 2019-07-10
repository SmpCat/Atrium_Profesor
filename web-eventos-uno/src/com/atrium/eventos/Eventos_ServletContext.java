package com.atrium.eventos;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Ejemplo basico de definicion de tratamiento de eventos de SERVLETCONTEXT
 * (aplicacion)
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 20-10-2016.
 *
 */
public class Eventos_ServletContext implements ServletContextListener,
		ServletContextAttributeListener {

	// *************** CREACION/DESTRUCCION DEL CONTEXTO
	@Override
	public void contextInitialized(ServletContextEvent evento) {
		System.out.println("SE CREA LA APLICACION");
	}

	@Override
	public void contextDestroyed(ServletContextEvent evento) {
		System.out.println("FINALIZA LA APLICACION");
	}

	// ****************** TRATAMIENTO DE EVENTOS DE ATRIBUTO
	@Override
	public void attributeAdded(ServletContextAttributeEvent evento) {
		System.out.println("SE AÑADE UN ATRIBUTO AL CONTEXTO DE APLICACION");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent evento) {
		System.out.println("SE QUITA UN ATRIBUTO AL CONTEXTO DE APLICACION");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent evento) {
		System.out
				.println("SE MODIFICA UN ATRIBUTO EN EL CONTEXTO DE APLICACION");
	}
}
