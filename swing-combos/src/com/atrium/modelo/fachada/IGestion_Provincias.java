package com.atrium.modelo.fachada;

import java.util.List;

import com.atrium.modelo.Provincia;

/**
 * Interface de ocultacion para la fachada de provincias.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-3-2016.
 * 
 */
public interface IGestion_Provincias {

	public List<Provincia> consultar_Todas();

}