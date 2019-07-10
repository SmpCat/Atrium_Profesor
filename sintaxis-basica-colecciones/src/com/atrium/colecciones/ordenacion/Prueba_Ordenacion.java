package com.atrium.colecciones.ordenacion;

import java.util.Date;

/**
 * Ejemplo de tipo propio para su ordenacion dentro de la coleccion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Prueba_Ordenacion {
	// PROPIEDADES DE CLASE
	private String texto;
	private Integer numero;
	private Date fecha;

	// ACCESORES PARA LAS PROPIEDADES
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
