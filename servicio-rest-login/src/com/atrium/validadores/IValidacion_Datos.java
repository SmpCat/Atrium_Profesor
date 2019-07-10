package com.atrium.validadores;

import com.atrium.excepciones.Validacion_Exception;
import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.respuesta.ICodigos_Error;

public interface IValidacion_Datos {

	/**
	 * Reglas de validacion para las operaciones del servicio.</br> 1º El nombre
	 * del usuario es obligatorio, no puede venir en blanco o nulo.</br> 2º La
	 * clave del usuario es obligatorio, no puede venir en blanco o nulo.</br>3º
	 * El tamaño maximo del campo usuarioes 20 y el de clave 10.
	 * 
	 * @param usuario_aconsultar
	 *            Objeto usuario a validar.
	 * @return
	 */
	public void validar_Datos(Usuarios usuario_aconsultar)
			throws Validacion_Exception;

	public abstract void validar_CrudUsuarios(Usuarios usuario_crud)
			throws Validacion_Exception;

	public abstract void validar_CrudTareas(Tareas tarea_crud)
			throws Validacion_Exception;

	public abstract void validar_CrudRoles(Roles rol_crud)
			throws Validacion_Exception;

}