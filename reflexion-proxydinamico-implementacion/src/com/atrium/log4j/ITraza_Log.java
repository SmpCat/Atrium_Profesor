package com.atrium.log4j;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.log4j.Priority;

/**
 * Interface definitoria de los procesos de traza junto con las constantes
 * necesarias para el proceso.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 * @since 4-10-2014
 *
 */
public interface ITraza_Log {
	// CONSTANTES QUE REPRESENTAN LOS NIVELES DE MENSAJE PARA EL SERVICIO LOG4J
	public static final int LOG_TRACE = 10;
	public static final int LOG_DEBUG = 20;
	public static final int LOG_INFO = 30;
	public static final int LOG_WARNING = 40;
	public static final int LOG_ERROR = 50;
	public static final int LOG_FATAL = 60;

}