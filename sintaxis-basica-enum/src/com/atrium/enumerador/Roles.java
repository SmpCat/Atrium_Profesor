package com.atrium.enumerador;

import java.util.Date;

/**
 * Ejemplo de definicion de Enum en Java.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-2-2017.
 *
 */
public enum Roles {

	// ************ DISTINTOS VALORES (INSTANCIAS) DEL ENUM ROLES
	USUARIO("usuario", 10, new Date(), "es", "lamia"),
	ADMINISTRADOR("administrador", 20, new Date(), "fr","otracarpeta"),
	CLIENTE("cliente", 30, new Date(), "en","carpeta_cliente"),
	VENDEDOR("vendedor", 40, new Date(), "es", "carpeta_ventas");

	// ************PROPIEDADES DEL ENUM ROLES
	private String nombre_rol;
	private int codigo_rol;
	private Date fecha_creacion;
	private String idioma;
	private String carpeta_documentacion;

	/**
	 * Constructor para recibir la informacion de cada valor del Enum.
	 * 
	 * @param nombre_rol
	 * @param codigo_rol
	 * @param fecha_creacion
	 * @param idioma
	 * @param carpeta_documentacion
	 */
	private Roles(String nombre_rol, int codigo_rol, Date fecha_creacion, String idioma, String carpeta_documentacion) {
		this.nombre_rol = nombre_rol;
		this.codigo_rol = codigo_rol;
		this.fecha_creacion = fecha_creacion;
		this.idioma = idioma;
		this.carpeta_documentacion = carpeta_documentacion;
	}

	// ACCESORES DE LAS PROPIEDADES
	public String getNombre_rol() {
		return nombre_rol;
	}

	public int getCodigo_rol() {
		return codigo_rol;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getCarpeta_documentacion() {
		return carpeta_documentacion;
	}

}
