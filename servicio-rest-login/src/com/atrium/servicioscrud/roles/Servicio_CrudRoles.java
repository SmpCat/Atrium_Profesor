package com.atrium.servicioscrud.roles;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.atrium.excepciones.Conversor_Exception;
import com.atrium.excepciones.Validacion_Exception;
import com.atrium.hibernate.Roles;
import com.atrium.hibernate.modelo.IGestion_Roles;
import com.atrium.hibernate.modelo.IGestion_Usuarios;
import com.atrium.respuesta.ICodigos_Error;
import com.atrium.respuesta.Respuesta_Servicio;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.ITratamiento_ErroresBD;
import com.atrium.validadores.IValidacion_Datos;

/**
 * Servicio de procesos CRUD para Roles.
 * 
 * Adaptacion a tipo de servicio REST del servicio CRUD de roles.<br/>
 * Se añaden librerias para la conversion por parte del servicio al formato
 * JSON, incluida una dependencia externa no gestionada por MyEclipse.<br/>
 * 
 * @author Juan Antonio Solves Garcia
 * @since 14-2-2018.
 * @version 1.0.
 *
 */
@Path("/servicio_crudroles")
public class Servicio_CrudRoles {
	// PROPIEDADES PARA LAS OPERACIONES DEL SERVICIO
	private Respuesta_Servicio resultado_operacion;
	// RESPUESTA DEL SERVICIO
	private String respuesta;

	@POST
	@Path("/alta_rol")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio alta_Roles(Roles rol_nuevo) {
		// VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(rol_nuevo);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Roles.class)
						.alta_Rol(rol_nuevo);
				// ALTA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ALTA_ROLCORRECTA);
				resultado_operacion
						.setMensaje("El alta se realizo de forma correcta");
			} catch (Exception e) {
				// TRATAMIENTO PERSONALIZADO DE LOS ERRORES DE SPRING/HIBERNATE
				ITratamiento_ErroresBD error_bd = Acceso_ApplicationContext
						.getBean(ITratamiento_ErroresBD.class);
				Map<Integer, Map<String, String>> mapa_errores = error_bd
						.tratar_SpringException(e);
				// ERROR EN EL ALTA
				resultado_operacion.setMapa_erroresbd(mapa_errores);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ALTA_ROLINCORRECTA);
				resultado_operacion.setMensaje("Error en el alta");
			}
		}
		return resultado_operacion;
	}

	@POST
	@Path("/baja_rol")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio baja_Roles(Roles rol_nuevo) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(rol_nuevo);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Roles.class)
						.baja_Rol(rol_nuevo);
				// ALTA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.BAJA_ROLCORRECTA);
				resultado_operacion
						.setMensaje("la baja se realizo de forma correcta");
			} catch (Exception e) {
				// TRATAMIENTO PERSONALIZADO DE LOS ERRORES DE SPRING/HIBERNATE
				ITratamiento_ErroresBD error_bd = Acceso_ApplicationContext
						.getBean(ITratamiento_ErroresBD.class);
				Map<Integer, Map<String, String>> mapa_errores = error_bd
						.tratar_SpringException(e);
				// ERROR EN EL ALTA
				resultado_operacion.setMapa_erroresbd(mapa_errores);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.BAJA_ROLINCORRECTA);
				resultado_operacion.setMensaje("Error en la baja");
			}
		}
		return resultado_operacion;
	}

	@POST
	@Path("/modificacion_rol")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio modificacion_Roles(Roles rol_nuevo) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(rol_nuevo);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Roles.class)
						.modificacion_Rol(rol_nuevo);
				// ALTA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.MODIFICACION_ROLCORRECTA);
				resultado_operacion
						.setMensaje("la modificion se realizo de forma correcta");
			} catch (Exception e) {
				// TRATAMIENTO PERSONALIZADO DE LOS ERRORES DE SPRING/HIBERNATE
				ITratamiento_ErroresBD error_bd = Acceso_ApplicationContext
						.getBean(ITratamiento_ErroresBD.class);
				Map<Integer, Map<String, String>> mapa_errores = error_bd
						.tratar_SpringException(e);
				// ERROR EN EL ALTA
				resultado_operacion.setMapa_erroresbd(mapa_errores);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.MODIFICACION_ROLINCORRECTA);
				resultado_operacion.setMensaje("Error en la modificacion");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Proceso auxiliar para todas las operaciones del servicio. Llama a la
	 * operacion validacion.
	 * 
	 * @param rol
	 *            String mandado por el cliente.
	 * @return Indicador se si continuar con la operacion o no.
	 */
	private boolean inicio_Operacion(Roles rol) {
		// PROPIEDADES PARA EL PROCESO
		// RESPUESTA DEL SERVICIO
		respuesta = null;
		resultado_operacion = new Respuesta_Servicio(false);
		// BANDERA DE VALIDACION
		boolean valido = true;
		// VALIDACION DE DATOS
		if (rol != null) {
			IValidacion_Datos validacion = Acceso_ApplicationContext
					.getBean(IValidacion_Datos.class);
			try {
				validacion.validar_CrudRoles(rol);
			} catch (Validacion_Exception e) {
				// ERROR EN LA VALIDACION
				valido = false;
				resultado_operacion.setCodigo_error(e.getCodigo_error());
				resultado_operacion.setMensaje(e.getMensaje_error());
			}
		} else {
			// ERROR EN LA CONVERSION
			valido = false;
		}
		return valido;
	}

}
