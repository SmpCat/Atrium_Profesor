package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;

public interface IGestion_USuario {

	public Usuarios consultar_PorNombre(String nombre);

	public List<Usuarios> consultar_Todos();

	public Usuarios consultar_Todo(String nombre);

	public Usuarios consultar_ConRol(String nombre);

	public abstract void modificion_Usuario(Usuarios usuario);

	public abstract void baja_Usuario(Usuarios usuario);

	public abstract void alta_Usuario(Usuarios usuario);

}