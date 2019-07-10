package com.atrium.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.ext.Usuarios_DAOEXT;

/**
 * Fachada de acceso a los procesos de los DAO.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 26-10-2016.
 *
 */
public class Gestion_Usuarios implements IGestion_Usuarios {
	// DAO DE ACCESO A LA INFORMACION
	private Usuarios_DAOEXT usuario_DAO;

	/**
	 * Constructor de la fachada.
	 */
	public Gestion_Usuarios() {
		usuario_DAO = new Usuarios_DAOEXT();
	}

	// ***** CONSULTAS
	@Override
	public Usuarios consulta_PorClave(String nombre_usuario) {
		Usuarios usuario = usuario_DAO.findById(nombre_usuario);
		usuario_DAO.getSession().close();
		return usuario;
	}

	/**
	 * Consulta general de todos los usuarios.
	 * 
	 * @return Coleccion de usuarios.
	 */
	@Override
	public List<Usuarios> consultar_Todos() {
		List<Usuarios> lista = usuario_DAO.findAll();
		usuario_DAO.getSession().close();
		return lista;
	}

	/**
	 * Consulta de las tareas que puede realizar un usuario.
	 * 
	 * @param nombre_cliente
	 *            Clave primaria del usuario.
	 * @return Coleccion de tareas del usuario.
	 */
	@Override
	public List<Tareas> consultar_Tareas(String nombre_cliente) {
		List<Tareas> lista = usuario_DAO.consultar_Tareas(nombre_cliente);
		usuario_DAO.getSession().close();
		return lista;
	}

	/**
	 * Consulta de resolucion de carga vaga de un usuario con su rol.
	 * 
	 * @param nombre_cliente
	 *            Clave primaria del usuario.
	 * @return Usuario consultado.
	 */
	@Override
	public Usuarios consultar_UsuarioConRol(String nombre_usuario) {
		Usuarios usuario = usuario_DAO.consultar_ConRol(nombre_usuario);
		usuario_DAO.getSession().close();
		return usuario;
	}
}
