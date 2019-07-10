package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

public class Gestion_Usuarios implements IGestion_Usuario {

	private UsuariosDAO usuario_dao;

	@Override
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuario_dao.findById(nombre_usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(UsuariosDAO usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
