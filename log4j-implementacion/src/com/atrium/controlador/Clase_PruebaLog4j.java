package com.atrium.controlador;

import org.apache.log4j.Logger;

/**
 * Ejemplo basico de definicon y uso de log4j en una clase de java.
 * 
 * @author Juan Antonio solves Garcia.
 * @version 1.5.
 * @since 23-9-2016.
 *
 */
public class Clase_PruebaLog4j {
	// REGISTRO DE LA CLASE EN EL SISTEMA DE LOG.
	private Logger log = Logger.getLogger(Clase_PruebaLog4j.class);

	public Clase_PruebaLog4j() {
		// COMPROBACION DE NIVEL ANTES DE EMITRI EL MENSAJE
		if (log.isTraceEnabled()) {
			// EMISON DE MENSAJE
			log.trace("Inicio constructor clase_prueba");
		}
		this.primer_Metodo();
		this.segundo_Metodo();

		if (log.isTraceEnabled()) {
			log.trace("fin constructor clase_prueba");
		}
	}

	public void primer_Metodo() {
		if (log.isTraceEnabled()) {
			log.trace("Inicio primer metodo");
		}

		if (log.isTraceEnabled()) {
			log.trace("Fin primer metodo");
		}
	}

	public void segundo_Metodo() {
		if (log.isTraceEnabled()) {
			log.trace("Inicio segundo metodo");
		}

		if (log.isTraceEnabled()) {
			log.trace("Fin segundo metodo");
		}
	}
}
