package com.atrium.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

/**
 * Ejemplo de definicion de metodos rest. Segun que tipo de informacion mande el
 * cliente se cambia el Consumes y la inyeccion del valor de la peticion
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1.
 * @since 13-2-2018.
 * 
 */
@Path("/servicio")
public class Primer_ServicioRest {

	// ********************** DATOS EN EL CUERPO DE LA PETICION
	/**
	 * Proceso de peticion via post. Se usa texto en formato JSON.
	 * 
	 * @param nombre
	 *            Datos llegados en el cuerpo de la peticion (texto en JSON).
	 * @return Datos enviados al cliente.
	 */
	@POST
	@Path("/prueba_post")
	public String peticion_Post(String nombre) {
		System.out.println("Soy la peticion post ......" + nombre);
		return "Soy la repuesta de peticion POST de json " + nombre;
	}

	/**
	 * Proceso de peticion via post. Se usa formulario de navegador.
	 * 
	 * @param nombre
	 *            Datos llegados en el cuerpo de la peticion (formulario).
	 * @return Datos enviados al cliente.
	 */
	@POST
	@Path("/prueba_post2")
	@Consumes("application/x-www-form-urlencoded")
	public String peticion_Post2(@FormParam("nombre") String nombre) {
		System.out.println("Soy la peticion post ......" + nombre);
		return "Soy la repuesta a la peticion POST de formulario " + nombre;
	}

	/**
	 * Proceso de peticion via post. Se usa formulario de navegador.
	 * 
	 * @param nombre
	 *            Datos llegados en el cuerpo de la peticion (formulario).
	 * @return Datos enviados al cliente.
	 */
	@POST
	@Path("/prueba_post3")
	@Consumes("application/json")
	public String peticion_Post3(String nombre) {
		System.out.println("Soy la peticion post ......" + nombre);
		return "Soy la repuesta a la peticion POST de formulario " + nombre;
	}

	/**
	 * Proceso de peticion via put. Se usa formato de formulario.
	 * 
	 * @param nombre
	 *            Datos llegados en el cuerpo de la peticion.
	 * @param texto
	 *            Todos los parametros de la peticion.
	 * @return Datos enviados al cliente.
	 */
	@PUT
	@Path("/prueba_put")
	@Consumes("application/x-www-form-urlencoded")
	public String peticion_Put(@FormParam("nombre") String nombre, String texto) {
		System.out.println("Soy la peticion put ......" + nombre);
		return "Soy la repuesta a la peticion PUT de formulario " + nombre;
	}

	/**
	 * Proceso de peticion via delete.
	 * 
	 * @param nombre
	 *            Datos llegados en la url de la peticion.
	 * @param texto
	 *            Datos del cuerpo de la peticion. No admite el desglose por
	 *            parametros de formulario (@Formparam)
	 * @return Datos enviados al cliente.
	 */
	@DELETE
	@Path("/prueba_delete")
	public String peticion_Delete(@HeaderParam("nombre") String nombre, String texto) {
		System.out.println("Soy la peticion delete ......" + nombre);
		return "Soy la respuesta de la peticion DELETE " + nombre;
	}

	// *************************** DATOS EN LA URL
	/**
	 * Proceso de peticion via get. Parametros en la cabecera de la peticion
	 * 
	 * @param nombre
	 *            Datos llegados en la url de la peticion.
	 * @return Datos enviados al cliente.
	 */
	@GET
	@Path("/prueba_get")
	public String peticion_Get(@HeaderParam("nombre") String nombre) {
		System.out.println("Soy la peticion get ......" + nombre);
		return "Soy la respuesta de la peticion GET " + nombre;
	}

	// ***************************** DATOS EN LA CABECERA
	/**
	 * Proceso de peticion via head. Tan solo se devuelve la respuesta con la
	 * cabecera, sin cuerpo.<br/>
	 * Con la anotacion @Context podemos recibir el contexto HTTPSERVLETREQUEST
	 * o HTTPSERVLETRESPONSE.<br/>
	 * El valor de retorno puede ser null o no tener valor de retorno.
	 * 
	 * @param nombre
	 *            Datos llegados en la cabecera de la peticion.
	 * @param respuesta
	 *            contexto de respuesta de la peticion.
	 * @return Datos enviados al cliente.
	 */
	@HEAD
	@Path("/prueba_head")
	public void peticion_Head(@HeaderParam("nombre") String nombre, @Context HttpServletResponse respuesta) {
		System.out.println("Soy la peticion head ......" + nombre);
		// INCLUIMOS VALOR DE RESPUESTA EN LA CABECERA DE LA MISMA
		respuesta.setHeader("parametro_propio", "Soy la peticion head ...... " + nombre);
	}

	/**
	 * Proceso de peticion via options. la norma establece que solo se informara
	 * de los metodos disponibles de peticion en el servicio.<br/>
	 * Se prodra recibir parametros de la cabecera, el contenido del cuerpo si
	 * lo hay o algun contexto.
	 * 
	 * @return Datos enviados al cliente.
	 */
	@OPTIONS
	@Path("/prueba_options")
	public String peticion_Options(String texto, @HeaderParam("nombre") String nombre,
			@Context HttpServletRequest peticion) {
		return "Soy la peticion OPTIONS tipos de peticiones validas: GET,POST,PUT,DELETE,HEAD";
	}

}