package com.atrium.modelo.fachada;

import java.util.List;

import com.atrium.modelo.Municipio;

/**
 * Interface de ocultacion para la fachada de municipios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-3-2016.
 * 
 */
public interface IGestion_Municipios {

	public List<Municipio> consultar_PorProvincia(Byte codigo_provincia);

}