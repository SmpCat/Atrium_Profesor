package com.atrium.modelo;

/**
 * DTO -- Persistencia de DATOS.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-9-2016.
 *
 */
public class Datos_DTO {
	// PROPIEDADES DE CLASE
	private String fecha;
	private String autor;
	private String nombre;
	private String calle;
	private String apellido;
	private String ciudad;

	// METODOS ACCESORES
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
