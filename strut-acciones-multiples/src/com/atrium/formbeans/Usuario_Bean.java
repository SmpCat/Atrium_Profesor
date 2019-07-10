package com.atrium.formbeans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Procesos de gestion de datos en la peticiones de gestion de usuarios. <br/>
 * Se contempla validacion, reinicio de formulario y conversion de tipos,
 * incluidos los correspondientes mensajes de error idiomatizados.</br> Se
 * incluye conversion de tipos dentro del ciclo de Strut.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.2
 * @since 6-11-2017.
 * 
 */
public class Usuario_Bean extends ActionForm {
	// PROPIEDADES DEL FORMULARIO
	private String boton;

	/**
	 * En la validacion devolveremos tanto los errores de la conversion como de
	 * la validacion.<br/>
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest peticion) {
		ActionErrors errores = new ActionErrors();
		System.out.println("SOY LA VALIDACION DE USUARIOS BEAN");
		return errores;
	}

	// ACESORES PARA STRUT
	public String getBoton() {
		return boton;
	}

	public void setBoton(String boton) {
		this.boton = boton;
	}

}
