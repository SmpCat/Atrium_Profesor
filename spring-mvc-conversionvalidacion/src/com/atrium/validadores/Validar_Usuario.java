package com.atrium.validadores;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.atrium.dominio.Datos_Usuario;

/**
 * Procesos de validacion para administracion de usuarios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 17-11-2017.
 * 
 */
@Component("validar_usuarios")
@Scope("prototype")
public class Validar_Usuario implements Validator {

	/**
	 * Comprobacion de tipo previa a la validacion.
	 */
	@Override
	public boolean supports(Class<?> objeto_avalidar) {
		boolean valido = false;
		if (objeto_avalidar != null
				&& Datos_Usuario.class.equals(objeto_avalidar)) {
			valido = true;
		}
		return valido;
	}

	/**
	 * Reglas a cumplir por los datos segun proceso.
	 */
	@Override
	public void validate(Object objeto_avalidar, Errors errores_validacion) {
		Datos_Usuario datos_formulario = (Datos_Usuario) objeto_avalidar;
		// DISTINGUIMOS EL PROCESO PEDIDO POR EL BOTON PULSADO
		// ****** REGLAS PARA ALTA
		if (datos_formulario.getBoton_alta() != null) {
			// LOGICA DE VALIDACION
			if (datos_formulario.getNombreUsuario().equals("")) {
				// ERROR EN EL NOMBRE
				errores_validacion.rejectValue("nombreUsuario",
						"usuario.error.alta.nombre", "Nombre vacio");
			} else if (datos_formulario.getNombreUsuario().length() > 20) {
				// ERROR EN EL TAMAÑO DEL NOMBRE
				errores_validacion.rejectValue("nombreUsuario",
						"usuario.error.alta.nombregrandee",
						"Demasiados caracteres");
			}
			if (datos_formulario.getPassword().equals("")) {
				// ERROR EN LA CLAVE
				errores_validacion.rejectValue("password",
						"usuario.error.alta.clave", "Clave vacia");
			} else if (datos_formulario.getPassword().length() > 10) {
				// ERROR EN EL TAMAÑO DE LA CLAVE
				errores_validacion.rejectValue("password",
						"usuario.error.alta.clavegrande", "Clave muy grande");
			}
			if (datos_formulario.getRoles() == null) {
				// ERROR EN EL ROL
				errores_validacion.rejectValue("roles",
						"usuario.error.alta.rol", "Rol obligatorio");
			}
		}
		// ****** REGLAS PARA BAJA
		if (datos_formulario.getBoton_baja() != null) {
			if (datos_formulario.getNombreUsuario().equals("")) {
				// ERROR EN EL NOMBRE
				errores_validacion.rejectValue("nombreUsuario",
						"usuario.error.baja.nombre", "Nombre vacio");
			} else if (datos_formulario.getNombreUsuario().length() > 20) {
				// ERROR EN EL TAMAÑO DEL NOMBRE
				errores_validacion.rejectValue("nombreUsuario",
						"usuario.error.alta.nombregrandee",
						"Demasiados caracteres");
			}
		}
		// ****** REGLAS PARA MODIFICACION
		if (datos_formulario.getBoton_modificacion() != null) {
			// PENDIENTE DE ESTABLECER REGLAS
		}
		// ****** REGLAS PARA CONSULTA
		if (datos_formulario.getBoton_consulta() != null) {
			if (datos_formulario.getNombreUsuario().equals("")) {
				// ERROR EN EL NOMBRE
				errores_validacion.rejectValue("nombreUsuario",
						"usuario.error.consulta.nombre", "Nombre vacio");
			} else if (datos_formulario.getNombreUsuario().length() > 20) {
				// ERROR EN EL TAMAÑO DEL NOMBRE
				errores_validacion.rejectValue("nombreUsuario",
						"usuario.error.alta.nombregrandee",
						"Demasiados caracteres");
			}
		}
	}
	// **** OPCION DE LOGICA DE VALIDACION PROPIA DE SPRING
	// ValidationUtils.rejectIfEmptyOrWhitespace(errores, "nombre_usuario",
	// "login.error.nombrevacio", "Nombre vacio");
	// ValidationUtils.rejectIfEmptyOrWhitespace(errores, "clave",
	// "login.error.clavegrande", "Clave muy grande");
}
