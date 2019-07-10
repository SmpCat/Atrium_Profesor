package com.atrium.serviciologin;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.atrium.excepciones.Conversor_Exception;
import com.atrium.excepciones.Validacion_Exception;
import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuarios;
import com.atrium.respuesta.ICodigos_Error;
import com.atrium.respuesta.Respuesta_Servicio;
import com.atrium.spring.Acceso_ApplicationContext;
import com.atrium.util.Eliminacion_CargasVagas;
import com.atrium.util.IEliminacion_CargasVagas;
import com.atrium.validadores.IValidacion_Datos;

/**
 * Servicio de consultas de informacion sobre usuarios.
 * <ul>
 * <li>
 * Comprobacion de credenciales.</li>
 * <li>
 * Obtencion del perfil de datos del usuario</li>
 * <li>
 * Obtencion del rol concreto del usuario</li>
 * <li>
 * Lista de tareas a realizar por el usuario.</li>
 * </ul>
 * Adaptacion a tipo de servicio REST del servicio de login.<br/>
 * Se añaden librerias para la conversion por parte del servicio al formato
 * JSON, incluida una dependencia externa no gestionada por MyEclipse.<br/>
 * 
 * @PATH URL concreta de las peticiones a responder por los metodos de esta
 *       clase.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.1.
 * @since 14-2-2018.
 */
@Path("/servicio_login")
public class Servicio_Login {
	// PROPIEDADES PARA LAS OPERACIONES DEL SERVICIO
	private Usuarios usuario_nuevo;
	private IGestion_Usuarios gestion_usuarios;
	private IValidacion_Datos validador;
	private IEliminacion_CargasVagas limpia_cargasvagas;
	private Respuesta_Servicio resultado_operacion;
	// RESPUESTA DEL SERVICIO
	private String respuesta;

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * En caso de ser correcto se devolvera valor booleano indicando si las
	 * credenciales son validas o no.<br/>
	 * 
	 * La respuesta es objeto respuesta_servicio que engloba toda la informacion
	 * posible. Dicho objeto se convertira a formato Json antes de ser devuelto.
	 * 
	 * @POST Tipo de peticion del protocolo http que recibira este metodo.
	 * @PATH URL concreta para este metodo.
	 * @PRODUCES Tipo MIME para la respuesta concreta de un cliente rest.
	 * @CONSUMES Tipo MIME para la informacion de la peticion del cliente rest.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/comprobar_credenciales")
	@Consumes("application/json")
	@Produces("application/json")
	public Respuesta_Servicio comprobar_Credenciales(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			// CON LA INFORMACION RECIBIDA SE REALIZA LA CONSULTA EN LA BD.
			Usuarios usuario_consultado = Acceso_ApplicationContext.getBean(
					IGestion_Usuarios.class).consultar_PorNombre(
					usuario.getNombreUsuario());
			if (usuario_consultado != null) {
				// NOMBRE DE USUARIO CORRECTO
				if (usuario_consultado.getPassword().equals(
						usuario.getPassword())) {
					// CREDENCIALES CORRECTAS
					resultado_operacion.setValor_booleano(true);
					resultado_operacion
							.setCodigo_error(ICodigos_Error.USUARIO_CORRECTO);
					resultado_operacion.setMensaje("Credenciales correctas");
				} else {
					// PASSWORD INVALIDO
					resultado_operacion.setValor_booleano(false);
					resultado_operacion
							.setCodigo_error(ICodigos_Error.ERROR_USUARIOCLAVE);
					resultado_operacion
							.setMensaje("La clave dada no es la del usuario");
				}
			} else {
				// ERROR EN NOMBRE
				resultado_operacion.setValor_booleano(false);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ERROR_USUARIOINEXISTENTE);
				resultado_operacion
						.setMensaje("No existe ningun usuario con ese nombre");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * En caso de ser correcto se devolvera el mismo objeto y en caso contrario
	 * un objeto con las propiedades a nulo.
	 * 
	 * La respuesta es objeto respuesta_servicio que engloba toda la informacion
	 * posible. Dicho objeto se convertira a formato Json antes de ser devuelto.<br/>
	 * Se define un tipo de salida concreto para el cliente remoto a partir de
	 * las opciones internas del servicio rest. La conversion con el JsonLib en
	 * la fecha no es compatible.
	 * 
	 * @POST Tipo de peticion del protocolo http que recibira este metodo.
	 * @PATH URL concreta para este metodo.
	 * @PRODUCES Tipo MIME para la respuesta concreta de un cliente rest.
	 * @CONSUMES Tipo MIME para la informacion de la peticion del cliente rest.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/obtener_perfil")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio obtener_Perfil(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			gestion_usuarios = Acceso_ApplicationContext
					.getBean(IGestion_Usuarios.class);
			usuario_nuevo = gestion_usuarios.consultar_PorNombre(usuario
					.getNombreUsuario());
			// COMPROBAMOS EL NOMBRE
			if (usuario_nuevo != null) {
				// COMPROBAMOS LA CLAVE
				if (usuario_nuevo.getPassword().equals(usuario.getPassword())) {
					// EVITAMOS EL ERROR CON LA CARGA VAGA PENDIENTE
					// usuario_nuevo.setRoles(null);
					// ELIMINACION DE LAS CARGAS VAGAS VIA AUXILIAR DE FORMA
					// REFLEXIVA
					limpia_cargasvagas = Acceso_ApplicationContext
							.getBean(IEliminacion_CargasVagas.class);
					limpia_cargasvagas.eliminar_CargasVagas(Usuarios.class,
							usuario_nuevo);
					resultado_operacion.setValor_booleano(true);
					resultado_operacion
							.setCodigo_error(ICodigos_Error.USUARIO_CORRECTO);
					resultado_operacion.setMensaje("Se manda perfil");
					resultado_operacion.setUsuario(usuario_nuevo);
				} else {
					// ERROR DE CLAVE
					resultado_operacion.setValor_booleano(false);
					resultado_operacion
							.setCodigo_error(ICodigos_Error.ERROR_USUARIOCLAVE);
					resultado_operacion
							.setMensaje("La clave dada no es la del usuario");
				}
			} else {
				// ERROR EN NOMBRE
				resultado_operacion.setValor_booleano(false);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ERROR_USUARIOINEXISTENTE);
				resultado_operacion
						.setMensaje("No existe ningun usuario con ese nombre");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * Se devolvera el objeto usuario con el rol cargado.
	 * 
	 * La respuesta es objeto respuesta_servicio que engloba toda la informacion
	 * posible. Dicho objeto se convertira a formato Json antes de ser devuelto.<br/>
	 * Se define un tipo de salida concreto para el cliente remoto a partir de
	 * las opciones internas del servicio rest. La conversion con el JsonLib en
	 * la fecha no es compatible.
	 * 
	 * @POST Tipo de peticion del protocolo http que recibira este metodo.
	 * @PATH URL concreta para este metodo.
	 * @PRODUCES Tipo MIME para la respuesta concreta de un cliente rest.
	 * @CONSUMES Tipo MIME para la informacion de la peticion del cliente rest.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/consultar_Rol")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio consultar_Rol(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			gestion_usuarios = Acceso_ApplicationContext
					.getBean(IGestion_Usuarios.class);
			Usuarios usuario_conrol = gestion_usuarios
					.consultar_UsuarioConROl(usuario.getNombreUsuario());
			// COMPROBAMOS QUE EL ROL A SIDO DEVUELTO (EL USUARIO EXISTE)
			if (usuario_conrol != null) {
				// COMPROBAMOS QUE LA CLAVE ES CORRECTA
				if (usuario.getPassword().equals(usuario_conrol.getPassword())) {
					// USUARIO CON ROL ASIGNADO EN LA BD
					if (usuario_conrol.getRoles() != null) {
						// ELIMINAMOS LAS CARGAS VAGAS DEL ROL ANTES DE
						// SERIALIZAR
						// usuario_conrol.getRoles().setTareases(null);
						// usuario_conrol.getRoles().setUsuarioses(null);
						limpia_cargasvagas = Acceso_ApplicationContext
								.getBean(IEliminacion_CargasVagas.class);
						limpia_cargasvagas.eliminar_CargasEnColecciones(
								Roles.class, usuario_conrol.getRoles());
						resultado_operacion.setValor_booleano(true);
						resultado_operacion
								.setCodigo_error(ICodigos_Error.USUARIO_CORRECTO);
						resultado_operacion
								.setMensaje("Se manda el rol del usuario pedido");
						resultado_operacion.setRol(usuario_conrol.getRoles());
					} else {
						// USUARIO SIN ROL ASIGNADO EN LA BD
						resultado_operacion.setValor_booleano(false);
						resultado_operacion
								.setCodigo_error(ICodigos_Error.ERROR_USUARIOSINROL);
						resultado_operacion
								.setMensaje("El usuario no tiene ningun rol asignado");
					}
				} else {
					// ERROR EN LA CLAVE
					resultado_operacion.setValor_booleano(false);
					resultado_operacion
							.setCodigo_error(ICodigos_Error.ERROR_USUARIOCLAVE);
					resultado_operacion
							.setMensaje("La clave dada no es la del usuario");
				}
			} else {
				// ERROR EN LA OBTENCION DEL ROL (EL USUARIO NO ES CORRECTO)
				resultado_operacion.setValor_booleano(false);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ERROR_USUARIOINEXISTENTE);
				resultado_operacion
						.setMensaje("No existe ningun usuario con ese nombre");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * Se devolvera la coleccion de tareas del usuario concreto en formato JSON.
	 * 
	 * La respuesta es objeto respuesta_servicio que engloba toda la informacion
	 * posible. Dicho objeto se convertira a formato Json antes de ser devuelto.<br/>
	 * Se define un tipo de salida concreto para el cliente remoto a partir de
	 * las opciones internas del servicio rest. La conversion con el JsonLib en
	 * la fecha no es compatible.
	 * 
	 * @POST Tipo de peticion del protocolo http que recibira este metodo.
	 * @PATH URL concreta para este metodo.
	 * @PRODUCES Tipo MIME para la respuesta concreta de un cliente rest.
	 * @CONSUMES Tipo MIME para la informacion de la peticion del cliente rest.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/consultar_tareas")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio consultar_Tareas(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			gestion_usuarios = Acceso_ApplicationContext
					.getBean(IGestion_Usuarios.class);
			Usuarios usuario_acomprobar = gestion_usuarios
					.consultar_UsuarioConTareas(usuario.getNombreUsuario());
			// COMPROBAMOS QUE EL USUARIO ES CORRECTO(EXISTE)
			if (usuario_acomprobar != null) {
				// COMPROBAMOS QUE LA CLAVE SEA CORRECTA
				if (usuario_acomprobar.getPassword().equals(
						usuario.getPassword())) {
					// COMPROBAMOS QUE TENGA ROL ASIGNADO
					if (usuario_acomprobar.getRoles() != null) {
						// SI EL USUARIO ES CORRECTO SE CONSULTAN SUS TAREAS
						List<Tareas> lista_tareas = gestion_usuarios
								.consultar_Tareas(usuario,
										IGestion_Usuarios.ASCENDENTE);
						// COMPROBAMOS QUE EL USUARIO TENGA TAREAS A PARTIR DE
						// SU ROL
						if (!lista_tareas.isEmpty()) {
							// ELIMINAMOS LAS CARGAS VAGAS ANTES DE SERIALIZAR
							limpia_cargasvagas = Acceso_ApplicationContext
									.getBean(IEliminacion_CargasVagas.class);
							for (Tareas tarea : lista_tareas) {
								// tarea.setRoleses(null);
								limpia_cargasvagas
										.eliminar_CargasEnColecciones(
												Tareas.class, tarea);
							}
							resultado_operacion.setValor_booleano(true);
							resultado_operacion
									.setCodigo_error(ICodigos_Error.USUARIO_CORRECTO);
							resultado_operacion
									.setMensaje("Se manda la lista de tareas");
							// OPCION NUEVA
							resultado_operacion.setTareas(lista_tareas);
						} else {
							// USUARIO SIN TAREAS ASIGNADAS
							resultado_operacion.setValor_booleano(false);
							resultado_operacion
									.setCodigo_error(ICodigos_Error.ERROR_USUARIOSINTAREAS);
							resultado_operacion
									.setMensaje("El usuario no tiene ninguna tarea asignada");
						}
					} else {
						// USUARIO SIN ROL ASIGNADO EN LA BD
						resultado_operacion.setValor_booleano(false);
						resultado_operacion
								.setCodigo_error(ICodigos_Error.ERROR_USUARIOSINROL);
						resultado_operacion
								.setMensaje("El usuario no tiene ningun rol asignado");
					}
				} else {
					// ERROR EN LA CLAVE DADA PARA EL USUARIO
					resultado_operacion.setValor_booleano(false);
					resultado_operacion
							.setCodigo_error(ICodigos_Error.ERROR_USUARIOCLAVE);
					resultado_operacion
							.setMensaje("La clave dada no es la del usuario");
				}
			} else {
				// ERROR DE USUARIO INCORRECTO
				resultado_operacion.setValor_booleano(false);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ERROR_USUARIOINEXISTENTE);
				resultado_operacion
						.setMensaje("No existe ningun usuario con ese nombre");
			}
		}
		return resultado_operacion;
	}

	/**
	 * Se recibira una cadena de texto que sera un objeto usuario serializado en
	 * JSON.<br/>
	 * Se devolvera toda la informacion del usuario concreto en formato JSON.
	 * 
	 * La respuesta es objeto respuesta_servicio que engloba toda la informacion
	 * posible. Dicho objeto se convertira a formato Json antes de ser devuelto.<br/>
	 * Se define un tipo de salida concreto para el cliente remoto a partir de
	 * las opciones internas del servicio rest. La conversion con el JsonLib en
	 * la fecha no es compatible.
	 * 
	 * @POST Tipo de peticion del protocolo http que recibira este metodo.
	 * @PATH URL concreta para este metodo.
	 * @PRODUCES Tipo MIME para la respuesta concreta de un cliente rest.
	 * @CONSUMES Tipo MIME para la informacion de la peticion del cliente rest.
	 * 
	 * @param usuario
	 *            Objeto usuario en JSON:
	 * @return Objeto respuesta servicio en JSON.
	 */
	@POST
	@Path("/consulta_general")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta_Servicio consulta_General(Usuarios usuario) {
		// CONVERTIMOS Y VALIDAMOS PREVIAMENTE A LA OPERACION DEL SERVICIO
		boolean valido = inicio_Operacion(usuario);
		// SI LOS PASOS ANTERIORES SON CORRECTOS SE REALIZA EL PROCESO DEL
		// SERVICIO
		if (valido) {
			// COMPROBAMOS QUE EL USUARIO ES CORRECTO(EXISTE)
			Usuarios usuario_acomprobar = Acceso_ApplicationContext.getBean(
					IGestion_Usuarios.class).consulta_GeneralUsuario(
					usuario.getNombreUsuario());
			// COMPROBAMOS QUE EL USUARIO ES CORRECTO(EXISTE)
			if (usuario_acomprobar != null) {
				// COMPROBAMOS QUE LA CLAVE SEA CORRECTA
				if (usuario_acomprobar.getPassword().equals(
						usuario.getPassword())) {
					// USUARIO CORRECTO
					// ELIMINAMOS LAS CARGAS VAGAS ANTES DE SERIALIZAR EN CASO
					// DE QUE EXISTAN
					if (usuario_acomprobar.getRoles() != null) {
						// ELIMINAMOS LAS CARGAS VAGAS DEL ROL ANTES DE
						// SERIALIZAR
						limpia_cargasvagas = Acceso_ApplicationContext
								.getBean(IEliminacion_CargasVagas.class);
						limpia_cargasvagas.eliminar_CargasEnColecciones(
								Roles.class, usuario_acomprobar.getRoles());
						// COMPROBAMOS LAS TAREAS
						if (usuario_acomprobar.getRoles().getTareases().size() > 0) {
							// TRATAMOS LAS TAREAS UNA A UNA PARA ELIMINAR LAS
							// CARGAS VAGAS
							Set<Tareas> lista_tareas = usuario_acomprobar
									.getRoles().getTareases();
							for (Tareas tarea : lista_tareas) {
								limpia_cargasvagas
										.eliminar_CargasEnColecciones(
												Tareas.class, tarea);
							}
						} else {
							// USUARIO SIN TAREAS ASIGNADAS
							resultado_operacion.setValor_booleano(false);
							resultado_operacion
									.setCodigo_error(ICodigos_Error.ERROR_USUARIOSINTAREAS);
							resultado_operacion
									.setMensaje("El usuario no tiene ninguna tarea asignada");
						}
						// USUARIO CON ROL Y TAREAS SIN CARGAS VAGAS PENDIENTES
						resultado_operacion.setValor_booleano(true);
						resultado_operacion
								.setCodigo_error(ICodigos_Error.USUARIO_CORRECTO);
						resultado_operacion.setMensaje("Se manda perfil");
						resultado_operacion.setUsuario(usuario_acomprobar);
					} else {
						// USUARIO CORRECTO SIN ROL ASIGNADO
						resultado_operacion.setValor_booleano(true);
						resultado_operacion
								.setCodigo_error(ICodigos_Error.USUARIO_CORRECTO);
						resultado_operacion.setMensaje("Se manda perfil");
						resultado_operacion.setUsuario(usuario_acomprobar);
					}
				} else {
					// ERROR DE CLAVE
					resultado_operacion.setValor_booleano(false);
					resultado_operacion
							.setCodigo_error(ICodigos_Error.ERROR_USUARIOCLAVE);
					resultado_operacion
							.setMensaje("La clave dada no es la del usuario");
				}
			} else {
				// ERROR DE USUARIO INCORRECTO
				resultado_operacion.setValor_booleano(false);
				resultado_operacion
						.setCodigo_error(ICodigos_Error.ERROR_USUARIOINEXISTENTE);
				resultado_operacion
						.setMensaje("No existe ningun usuario con ese nombre");
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
		// RESPUESTA DEL SERVICIO
		resultado_operacion = new Respuesta_Servicio(false);
		// BANDERA DE VALIDACION
		boolean valido = true;
		// VALIDACION DE DATOS
		if (valido) {
			validador = Acceso_ApplicationContext
					.getBean(IValidacion_Datos.class);
			try {
				validador.validar_Datos(usuario);
			} catch (Validacion_Exception e) {
				// ERROR EN LA VALIDACION
				valido = false;
				// SE GENERA EL RESULTADO DE ERROR PARA EL CLIENTE EN FORMATO
				// TEXTO Y EN NUMERO
				resultado_operacion.setValor_booleano(false);
				resultado_operacion.setCodigo_error(e.getCodigo_error());
				resultado_operacion.setMensaje(e.getMensaje_error());
			}
		}
		return valido;
	}

}
