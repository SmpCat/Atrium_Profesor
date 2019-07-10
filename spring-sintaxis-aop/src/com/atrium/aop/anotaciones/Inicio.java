package com.atrium.aop.anotaciones;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso de AOP con anotaciones en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-3-2017.
 *
 */
public class Inicio {

	/**
	 * Arranque del ejemplo.
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext contenedor = new ClassPathXmlApplicationContext(
				"com/atrium/aop/anotaciones/spring.xml");

		Pasajero pasajero = contenedor.getBean("pasajero", Pasajero.class);
		pasajero.viajar("IB-1234");
	}

}
