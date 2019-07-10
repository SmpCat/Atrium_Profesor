package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.dao.PaisDAO;
import com.atrium.hibernate.dao.ext.Pais_DAOEXT;

public class Gestion_Paises implements IGestion_Pais {

	private Pais_DAOEXT pais_dao;

	@Override
	@Transactional(readOnly = true)
	public List<Pais> consultar_Todos() {
		return pais_dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pais> consultar_OrdenadosPorNombre() {
		return pais_dao.consultar_TodosOrdenados();
	}

	// ACCESORES PARA SPRING
	public void setPais_dao(Pais_DAOEXT pais_dao) {
		this.pais_dao = pais_dao;
	}

}
