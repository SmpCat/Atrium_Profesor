package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.dao.PaisDAO;

public class Gestion_Pais implements IGestion_Pais {

	private PaisDAO pais_dao;

	@Override
	public List<Pais> consultar_Todos() {
		return pais_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setPais_dao(PaisDAO pais_dao) {
		this.pais_dao = pais_dao;
	}

}
