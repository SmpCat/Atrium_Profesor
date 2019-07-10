package com.atrium.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Ejemplo de uso configuration de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Inicio_Configuracion {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfiguracion.class);
		MensajeHola hola = (MensajeHola) context.getBean("holaBean");
		MensajeAdios adios = (MensajeAdios) context.getBean("adiosBean");
		hola.pintaMensaje("Hola ¿QUE TAL?");
		adios.pintaMensaje("Hasta luego");

	}
}
