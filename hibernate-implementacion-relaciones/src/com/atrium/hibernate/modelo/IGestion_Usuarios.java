package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;

public interface IGestion_Usuarios {

	public abstract Usuarios consulta_PorClave(String nombre_usuario);

	public abstract List<Usuarios> consultar_Todos();

	public abstract List<Tareas> consultar_Tareas(String nombre_cliente);

	public abstract Usuarios consultar_UsuarioConRol(String nombre_usuario);

}