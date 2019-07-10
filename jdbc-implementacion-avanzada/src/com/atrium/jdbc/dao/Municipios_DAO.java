package com.atrium.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atrium.jdbc.dto.Municipios;
import com.atrium.reflexion.Cargar_Datos;

/**
 * Procesos de la tabla Municipios.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.5
 * 
 */
public class Municipios_DAO extends Abstract_DAO {

	public Municipios_DAO() {
		super();
	}

	public Municipios_DAO(int tipo_conexion) {
		super(tipo_conexion);
	}

	/**
	 * Consulta de municipios por codigo de provincia.
	 * 
	 * @param codigo_provincia
	 *            Provincia de la cual se quieren obtener los municipios.
	 * @return Coleccion con el resultado de la consulta.
	 * @throws SQLException
	 */
	public List<Municipios> consultar_PorProvincia(Byte codigo_provincia)
			throws SQLException {
		List<Municipios> lista = new ArrayList<>(0);
		// RECOGEMOS EL SQL DEL FICHERO
		String consulta = rb.getString("consulta.municipios.porprovincia");
		// CREAMOS EL PREPARESTATEMENT
		pta = conexion.prepareStatement(consulta);
		// SUSTITUIMOS LA UNICA VARIABLE POR SU VALOR
		pta.setByte(1, codigo_provincia.byteValue());
		// HACEMOS LA CONSULTA
		rs = pta.executeQuery();
		Municipios muni_nuevo;
		// CARGAMOS EL RESULTADO DE LA CONSULTA POR REFLEXION
		while (rs.next()) {
			muni_nuevo = new Municipios();
			Cargar_Datos.cargar_Objeto_RS(rs, muni_nuevo);
			lista.add(muni_nuevo);
		}
		return lista;
	}

}
