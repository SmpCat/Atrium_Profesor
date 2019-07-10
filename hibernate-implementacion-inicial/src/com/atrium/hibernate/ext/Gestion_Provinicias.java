package com.atrium.hibernate.ext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Gestion_Provinicias {

	private ProvinciasDAO provincia_DAO;

	public Gestion_Provinicias() {
		provincia_DAO = new ProvinciasDAO();
	}

	public List<Municipios> consultar_MunicipiosEnProvincia(
			Provincias provincia_sinmunicipios) {
		Provincias provincia = provincia_DAO.findById(provincia_sinmunicipios
				.getCodigoProvincia());
		Set<Municipios> municipios = provincia.getMunicipios();
		List<Municipios> lista_muni = new ArrayList<Municipios>(0);
		// CARGAMOS LA INFORMACION NECESARIA DE LA CONSULTA
		for (Municipios municipio : municipios) {
			Municipios municipio_nuevo = new Municipios();
			municipio_nuevo.setMunicipio(municipio.getMunicipio());
			municipio_nuevo.setProvincia(municipio.getProvincia());
			MunicipiosId id = new MunicipiosId();
			id.setCodigoMunicipio(municipio.getId().getCodigoMunicipio());
			id.setProvincia(municipio.getId().getProvincia());
			municipio_nuevo.setId(id);
			lista_muni.add(municipio_nuevo);
		}
		provincia_DAO.getSession().close();
		return lista_muni;
	}

	public Provincias consultar_PorClave(Byte codigo_provincia) {
		Provincias provincia = provincia_DAO.findById(codigo_provincia);
		provincia_DAO.getSession().close();
		return provincia;
	}

	public List<Provincias> consultar_Todas() {
		List<Provincias> lista = provincia_DAO.findAll();
		provincia_DAO.getSession().close();
		return lista;
	}
}
