package com.atrium.eventos;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.atrium.util.Resta_Fechas;

/**
 * Proceso de seguimiento de los distintos eventos del contexto de aplicacion
 * para su volcado por el sistema de log y su posterior uso.<br/>
 * Actualizado la forma de emision de los mensajes
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 5-3-2017.
 */
public class Rastreo_Aplicacion extends Abstract_Rastreo implements
		ServletContextListener, ServletContextAttributeListener {

	// *************** EVENTOS DE SERVLETCONTEXTLISTENER ****************
	/**
	 * Seguimiento del inicio del programa.<br/>
	 * Se crean los valores iniciales de contador de sesiones y de peticiones,
	 * ademas de marcar la hora de inicio.
	 */
	@Override
	public void contextInitialized(ServletContextEvent evento_creacion) {
		// INICIALIZO CONTADORES PARA EL USO EN LOS OTROS RASTREADORES
		// TOTAL DE SESIONES
		evento_creacion.getServletContext().setAttribute("contador_sesiones",
				new Integer(0));
		// TOTAL DE PETICIONES DE TODAS LAS SESIONES
		evento_creacion.getServletContext().setAttribute("contador_peticiones",
				new Integer(0));
		// TOTAL DE LOS ATRIBUTOS DE APLICACION
		evento_creacion.getServletContext().setAttribute(
				"contador_atributos_aplicacion", new Integer(0));
		// TOTAL DE LOS ATRIBUTOS DE TODAS LAS SESIONES
		evento_creacion.getServletContext().setAttribute(
				"contador_atributos_sesion", new Integer(0));
		// TOTAL DE ATRIBUTOS DE TODAS LAS PETICIONES
		evento_creacion.getServletContext().setAttribute(
				"contador_atributos_peticion", new Integer(0));
		// AÑADO UN DATE PARA SABER LA CREACION DE LA APLICACION Y PODER
		// CALCULAR LA DURACION
		evento_creacion.getServletContext().setAttribute("hora_creacion",
				new Date());
		// ESTRUCTURA DE DATOS PARA LA ESTADISTICA FINAL-- TODOS LOS ATRIBUTOS
		// CON SUS VALORES DE CADA SESION
		Map<Integer, Map<Integer, List<String>>> mapa_sesiones = new HashMap<Integer, Map<Integer, List<String>>>(
				0);
		evento_creacion.getServletContext().setAttribute("mapa_sesiones",
				mapa_sesiones);
		// LANZAMOS MENSAJE DE TRAZA
		registro("----->>>>> CREADO EL CONTEXTO DE APLICACION (SERVLETCONTEXT) INICIO PROGRAMA <<<<<<<-----");
	}

	/**
	 * Seguimiento de la finalizacion del programa. Se indica ademas la duracion
	 * del mismo.<br/>
	 * Tambien se indica el numero de sesiones creadas junto con el numero de
	 * peticiones recibidas.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent evento_destruccion) {
		// CALCULAMOS LA DURACION DE LA PRUEBA
		Date hora_fin = new Date();
		Date hora_creacion = (Date) evento_destruccion.getServletContext()
				.getAttribute("hora_creacion");
		Map<String, String> resultado = Resta_Fechas.getDiferencia(
				hora_creacion, hora_fin);
		// MOSTRAMOS LA DURACION DE LA PRUEBA
		registro("*****  LA APLICACION DURO FUNCIONANDO "
				+ resultado.get("horas") + " HORAS " + resultado.get("minutos")
				+ " MINUTOS " + resultado.get("segundos") + " SEGUNDOS ******");
		// OBTENEMOS LOS DATOS DE LA EJECUCION DE LA PRUEBA
		int numero_sesiones = (int) evento_destruccion.getServletContext()
				.getAttribute("contador_sesiones");
		int numero_peticiones = (int) evento_destruccion.getServletContext()
				.getAttribute("contador_peticiones");
		int numero_atributos_aplicacion = (int) evento_destruccion
				.getServletContext().getAttribute(
						"contador_atributos_aplicacion");
		int numero_atributos_sesiones = (int) evento_destruccion
				.getServletContext().getAttribute("contador_atributos_sesion");
		int numero_atributos_peticiones = (int) evento_destruccion
				.getServletContext()
				.getAttribute("contador_atributos_peticion");
		// OBTENEMOS LA ESTRUCTURA CON EL DESGLOSE POR SESIONES
		Map<Integer, Map<Integer, List<String>>> mapa_sesiones = (Map<Integer, Map<Integer, List<String>>>) evento_destruccion
				.getServletContext().getAttribute("mapa_sesiones");
		// TRAZAMOS LOS DATOS DE LA PRUEBA
		registro(System.getProperty("line.separator")
				+ "***** estadistica de la aplicacion *****");
		registro("***** datos totales *****");
		registro("***** Se crearon " + numero_sesiones + " sesiones.");
		registro("***** Se crearon " + numero_peticiones + " peticiones.");
		registro("***** Se usaron " + numero_atributos_aplicacion
				+ " atributos en la aplicacion.");
		registro("***** Se usaron " + numero_atributos_sesiones
				+ " atributos en las sesiones.");
		registro("***** Se usaron " + numero_atributos_peticiones
				+ " atributos en las peticiones.");
		registro("***** desglose por sesiones *****");
		// TRATAMOS EL MAPA CON LOS DATOS DE LA SESIONES
		Set<Integer> claves_mapa = mapa_sesiones.keySet();
		// RECORREMOS CADA SESION UNA A UNA
		for (Integer numero_sesion : claves_mapa) {
			Map<Integer, List<String>> atributos_sesion = mapa_sesiones
					.get(numero_sesion);
			registro("***---- DESGLOSE POR SESIONES ----****");
			registro("---- sesion numero " + numero_sesion.intValue());
			// TRATAMOS LOS DATOS DE CADA SESION POR SEPARADO
			if (!atributos_sesion.isEmpty()) {
				Set<Integer> claves_atributo = atributos_sesion.keySet();
				int posicion_atributo = 1;
				// TRATAMOS CADA ATRIBUTO DE SESION POR UNO A UNO
				for (Integer numero_atributo : claves_atributo) {
					List<String> valores_atributo = atributos_sesion
							.get(numero_atributo);
					registro("----- atributo " + posicion_atributo
							+ "º sesion " + numero_sesion.intValue() + ". "
							+ valores_atributo.get(0) + " tipo: "
							+ valores_atributo.get(1) + " contenido: "
							+ valores_atributo.get(2));
					posicion_atributo++;
				}
			} else {
				// SESION SIN ATRIBUTOS
				registro("----- sesion " + numero_sesion.intValue()
						+ " sin atributos.");
			}
		}
		// *********** CASO DE NINGUNA SESION EN LA APLICACION
		if (claves_mapa.isEmpty()) {
			registro("-->> no se creo ninguna sesion en la prueba <<--");
		}
		// FINALIZACION DE PROGRAMA
		registro("----->>>>> DESTRUIDO EL CONTEXTO DE APLICACION (SERVLETCONTEXT) FIN PROGRAMA <<<<<<<-----");
	}

	// ************** FIN EVENTOS DE SERVLETCONTEXTLISTENER **************

	// ************** EVENTOS DE SERVLETCONTEXTATTRIBUTELISTENER **************
	/**
	 * Proceso de recogida de el atributo que se introduce en el contexto.
	 * Mostramos el tipo y el valor del atributo.
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent evento_atributo) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_atributo.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// PROCESO DE CONTROL DE NUMERO DE ATRIBUTOS
			int numero_atributos = (int) evento_atributo.getServletContext()
					.getAttribute("contador_atributos_aplicacion");
			numero_atributos++;
			evento_atributo.getServletContext().setAttribute(
					"contador_atributos_aplicacion",
					new Integer(numero_atributos));
			// PROCESO DE CONTROL DEL VALOR Y TIPO DE ATRIBUTO
			Object valor = evento_atributo.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = null;
			tipo = valor.getClass().getSimpleName();
			// LANZAMOS MENSAJE DE TRAZA
			registro("*** Añadido el atributo de aplicacion del tipo " + tipo
					+ " nombre: " + nombre_atributo + " valor: " + valor_texto);
		}
	}

	/**
	 * Proceso de recogida de el atributo que se elimina del contexto. Mostramos
	 * el tipo y el valor del atributo.
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent evento_atributo) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_atributo.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// PROCESO DE CONTROL DEL VALOR Y TIPO DE ATRIBUTO
			Object valor = evento_atributo.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = null;
			tipo = valor.getClass().getSimpleName();
			// LANZAMOS MENSAJE DE TRAZA
			registro("*** Eliminado el atributo de aplicacion del tipo " + tipo
					+ " nombre: " + nombre_atributo + " valor: " + valor_texto);
		}
	}

	/**
	 * Proceso de recogida de el atributo que se modifica en el contexto.
	 * Mostramos el tipo y el valor nuevo del atributo.
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent evento_atributo) {
		// CONTROL DEL NOMBRE DEL ATRIBUTO
		String nombre_atributo = evento_atributo.getName();
		if (this.seguir_Proceso(nombre_atributo)) {
			// PROCESO DE CONTROL DEL VALOR Y TIPO DE ATRIBUTO
			Object valor = evento_atributo.getValue();
			String valor_texto = this.coger_Valor(valor);
			String tipo = null;
			tipo = valor.getClass().getSimpleName();
			// LANZAMOS MENSAJE DE TRAZA
			registro("*** Modificado el atributo de aplicacion del tipo "
					+ tipo + " nombre: " + nombre_atributo
					+ " valor modificado: " + valor_texto);
		}
	}
	// ************ FIN EVENTOS DE SERVLETCONTEXTATTRIBUTELISTENER ************

}
