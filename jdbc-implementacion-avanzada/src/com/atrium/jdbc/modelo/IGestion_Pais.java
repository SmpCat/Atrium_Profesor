package com.atrium.jdbc.modelo;

import java.sql.SQLException;
import java.util.List;

import com.atrium.jdbc.dto.Pais;

/**
 * Definicion de la interface de la fachada Gestion_Pais.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 *
 */
public interface IGestion_Pais extends IConstantes_Pais {

	//PROCESOS DE CONSULTAS DE PAIS
	public List<Pais> consultar_Todos(int sentido, int campo);

	public List<Pais> consultar_Todos();

}