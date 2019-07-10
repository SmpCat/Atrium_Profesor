package com.atrium.formbean;

import org.apache.struts.action.ActionForm;

public class Login_Bean extends ActionForm {

	private String nombre;
	private String clave;

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
