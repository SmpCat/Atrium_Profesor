package com.atrium.hibernate.modelo;

import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Roles;

public interface IGestion_Roles {

	public void alta_Rol(Roles rol_nuevo);

	public void baja_Rol(Roles rol_nuevo);

	public void modificacion_Rol(Roles rol_nuevo);

}