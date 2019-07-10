package com.atrium.hibernate.modelo;

import java.util.List;

import com.atrium.hibernate.Municipios;

public interface IGestion_Municipios {

	public List<Municipios> consultar_PorProviincia(Byte codigo_provincia);

}