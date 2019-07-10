package com.atrium.configuracion;

import java.util.Date;

/**
 * Clase para transporte de datos del fichero de configuracion a la aplicacion.
 * <br/>
 * Añade la gestion de color de fondo en los campos de texto.
 * 
 * @author Juan Antonio Solves Garcia.
 * @serial 2.2
 * @since 12-4-2016.
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
	private String ruta_imagenes;

	private String idioma;
	private String idioma_preferido;
	private String idioma_defecto;
	private String permitir_idioma;
	private String modo_ejecucion;
	private String color_fondo;

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

	public String getRuta_imagenes() {
		return ruta_imagenes;
	}

	public void setRuta_imagenes(String ruta_imagenes) {
		this.ruta_imagenes = ruta_imagenes;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
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

	public String getColor_fondo() {
		return color_fondo;
	}

	public void setColor_fondo(String color_fondo) {
		this.color_fondo = color_fondo;
	}

	// METODO PARA COMPROBACION EN PRUEBAS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Configuracion_DTO other = (Configuracion_DTO) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (color_fondo == null) {
			if (other.color_fondo != null)
				return false;
		} else if (!color_fondo.equals(other.color_fondo))
			return false;
		if (fecha_actualizacion == null) {
			if (other.fecha_actualizacion != null)
				return false;
		} else if (!fecha_actualizacion.equals(other.fecha_actualizacion))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (idioma_defecto == null) {
			if (other.idioma_defecto != null)
				return false;
		} else if (!idioma_defecto.equals(other.idioma_defecto))
			return false;
		if (idioma_preferido == null) {
			if (other.idioma_preferido != null)
				return false;
		} else if (!idioma_preferido.equals(other.idioma_preferido))
			return false;
		if (modo_ejecucion == null) {
			if (other.modo_ejecucion != null)
				return false;
		} else if (!modo_ejecucion.equals(other.modo_ejecucion))
			return false;
		if (permitir_idioma == null) {
			if (other.permitir_idioma != null)
				return false;
		} else if (!permitir_idioma.equals(other.permitir_idioma))
			return false;
		if (ruta_ayuda == null) {
			if (other.ruta_ayuda != null)
				return false;
		} else if (!ruta_ayuda.equals(other.ruta_ayuda))
			return false;
		if (ruta_bitacora == null) {
			if (other.ruta_bitacora != null)
				return false;
		} else if (!ruta_bitacora.equals(other.ruta_bitacora))
			return false;
		if (ruta_depuracion == null) {
			if (other.ruta_depuracion != null)
				return false;
		} else if (!ruta_depuracion.equals(other.ruta_depuracion))
			return false;
		if (ruta_enginebirt == null) {
			if (other.ruta_enginebirt != null)
				return false;
		} else if (!ruta_enginebirt.equals(other.ruta_enginebirt))
			return false;
		if (ruta_iconos == null) {
			if (other.ruta_iconos != null)
				return false;
		} else if (!ruta_iconos.equals(other.ruta_iconos))
			return false;
		if (ruta_imagenes == null) {
			if (other.ruta_imagenes != null)
				return false;
		} else if (!ruta_imagenes.equals(other.ruta_imagenes))
			return false;
		if (ruta_listados == null) {
			if (other.ruta_listados != null)
				return false;
		} else if (!ruta_listados.equals(other.ruta_listados))
			return false;
		if (ruta_logsbirt == null) {
			if (other.ruta_logsbirt != null)
				return false;
		} else if (!ruta_logsbirt.equals(other.ruta_logsbirt))
			return false;
		if (ruta_seguridad == null) {
			if (other.ruta_seguridad != null)
				return false;
		} else if (!ruta_seguridad.equals(other.ruta_seguridad))
			return false;
		if (ruta_serializacion == null) {
			if (other.ruta_serializacion != null)
				return false;
		} else if (!ruta_serializacion.equals(other.ruta_serializacion))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((color_fondo == null) ? 0 : color_fondo.hashCode());
		result = prime * result + ((fecha_actualizacion == null) ? 0 : fecha_actualizacion.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((idioma_defecto == null) ? 0 : idioma_defecto.hashCode());
		result = prime * result + ((idioma_preferido == null) ? 0 : idioma_preferido.hashCode());
		result = prime * result + ((modo_ejecucion == null) ? 0 : modo_ejecucion.hashCode());
		result = prime * result + ((permitir_idioma == null) ? 0 : permitir_idioma.hashCode());
		result = prime * result + ((ruta_ayuda == null) ? 0 : ruta_ayuda.hashCode());
		result = prime * result + ((ruta_bitacora == null) ? 0 : ruta_bitacora.hashCode());
		result = prime * result + ((ruta_depuracion == null) ? 0 : ruta_depuracion.hashCode());
		result = prime * result + ((ruta_enginebirt == null) ? 0 : ruta_enginebirt.hashCode());
		result = prime * result + ((ruta_iconos == null) ? 0 : ruta_iconos.hashCode());
		result = prime * result + ((ruta_imagenes == null) ? 0 : ruta_imagenes.hashCode());
		result = prime * result + ((ruta_listados == null) ? 0 : ruta_listados.hashCode());
		result = prime * result + ((ruta_logsbirt == null) ? 0 : ruta_logsbirt.hashCode());
		result = prime * result + ((ruta_seguridad == null) ? 0 : ruta_seguridad.hashCode());
		result = prime * result + ((ruta_serializacion == null) ? 0 : ruta_serializacion.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

}
