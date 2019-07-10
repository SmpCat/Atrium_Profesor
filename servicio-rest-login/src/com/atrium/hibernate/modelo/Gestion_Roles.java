package com.atrium.hibernate.modelo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.dao.RolesDAO;

@Component("getion_roles")
@Scope("prototype")
public class Gestion_Roles implements IGestion_Roles {
	private RolesDAO roles_dao;

	@Override
	@Transactional
	public void alta_Rol(Roles rol_nuevo) {
		roles_dao.save(rol_nuevo);
	}

	@Override
	@Transactional
	public void baja_Rol(Roles rol_nuevo) {
		roles_dao.delete(rol_nuevo);
	}

	@Override
	@Transactional
	public void modificacion_Rol(Roles rol_nuevo) {
		roles_dao.attachDirty(rol_nuevo);
	}

	// ACCESORES PARA SPRING
	public RolesDAO getRoles_dao() {
		return roles_dao;
	}

	public void setRoles_dao(RolesDAO roles_dao) {
		this.roles_dao = roles_dao;
	}

}
