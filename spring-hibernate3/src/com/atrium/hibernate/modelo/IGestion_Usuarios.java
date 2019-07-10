package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;

public interface IGestion_Usuarios {

	public Usuarios consultar_PorNombre(String nombre_usuario);

	public List<Usuarios> consultar_Todos();

	public abstract Usuarios consultar_ConRol(String nombre_usuario);

}