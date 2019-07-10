package com.atrium.cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Cliente basico para la prueba remota del servicio rest.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.2.
 * @since 13-2-2018.
 * 
 */
public class Inicio {

	public static void main(String[] args) {
		// A PARTIR DEL FACTORY CLIENTBUILDER INSTANCIAMOS LA CONEXION
		Client cliente = ClientBuilder.newClient();
		// *********** PETICION VIA GET
		// A PARTIR DE LA CONEXION OBTENEMOS EL OBJETO REMOTO PARA LANZAR LA
		// PETICION
		WebTarget objeto_remoto = cliente
				.target("http://localhost:8080/servicio-rest-inicial/jaxrs/servicio/prueba_get");
		// FORMATO HTTP DE LA RESPUESTA
		Builder tipo_peticion = objeto_remoto
				.request(MediaType.TEXT_PLAIN_TYPE);
		// DATOS PARA LA PETICION
		Datos datos_peticion = new Datos("Juan administrador");
		// CREACION DE LA CABECERA
		tipo_peticion.header("nombre", datos_peticion.getNombre());
		// LANZAMOS LA PETICION EN TIPO HTTP QUE NOS INTERESA Y OBTENEMOS LA
		// RESPUESTA
		String respuesta_servicio = tipo_peticion.get(String.class);
		System.out.println(respuesta_servicio);
		// *********** PETICION VIA DELETE
		WebTarget objeto_remoto4 = cliente
				.target("http://localhost:8080/servicio-rest-inicial/jaxrs/servicio/prueba_delete");
		// FORMATO HTTP DE LA RESPUESTA
		Builder tipo_peticion4 = objeto_remoto4
				.request(MediaType.TEXT_PLAIN_TYPE);
		// DATOS PARA LA PETICION
		datos_peticion = new Datos("Juan administrador");
		// CREACION DE LA CABECERA
		tipo_peticion4.header("nombre", datos_peticion.getNombre());
		String respuesta_servicio4 = tipo_peticion4.delete(String.class);
		System.out.println(respuesta_servicio4);
		// ***************************** DATOS EN LA CABECERA
		// *********** PETICION VIA HEAD
		WebTarget objeto_remoto5 = cliente
				.target("http://localhost:8080/servicio-rest-inicial/jaxrs/servicio/prueba_head");
		// AL SER UNA PETICION SIN CUERPO NO NECESITA TIPO DE RESPUESTA HTTP
		Builder tipo_peticion5 = objeto_remoto5.request().header("nombre",
				"Juan administrador de HEAD");
		// NO HAY TIPO DE SALIDA EN EL HEAD, SOLO LA CLASE RESPONSE QUE
		// REPRESENTA LA CABECERA DE LA PETICION
		Response respuesta = tipo_peticion5.head();
		// OBTENCION DE LOS PARAMETROS DE LA CABECERA DE LA RESPUESTA
		MultivaluedMap<String, Object> mapa = respuesta.getHeaders();
		System.out.println("Soy la respuesta del la peticion HEAD "
				+ respuesta.toString());
		// ********************** DATOS EN EL CUERPO DE LA PETICION
		// *********** PETICION VIA POST TEXTO PLANO
		WebTarget objeto_remoto2 = cliente
				.target("http://localhost:8080/servicio-rest-inicial/jaxrs/servicio/prueba_post");
		// INDICAMOS EL TIPO DE INFORMACION A MANDAR EN EL CUERPO DE LA PETICION
		Builder tipo_peticion2 = objeto_remoto2
				.request(MediaType.TEXT_HTML_TYPE);
		// CONVERSION DEL OBJETO AL FORMATO PEDIDO
		Entity<String> datos3 = Entity
				.text("Soy el contenido de la peticion post de texto plano");
		String respuesta_servicio3 = tipo_peticion2.post(datos3, String.class);
		System.out.println(respuesta_servicio3);
		// *********** PETICION VIA POST FORMULARIO
		WebTarget objeto_remoto22 = cliente
				.target("http://localhost:8080/servicio-rest-inicial/jaxrs/servicio/prueba_post2");
		// INDICAMOS EL TIPO DE INFORMACION A MANDAR EN EL CUERPO DE LA PETICION
		Builder tipo_peticion22 = objeto_remoto22.request();
		// CREACION DE DATOS DE FORMULARIO
		Form formulario = new Form();
		formulario.param("primer_paramformu", "valor_primerparam");
		formulario.param("segundo_paramformu", "valor_segundoparam");
		formulario.param("nombre", "Juan administrador formulario POST");
		String respuesta_servicio33 = tipo_peticion22.post(Entity.entity(
				formulario, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
				String.class);
		System.out.println(respuesta_servicio33);
		// *********** PETICION VIA POST JSON
		WebTarget objeto_remoto23 = cliente
				.target("http://localhost:8080/servicio-rest-inicial/jaxrs/servicio/prueba_post3");
		// INDICAMOS EL TIPO DE INFORMACION A MANDAR EN EL CUERPO DE LA PETICION
		Builder tipo_peticion23 = objeto_remoto2
				.request(MediaType.TEXT_HTML_TYPE);
		// CONVERSION DEL OBJETO AL FORMATO PEDIDO
		Datos nuevos_datos = new Datos();
		nuevos_datos.setNombre("Juan administrador post JSON");
		nuevos_datos.setClave("admin JSON");
		Entity<Datos> datos23 = Entity.json(nuevos_datos);
		String respuesta_servicio23 = tipo_peticion23.post(datos23,
				String.class);
		System.out.println(respuesta_servicio23);
		// *********** PETICION VIA POST FORMULARIO
		WebTarget objeto_remoto6 = cliente
				.target("http://localhost:8080/servicio-rest-inicial/jaxrs/servicio/prueba_put");
		// INDICAMOS EL TIPO DE INFORMACION A MANDAR EN EL CUERPO DE LA PETICION
		Builder tipo_peticion6 = objeto_remoto6.request();
		// CREACION DE DATOS DE FORMULARIO
		Form formulario_put = new Form();
		formulario_put.param("primer_paramformu", "valor_primerparam");
		formulario_put.param("segundo_paramformu", "valor_segundoparam");
		formulario_put.param("nombre", "Juan administrador formulario PUT");
		String respuesta_servicio6 = tipo_peticion6.put(Entity.entity(
				formulario, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
				String.class);
		System.out.println(respuesta_servicio6);
	}

}
