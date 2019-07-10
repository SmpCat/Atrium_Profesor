package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Pais;

public interface IGestion_Pais {

	public List<Pais> consultar_Todos();

	public abstract List<Pais> consultar_OrdenadosPorNombre();

}