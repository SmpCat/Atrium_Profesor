package com.atrium.eventos;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Ejemplo basico de definicion de tratamiento de eventos de SERVLETREQUEST (peticion)
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 20-10-2016.
 *
 */
public class Eventos_Peticion implements ServletRequestListener,
		ServletRequestAttributeListener {

	// ***************** CREACION/DESTRUCCION
	@Override
	public void requestDestroyed(ServletRequestEvent evento) {
		System.out.println("SE DESTRUYE LA PETICION EN CURSO");
	}

	@Override
	public void requestInitialized(ServletRequestEvent evento) {
		System.out.println("SE CREA UNA PETICION NUEVA");
	}

	// ****************** TRATAMIENTO DE EVENTOS DE ATRIBUTO
	@Override
	public void attributeAdded(ServletRequestAttributeEvent evento) {
		System.out.println("SE AÑADE UN ATRIBUTO AL CONTEXTO DE PETICION");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent evento) {
		System.out.println("SE QUITA UN ATRIBUTO DEL CONTEXTO DE PETICION");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent evento) {
		System.out
				.println("SE MODIFICA UN ATRIBUTO EN EL CONTEXTO DE PETICION");
	}

}
