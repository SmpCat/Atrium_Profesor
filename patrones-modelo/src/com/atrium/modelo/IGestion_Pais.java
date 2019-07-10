package com.atrium.modelo;

import java.sql.SQLException;
import java.util.List;

import com.atrium.dto.Pais;

/**
 * Interface para la ocultacion de la fachada al programa.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 4-10-2016.
 *
 */

public interface IGestion_Pais extends IConstantes_Pais {

	public List<Pais> consultar_Todos(int sentido, int campo);

	public abstract List<Pais> consultar_Todos();

}