package com.atrium.modelo;

import java.util.Date;

/**
 * Clase para transporte de datos del fichero de configuracion a la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @serial 2.1
 * @since 29-6-2015.
 * 
 */
public class Configuracion_DTO {

	// PROPIEDADES DE CLASE
	private Float version;
	private Date fecha_actualizacion;
	private String autor;

	private String ruta_ayuda;
	private String ruta_depuracion;
	private String ruta_seguridad;
	private String ruta_bitacora;
	private String ruta_enginebirt;
	private String ruta_logsbirt;
	private String ruta_listados;
	private String ruta_serializacion;
	private String ruta_iconos;

	private String idioma;
	private String idioma_preferido;
	private String idioma_defecto;
	private String permitir_idioma;
	private String modo_ejecucion;

	// ACCESORES PARA LAS PROPIEDADES
	public Float getVersion() {
		return version;
	}

	public void setVersion(Float version) {
		this.version = version;
	}

	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getRuta_ayuda() {
		return ruta_ayuda;
	}

	public void setRuta_ayuda(String ruta_ayuda) {
		this.ruta_ayuda = ruta_ayuda;
	}

	public String getRuta_depuracion() {
		return ruta_depuracion;
	}

	public void setRuta_depuracion(String ruta_depuracion) {
		this.ruta_depuracion = ruta_depuracion;
	}

	public String getRuta_seguridad() {
		return ruta_seguridad;
	}

	public void setRuta_seguridad(String ruta_seguridad) {
		this.ruta_seguridad = ruta_seguridad;
	}

	public String getRuta_bitacora() {
		return ruta_bitacora;
	}

	public void setRuta_bitacora(String ruta_bitacora) {
		this.ruta_bitacora = ruta_bitacora;
	}

	public String getRuta_enginebirt() {
		return ruta_enginebirt;
	}

	public void setRuta_enginebirt(String ruta_enginebirt) {
		this.ruta_enginebirt = ruta_enginebirt;
	}

	public String getRuta_logsbirt() {
		return ruta_logsbirt;
	}

	public void setRuta_logsbirt(String ruta_logsbirt) {
		this.ruta_logsbirt = ruta_logsbirt;
	}

	public String getRuta_listados() {
		return ruta_listados;
	}

	public void setRuta_listados(String ruta_listados) {
		this.ruta_listados = ruta_listados;
	}

	public String getRuta_serializacion() {
		return ruta_serializacion;
	}

	public void setRuta_serializacion(String ruta_serializacion) {
		this.ruta_serializacion = ruta_serializacion;
	}

	public String getRuta_iconos() {
		return ruta_iconos;
	}

	public void setRuta_iconos(String ruta_iconos) {
		this.ruta_iconos = ruta_iconos;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPermitir_idioma() {
		return permitir_idioma;
	}

	public void setPermitir_idioma(String permitir_idioma) {
		this.permitir_idioma = permitir_idioma;
	}

	public String getModo_ejecucion() {
		return modo_ejecucion;
	}

	public void setModo_ejecucion(String modo_ejecucion) {
		this.modo_ejecucion = modo_ejecucion;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return true;
	}

	public String getIdioma_preferido() {
		return idioma_preferido;
	}

	public void setIdioma_preferido(String idioma_preferido) {
		this.idioma_preferido = idioma_preferido;
	}

	public String getIdioma_defecto() {
		return idioma_defecto;
	}

	public void setIdioma_defecto(String idioma_defecto) {
		this.idioma_defecto = idioma_defecto;
	}

}
