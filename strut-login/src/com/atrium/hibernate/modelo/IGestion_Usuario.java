package com.atrium.hibernate.modelo;

import com.atrium.hibernate.Usuarios;

public interface IGestion_Usuario {

	public Usuarios consultar_PorNombre(String nombre_usuario);

}