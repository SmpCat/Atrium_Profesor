package com.atrium.negocio;

public interface ILogica_ListasAJAX {

	public String consultar_Paises();

	public String consultar_Provincias(String codigo_pais);

	public String consultar_Municipios(String codigo_municipio);

}