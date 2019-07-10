package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.dao.PaisDAO;

@Component("gestion_pais")
@Scope("prototype")
public class Gestion_Pais implements IGestion_Pais {

	private PaisDAO pais_dao;

	@Override
	@Transactional(readOnly = true)
	public List<Pais> consultar_Todos() {
		return pais_dao.findAll();
	}

	// ACCESORES PARA SPRING
	public void setPais_dao(PaisDAO pais_dao) {
		this.pais_dao = pais_dao;
	}

}
