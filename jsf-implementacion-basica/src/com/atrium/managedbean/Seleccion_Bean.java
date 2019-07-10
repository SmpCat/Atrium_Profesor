package com.atrium.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.Pais;
import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.IGestion_Municipios;
import com.atrium.hibernate.modelo.IGestion_Pais;
import com.atrium.hibernate.modelo.IGestion_Provincias;

/**
 * Proceso para el uso de listas dinamicas en JSF.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0
 * @since 10-1-2017.
 * 
 */
@ManagedBean(name = "seleccion_bean")
@ViewScoped
public class Seleccion_Bean implements Serializable {
	// CONTENIDO DE TEXTO DEL COMBO DE PROVINCIAS
	private String texto_provincia;
	private String texto_municipios;
	// PROPIEDADES CON LA SELECCION DEL USUARIO
	private String provincia_seleccionada;
	private String pais_seleccionado;
	private String municipio_seleccionado;
	// PROPIEDADES DE CONTENIDO DE COMBOS
	private List<SelectItem> lista_paises;
	private List<SelectItem> lista_provincias;
	private List<SelectItem> lista_municipios;
	// FACHADAS DE LA CAPA MODELO
	@ManagedProperty(value = "#{gestion_pais}")
	private IGestion_Pais gestion_pais;
	@ManagedProperty(value = "#{gestion_provincias}")
	private IGestion_Provincias gestion_provincias;
	@ManagedProperty(value = "#{gestion_municipios}")
	private IGestion_Municipios gestion_municipios;

	public Seleccion_Bean() {
		System.out.println("soy seleccion bean");
		// VALORES INICIALES DE PROVINCIAS
		texto_provincia = "Seleccione un pais";
		lista_provincias = new ArrayList<>(0);
		// VALORES INICIALES DE MUNICIPIOS
		texto_municipios = "Seleccione un pais";
		lista_municipios = new ArrayList<>(0);
	}

	/**
	 * Proceso de carga automatica de la lista de paises.
	 */
	@PostConstruct
	public void crear_ListaPaises() {
		// CONSULTA A LA BASE DE DATOS
		List<Pais> lista = gestion_pais.consultar_Todos();
		lista_paises = new ArrayList<>(0);
		SelectItem opcion_nueva;
		// CARGA DE DATOS EN EL MODELO DEL COMBO
		for (Pais pais : lista) {
			opcion_nueva = new SelectItem();
			opcion_nueva.setValue(pais.getCodigoPais().toString());
			opcion_nueva.setLabel(pais.getPaisNombre());
			lista_paises.add(opcion_nueva);
		}
	}

	/**
	 * Proceso de carga dinamica del combo de provincias.
	 * 
	 * @param evento
	 *            Evento producido por el combo de paises.
	 */
	public void carga_Provincias(ValueChangeEvent evento) {
		// SE RECIBE EL VALOR SELECCIONADO POR EL EVENTO
		String pais_seleccionado = (String) evento.getNewValue();
		SelectItem opcion = null;
		lista_provincias.clear();
		lista_municipios.clear();
		// SE CONSULTA A LA BD. SI ES ESPAÑA
		if (pais_seleccionado.equals("73")) {
			// ESPAÑA
			// MODIFICACION DEL TEXTO INICIAL DEL COMBO
			texto_provincia = "Seleccione una provincia";
			texto_municipios = "Seleccione una provincia";
			// CONSULTAMOS LA INFORMACION A LA FUENTE DE DATOS
			List<Provincias> lista = gestion_provincias.comsultar_Todos();
			// CREAMOS DINAMICAMENTE EL CONTENIDO DE LA LISTA
			for (Provincias provincia : lista) {
				opcion = new SelectItem();
				opcion.setLabel(provincia.getProvincia());
				opcion.setValue(provincia.getCodigoProvincia());
				lista_provincias.add(opcion);
			}
		} else {
			// CUALQUIER OTRO PAIS
			// REINICAMOS LAS LISTAS DE PROVINCIAS Y MUNICIPIOS A VALORES
			// INICIALES
			texto_provincia = "Seleccione un pais";
			texto_municipios = "Seleccione un pais";
		}
	}

	/**
	 * Proceso de carga de municipios de una provincia concreta.
	 * 
	 * @param evento
	 */
	public void cargar_Municipios(ValueChangeEvent evento) {
		// SE RECIBE EL VALOR SELECCIONADO POR EL EVENTO
		String provincia_seleccionado = (String) evento.getNewValue();
		SelectItem opcion = null;
		lista_municipios.clear();
		texto_municipios = "Seleccione un municipio";
		// SE CONSULTA A LA BD.
		List<Municipios> lista_muni = gestion_municipios
				.consultar_PorProvincias(new Byte(provincia_seleccionado));
		for (Municipios muni : lista_muni) {
			opcion = new SelectItem();
			opcion.setLabel(muni.getMunicipio());
			opcion.setValue(muni.getId().getCodigoMunicipio());
			lista_municipios.add(opcion);
		}
	}

	// ACCESORES PARA JSF
	public List<SelectItem> getLista_paises() {
		return lista_paises;
	}

	public void setLista_paises(List<SelectItem> lista_paises) {
		this.lista_paises = lista_paises;
	}

	public String getPais_seleccionado() {
		return pais_seleccionado;
	}

	public void setPais_seleccionado(String pais_seleccionado) {
		this.pais_seleccionado = pais_seleccionado;
	}

	public String getProvincia_seleccionada() {
		return provincia_seleccionada;
	}

	public void setProvincia_seleccionada(String provincia_seleccionada) {
		this.provincia_seleccionada = provincia_seleccionada;
	}

	public List<SelectItem> getLista_provincias() {
		return lista_provincias;
	}

	public void setLista_provincias(List<SelectItem> lista_provincias) {
		this.lista_provincias = lista_provincias;
	}

	public String getTexto_provincia() {
		return texto_provincia;
	}

	public void setTexto_provincia(String texto_provincia) {
		this.texto_provincia = texto_provincia;
	}

	public String getTexto_municipios() {
		return texto_municipios;
	}

	public void setTexto_municipios(String texto_municipios) {
		this.texto_municipios = texto_municipios;
	}

	public String getMunicipio_seleccionado() {
		return municipio_seleccionado;
	}

	public void setMunicipio_seleccionado(String municipio_seleccionado) {
		this.municipio_seleccionado = municipio_seleccionado;
	}

	public List<SelectItem> getLista_municipios() {
		return lista_municipios;
	}

	public void setLista_municipios(List<SelectItem> lista_municipios) {
		this.lista_municipios = lista_municipios;
	}

	// ACCESORES PARA SPRING
	public void setGestion_pais(IGestion_Pais gestion_pais) {
		this.gestion_pais = gestion_pais;
	}

	public void setGestion_provincias(IGestion_Provincias gestion_provincias) {
		this.gestion_provincias = gestion_provincias;
	}

	public void setGestion_municipios(IGestion_Municipios gestion_municipios) {
		this.gestion_municipios = gestion_municipios;
	}

}
