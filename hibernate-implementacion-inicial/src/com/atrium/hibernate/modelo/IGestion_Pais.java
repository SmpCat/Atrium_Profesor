package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Pais;

public interface IGestion_Pais {

	/**
	 * Proceso de consulta de todos los paises.
	 * 
	 * @return Coleccion con la informacion obtenida de la base de datos.
	 */
	public abstract List<Pais> consultar_Todos();

	/**
	 * Proceso de consulta de un pais por su codigo.
	 * 
	 * @param codigopais
	 *            Codigo del pais consultado.
	 * @return Informacion obtenida.
	 */
	public abstract Pais consultar_PorCodigo(Long codigopais);

	public abstract boolean alta_Pais(Pais pais_nuevo);

	public abstract boolean baja_Pais(Pais pais_aeleminar);

	public abstract boolean modificacion_Pais(Pais pais_amodificar);

}