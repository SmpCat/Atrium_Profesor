package com.atrium.configuration;

import org.springframework.context.annotation.Bean;

/**
 * Ejemplo de uso configuration de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */

public class MensajeAdios implements SaludoInterfaz {

	@Override
	public void pintaMensaje(String mensaje) {
		System.out.println("Mensaje Adios: " + mensaje);
	}
}
