package com.atrium.eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Procesos de traza en la sesiones.<br/>
 * Actualizado la forma de emision de los mensajes.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 5-3-2017.
 * 
 */
public class Rastreo_Sesiones extends Abstract_Rastreo implements
		HttpSessionListener, HttpSessionAttributeListener,
		HttpSessionActivationListener {

	// ************ EVENTOS DE HTTPSESSIONLISTENER *********************
	/**
	 * Cada vez que se crea una sesion se detecta y se muestra el mensaje
	 * mediante el log4j.<br/>
	 * Recogemos del servletcontext el contador adecuado, les sumamos uno y
	 * actualizamos el contador. Guardamos este valor en la sesion tambien para
	 * que sea accesible como identificador valido de sesion.
	 */
	public void sessionCreated(HttpSessionEvent evento_creacion) {
		// PROCESO DE CONTEO DE LAS DISTINTAS SESIONES
		Integer contador = (Integer) evento_creacion.getSession()
				.getServletContext().getAttribute("contador_sesiones");
		Integer nuevo_contador = new Integer(contador.intValue() + 1);
		evento_creacion.getSession().getServletContext()
				.setAttribute("contador_sesiones", nuevo_contador);
		// IDENTIFICADOR DE LA SESION TAMBIEN ESTABLECE EL NUMERO DE SESIONES
		// CREADAS
		evento_creacion.getSession().setAttribute("numero_sesion",
				nuevo_contador);
		// CONTADOR DE NUMERO DE PETICIONES EN LA SESION
		evento_creacion.getSession().setAttribute("numero_peticiones",
				new Integer(0));
		// CONTADOR DE ATRIBUTOS DE SESION
		evento_creacion.getSession().setAttribute("numero_atributos_sesion",
				new Integer(0));
		// CREO LA ESTRUCTURA PARA LOS DATOS DE LA SESION
		Map<Integer, List<String>> atributos_sesion = new HashMap<Integer, List<String>>(
				0);
		// DAMOS LA SESION DE ALTA EN MAPA SE SESIONES.
		Map<Integer, Map<Integer, List<String>>> mapa_sesiones = (Map<Integer, Map<Integer, List<String>>>) evento_creacion
				.getSession().getServletContext().getAttribute("mapa_sesiones");
		mapa_sesiones.put(nuevo_contador, atributos_sesion);
		// LANZAMOS MENSAJE DE TRAZA
		registro("------>>>>>> CREAMOS LA SESION : IDENTIFICADOR -- "
				+ evento_creacion.getSession().getId() + " NUMERO DE SESION: "
				+ nuevo_contador.intValue());
	}

	/**
	 * Cada que se destruye una sesion se identifica para su rastreo.<br/>
	 * Se indica tambien el numero de peticiones que han sucedio en cada sesion.
	 */
	public void sessionDestroyed(HttpSessionEvent evento_creacion) {
		Integer contador = (Integer) evento_creacion.getSession().getAttribute(
				"numero_sesion");
		// PROCESO DE CONTROL DE NUMERO DE ATRIBUTOS A NIVEL DE APLICACION
		// ACTUALIZO EL CONTADOR GENERAL DE ATRIBUTOS DE SESION
		Integer contador_attsesiones = (Integer) evento_creacion.getSession()
				.getServletContext().getAttribute("contador_atributos_sesion");
		contador_attsesiones = new Integer(contador_attsesiones.intValue()
				+ ((Integer) evento_creacion.getSession().getAttribute(
						"numero_atributos_sesion")).intValue());
		evento_creacion
				.getSession()
				.getServletContext()
				.setAttribute("contador_atributos_sesion", contador_attsesiones);
		// LANZAMOS MENSAJE DE TRAZA
		registro("--->>> *** NUMERO DE PETICIONES DE LA SESION "
				+ ((Integer) evento_creacion.getSession().getAttribute(
						"numero_peticiones")).intValue() + " *** <<<---");
		registro("--->>> *** NUMERO DE ATRIBUTOS DE LA SESION "
				+ ((Integer) evento_creacion.getSession().getAttribute(
						"numero_atributos_sesion")).intValue() + " *** <<<---");
		registro("------>>>>>> DESTRUIMOS LA SESION : IDENTIFICADOR -- "
				+ evento_creacion.getSession().getId() + " NUMERO DE SESION: "
				+ contador.intValue());
	}

	// ************ FIN EVENTOS DE HTTPSESSIONLISTENER *********************

	// ************ EVENTOS DE HTTPSESSIONATTRIBUTELISTENER ****************
	/**
	 * Al añadir un atributo a la sesion se registra en la bitacora
	 * correspondiente el nuevo valor indicando la clase y algun dato del objeto
	 * para una mejor identificacion del mismo.
	 * 
	 * @param evento_sesion
	 *            Evento de atributo de sesion.
	 */
	public void attributeAdded(HttpSessionBindingEvent evento_sesion) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_sesion.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// PROCESO DE CONTROL DE NUMERO DE ATRIBUTOS A NIVEL DE SESION
			Integer contador_atributos_sesion = (Integer) evento_sesion
					.getSession().getAttribute("numero_atributos_sesion");
			contador_atributos_sesion = new Integer(
					contador_atributos_sesion.intValue() + 1);
			evento_sesion.getSession().setAttribute("numero_atributos_sesion",
					contador_atributos_sesion);
			// RECOGEMOS EL NUMERO DE LA SESION Y PREPARAMOS LA INFORMACION DEL
			// ATRIBUTO
			Integer contador = (Integer) evento_sesion.getSession()
					.getAttribute("numero_sesion");
			Object valor = evento_sesion.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = null;
			tipo = valor.getClass().getSimpleName();
			// CREAMOS Y GUARDAMOS LA INFORMACION EN EL MAPA PARA LA ESTADISTICA
			List<String> datos_atributo = new ArrayList<>(3);
			datos_atributo.add(nombre_atributo);
			datos_atributo.add(tipo);
			datos_atributo.add(valor_texto);
			Map<Integer, Map<Integer, List<String>>> mapa_sesiones = (Map<Integer, Map<Integer, List<String>>>) evento_sesion
					.getSession().getServletContext()
					.getAttribute("mapa_sesiones");
			mapa_sesiones.get(contador.intValue()).put(
					contador_atributos_sesion, datos_atributo);
			// LANZAMOS MENSAJE DE TRAZA
			registro("*** Añadido el atributo de sesion del tipo " + tipo
					+ " nombre: " + nombre_atributo + " valor: " + valor_texto
					+ " de la sesion numero: " + contador.intValue());
		}
	}

	/**
	 * Al eliminar un atributo de la sesion se registra junto con los datos del
	 * objeto.<br/>
	 * Cuando la sesion finalize se pierde el acceso a los atributos cuando son
	 * eliminados. Se controla por el try-catch.
	 */
	public void attributeRemoved(HttpSessionBindingEvent evento_sesion) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_sesion.getName();
		String valor_texto = null;
		String tipo = null;
		if (this.seguir_Proceso(nombre_atributo)) {
			try {
				// RECOGEMOS EL NUMERO DE LA SESION Y PREPARAMOS LA INFORMACION
				// DEL ATRIBUTO
				Integer contador = (Integer) evento_sesion.getSession()
						.getAttribute("numero_sesion");
				Object valor = evento_sesion.getValue();
				valor_texto = this.coger_Valor(valor);
				tipo = valor.getClass().getSimpleName();
				if (contador == null) {
					// EVITAMOS EL ERROR EN BORRADO MASIVO DE ATRIBUTOS DE
					// SESION. (MEJORAR)
					contador = new Integer(0);
				}
				// LANZAMOS MENSAJE DE TRAZA
				registro("*** Eliminado el atributo de sesion del tipo " + tipo
						+ " nombre: " + nombre_atributo + " valor: "
						+ valor_texto + " de la sesion numero: "
						+ contador.intValue());
			} catch (Exception e) {
				// TRATAMIENTO EN CASO DE SESION INVALIDADA. SIN ACCESO POSIBLE
				// A LOS ATRIBUTOS
				registro("*** Eliminado atributo de sesion invalida");
				// LANZAMOS MENSAJE DE TRAZA
				registro("*** Eliminado el atributo de sesion del tipo " + tipo
						+ " nombre: " + nombre_atributo + " valor: "
						+ valor_texto);
			}
		}
	}

	/**
	 * Al modificar algun atributo de sesion se registra junto con algun valor
	 * del atributo. Este valor es el reemplazado no en nuevo valor
	 */
	public void attributeReplaced(HttpSessionBindingEvent evento_sesion) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_sesion.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// RECOGEMOS EL NUMERO DE LA SESION Y PREPARAMOS LA INFORMACION
			// DEL ATRIBUTO
			Integer contador = (Integer) evento_sesion.getSession()
					.getAttribute("numero_sesion");
			Object valor = evento_sesion.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = null;
			tipo = valor.getClass().getSimpleName();
			// LANZAMOS MENSAJE DE TRAZA
			registro("*** Modificado el atributo de sesion del tipo " + tipo
					+ " nombre: " + nombre_atributo + " valor modificado: "
					+ valor_texto + " de la sesion numero: "
					+ contador.intValue());
		}
	}

	// ************ FIN EVENTOS DE HTTPSESSIONATTRIBUTELISTENER ****************

	// ********** EVENTOS DE HTTPSESSIONACTIVATIONLISTENER **********
	/**
	 * Registramos la activacion de la sesion.
	 */
	public void sessionDidActivate(HttpSessionEvent evento_activacion) {
		Integer contador = (Integer) evento_activacion.getSession()
				.getAttribute("numero_sesion");
		registro("------>>>>>> LA SESION HA SIDO ACTIVADA: IDENTIFICADOR -- "
				+ evento_activacion.getSession().getId()
				+ " NUMERO DE SESION: " + contador.intValue());
	}

	/**
	 * Registramos el convertir la sesion a pasiva.
	 */
	public void sessionWillPassivate(HttpSessionEvent evento_activacion) {
		Integer contador = (Integer) evento_activacion.getSession()
				.getAttribute("contador_sesiones");
		registro("------>>>>>> LA SESION VA HA SER DESACTIVADA: IDENTIFICADOR -- "
				+ evento_activacion.getSession().getId()
				+ " NUMERO DE SESION: " + contador.intValue());
	}
	// *********** FIN EVENTOS DE HTTPSESSIONACTIVATIONLISTENER *************
}
