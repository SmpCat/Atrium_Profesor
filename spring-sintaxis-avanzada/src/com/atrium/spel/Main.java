package com.atrium.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso de expresiones dinamicas Spel en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Main {

	public static void main(String[] args) {
		ApplicationContext contenedor = new ClassPathXmlApplicationContext(
				"com/atrium/spel/spring.xml");

		System.out.println(contenedor.getBean("cliente1", Cliente.class));
		System.out.println(contenedor.getBean("cliente2", Cliente.class));

		Pruebas pruebas = (Pruebas) contenedor.getBean("prueba");
		Pruebas pruebas2 = (Pruebas) contenedor.getBean("prueba2");

		System.out.println("Valor contador: " + pruebas.getValorContador());
		System.out.println("Importe Compras: " + pruebas.getImporteCompras());

		System.out.println("Lista de clientes -------------------");
		for (Cliente c : pruebas.getClientes()) {
			System.out.println(c);
		}

		System.out.println("Lista de mejores clientes -----------");
		for (Cliente c2 : pruebas2.getMejoresClientes()) {
			System.out.println(c2);
		}

		System.out.println("Nueva coleccion con nombre y nif---");
		for (String dato : pruebas2.getNuevaColeccion()) {
			System.out.println(dato);
		}
	}

}
