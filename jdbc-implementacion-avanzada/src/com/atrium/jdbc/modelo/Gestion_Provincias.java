package com.atrium.jdbc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atrium.jdbc.dao.Provincias_DAO;
import com.atrium.jdbc.dto.Provincias;

/**
 * Fachada de la tabla provincias.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0
 * 
 */
public class Gestion_Provincias implements IGestion_Provincias {
	// PROPIEDADES DE CLASE
	private Provincias_DAO provi_DAO;

	// ********** CONSTRUCTORES
	/**
	 * Conexion por defecto,
	 */
	public Gestion_Provincias() {
		provi_DAO = new Provincias_DAO();
	}

	/**
	 * Conexion segun parametro pasado.
	 * 
	 * @param tipo_conexion
	 */
	public Gestion_Provincias(int tipo_conexion) {
		provi_DAO = new Provincias_DAO(tipo_conexion);
	}

	/**
	 * Consulta general de todas las provincias.
	 */
	@Override
	public List<Provincias> consultar_Provincias() {
		List<Provincias> lista = new ArrayList<>(0);
		try {
			lista = provi_DAO.consultar_Provincias();
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		try {
			provi_DAO.liberar_Recursos();
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		return lista;
	}

	/**
	 * Proceso de alta de provincias.
	 */
	@Override
	public void alta_Provincia(Provincias provincia) {
		try {
			provi_DAO.alta_Provincia(provincia);
		} catch (SQLException e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		try {
			provi_DAO.liberar_Recursos();
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
	}

	/**
	 * Proceso de baja de provincias.
	 */
	@Override
	public void baja_Provincia(Provincias provincia) {
		try {
			provi_DAO.baja_Provincia(provincia);
		} catch (SQLException e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		try {
			provi_DAO.liberar_Recursos();
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
	}

	/**
	 * Proceso de modificacion de provincias.
	 */
	@Override
	public void modificacion_Provincia(Provincias provincia) {
		try {
			provi_DAO.modificacion_Provincia(provincia);
		} catch (SQLException e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
		try {
			provi_DAO.liberar_Recursos();
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR, SIN IMPLEMENTAR
		}
	}
}
