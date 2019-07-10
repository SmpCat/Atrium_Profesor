package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.atrium.hibernate.Usuarios;

public interface IGestion_Usuarios {

	public Usuarios consultar_PorNombre(String nombre_usuario);

	public List<Usuarios> consultar_Todos();

}