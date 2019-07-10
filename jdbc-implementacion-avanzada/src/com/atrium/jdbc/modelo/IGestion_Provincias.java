package com.atrium.jdbc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atrium.jdbc.dto.Provincias;

/**
 * Definicion de la interface de la fachada Gestion_Provincias.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 *
 */
public interface IGestion_Provincias {

	// PROCESO DE CONSULTA DE TODOS LOS PAISES DE LA BASE DE DATOS
	public abstract List<Provincias> consultar_Provincias();

	public abstract void modificacion_Provincia(Provincias provincia);

	public abstract void baja_Provincia(Provincias provincia);

	public abstract void alta_Provincia(Provincias provincia);

}