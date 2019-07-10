package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;
import com.atrium.hibernate.dao.ext.Usuario_DAOEXT;

@Component("gestion_usuarios")
@Scope("prototype")
public class Gestion_Usuarios implements IGestion_Usuarios {

	private Usuario_DAOEXT usuarios_dao;

	// ************** CONSULTAS
	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuarios_dao.findById(nombre_usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_UsuarioConROl(String nombre_usuario) {
		return usuarios_dao.consultar_UsuarioConRol(nombre_usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_UsuarioConTareas(String nombre_usuario) {
		return usuarios_dao.consultar_TareasUsuario(nombre_usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tareas> consultar_Tareas(Usuarios usuario_sintareas,
			int direccion) {
		return usuarios_dao.consultar_Tareas(usuario_sintareas
				.getNombreUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios consulta_GeneralUsuario(String nombre_usuario) {
		return usuarios_dao.consulta_GeneralUsuario(nombre_usuario);
	}

	// ********** CRUD USUARIOS
	@Override
	@Transactional
	public void alta_Usuario(Usuarios usuario_nuevo) {
		usuarios_dao.save(usuario_nuevo);
	}

	@Override
	@Transactional
	public void baja_Usuario(Usuarios usuario_aeliminar) {
		usuarios_dao.delete(usuario_aeliminar);
	}

	@Override
	@Transactional
	public void modificion_Usuario(Usuarios usuario_amodificar) {
		usuarios_dao.attachDirty(usuario_amodificar);
	}

	// ACCESORES PARA SPRING
	public void setUsuarios_dao(Usuario_DAOEXT usuarios_dao) {
		this.usuarios_dao = usuarios_dao;
	}
}
