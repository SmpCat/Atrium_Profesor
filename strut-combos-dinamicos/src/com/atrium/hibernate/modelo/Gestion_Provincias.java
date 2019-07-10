package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;

public class Gestion_Provincias implements IGestion_Provincias {

	private ProvinciasDAO provincia_dao;

	@Override
	@Transactional(readOnly=true)
	public List<Provincias> consultar_Todas() {
		return provincia_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setProvincia_dao(ProvinciasDAO provincia_dao) {
		this.provincia_dao = provincia_dao;
	}

}
