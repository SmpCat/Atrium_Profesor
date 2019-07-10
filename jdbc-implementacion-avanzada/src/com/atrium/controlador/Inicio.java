package com.atrium.controlador;

import java.util.List;

import com.atrium.jdbc.dto.Pais;
import com.atrium.jdbc.modelo.Gestion_Pais;
import com.atrium.jdbc.modelo.IGestion_Pais;

/**
 * Implementacion completa de acceso a la BD via JDBC.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * 
 */
public class Inicio {

	
	public static void main(String[] args) {
		//CREACION DE LA FACHADA
		IGestion_Pais gestion_pais = new Gestion_Pais();

		List<Pais> lista1 = gestion_pais.consultar_Todos();

		gestion_pais = new Gestion_Pais();

		List<Pais> lista2 = gestion_pais.consultar_Todos(
				IGestion_Pais.DESCENDENTE, IGestion_Pais.CODIGO);

		System.out.println("");
	}

}
