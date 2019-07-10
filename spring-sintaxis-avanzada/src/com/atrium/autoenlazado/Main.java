package com.atrium.autoenlazado;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso de AUTOWIRED/autoenlazado en spring.
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
				"com/atrium/autoenlazado/spring.xml");
		// PEDIMOS OBJETOS CON LAS PROPIEDADES AUTOINYECTADAS
		Orquesta orquesta_uno = contenedor.getBean("orquesta_name",
				Orquesta.class);
		orquesta_uno.concierto();
		Orquesta orquesta_dos = contenedor.getBean("orquesta_type",
				Orquesta.class);
		orquesta_dos.concierto();
		Orquesta orquesta_tres = contenedor.getBean("orquesta_cons",
				Orquesta.class);
		orquesta_tres.concierto();
	}

}
