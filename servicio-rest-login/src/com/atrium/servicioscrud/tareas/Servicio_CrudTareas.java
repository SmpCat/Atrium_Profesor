package com.atrium.servicioscrud.tareas;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.atrium.excepciones.Conversor_Exception;
import com.atrium.excepciones.Validacion_Exception;
import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Roles;
import com.atrium.hibernate.modelo.IGestion_Tareas;
import com.atrium.respuesta.ICodigos_Error;
import com.atrium.respuesta.Respuesta_Servicio;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.ITratamiento_ErroresBD;
import com.atrium.validadores.IValidacion_Datos;

/**
 * Servicio de procesos CRUD para Tareas.
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
@Path("/servicio_crudtareas")
public class Servicio_CrudTareas {
	// PROPIEDADES PARA LAS OPERACIONES DEL SERVICIO
	private Respuesta_Servicio resultado_operacion;
	// RESPUESTA DEL SERVICIO
	private String respuesta;

	@POST
	@Path("/alta_tarea")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio alta_Tareas(Tareas tarea_nueva) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(tarea_nueva);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Tareas.class)
						.alta_Tarea(tarea_nueva);
				// ALTA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ALTA_TAREACORRECTA);
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
						.setCodigo_error(ICodigos_Error.ALTA_TAREAINCORRECTA);
				resultado_operacion.setMensaje("Error en el alta");
			}
		}
		return resultado_operacion;
	}

	@POST
	@Path("/baja_tarea")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio baja_Tareas(Tareas tarea_nueva) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(tarea_nueva);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Tareas.class)
						.baja_Tarea(tarea_nueva);
				// ALTA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.BAJA_TAREACORRECTA);
				resultado_operacion
						.setMensaje("La baja se realizo de forma correcta");
			} catch (Exception e) {
				// TRATAMIENTO PERSONALIZADO DE LOS ERRORES DE SPRING/HIBERNATE
				ITratamiento_ErroresBD error_bd = Acceso_ApplicationContext
						.getBean(ITratamiento_ErroresBD.class);
				Map<Integer, Map<String, String>> mapa_errores = error_bd
						.tratar_SpringException(e);
				// ERROR EN EL ALTA
				resultado_operacion.setMapa_erroresbd(mapa_errores);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.BAJA_TAREAINCORRECTA);
				resultado_operacion.setMensaje("Error en la baja");
			}
		}
		return resultado_operacion;
	}

	@POST
	@Path("/modificacion_tarea")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio modificacion_Tareas(Tareas tarea_nueva) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(tarea_nueva);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Tareas.class)
						.modificacion_Tarea(tarea_nueva);
				// ALTA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.MODIFICACION_TAREACORRECTA);
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
						.setCodigo_error(ICodigos_Error.MODIFICACION_TAREAINCORRECTA);
				resultado_operacion.setMensaje("Error en la modificacion");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Proceso auxiliar para todas las operaciones del servicio. Llama a la
	 * operacion de conversion y validacion.
	 * 
	 * @param tarea
	 *            String mandado por el cliente.
	 * @return Indicador se si continuar con la operacion o no.
	 */
	private boolean inicio_Operacion(Tareas tarea) {
		// PROPIEDADES PARA EL PROCESO
		// RESPUESTA DEL SERVICIO
		respuesta = null;
		resultado_operacion = new Respuesta_Servicio(false);
		// BANDERA DE VALIDACION
		boolean valido = true;
		// VALIDACION DE DATOS
		if (tarea != null) {
			IValidacion_Datos validacion = Acceso_ApplicationContext
					.getBean(IValidacion_Datos.class);
			try {
				validacion.validar_CrudTareas(tarea);
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
