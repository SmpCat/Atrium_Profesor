package com.atrium.negocio;

import java.util.List;

import com.atrium.conversores.IConversor_JSON;
import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.Pais;
import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.IGestion_Municipios;
import com.atrium.hibernate.modelo.IGestion_Pais;
import com.atrium.hibernate.modelo.IGestion_Provincia;
import com.atrium.spring.Acceso_ApplicationContext;

/**
 * Logica de proceso de las peticiones AJAX para los combos de paises,provincias
 * y municipios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 9-1-2018.
 * 
 */
public class Logica_ListasAJAX implements ILogica_ListasAJAX {

	// FACHADAS DE ACCESO AL MODELO
	private IGestion_Pais gestion_paises;
	private IGestion_Provincia gestion_provincias;
	private IGestion_Municipios gestMunicipios;

	private String salida_json;

	@Override
	public String consultar_Paises() {
		// ACCESO A LA INFORMACION NECESARIO PARA EL PROCESO
		List<Pais> lista_paises = Acceso_ApplicationContext.getBean(
				IGestion_Pais.class).consultar_Todos();
		// CONVERSION AL FORMATO DE SALIDA
		salida_json = Acceso_ApplicationContext.getBean(IConversor_JSON.class)
				.convertir_Coleccion(lista_paises);
		return salida_json;
	}

	@Override
	public String consultar_Provincias(String codigo_pais) {
		salida_json = null;
		if (!codigo_pais.equals("") && codigo_pais.equals("73")) {
			// TENEMOS CODIGO PAIS, PETICION DE USUARIO
			// CONSULTA A LA BASE DE DATOS
			List<Provincias> lista_provincias = Acceso_ApplicationContext
					.getBean(IGestion_Provincia.class).consultar_todas();
			// CONVERSION AL FORMATO DE SALIDA
			salida_json = Acceso_ApplicationContext.getBean(
					IConversor_JSON.class)
					.convertir_Coleccion(lista_provincias);
		} else {
			// VALOR PARA LOS PAISES SIN PROVINCIAS
			salida_json = "[{'provincia':'pais sin provincias','codigo_provincia':'-1'}]";
		}
		return salida_json;
	}

	@Override
	public String consultar_Municipios(String provincia_seleccionado) {

		// TENEMOS CODIGO PROVINCIA, PETICION DE USUARIO
		// CONSULTA A LA BASE DE DATOS
		List<Municipios> lista_municipios = Acceso_ApplicationContext.getBean(
				IGestion_Municipios.class).consultar_PorProviincia(
				new Byte(provincia_seleccionado));
		// CONVERSION AL FORMATO DE SALIDA
		salida_json = Acceso_ApplicationContext.getBean(IConversor_JSON.class)
				.convertir_Coleccion(lista_municipios);
		return salida_json;
	}
}
