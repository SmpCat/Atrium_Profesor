package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

/**
 * Ejemplo de fachada con spring para hibernate 4.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 4-3-2017.
 *
 */
@Component("gestion_usuarios")
@Scope("prototype")
public class Gestion_Usuarios implements IGestion_Usuarios {
	// PROPIEDADES DE CLASE
	private UsuariosDAO usuario_dao;

	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuario_dao.findById(nombre_usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> consultar_Todos() {
		return usuario_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(UsuariosDAO usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
