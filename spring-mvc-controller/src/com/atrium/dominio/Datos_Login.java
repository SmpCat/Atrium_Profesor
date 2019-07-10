package com.atrium.dominio;


/**
 * Clase que representa los datos de la peticion, objeto de dominio. Segunda
 * version con anotaciones.<br/>
 * Se precisa añadir dos jar al proyecto. <br/>
 * 1º El de javax para la definicion de las anotaciones.<br/>
 * 2º La implementacion concreta de las mismas, en este caso la de hibernate 4.1
 * (como con JPA).
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1
 * @since 7-2-2017.
 * 
 */
public class Datos_Login {
	// PROPIEDADES PARA TRATAR LA INFORMACION DEL FORMULARIO
	private String nombre_usuario;
	private String clave;

	// ACCESORES PARA SPRING MVC
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
