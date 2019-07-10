package com.atrium.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuarios;

/**
 * Ejemplo basico de uso de HIBERNATE 4 para la gestion de la persistencia.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 3-4-2017.
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
		// ARRANQUE DE SPRING
		ApplicationContext contexto = new ClassPathXmlApplicationContext(
				"com/atrium/spring/modelo.xml");
		// CREACION DE LA FACHADA
		IGestion_Usuarios gestion_usuarios = contexto
				.getBean(IGestion_Usuarios.class);
		// REALIZACION DE CONSULTAS
		Usuarios usuario = gestion_usuarios.consultar_PorNombre("Juan");

		Usuarios usuario2 = gestion_usuarios.consultar_PorNombre("Juanxxx");

		List<Usuarios> lista = gestion_usuarios.consultar_Todos();


	}

}
