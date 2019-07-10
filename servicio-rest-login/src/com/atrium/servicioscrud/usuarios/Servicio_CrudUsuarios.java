package com.atrium.servicioscrud.usuarios;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.atrium.excepciones.Conversor_Exception;
import com.atrium.excepciones.Validacion_Exception;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuarios;
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
@Path("/servicio_crudusuario")
public class Servicio_CrudUsuarios {
	// PROPIEDADES PARA LAS OPERACIONES DEL SERVICIO
	private Respuesta_Servicio resultado_operacion;
	// RESPUESTA DEL SERVICIO
	private String respuesta;

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * A continuacion de dara el alta en base de datos.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/alta_usuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio alta_Usuario(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Usuarios.class)
						.alta_Usuario(usuario);
				// ALTA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ALTA_USUARIOCORRECTA);
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
						.setCodigo_error(ICodigos_Error.ALTA_USUARIOINCORRECTA);
				resultado_operacion.setMensaje("Error en el alta");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * A continuacion de dara la baja en base de datos.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/baja_usuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio baja_Usuario(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Usuarios.class)
						.baja_Usuario(usuario);
				// BAJA CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.BAJA_USUARIOCORRECTA);
				resultado_operacion.setMensaje("Baja correcta");
			} catch (Exception e) {
				// TRATAMIENTO PERSONALIZADO DE LOS ERRORES DE SPRING/HIBERNATE
				ITratamiento_ErroresBD error_bd = Acceso_ApplicationContext
						.getBean(ITratamiento_ErroresBD.class);
				Map<Integer, Map<String, String>> mapa_errores = error_bd
						.tratar_SpringException(e);
				// ERROR EN EL BAJA
				resultado_operacion.setMapa_erroresbd(mapa_errores);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.BAJA_USUARIOINCORRECTA);
				resultado_operacion.setMensaje("Error en la baja");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * A continuacion de dara la modificacion en base de datos.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/modificacion_usuario")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio modificacion_Usuario(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			try {
				Acceso_ApplicationContext.getBean(IGestion_Usuarios.class)
						.modificion_Usuario(usuario);
				// MODIFICACION CORRECTA
				resultado_operacion
						.setCodigo_error(ICodigos_Error.MODIFICACION_USUARIOCORRECTA);
				resultado_operacion.setMensaje("Modificacion echa");
			} catch (Exception e) {
				// TRATAMIENTO PERSONALIZADO DE LOS ERRORES DE SPRING/HIBERNATE
				ITratamiento_ErroresBD error_bd = Acceso_ApplicationContext
						.getBean(ITratamiento_ErroresBD.class);
				Map<Integer, Map<String, String>> mapa_errores = error_bd
						.tratar_SpringException(e);
				// ERROR EN EL BAJA
				resultado_operacion.setMapa_erroresbd(mapa_errores);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.MODIFICACION_USUARIOINCORRECTA);
				resultado_operacion.setMensaje("Error en la modificacion");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Proceso auxiliar para todas las operaciones del servicio. Llama a la
	 * operacion de conversion y validacion.
	 * 
	 * @param usuario
	 *            String mandado por el cliente.
	 * @return Indicador se si continuar con la operacion o no.
	 */
	private boolean inicio_Operacion(Usuarios usuario) {
		// PROPIEDADES PARA EL PROCESO
		// RESPUESTA DEL SERVICIO
		respuesta = null;
		resultado_operacion = new Respuesta_Servicio(false);
		// BANDERA DE VALIDACION
		boolean valido = true;
		// VALIDACION DE DATOS
		if (usuario != null) {
			IValidacion_Datos validacion = Acceso_ApplicationContext
					.getBean(IValidacion_Datos.class);
			try {
				validacion.validar_CrudUsuarios(usuario);
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
