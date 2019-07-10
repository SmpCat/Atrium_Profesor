package com.atrium.eventos;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Procesos de siguimiento de los eventos de peticion.<br/>
 * Actualizado la forma de emision de los mensajes
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 5-3-2017.
 */
public class Rastreo_Peticiones extends Abstract_Rastreo implements
		ServletRequestListener, ServletRequestAttributeListener {

	// ************ EVENTOS DE SERVLETREQUESTLISTENER ************************
	/**
	 * Rastreo de la creacion de la peticion. Se controla el numero de
	 * peticiones por sesion.
	 */
	public void requestInitialized(ServletRequestEvent evento_peticion) {
		// AVERIGUAMOS SI LA PETICION VINO ENCRIPTADA O NO
		String protocolo_peticion = ((HttpServletRequest) evento_peticion
				.getServletRequest()).getProtocol();
		// ACTULIZAMOS EL CONTADOR DE PETICIONES DEL SERVLETCONTEXT
		Integer contador = (Integer) evento_peticion.getServletContext()
				.getAttribute("contador_peticiones");
		Integer nuevo_contador = new Integer(contador.intValue() + 1);
		evento_peticion.getServletContext().setAttribute("contador_peticiones",
				nuevo_contador);
		// AÑADIMOS EL IDENTIFICADOR DE LA PETICION A LA PROPIA PETICION
		evento_peticion.getServletRequest().setAttribute(
				"identificador_peticion", nuevo_contador);
		// REGISTRAMOS EL NUMERO DE PETICIONES PARA CADA SESION
		Integer numero_peticiones = new Integer(
				((Integer) ((HttpServletRequest) evento_peticion
						.getServletRequest()).getSession().getAttribute(
						"numero_peticiones")).intValue() + 1);
		((HttpServletRequest) evento_peticion.getServletRequest()).getSession()
				.setAttribute("numero_peticiones", numero_peticiones);
		// INICIAMOS EL CONTADOR DE ATRIBUTOS DE PETICION
		evento_peticion.getServletRequest().setAttribute(
				"numero_atributos_peticion", new Integer(0));
		// RECOGEMOS EL NUMERO IDENTIFICADOR DE LA SESION PROPIO
		Integer numero_sesion = (Integer) ((HttpServletRequest) evento_peticion
				.getServletRequest()).getSession()
				.getAttribute("numero_sesion");
		// EMITIMOS LA TRAZA
		registro("----->>>>> CREADO EL CONTEXTO DE PETICION (HTTPSERVLETREQUEST) NUMERO: "
				+ nuevo_contador.intValue()
				+ " DE LA SESION NUMERO: "
				+ numero_sesion.intValue());
		registro("*** peticion recibida: "
				+ ((HttpServletRequest) evento_peticion.getServletRequest())
						.getServletPath());
		registro("*** la peticion se realizo con el protocolo: "
				+ protocolo_peticion);
	}

	/**
	 * Rastreo de la destruccion de la peticion.<br/>
	 * Indicamos el numero identificador de la peticion, el numero identificador
	 * de sesion en donde se produce la peticion, junto con el numero de
	 * atributos usados en la misma.
	 */
	public void requestDestroyed(ServletRequestEvent evento_peticion) {
		// COGEMOS EL NUMERO DE LA PETICION
		Integer contador = (Integer) evento_peticion.getServletRequest()
				.getAttribute("identificador_peticion");
		// COGEMOS EL NUMERO DE LA SESION
		Integer numero_sesion = (Integer) ((HttpServletRequest) evento_peticion
				.getServletRequest()).getSession()
				.getAttribute("numero_sesion");
		// COGEMOS EL CONTADOR DE LOS ATRIBUTOS DE PETICION
		Integer numero_atributos = (Integer) evento_peticion
				.getServletRequest().getAttribute("numero_atributos_peticion");
		// ACTUALIZAMOS EL CONTADOR GENERAL DE ATRIBUTOS DE PETICION
		Integer contador_attpeticiones = (Integer) evento_peticion
				.getServletContext()
				.getAttribute("contador_atributos_peticion");
		contador_attpeticiones = new Integer(contador_attpeticiones.intValue()
				+ numero_atributos.intValue());
		evento_peticion.getServletContext().setAttribute(
				"contador_atributos_peticion", contador_attpeticiones);
		// EMITIMOS LA TRAZA
		registro("----->>>>> DESTRUIDO EL CONTEXTO DE PETICION (HTTPSERVLETREQUEST) NUMERO: "
				+ contador.intValue()
				+ " DE LA SESION "
				+ numero_sesion.intValue()
				+ " QUE HA RECIBIDO "
				+ numero_atributos.intValue() + " ATRIBUTOS");
	}

	// ********** FIN EVENTOS DE SERVLETREQUESTLISTENER **********************

	// *************** EVENTOS DE SERVLETREQUESTATTRIBUTELISTENER **********
	/**
	 * Proceso de registro de los distintos atributos de peticion que se añadan
	 * durante la ejecucion del programa.<br/>
	 * Se muestra el numero identificador de la peticion junto con la
	 * informacion de atributo añadido.
	 */
	public void attributeAdded(ServletRequestAttributeEvent evento_peticion) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_peticion.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// COGEMOS EL NUMERO DE LA PETICION
			Integer numero_peticion = (Integer) evento_peticion
					.getServletRequest().getAttribute("identificador_peticion");
			// ACTUALIZAMOS EL CONTADOR DE ATRIBUTOS DE PETICION
			Integer contador = (Integer) evento_peticion.getServletRequest()
					.getAttribute("numero_atributos_peticion");
			Integer nuevo_contador = new Integer(contador.intValue() + 1);
			evento_peticion.getServletRequest().setAttribute(
					"numero_atributos_peticion", nuevo_contador);
			// ANALIZAMOS EL CONTENIDO DEL ATRIBUTO AÑADIDO
			Object valor = evento_peticion.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = valor.getClass().getSimpleName();
			// EMITIMOS LA TRAZA
			registro("*** Añadido el atributo de peticion numero - "
					+ nuevo_contador.intValue() + " del tipo " + tipo
					+ " nombre: " + nombre_atributo + " valor: " + valor_texto
					+ " de la peticion numero " + numero_peticion.intValue());
		}
	}

	/**
	 * Rastreo de la eliminacion de un atributo de peticion.<br/>
	 * Se muestra el numero identificador de la peticion junto con la
	 * informacion de atributo eliminado.
	 */
	public void attributeRemoved(ServletRequestAttributeEvent evento_peticion) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_peticion.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// COGEMOS EL NUMERO DE LA PETICION
			Integer numero_peticion = (Integer) evento_peticion
					.getServletRequest().getAttribute("identificador_peticion");
			// ANALIZAMOS EL CONTENIDO DEL ATRIBUTO AÑADIDO
			Object valor = evento_peticion.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = null;
			tipo = valor.getClass().getSimpleName();
			// EMITIMOS LA TRAZA
			registro("*** Eliminado el atributo de peticion del tipo " + tipo
					+ " nombre: " + nombre_atributo + " valor: " + valor_texto
					+ " de la peticion numero " + numero_peticion.intValue());
		}
	}

	/**
	 * Rastreo de la modificacion de un atributo de peticion.<br/>
	 * Se muestra el numero identificador de la peticion junto con la
	 * informacion de atributo modificado.
	 */
	public void attributeReplaced(ServletRequestAttributeEvent evento_peticion) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_peticion.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// COGEMOS EL NUMERO DE LA PETICION
			Integer numero_peticion = (Integer) evento_peticion
					.getServletRequest().getAttribute("identificador_peticion");
			// ANALIZAMOS EL CONTENIDO DEL ATRIBUTO AÑADIDO
			Object valor = evento_peticion.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = null;
			tipo = valor.getClass().getSimpleName();
			// EMITIMOS LA TRAZA
			registro("*** Modificado el atributo de peticion del tipo " + tipo
					+ " nombre: " + nombre_atributo + " valor anterior: "
					+ valor_texto + " de la peticion numero "
					+ numero_peticion.intValue());
		}
	}

	// *************** FIN EVENTOS DE SERVLETREQUESTATTRIBUTELISTENER **********

}
