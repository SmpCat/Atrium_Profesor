package com.atrium.modelo.fachada;

import java.util.List;

import com.atrium.modelo.Provincia;
import com.atrium.modelo.dao.Provincias_DAO;

/**
 * Fachada de la capa de modelo para el DTO provincias.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-3-2016.
 * 
 */
public class Gestion_Provincias implements IGestion_Provincias {

	//DAO DE PROVINCIAS.
	private Provincias_DAO provincia_dao;

	/**
	 * Constructor de la clase donde se instancia el DAO.
	 */
	public Gestion_Provincias() {
		provincia_dao = new Provincias_DAO();
	}

	/**
	 * Proceso de consultar todas las provincias.
	 */
	@Override
	public List<Provincia> consultar_Todas() {
		List<Provincia> lista = provincia_dao.consultar_Todas();
		return lista;
	}

	/**
	 * Añadido por necesidades de prueba
	 * 
	 * @return Provincias_DAO 
	 */
	public Provincias_DAO getProvincia_dao() {
		return provincia_dao;
	}

}
