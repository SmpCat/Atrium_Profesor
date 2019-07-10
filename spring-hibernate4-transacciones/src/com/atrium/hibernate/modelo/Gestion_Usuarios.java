package com.atrium.hibernate.modelo;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;
/**
 * Ejemplo de fachada para el uso de transacciones con spring. La definicion de
 * las transacciones con anotaciones en la clase.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 4-4-2017.
 *
 */
@Component("gestion_usuarios")
@Scope("prototype")
public class Gestion_Usuarios implements IGestion_Usuario {

	private UsuariosDAO usuario_dao;

	// ***************** CONSULTAS DE USUARIOS
	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_PorNombre(String nombre_usuario) {
		return usuario_dao.findById(nombre_usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> consultar_Todos() {
		List<Usuarios> lista = usuario_dao.findAll();
		return lista;
	}

	// *************** OPERACIONES CRUD USUARIOS

	@Override
	@Transactional
	public void alta_Usuario(Usuarios usuario) {
		usuario_dao.save(usuario);
	}

	@Override
	@Transactional
	public void baja_Usuario(Usuarios usuario) {
		usuario_dao.delete(usuario);
	}

	@Override
	@Transactional
	public void modificion_Usuario(Usuarios usuario) {
		usuario_dao.attachDirty(usuario);
	}

	// ACCESORES PARA SPRING
	public void setUsuario_dao(UsuariosDAO usuario_dao) {
		this.usuario_dao = usuario_dao;
	}

}
