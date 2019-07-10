package com.atrium.eventos.arranque;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * Proceso de carga de variables de contexto para la configuracion del programa.
 * Se leeran del WEB.XML.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 5-3-2017.
 */
public class Evento_ArranquePrograma implements ServletContextListener {

	private Logger log = Logger.getLogger(Evento_ArranquePrograma.class);

	/**
	 * Cargamos las variables de contexto de la aplicacion y establecemos
	 * valores para los procesos. <br/>
	 * Inicialmente se cargan las siguientes variables.
	 * <ul>
	 * <li>ruta_depu. Carpeta para los ficheros logs del proceso propio de
	 * depuracion.</li>
	 * <li>ruta_logs. Carpeta donde se almacena el log4j.properties.</li>
	 * </ul>
	 */
	public void contextInitialized(ServletContextEvent evento_creacion) {
		// OBTENEMOS EL VALOR DEL PARAMETRO DE CONFIGURACION
		String ruta_depu = evento_creacion.getServletContext()
				.getInitParameter("ruta_seguimiento");
		// CALCULAMOS DINAMICAMENTE LA RUTA A PARTIR DEL VALOR DEL PARAMETRO
		ruta_depu = evento_creacion.getServletContext().getRealPath(ruta_depu);
		// COMPROBAMOS QUE EXISTA Y SI NO ES CREADA LA RUTA
		Mantenimiento_Rutas.comprobar_Carpeta(ruta_depu);
		// CREACION DE LA VARIABLE DE ENTORNO DE JAVA PARA QUE EL LOG4J PUEDA
		// USAR ESE VALOR AL LEER EL FICHERO DE CONFIGURACION
		System.setProperty("ruta_seguimiento", ruta_depu);
		// OBTENEMOS EL VALOR DEL PARAMETRO DE CONFIGURACION
		String ruta_log4j = evento_creacion.getServletContext()
				.getInitParameter("ruta_log4j");
		// RUTA PARA QUE EL LOG4J ENCUENTRE SU FICHERO DE CONFIGURACION
		String ruta_logs = evento_creacion.getServletContext().getRealPath(
				"/WEB-INF/classes" + ruta_log4j + "/log4j.properties");
		// ARRANQUE DEL SISTEMA DE LOG
		PropertyConfigurator.configure(ruta_logs);
		// TRAZA DEL PROCESO
		if (log.isTraceEnabled()) {
			log.trace("--->>>>>>>>> CREACION DEL CONTEXTO. INICIO PROGRAMA <<<<<<<<<<<-----");
			log.trace("--->>>>>>>>> ESTABLECIDOS LOS PARAMETROS INICIALES DEL PROGRAMA <<<<<<<<<<<-----");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent evento_destruccion) {
		// SIN USO
	}
}
