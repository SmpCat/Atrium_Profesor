package com.atrium.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Component;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.Gestion_Usuario;
import com.atrium.hibernate.modelo.IGestion_usuario;

/**
 * Ejemplo de managedbean de apoyo para la vista de datatable.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.5.
 * @since 27-4-2017.
 *
 */
@ManagedBean(name="usuarios_bean")
@ViewScoped
public class DatatableUsuarios_Bean implements Serializable {

	private List<Usuarios> lista_usuarios;
	@ManagedProperty(value="#{gestion_usuario}")
	private IGestion_usuario gestion_usuario;

	private int primera_filapagina;
	private int total_filas;

	public DatatableUsuarios_Bean() {
		System.out.println("Se crea el bean datable");
	}

	@PostConstruct
	public void cargar_Usuarios() {
		// CARGA DE DATOS EN LA PROPIEDAD DEL MANAGEDBEAN
		lista_usuarios = gestion_usuario.consultar_Todos();
		primera_filapagina = 0;
		total_filas = lista_usuarios.size();
	}

	public void pagina_Tabla(ActionEvent evento) {
		if (!(primera_filapagina + 5 > total_filas)) {
			primera_filapagina += 5;
		}
	}

	// ACCESORES PARA JSF
	public List<Usuarios> getLista_usuarios() {
		return lista_usuarios;
	}

	public void setLista_usuarios(List<Usuarios> lista_usuarios) {
		this.lista_usuarios = lista_usuarios;
	}

	public void setGestion_usuario(IGestion_usuario gestion_usuario) {
		this.gestion_usuario = gestion_usuario;
	}

	public IGestion_usuario getGestion_usuario() {
		return gestion_usuario;
	}

	public int getPrimera_filapagina() {
		return primera_filapagina;
	}

	public void setPrimera_filapagina(int primera_filapagina) {
		this.primera_filapagina = primera_filapagina;
	}

}
