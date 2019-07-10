package com.atrium.util;

import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;

/**
 * Interface definitoria de el tratamiento de errores en las base de datos
 * relacionales.<br/>
 * Se establece una herencia con {@link ITratamiento_ErroresBD} para establecer
 * la parametrizacion de los tipos de error.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 6-6-2017.
 *
 */
public interface ITratamiento_ErroresBD extends ITipos_Incidencias {

	/**
	 * Tratamiento de las {@link SQLException} genericas de jdbc.
	 * 
	 * @param e
	 *            Excepcion producida.
	 * @return Mapa con la informacion obtenida de la excepcion.
	 * 
	 */
	public Map<Integer, Map<String, String>> tratar_SQLException(Exception e);

	/**
	 * Tratamiento de las {@link HibernateException} para conocer la informacion
	 * que nos puedan ofrecer del error producido.
	 * 
	 * @param e
	 *            Excepcion ocurrida.
	 * @return Mapa con la informacion obtenida de la excepcion.
	 */
	public Map<Integer, Map<String, String>> tratar_HibernateException(Exception e);

	/**
	 * Tratamiento de las {@link DataAccessException} para conocer la
	 * informacion que nos puedan ofrecer del error producido.
	 * 
	 * @param e
	 *            Excepcion ocurrida.
	 * 
	 * @return Mapa con la informacion obtenida de la excepcion.
	 */

	public Map<Integer, Map<String, String>> tratar_SpringException(Exception e);

}