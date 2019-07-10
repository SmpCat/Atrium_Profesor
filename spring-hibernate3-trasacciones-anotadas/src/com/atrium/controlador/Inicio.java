package com.atrium.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_USuario;

/**
 * Ejemplo basico de uso de HIBERNATE 3 para la gestion de la persistencia y
 * transacciones.
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
				"/com/atrium/spring/modelo.xml");
		// CREACION DE LA FACHADA
		IGestion_USuario gestion_usuarios = contexto
				.getBean(IGestion_USuario.class);
		// CREACION DEL OBJETO EN TRANSITO PARA SU ALTA EN LA BASE DE DATOS
		Usuarios usuario_nuevo = new Usuarios();
		usuario_nuevo.setNombreUsuario("prueba j116");
		usuario_nuevo.setPassword("quien sabe");
		usuario_nuevo.setFechaAlta(new Date());
		// PROCESO DE ALTA
		try {
			gestion_usuarios.alta_Usuario(usuario_nuevo);
		} catch (Exception e) {
			System.out.println("");
		}
		// MODIFICACION DEL OBJETO EN TRANSITO
		usuario_nuevo.setPassword("otro pass");
		// PROCESO DE MODIFICACION
		try {
			gestion_usuarios.modificion_Usuario(usuario_nuevo);
		} catch (Exception e) {
			System.out.println("");
		}
		// PROCESO DE BAJA
		try {
			gestion_usuarios.baja_Usuario(usuario_nuevo);
		} catch (Exception e) {
			System.out.println("");
		}
		// CONSULTAS VARIAS
		Usuarios usuario2 = gestion_usuarios.consultar_ConRol("Juan");

		Usuarios usuario3 = gestion_usuarios.consultar_Todo("Juan");

		Usuarios usuario = gestion_usuarios.consultar_PorNombre("Juan");

		List<Usuarios> lista = gestion_usuarios.consultar_Todos();

	}

}
