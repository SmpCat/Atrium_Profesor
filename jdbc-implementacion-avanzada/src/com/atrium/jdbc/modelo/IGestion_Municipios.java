package com.atrium.jdbc.modelo;

import java.util.List;

import com.atrium.jdbc.dto.Municipios;

/**
 * Definicion de la interface de la fachada Gestion_Municipios
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 *
 */
public interface IGestion_Municipios {

	// CONSTANTES DE CLASE PARA INDICAR LA ORDENACION
	public static final int CODIGO_MUNICIPIO = 1;
	public static final int NOMBRE_MUNICIPIO = 2;
	public static final boolean ASCENDENTE = true;
	public static final boolean DESCENDENTE = false;

	/**
	 * Consulta de todos los MUNICIPIOS de la tabla.<br/>
	 * Se establece opciones de ordenacion el resultado de la consulta.
	 * 
	 * @param Codigo
	 *            de la provincia a buscar.
	 * @return Coleccion con el resultado de la consulta.
	 */
	public List<Municipios> consultar_PorProvincia(Byte codigo_provincia, int propiedad_aordenar,
			boolean sentido_ordenacion);

	/**
	 * Consulta de todos los MUNICIPIOS de la tabla.
	 * 
	 * @param Codigo
	 *            de la provincia a buscar.
	 * @return Coleccion con el resultado de la consulta.
	 */
	public List<Municipios> consultar_PorProvincia(Byte codigo_provincia);
}