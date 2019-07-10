package com.atrium.aop.anotaciones;

/**
 * Ejemplo de uso de AOP con anotaciones en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-3-2017.
 *
 */
public class Pasajero {
	/**
	 * Metodo que va a ser interceptado.
	 * 
	 * @param numeroVuelo
	 * @throws Exception
	 */
	public void viajar(String numeroVuelo) throws Exception {
		System.out.println("El pasajero viaja en " + numeroVuelo);
		// throw new Exception("Socorro ........");
	}
}
