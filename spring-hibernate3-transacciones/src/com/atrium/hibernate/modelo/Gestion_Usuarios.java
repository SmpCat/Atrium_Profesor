package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.ext.Usuario_DAOEXT;

/**
 * Ejemplo de fachada para el uso de transacciones con spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 4-4-2017.
 *
 */
public class Gestion_Usuarios implements IGestion_Usuarios {

	private Usuario_DAOEXT usuario_dao;

	@Override
	public Usuarios consultar_PorNombre(String nombre) {
		Usuarios usuario = usuario_dao.findById(nombre);
		return usuario;
	}

	@Override
	public List<Usuarios> consultar_Todos() {
		return usuario_dao.findAll();
	}

	@Override
	public Usuarios consultar_Todo(String nombre) {
		return usuario_dao.consultar_Todo(nombre);
	}

	@Override
	public Usuarios consultar_ConRol(String nombre) {
		return usuario_dao.consultar_ConRol(nombre);
	}

	@Override
	public void alta_Usuario(Usuarios usuario) {
		usuario_dao.save(usuario);
	}

	@Override
	public void baja_Usuario(Usuarios usuario) {
		usuario_dao.delete(usuario);
	}

	@Override
	public void modificion_Usuario(Usuarios usuario) {
		usuario_dao.attachDirty(usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(Usuario_DAOEXT usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
