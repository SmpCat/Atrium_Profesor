package com.atrium.formbeans;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.atrium.util.Combo_Objeto;

/**
 * Procesos de gestion de datos en la peticiones de gestion de usuarios. <br/>
 * Se contempla validacion, reinicio de formulario y conversion de tipos,
 * incluidos los correspondientes mensajes de error idiomatizados.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 3-11-2017.
 * 
 */
public class Usuario_Bean extends ActionForm {
	// PROPIEDADES DEL FORMULARIO
	private String nombre;
	private String clave;
	private String fecha_alta;
	private String fecha_baja;
	private String carpeta;
	private String rol_usuario;
	private String idioma;
	// BOTON/CONTROL DE LA ACCION DEL FORMULARIO
	private String boton;
	private String boton2;

	private List<Combo_Objeto> lista_roles;

	// PROPIEDADES PARA EL CONTROL DEL ESTADO DE LOS BOTONES
	private Boolean habilitar;
	private Boolean habilitaralta;

	/**
	 * Constructor donde se cargan los valores iniciales del formulario,
	 * incluido la carga dinamica del combo de roles.
	 */
	public Usuario_Bean() {
		lista_roles = new ArrayList<>(0);
		Combo_Objeto opcion = new Combo_Objeto();
		opcion.setTexto_combo("prueba uno");
		opcion.setValor_combo("0");
		lista_roles.add(opcion);
		opcion = new Combo_Objeto();
		opcion.setTexto_combo("prueba dos");
		opcion.setValor_combo("0");
		lista_roles.add(opcion);
	}

	// ACCESORES PARA STRUT
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public String getRol_usuario() {
		return rol_usuario;
	}

	public void setRol_usuario(String rol_usuario) {
		this.rol_usuario = rol_usuario;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getBoton() {
		return boton;
	}

	public void setBoton(String boton) {
		this.boton = boton;
	}

	public String getBoton2() {
		return boton2;
	}

	public void setBoton2(String boton2) {
		this.boton2 = boton2;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public Boolean getHabilitaralta() {
		return habilitaralta;
	}

	public void setHabilitaralta(Boolean habilitaralta) {
		this.habilitaralta = habilitaralta;
	}

	public List<Combo_Objeto> getLista_roles() {
		return lista_roles;
	}

	public void setLista_roles(List<Combo_Objeto> lista_roles) {
		this.lista_roles = lista_roles;
	}

}
