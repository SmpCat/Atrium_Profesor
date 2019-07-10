package com.atrium.log4j;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.atrium.util.foco.Aplicar_Normalizacion;

/**
 * Proceso general de tratamiento de mensajes dentro de la aplicacion.<br/>
 * Indicamos el nivel atraves de constantes de clase que pasamos como argumento
 * en el metodo. Se incluye una version con un solo argumento que por defecto
 * usa el nivel trace.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2016.
 * 
 */
public class Traza_Log implements ITraza_Log {
	// REGISTRO DE LA PROPIA CLASE EN EL SISTEMA DE LOG.
	private static Logger log = Logger.getLogger(Traza_Log.class);

	// AÑADIDO OBJETO RESOURCE BUNDLE PARA LA OPCION DE MENSAJES DE TRAZA
	// PERSONALIZABLES
	private static ResourceBundle rb;

	/**
	 * Sobrecarga de metodo para no tener que poner el nivel trace puesto que
	 * sera el nivel adjudicado por defecto.
	 * 
	 * @param mensaje
	 *            Texto a registrar.
	 */
	public static void registro(String mensaje) {
		registro(mensaje, LOG_TRACE);
	}

	/**
	 * Proceso que sobrecarga el metodo añadiendo la posibilidad de uso de
	 * externalizacion de cadenas y uso de variables en tiempo de ejecucion.
	 * 
	 * @param clave
	 *            Clave del properties.
	 * @param nivel
	 *            Nivel con el que se va a mostrar el mensaje.
	 * @param valores
	 *            Valores para las variables en los mensajes.
	 */
	public static void registro(String clave, int nivel, String valores[]) {
		if (rb == null) {
			rb = ResourceBundle.getBundle("com.atrium.log4j.textos_trazas");
		}
		String mensa = rb.getString(clave);
		mensa = MessageFormat.format(mensa, (Object[]) valores);
		registro(mensa, nivel);
	}

	/**
	 * Sobrecarga del metodo {@link #registro(String, int, String[])} para
	 * notener que indicar el nivel siempre.<BR/>
	 * Por defecto se usa el nivel trace.
	 * 
	 * @param mensaje
	 *            Clave del properties.
	 * @param valores
	 *            Valores para las variables en los mensajes.
	 */
	public static void registro(String mensaje, String valores[]) {
		if (rb == null) {
			rb = ResourceBundle.getBundle("com.atrium.log4j.textos_trazas");
		}
		String mensa = rb.getString(mensaje);
		mensa = MessageFormat.format(mensa, (Object[]) valores);
		registro(mensa, LOG_TRACE);
	}

	/**
	 * Proceso de escritura mediante el sistema de log4j.<br/>
	 * Ademas segun el nivel se formatea el texto de la siguiente manera:
	 * <ul>
	 * <li>
	 * Para trace las palabras capitalizadas.</li>
	 * <li>
	 * Para debug las palabras todo minusculas.</li>
	 * <li>
	 * Para info las palabras todo mayusculas.</li>
	 * <li>
	 * Para warn, error y fatal las palabras fraseadas.</li>
	 * </ul>
	 * 
	 * @param mensaje
	 *            Texto del mensaje a tratar.
	 * @param nivel
	 *            Prioridad dentro del sistema de log4j.
	 */
	public static void registro(String mensaje, int nivel) {
		if (nivel == LOG_TRACE) {
			if (log.isTraceEnabled()) {
				mensaje = capitalizar_texto(mensaje);
				log.trace(mensaje);
			}
		}
		if (nivel == LOG_DEBUG) {
			if (log.isDebugEnabled()) {
				mensaje = mensaje.toLowerCase().trim();
				log.debug(mensaje);
			}
		}
		if (nivel == LOG_INFO) {
			if (log.isInfoEnabled()) {
				mensaje = mensaje.toUpperCase().trim();
				log.info(mensaje);
			}
		}
		if (nivel == LOG_WARNING) {
			if (log.isEnabledFor(Level.WARN)) {
				mensaje = fraseado_Texto(mensaje);
				log.warn(mensaje);
			}
		}
		if (nivel == LOG_ERROR) {
			if (log.isEnabledFor(Level.ERROR)) {
				log.error(mensaje);
			}
		}
		if (nivel == LOG_FATAL) {
			if (log.isEnabledFor(Level.FATAL)) {
				log.fatal(mensaje);
			}
		}
	}

	/**
	 * Proceso interno en donde capitalizamos el texto recibido.
	 * 
	 * @param texto_recibido
	 *            Texto a capitalizar
	 * @return Testo capitalizado
	 */
	private static String capitalizar_texto(String texto_recibido) {
		return Aplicar_Normalizacion.capitalizar_texto(texto_recibido);
	}

	/**
	 * Damos el formato de parrafo al texto recibido.
	 * 
	 * @param texto
	 *            Texto a formatear.
	 * @return Texto ya formateado.
	 */
	private static String fraseado_Texto(String texto) {
		return Aplicar_Normalizacion.fraseado_Texto(texto);
	}

}
