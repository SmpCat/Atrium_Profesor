package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;

public interface IGestion_usuario {

	public Usuarios consultar_PorNombre(String nombre_usuario);

	public abstract List<Usuarios> consultar_Todos();

}