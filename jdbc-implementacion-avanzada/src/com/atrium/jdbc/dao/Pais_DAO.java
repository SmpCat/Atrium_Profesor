package com.atrium.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atrium.jdbc.dto.Pais;

/**
 * DAO para el proceso de la tabla Paises.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 */
public class Pais_DAO extends Abstract_DAO{

	/**
	 * Creacion del DAO obteniendo la conexion mediante el proceso por defecto.<br/>
	 * Resolviendo en el constructor de clase padre.
	 */
	public Pais_DAO() {
		super();
	}

	/**
	 * Creacion del DAO obteniendo la conexion mediante el proceso de peticion
	 * concreta de conexion.<br/>
	 * Resolviendo en el constructor de clase padre.
	 * 
	 * @param tipo_conexion
	 *            Valor numerico que define el tipo de conexion. Constante de
	 *            clase en Conexion.java
	 */
	public Pais_DAO(int tipo_conexion) {
		super(tipo_conexion);
	}

	/**
	 * Proceso de consulta de todos los paises de la tabla, sin ningun criterio
	 * de consulta.
	 * 
	 * @return Coleccion con los DTO resultantes de la consulta.
	 * @throws SQLException
	 */
	public List<Pais> consultar_Todos() throws SQLException {
		// PREPARAMOS LA LISTA PARA OBTENER EL RESULTADO DE LA CONSULTA
		List<Pais> lista = new ArrayList<Pais>(0);
		// CREAMOS EL STATEMENT NECESARIO PARA LANZAR LA ORDEN SQL SIN
		// VARIABLES
		sta = conexion.createStatement();
		// EJECUTAMOS LA CONSULTA SACANDO EL CODIGO SQL DEL PROPERTIES
		rs = sta.executeQuery(rb.getString("consulta.paises.todos"));
		Pais nuevo_pais;
		// PROCESAMOS EL RESULTADO DE LA CONSULTA CREANDO LOS DTO NECESARIOS
		// PARA ALMACENAR TODA LA INFORMACION RECIBIDA
		while (rs.next()) {
			nuevo_pais = new Pais();
			// CARGA MANUAL DE DATOS EN EL DTO (SIN REFLEXION)
			nuevo_pais.setCodigo_pais(rs.getLong(1));
			nuevo_pais.setPais_iso2(rs.getString(3));
			nuevo_pais.setPais_iso3(rs.getString(4));
			nuevo_pais.setPais_isonum(rs.getInt(2));
			nuevo_pais.setPais_nombre(rs.getString(5));
			lista.add(nuevo_pais);
		}
		return lista;
	}
	
	
}
