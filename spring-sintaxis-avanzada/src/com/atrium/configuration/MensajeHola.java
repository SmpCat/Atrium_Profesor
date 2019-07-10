package com.atrium.configuration;

/**
 * Ejemplo de uso configuration de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class MensajeHola implements SaludoInterfaz {
	@Override
	public void pintaMensaje(String mensaje) {
		System.out.println("Mensaje Hola: " + mensaje);
	}

}
