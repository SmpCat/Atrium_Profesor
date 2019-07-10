package com.atrium.formbeans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Ejemplos de defincion de FORMBEAN dentro de Strut1.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 12-12-2016.
 */
public class Ejemplo_Formbean extends ActionForm {

	// PROPIEDADES PARA RECIBIR LOS PARAMETROS DE LA PETICION
	private String nombre;
	private String clave;

	/**
	 * Proceso de inicio de los datos (estado) en el servidor.
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// VALORES INICIALES
	}

	/**
	 * Proceso de validacion de la informacion recibidad.
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// LOGICA DE VALIDACION
		return null;
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

}
