package com.atrium.ciclovida;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso ciclo de vida en spring.
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
				"com/atrium/ciclovida/spring.xml");

		Factoria f = (Factoria) contenedor.getBean("miBean");
		f.saludar();

		Factoria factoria = contenedor.getBean("otroBean", Factoria.class);
		factoria.saludar();
		
		
		((AbstractApplicationContext) contenedor).registerShutdownHook();
	}
}
