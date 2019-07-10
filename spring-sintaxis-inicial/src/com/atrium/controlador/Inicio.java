package com.atrium.controlador;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso de SPRING para la creacion de objetos.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 14-11-2016.
 *
 */
public class Inicio {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// INICIAMOS SPRING
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/applicationContext.xml");
		// EJEMPLOS DE COMO INSTANCIAR LOS OBJETOS A PARTIR DE SPRING
		ISaludo saludo1 = (ISaludo) contexto.getBean("saludo1");

		ISaludo saludo11 = (ISaludo) contexto.getBean("saludo1");

		// ISaludo saludo12 = contexto.getBean(ISaludo.class);

		ISaludo saludo3 = (ISaludo) contexto.getBean("saludo2");

		ISaludo saludo4 = (ISaludo) contexto.getBean("saludo3");

		ISaludo saludo41 = (ISaludo) contexto.getBean("saludo31");

		ISaludo saludo5 = (ISaludo) contexto.getBean("saludo4");

		ISaludo saludo6 = (ISaludo) contexto.getBean("saludo5");

		ISaludo saludo7 = (ISaludo) contexto.getBean("saludo6");

		ISaludo saludo8 = (ISaludo) contexto.getBean("saludo7");

		ISaludo saludo9 = (ISaludo) contexto.getBean("saludo8");

		ISaludo saludo10 = (ISaludo) contexto.getBean("saludo9");


	}

}
