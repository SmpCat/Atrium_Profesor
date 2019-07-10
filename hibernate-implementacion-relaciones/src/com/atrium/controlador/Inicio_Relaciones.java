package com.atrium.controlador;

import java.util.List;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.Gestion_Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuarios;

/**
 * Ejemplo basico de uso de HIBERNATE para la gestion de la persistencia y las
 * relaciones entre entidades.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 26-10-2016.
 *
 */
public class Inicio_Relaciones {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		Inicio_Relaciones inicio = new Inicio_Relaciones();
		inicio.consultas_Usuario();
	}

	/**
	 * Consulta de resolucion de carga vaga.
	 */
	public void consultas_Usuario() {
		IGestion_Usuarios gestion_usuarios = new Gestion_Usuarios();
		// CONSULTAS POR CLAVE PRIMARIA
		// CLAVE CORRECTA
		Usuarios usuario = gestion_usuarios.consulta_PorClave("Juan");
		// CLAVE INCORRECTA
		usuario = gestion_usuarios.consulta_PorClave("JuanXXXXX");
		// CONSULTA GENERAL
		List<Usuarios> lista = gestion_usuarios.consultar_Todos();
		// CONSULTA DE ROL
		Usuarios usuario_consultado = gestion_usuarios
				.consultar_UsuarioConRol("Juan");
		Roles rol = usuario_consultado.getRoles();
		// CONSULTA DE TAREAS
		List<Tareas> lista_tareas = gestion_usuarios.consultar_Tareas(usuario
				.getNombreUsuario());
	}

}
