package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.dao.MunicipiosDAO;

public class Gestion_Municipios implements IGestion_Municipios {

	private MunicipiosDAO municipio_dao;

	
	@Override
	public List<Municipios> consultar_PorProviincia(Byte codigo_provincia){
		return municipio_dao.findByProperty("id.provincia", codigo_provincia);
	}
	
	//ACCESORES PARA SPRING
	public void setMunicipio_dao(MunicipiosDAO municipio_dao) {
		this.municipio_dao = municipio_dao;
	}
	
	
}
