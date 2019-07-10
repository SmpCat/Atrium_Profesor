package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;

/**
 * Definicion de los procesos a realizar en la fachada de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 28-9-2015.
 *
 */
public interface IGestion_Usuarios {

	public final int ASCENDENTE = 1;
	public final int DESCENDENTE = 2;

	// ***** CONSULTAS A LA BASE DE DATOS
	public Usuarios consultar_PorNombre(String nombre_usuario);

	public Usuarios consultar_UsuarioConROl(String nombre_usuario);

	public Usuarios consultar_UsuarioConTareas(String nombre_usuario);

	public abstract List<Tareas> consultar_Tareas(Usuarios usuario_sintareas,
			int direccion);

	public abstract Usuarios consulta_GeneralUsuario(String nombre_usuario);

	// ******************** PROCESOS CRUD DE USUARIOS

	public void alta_Usuario(Usuarios usuario_nuevo);

	public void baja_Usuario(Usuarios usuario_aeliminar);

	public void modificion_Usuario(Usuarios usuario_amodificar);
}