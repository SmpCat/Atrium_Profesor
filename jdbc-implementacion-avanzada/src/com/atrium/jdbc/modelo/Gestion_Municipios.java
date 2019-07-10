package com.atrium.jdbc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.jdbc.dao.Municipios_DAO;
import com.atrium.jdbc.dto.Municipios;

/**
 * Fachada de la tabla municipios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * 
 */
public class Gestion_Municipios implements IGestion_Municipios,
		Comparator<Municipios> {

	// DAO DE LA TABLA MUNICIPIOS
	private Municipios_DAO muni_DAO;
	// PROPIEDADES PARA INDICAR LA ORDENACION
	private boolean ascendente;
	private int propiedad_aordenar;

	public Gestion_Municipios() {
		muni_DAO = new Municipios_DAO();
	}

	public Gestion_Municipios(int tipo_conexion) {
		muni_DAO = new Municipios_DAO(tipo_conexion);
	}

	/**
	 * Consulta de los municipios de una provincia. Incluye el proceso de
	 * ordenacion de los mismos.
	 */
	@Override
	public List<Municipios> consultar_PorProvincia(Byte codigo_provincia,
			int propiedad_aordenar, boolean sentido_ordenacion) {
		List<Municipios> lista = new ArrayList<>(0);
		try {
			lista = muni_DAO.consultar_PorProvincia(codigo_provincia);
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		try {
			muni_DAO.liberar_Recursos();
		} catch (SQLException e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		this.propiedad_aordenar = propiedad_aordenar;
		this.ascendente = sentido_ordenacion;
		Collections.sort(lista, this);
		return lista;
	}

	/**
	 * Consulta de los municipios de una provincia.
	 */
	@Override
	public List<Municipios> consultar_PorProvincia(Byte codigo_provincia) {
		List<Municipios> lista = new ArrayList<>(0);
		try {
			lista = muni_DAO.consultar_PorProvincia(codigo_provincia);
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		try {
			muni_DAO.liberar_Recursos();
		} catch (SQLException e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		return lista;
	}

	/**
	 * Proceso interno de ordenacion por varios conceptos y en los dos posibles
	 * sentidos.
	 */
	@Override
	public int compare(Municipios muni1, Municipios muni2) {
		int posicion = 0;
		if (propiedad_aordenar == CODIGO_MUNICIPIO && ascendente) {
			posicion = muni1.getCodigo_municipio().compareTo(
					muni2.getCodigo_municipio());
		}
		if (propiedad_aordenar == CODIGO_MUNICIPIO && !ascendente) {
			posicion = muni2.getCodigo_municipio().compareTo(
					muni1.getCodigo_municipio());
		}
		if (propiedad_aordenar == NOMBRE_MUNICIPIO && ascendente) {
			posicion = muni1.getMunicipio().compareTo(muni2.getMunicipio());
		}
		if (propiedad_aordenar == NOMBRE_MUNICIPIO && !ascendente) {
			posicion = muni2.getMunicipio().compareTo(muni1.getMunicipio());
		}
		return posicion;
	}

}
