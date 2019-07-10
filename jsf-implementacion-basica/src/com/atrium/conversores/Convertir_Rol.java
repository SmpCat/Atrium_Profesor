package com.atrium.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.atrium.hibernate.Roles;

/**
 * Conversor personalizado para jsf.
 * 
 * @author Juan Antonio Solves Garcia.
 * @serial 2.0.
 * @since 28-4-2017.
 * 
 */
public class Convertir_Rol implements Converter {

	/**
	 * Conversion de entrada. De String a Roles.
	 */
	@Override
	public Object getAsObject(FacesContext contexto, UIComponent componente,
			String valor_aconvertir) {
		Roles rol = null;
		if (valor_aconvertir != null && !valor_aconvertir.equals("")) {
			try {
				Byte codigo_rol = new Byte(valor_aconvertir);
				rol = new Roles();
				rol.setCodigoRol(codigo_rol);
			} catch (Exception e) {
				throw new ConverterException(new FacesMessage(
						"El valor dado no es correcto para un rol"));
			}
		}
		return rol;
	}

	/**
	 * Conversion de salida. De Rol a String.
	 */
	@Override
	public String getAsString(FacesContext contexto, UIComponent componente,
			Object rol) {
		String salida = "";
		if (rol != null) {
			Roles rol_salida = (Roles) rol;
			salida = rol_salida.getCodigoRol().toString();
		}
		return salida;
	}

}
