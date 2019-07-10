package com.atrium.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atrium.jdbc.dto.Provincias;
import com.atrium.reflexion.Cargar_Datos;

/**
 * DAO para el proceso de la tabla Provincias,
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 */
public class Provincias_DAO extends Abstract_DAO {

	public Provincias_DAO() {
		super();
	}

	public Provincias_DAO(int tipo_conexion) {
		super(tipo_conexion);
	}

	/**
	 * Proceso de consulta de todas las provincias.
	 * 
	 * @return Coleccion de objetos provincias con el resultado de la consulta
	 * @throws SQLException
	 */
	public List<Provincias> consultar_Provincias() throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("consulta.provincias.todas");
		List<Provincias> lista = new ArrayList<Provincias>(0);
		// CREAMOS EL STATEMENT
		sta = conexion.createStatement();
		// HACEMOS LA CONSULTA
		rs = sta.executeQuery(consulta);
		Provincias provi_nueva;
		// CARGAMOS EL RESULTADO DE LA CONSULTA POR REFLEXION
		while (rs.next()) {
			provi_nueva = new Provincias();
			Cargar_Datos.cargar_Objeto_RS(rs, provi_nueva);
			lista.add(provi_nueva);
		}
		return lista;
	}

	/**
	 * Proceso de altas en la tabla provincias
	 * 
	 * @param provincia_nueva
	 * @throws SQLException
	 */
	public void alta_Provincia(Provincias provincia_nueva) throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("provincias.alta");
		// CREACION DEL PREPARESTATEMENT PARA LANZAR LA ORDEN
		pta = conexion.prepareStatement(consulta);
		// SUSTITUIMOS LAS VARIABLES POR SUS VALORES
		pta.setByte(1, provincia_nueva.getCodigo_provincia());
		pta.setString(2, provincia_nueva.getProvincia());
		// REALIZAR LA ORDEN
		pta.execute();
	}

	/**
	 * Proceso de baja en la tabla provincias.
	 * 
	 * @param provincia_aeliminar
	 * @throws SQLException
	 */
	public void baja_Provincia(Provincias provincia_aeliminar) throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("provincias.baja");
		// CREACION DEL PREPARESTATEMENT PARA LANZAR LA ORDEN
		pta = conexion.prepareStatement(consulta);
		// SUSTITUIMOS LAS VARIABLES POR SUS VALORES
		pta.setByte(1, provincia_aeliminar.getCodigo_provincia());
		// REALIZAR LA ORDEN
		pta.execute();
	}

	/**
	 * Proceso de modificacion en la tabla provincias
	 * 
	 * @param provincia_amodificar
	 * @throws SQLException
	 */
	public void modificacion_Provincia(Provincias provincia_amodificar) throws SQLException {
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("provincias.modificacion");
		// CREACION DEL PREPARESTATEMENT PARA LANZAR LA ORDEN
		pta = conexion.prepareStatement(consulta);
		// SUSTITUIMOS LAS VARIABLES POR SUS VALORES
		pta.setByte(2, provincia_amodificar.getCodigo_provincia());
		pta.setString(1, provincia_amodificar.getProvincia());
		// REALIZAR LA ORDEN
		pta.execute();
	}
}
