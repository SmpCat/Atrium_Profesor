package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;
import com.atrium.hibernate.dao.ext.Usuario_DAOEXT;

/**
 * Ejemplo de fachada con spring para hibernate 3.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 4-3-2017.
 *
 */
public class Gestion_Usuario implements IGestion_Usuarios {

	private Usuario_DAOEXT usuario_dao;

	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuario_dao.findById(nombre_usuario);
	}

	@Override
	public List<Usuarios> consultar_Todos() {
		return usuario_dao.findAll();
	}

	@Override
	public Usuarios consultar_ConRol(String nombre_usuario) {
		 return usuario_dao.consultar_ConRol(nombre_usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(Usuario_DAOEXT usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
