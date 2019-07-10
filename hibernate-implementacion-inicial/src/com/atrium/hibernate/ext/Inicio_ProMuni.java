package com.atrium.hibernate.ext;

import java.util.List;

public class Inicio_ProMuni {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Inicio_ProMuni inicio = new Inicio_ProMuni();
		inicio.consultas();
	}

	public void consultas() {
		Gestion_Provinicias gestion_provincias = new Gestion_Provinicias();
		// CONSULTA POR CLAVE PRIMARIA
		Provincias provincia = gestion_provincias.consultar_PorClave(new Byte(
				(byte) 28));
		// CONSULTA GENERAL
		List<Provincias> lista_pro = gestion_provincias.consultar_Todas();
		// CONSULTA DE MUNICIPIOS DE UNA PROVINCIA
		List<Municipios> lista_munis = gestion_provincias
				.consultar_MunicipiosEnProvincia(provincia);
		System.out.println("");
	}
}
