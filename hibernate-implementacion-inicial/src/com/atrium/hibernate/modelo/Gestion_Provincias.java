package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.dao.ProvinciasDAO;

public class Gestion_Provincias {

	private ProvinciasDAO provincias_DAO;

	public Gestion_Provincias() {
		provincias_DAO = new ProvinciasDAO();
	}

	public List<Provincias> consultar_Todas() {
		List<Provincias> lista = provincias_DAO.findAll();
		provincias_DAO.getSession().close();
		return lista;
	}
}
