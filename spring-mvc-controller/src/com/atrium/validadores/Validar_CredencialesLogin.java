package com.atrium.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.atrium.dominio.Datos_Login;

/**
 * Validador propio para spring MVC 3.X.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 9-6-2016.
 * 
 */
public class Validar_CredencialesLogin implements Validator {

	/**
	 * Comprobacion de tipos previa a la validacion.<br/>
	 * Se ejecuta como paso previo a la llamada al metodo validate.
	 * 
	 * @param objeto_acomprobartipo
	 * 
	 * @return
	 */
	@Override
	public boolean supports(Class<?> objeto_acomprobartipo) {
		boolean valido = false;
		if ((Datos_Login.class.equals(objeto_acomprobartipo))) {
			valido = true;
		}
		return valido;
	}

	/**
	 * Proceso de validacion. Se definiran todas las logicas necesarias para la
	 * comprobacion de los datos. <br/>
	 * La forma de gestionar los mensajes de error es la misma que en la version
	 * anterior.
	 * 
	 * @param credenciales
	 *            Objeto de dominio con la informacion de la peticion a validar.
	 * @param errores
	 *            Objeto de spring que contiene los errores producidos en la
	 *            validacion.
	 */
	@Override
	public void validate(Object credenciales, Errors errores) {
		// CONVERSION DE AL TIPO REAL COMPROBADO EN EL METODO ANTERIOR
		Datos_Login datos_login = (Datos_Login) credenciales;
		// LOGICA DE VALIDACION
		if (datos_login.getNombre_usuario().equals("")) {
			// ERROR EN EL NOMBRE
			errores.rejectValue("nombre_usuario", "login.error.nombrevacio",
					"Nombre vacio");
		} else if (datos_login.getNombre_usuario().length() > 20) {
			// ERROR EN EL TAMAÑO DEL NOMBRE
			errores.rejectValue("nombre_usuario", "login.error.nombregrande",
					"Demasiados caracteres");
		}
		if (datos_login.getClave().equals("")) {
			// ERROR EN LA CLAVE
			errores.rejectValue("clave", "login.error.clavevacia",
					"Clave vacia");
		} else if (datos_login.getClave().length() > 10) {
			// ERROR EN EL TAMAÑO DE LA CLAVE
			errores.rejectValue("clave", "login.error.clavegrande",
					"Clave muy grande");
		}
	}

}
