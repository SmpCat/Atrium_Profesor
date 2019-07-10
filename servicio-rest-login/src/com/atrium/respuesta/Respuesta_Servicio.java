package com.atrium.respuesta;

import java.util.List;
import java.util.Map;

import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;

/**
 * Conjunto de propiedades para crear la respuesta al cliente que se comunique
 * con el servicio.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1.
 * @since 14-2-2018.
 * 
 */
public class Respuesta_Servicio implements ICodigos_Error {
	// PROPIEDADES DE CLASE
	// *** DATOS PEDIDOS EN LA OPERACION
	private Boolean valor_booleano;
	private Usuarios usuario;
	private Roles rol;
	private List<Tareas> tareas;
	// *** PROPIEDADES PARA LA CONFIRMACION/ERROR DE LA OPERACION
	private String mensaje;
	private Integer codigo_error;
	// *** ERRORES DEL ACCESO A LA BASE DE DATOS
	private Map<Integer, Map<String, String>> mapa_erroresbd;

	// CONSTRUCTORES
	public Respuesta_Servicio() {
		valor_booleano = new Boolean(false);
	}

	public Respuesta_Servicio(boolean valor) {
		valor_booleano = new Boolean(valor);
	}

	// ACCESORES PROPIEDADES
	public Boolean getValor_booleano() {
		return valor_booleano;
	}

	public void setValor_booleano(Boolean valor_booleano) {
		this.valor_booleano = valor_booleano;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getCodigo_error() {
		return codigo_error;
	}

	public void setCodigo_error(Integer codigo_error) {
		this.codigo_error = codigo_error;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	public List<Tareas> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tareas> tareas) {
		this.tareas = tareas;
	}

	public Map<Integer, Map<String, String>> getMapa_erroresbd() {
		return mapa_erroresbd;
	}

	public void setMapa_erroresbd(
			Map<Integer, Map<String, String>> mapa_erroresbd) {
		this.mapa_erroresbd = mapa_erroresbd;
	}

}
