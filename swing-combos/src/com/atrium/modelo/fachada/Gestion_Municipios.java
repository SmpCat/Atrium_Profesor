package com.atrium.modelo.fachada;

import java.util.List;

import com.atrium.modelo.Municipio;
import com.atrium.modelo.dao.Municipio_DAO;

/**
 * Fachada de la capa de modelo para el DTO municipios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-3-2016.
 * 
 */

public class Gestion_Municipios implements IGestion_Municipios {
	// DAO DE MUNICIPIOS
	private Municipio_DAO municipio_dao;

	/**
	 * Constructor de la clase donde se instancia el DAO.
	 */
	public Gestion_Municipios() {
		municipio_dao = new Municipio_DAO();
	}

	/**
	 * Proceso de consultar los municipios de una provincia concreta.
	 */
	@Override
	public List<Municipio> consultar_PorProvincia(Byte codigo_provincia) {
		List<Municipio> lista = municipio_dao.consultar_PorProvincia(codigo_provincia);
		return lista;
	}

}
