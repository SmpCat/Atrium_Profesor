package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.dao.MunicipiosDAO;

public class Gestion_Municipios {

	private MunicipiosDAO municipios_DAO;
	
	public Gestion_Municipios(){
		municipios_DAO=new MunicipiosDAO();
	}

	public List<Municipios> consultar_Todos(){
		List<Municipios> lista=municipios_DAO.findAll();
		municipios_DAO.getSession().close();
		return lista;
	}
	
	public List<Municipios> consultar_PorProvincias(Byte codigo_provincia){
		List<Municipios> lista=municipios_DAO.findByProperty("id.provincia", codigo_provincia);
		municipios_DAO.getSession().close();
		return lista;
	}
}
