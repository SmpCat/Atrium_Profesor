package com.atrium.modelo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.atrium.dao.Pais_DAO;
import com.atrium.dto.Pais;


/**
 * Procesos contra la tabla de paises en la base de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 4-10-2016.
 *
 */
public class Gestion_Pais implements Comparator<Pais>, IGestion_Pais {
	// DAO DE ACCESO A LA FUENTE DE DATOS (B.D.)
	private Pais_DAO pais_dao;
	// PROPIEDADES PARA EL PROCESO DE LA CLASE
	private int sentido;
	private int campo;

	// ******* CONSTRUCTORES
	public Gestion_Pais() {
		pais_dao = new Pais_DAO();
	}

	

	/**
	 * Operacion de consulta a la base de datos.
	 * 
	 * @return List<Pais> Coleccion de objeto sin ordenar.
	 */
	@Override
	public List<Pais> consultar_Todos() {
		List<Pais> lista = null;
		try {
			lista = pais_dao.consultar_Todos();
		} catch (SQLException e) {
			// SIN TRATAMIENTO
		} finally {
			try {
				pais_dao.liberar_Recursos();
			} catch (SQLException e) {
				// SIN TRATAMIENTO
			}
		}
		return lista;
	}

	/**
	 * Proceso de consulta de paises, incluido ordenacion.<BR/>
	 * sobrecarga del metodo {@link Gestion_Pais.consultar_Todos }
	 */
	@Override
	public List<Pais> consultar_Todos(int sentido, int campo) {
		// PASO A PROPIEDADES DE CLASE LOS VALORES RECIBIDOS
		this.sentido = sentido;
		this.campo = campo;
		// OBTENEMOS LA INFORMACION SIN ORDENAR DE LA BASE DE DATOS
		List<Pais> lista = consultar_Todos();
		// ORDENACION DE LA INFORMACION SEGUN PETICION
		Collections.sort(lista, this);
		// RETORNO DE INFORMACION ORDENADA
		return lista;
	}

	@Override
	public int compare(Pais pais1, Pais pais2) {
		int posicion = 0;
		if (sentido == ASCENDENTE && campo == CODIGO) {
			posicion = pais1.getCodigo_pais().compareTo(pais2.getCodigo_pais());
		}
		if (sentido == ASCENDENTE && campo == NOMBRE) {
			posicion = pais1.getPais_nombre().compareTo(pais2.getPais_nombre());
		}
		if (sentido == DESCENDENTE && campo == CODIGO) {
			posicion = pais2.getCodigo_pais().compareTo(pais1.getCodigo_pais());
		}
		if (sentido == DESCENDENTE && campo == NOMBRE) {
			posicion = pais2.getPais_nombre().compareTo(pais1.getPais_nombre());
		}
		return posicion;
	}

}
