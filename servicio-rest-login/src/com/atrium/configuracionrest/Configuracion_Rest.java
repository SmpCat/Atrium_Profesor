package com.atrium.configuracionrest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.atrium.serviciologin.Servicio_Login;
import com.atrium.servicioscrud.roles.Servicio_CrudRoles;
import com.atrium.servicioscrud.tareas.Servicio_CrudTareas;
import com.atrium.servicioscrud.usuarios.Servicio_CrudUsuarios;

/**
 * Ejemplo de configuracion de multiples servicios REST en la misma aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 15-2-2018.
 *
 */
@ApplicationPath("jaxrs")
public class Configuracion_Rest extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(Servicio_Login.class);
		classes.add(Servicio_CrudRoles.class);
		classes.add(Servicio_CrudTareas.class);
		classes.add(Servicio_CrudUsuarios.class);
		return classes;
	}
}