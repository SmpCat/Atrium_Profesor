package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;

@Component("gestion_provincias")
@Scope("prototype")
public class Gestion_Provincia implements IGestion_Provincias {

	private ProvinciasDAO provincia_dao;

	@Override
	@Transactional(readOnly = true)
	public List<Provincias> comsultar_Todos() {
		return provincia_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setProvincia_dao(ProvinciasDAO provincia_dao) {
		this.provincia_dao = provincia_dao;
	}

}
