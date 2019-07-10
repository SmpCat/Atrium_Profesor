package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Roles;

public interface IGestion_Roles {

	public List<Roles> consultar_Todos();

}