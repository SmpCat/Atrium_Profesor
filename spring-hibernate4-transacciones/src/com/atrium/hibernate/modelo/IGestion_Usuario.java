package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Usuarios;

public interface IGestion_Usuario {

	public Usuarios consultar_PorNombre(String nombre_usuario);

	public abstract List<Usuarios> consultar_Todos();

	public abstract void modificion_Usuario(Usuarios usuario);

	public abstract void baja_Usuario(Usuarios usuario);

	public abstract void alta_Usuario(Usuarios usuario);

}