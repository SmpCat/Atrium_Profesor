package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;

public class Gestion_Provincias implements IGestion_Provincia {

	private ProvinciasDAO provincia_dao;

	@Override
	public List<Provincias> consultar_todas() {
		return provincia_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setProvincia_dao(ProvinciasDAO provincia_dao) {
		this.provincia_dao = provincia_dao;
	}

}
