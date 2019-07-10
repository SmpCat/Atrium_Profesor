package com.atrium.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import com.atrium.modelo.Municipio;

/**
 * DAO simulado para el uso de colecciones.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-3-2016.
 * 
 */
public class Municipio_DAO {

	/**
	 * Proceso de consulta (simulado) de municipios segun provincia.
	 * 
	 * @param codigo_provincia
	 *            Codigo de provincia.
	 * @return Coleccion de municipios de la provincia.
	 */
	public List<Municipio> consultar_PorProvincia(Byte codigo_provincia) {
		List<Municipio> lista = new ArrayList<>();
		Municipio municipio;
		if (codigo_provincia.intValue() == 1) {
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(1));
			municipio.setMunicipio("Municipio 1 provincia 1");
			lista.add(municipio);
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(2));
			municipio.setMunicipio("Municipio 1 provincia 2");
			lista.add(municipio);
		}
		if (codigo_provincia.intValue() == 2) {
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(1));
			municipio.setMunicipio("Municipio 1 provincia 2");
			lista.add(municipio);
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(2));
			municipio.setMunicipio("Municipio 2 provincia 2");
			lista.add(municipio);
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(3));
			municipio.setMunicipio("Municipio 3 provincia 2");
			lista.add(municipio);
		}
		if (codigo_provincia.intValue() == 3) {
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(1));
			municipio.setMunicipio("Municipio 1 provincia 3");
			lista.add(municipio);
		}
		if (codigo_provincia.intValue() == 28) {
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(1));
			municipio.setMunicipio("Alcobendas");
			lista.add(municipio);
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(2));
			municipio.setMunicipio("Alcorcon");
			lista.add(municipio);
			municipio = new Municipio();
			municipio.setCodigoMunicipio(new Long(3));
			municipio.setMunicipio("Madrid");
			lista.add(municipio);
		}
		return lista;
	}
}
