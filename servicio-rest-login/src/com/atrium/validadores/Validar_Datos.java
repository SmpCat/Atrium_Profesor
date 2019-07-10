package com.atrium.validadores;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.atrium.excepciones.Validacion_Exception;
import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.respuesta.ICodigos_Error;

/**
 * Reglas de validacion a aplicar a las operaciones del servicio.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 14-2-2018.
 * 
 */
@Component("validar_datos")
@Scope("prototype")
public class Validar_Datos implements IValidacion_Datos {

	/**
	 * Reglas de validacion para las operaciones del servicio.<br/>
	 * 1º El nombre del usuario es obligatorio, no puede venir en blanco o nulo.<br/>
	 * 2º La clave del usuario es obligatorio, no puede venir en blanco o nulo.<br/>
	 * 3º El tamaño maximo del campo usuarioes 20 y el de clave 10.
	 * 
	 * @param usuario_aconsultar
	 *            Objeto usuario a validar.
	 * @throws Validacion_Exception
	 *             Excepcion en el proceso de validacion
	 *             {@link Validacion_Exception}
	 */
	@Override
	public void validar_Datos(Usuarios usuario_aconsultar)
			throws Validacion_Exception {
		// REGLAS DE VALIDACION PARA EL NOMBRE DE USUARIO
		if (usuario_aconsultar.getNombreUsuario() == null) {
			throw new Validacion_Exception(
					"El nombre del usuario no puede estar nulo",
					ICodigos_Error.ERROR_VALIDACIONNOMBRENULO);
		} else if (usuario_aconsultar.getNombreUsuario().equals("")) {
			throw new Validacion_Exception(
					"El nombre del usuario no puede ser una cadena vacia",
					ICodigos_Error.ERROR_VALIDACIONNOMBREVACIO);
		} else if (usuario_aconsultar.getNombreUsuario().length() > 20) {
			throw new Validacion_Exception(
					"El nombre del usuario tiene mas caracteres de los permitidos, maximo 20.",
					ICodigos_Error.ERROR_VALIDACIONTAMNOMBRE);
		}
		// REGLAS DE VALIDACION PARA LA CLAVE DEL USUARIO
		if (usuario_aconsultar.getPassword() == null) {
			throw new Validacion_Exception("La clave no puede estar nula",
					ICodigos_Error.ERROR_VALIDACIONCLAVENULO);
		} else if (usuario_aconsultar.getPassword().equals("")) {
			throw new Validacion_Exception(
					"La clave no puede ser una cadena vacia",
					ICodigos_Error.ERROR_VALIDACIONCLAVEVACIA);
		} else if (usuario_aconsultar.getPassword().length() > 10) {
			throw new Validacion_Exception(
					"La clave tiene mas caracteres de los permitidos, maximo 10.",
					ICodigos_Error.ERROR_VALIDACIONTAMCLAVE);
		}
	}

	@Override
	public void validar_CrudUsuarios(Usuarios usuario_crud)
			throws Validacion_Exception {
		// REGLAS DE VALIDACION PARA EL NOMBRE DE USUARIO
		if (usuario_crud.getNombreUsuario() == null) {
			throw new Validacion_Exception(
					"El nombre del usuario no puede estar nulo",
					ICodigos_Error.ERROR_VALIDACIONNOMBRENULO);
		} else if (usuario_crud.getNombreUsuario().equals("")) {
			throw new Validacion_Exception(
					"El nombre del usuario no puede ser una cadena vacia",
					ICodigos_Error.ERROR_VALIDACIONNOMBREVACIO);
		} else if (usuario_crud.getNombreUsuario().length() > 20) {
			throw new Validacion_Exception(
					"El nombre del usuario tiene mas caracteres de los permitidos, maximo 20.",
					ICodigos_Error.ERROR_VALIDACIONTAMNOMBRE);
		}
		// REGLA DE VALIDACION PARA LA FECHA DE BAJA (ALTAS-MODIFICACIONES)
		if (usuario_crud.getFechaBaja() != null) {
			if (!usuario_crud.getFechaAlta()
					.before(usuario_crud.getFechaBaja())) {
				throw new Validacion_Exception(
						"La fecha de baja debe de ser posterior a la fecha de alta",
						ICodigos_Error.ERROR_VALIDACIONFECHASUSUARIOS);
			}
		}
	}

	@Override
	public void validar_CrudRoles(Roles rol_crud) throws Validacion_Exception {
		if (rol_crud.getCodigoRol() == null) {
			throw new Validacion_Exception(
					"Es obligatorio la clave dentro del rol",
					ICodigos_Error.ERROR_VALIDACIONCLAVEROLVACIA);
		}
	}

	@Override
	public void validar_CrudTareas(Tareas tarea_crud)
			throws Validacion_Exception {
		if (tarea_crud.getCodigoTarea() == null) {
			throw new Validacion_Exception(
					"Es obligatorio la clave dentro de la tarea",
					ICodigos_Error.ERROR_VALIDACIONCLAVETAREAVACIA);
		}
	}
}
