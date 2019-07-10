package com.atrium.eventos;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Ejemplo basico de definicion de tratamiento de eventos de HTTPSESSION
 * (sesion)
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 20-10-2016.
 *
 */
public class Eventos_Sesion implements HttpSessionListener,
		HttpSessionAttributeListener, HttpSessionActivationListener {

	// ***************** CREACION/DESTRUCCION
	@Override
	public void sessionCreated(HttpSessionEvent evento) {
		System.out.println("SE CREA LA SESION");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evento) {
		System.out.println("FINALIZA LA SESION");
	}

	// ****************** TRATAMIENTO DE EVENTOS DE ATRIBUTO
	@Override
	public void attributeAdded(HttpSessionBindingEvent evento) {
		System.out.println("SE AÑADE UN ATRIBUTO AL CONTEXTO DE SESION");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent evento) {
		System.out.println("SE QUITA UN ATRIBUTO EN EL CONTEXTO DE SESION");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent evento) {
		System.out.println("SE MODIFICA UN ATRIBUTO EN EL CONTEXTO DE SESION");
	}

	// ************ PASO DE SESION ENTRE SERVIDORES
	@Override
	public void sessionDidActivate(HttpSessionEvent evento) {
		System.out.println("SE HA RECIBIDO LA SESION DE OTRO SERVIDOR");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent evento) {
		System.out.println("LA SESISON SERA MANDADA A OTRO SERVIDOR");
	}

}
