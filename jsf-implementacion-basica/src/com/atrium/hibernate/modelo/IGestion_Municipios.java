package com.atrium.hibernate.modelo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Municipios;

public interface IGestion_Municipios {

	public List<Municipios> consultar_PorProvincias(Byte codigo_provincia);

}