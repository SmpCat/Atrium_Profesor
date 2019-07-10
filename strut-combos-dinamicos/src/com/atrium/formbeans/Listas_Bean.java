package com.atrium.formbeans;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.modelo.IGestion_Pais;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Combo_Objeto;

/**
 * Objeto de dominio del ejemplo de listas.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 3-11-2017.
 * 
 */
public class Listas_Bean extends ActionForm {
	// PAIS SELECCIONADO POR EL USUARIO
	private String pais_seleccionado;
	// PROVINCIA SELECCIONADA
	private String provincia_seleccionada;

	// CONTENIDO DEL COMBO PAIS
	private List<Combo_Objeto> lista_paises;
	// CONTENIDO DEL COMBO PROVINCIAS
	private List<Combo_Objeto> lista_provincias;

	/**
	 * Carga inicial de los combos de la pagina.
	 */
	public Listas_Bean() {
		// CARGA DINAMICA DE COMBO DE PAIS
		lista_paises = new ArrayList<>();
		// CONSULTA A LA BASE DE DATOS
		List<Pais> lista = Acceso_ApplicationContext.getBean(
				IGestion_Pais.class).consultar_OrdenadosPorNombre();
		// OPCION INICIAL POR DEFECTO EN EL COMBO
		Combo_Objeto opcion = new Combo_Objeto();
		opcion.setTexto_combo("Seleccione un pais");
		opcion.setValor_combo("-1");
		lista_paises.add(opcion);
		// CARGA DE LA INFORMACION DE LOS PAISES
		for (Pais pais : lista) {
			opcion = new Combo_Objeto();
			opcion.setTexto_combo(pais.getPaisNombre());
			opcion.setValor_combo(String.valueOf(pais.getCodigoPais()));
			lista_paises.add(opcion);
		}
		// VALOR INICIAL DEL COMBO PROVINCIAS
		lista_provincias = new ArrayList<>();
		opcion = new Combo_Objeto();
		opcion.setTexto_combo("Seleccione previamente un pais");
		opcion.setValor_combo("0");
		lista_provincias.add(opcion);
	}

	// ACCESORES PARA STRUT
	public String getPais_seleccionado() {
		return pais_seleccionado;
	}

	public void setPais_seleccionado(String pais_seleccionado) {
		this.pais_seleccionado = pais_seleccionado;
	}

	public List<Combo_Objeto> getLista_paises() {
		return lista_paises;
	}

	public void setLista_paises(List<Combo_Objeto> lista_paises) {
		this.lista_paises = lista_paises;
	}

	public String getProvincia_seleccionada() {
		return provincia_seleccionada;
	}

	public void setProvincia_seleccionada(String provincia_seleccionada) {
		this.provincia_seleccionada = provincia_seleccionada;
	}

	public List<Combo_Objeto> getLista_provincias() {
		return lista_provincias;
	}

	public void setLista_provincias(List<Combo_Objeto> lista_provincias) {
		this.lista_provincias = lista_provincias;
	}

}
