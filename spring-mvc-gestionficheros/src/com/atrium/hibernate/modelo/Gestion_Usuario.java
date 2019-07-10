package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

@Component("gestion_usuario")
@Scope("prototype")
public class Gestion_Usuario implements IGestion_Usuarios {

	private UsuariosDAO usuario_dao;

	// **** CONSULTAS
	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuario_dao.findById(nombre_usuario);
	}

	// *** ACCESORES PARA SPRING
	public void setUsuario_dao(UsuariosDAO usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
