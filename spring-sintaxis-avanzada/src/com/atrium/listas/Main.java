package com.atrium.listas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de carga en propiedades compuestas.
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
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/atrium/listas/spring.xml");

		ManejadorColecciones manejador = applicationContext.getBean(
				"manejador", ManejadorColecciones.class);

		manejador.muestraLista();
		manejador.muestraArray();
		manejador.muestraConjunto();
		manejador.muestraMapa();
		manejador.muestraPropiedades();
	}
}
