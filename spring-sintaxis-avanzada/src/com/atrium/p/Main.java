package com.atrium.p;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso de P en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Main {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// INICIAMOS SPRING
		ApplicationContext contenedor = new ClassPathXmlApplicationContext(
				"com/atrium/p/spring.xml");

		Cliente cliente = contenedor.getBean("beanCliente", Cliente.class);
		System.out.println(cliente);
	}

}
