package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.dao.MunicipiosDAO;

@Component("gestion_municipios")
@Scope("prototype")
public class Gestion_Municipios implements IGestion_Municipios {

	private MunicipiosDAO municipio_dao;

	@Override
	@Transactional(readOnly = true)
	public List<Municipios> consultar_PorProvincias(Byte codigo_provincia) {
		return municipio_dao.findByProperty("id.provincia", codigo_provincia);
	}

	// ACCSORES PARA SPRING
	public void setMunicipio_dao(MunicipiosDAO municipio_dao) {
		this.municipio_dao = municipio_dao;
	}

}
