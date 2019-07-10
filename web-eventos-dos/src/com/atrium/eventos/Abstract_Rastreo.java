package com.atrium.eventos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Procesos generales para todos los escuchadores de rastreo.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 5-3-2017.
 */
public abstract class Abstract_Rastreo {
	// PROPIEDAD QUE DEFINE EL LOGGER A USAR PARA EL REGISTRO DE LAS ACCIONES
	public Logger log = Logger.getLogger(this.getClass());
	// CONSTANTES QUE REPRESENTAN LOS NIVELES DE TRAZA DEL LOG4J
	public static final int LOG_TRACE = 0;
	public static final int LOG_DEBUG = 1;
	public static final int LOG_INFO = 2;
	public static final int LOG_WARNING = 3;
	public static final int LOG_ERROR = 4;
	public static final int LOG_FATAL = 5;
	// PROPIEDADES DE CLASE PARA LOS PROCESOS DE CONVERSION
	private SimpleDateFormat formato_fecha = new SimpleDateFormat(
			"dd-MM-yyyy HH:mm:ss");
	// PROPIEDAD PARA SEGUIR LA SECUENCIA DE LOS MENSAJES
	private static int numero_mensaje = 1;

	// ***** PROCESOS DE LANZAMIENTO DE MENSAJES
	/**
	 * Metodo de conveniencia para la traza de una forma mas simple.
	 * 
	 * @param mensaje
	 *            Texto a trazar en el log.
	 */
	public void registro(String mensaje) {
		this.registro(mensaje, Abstract_Rastreo.LOG_TRACE);
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
	public void registro(String mensaje, int nivel) {
		if (nivel == LOG_TRACE) {
			if (log.isTraceEnabled()) {
				mensaje = "Nª linea: " + String.valueOf(numero_mensaje) + " "
						+ capitalizar_texto(mensaje);
				log.trace(mensaje);
				numero_mensaje++;
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

	// ***** PROCESOS DE TRATAMIENTO DEL TEXTO DE LOS MENSAJES
	/**
	 * Proceso interno en donde capitalizamos el texto recibido.<br/>
	 * La primera letra de cada palabra se pone en mayuscula.
	 * 
	 * @param texto_recibido
	 *            Texto a capitalizar
	 * @return Texto capitalizado
	 */
	private static String capitalizar_texto(String texto_recibido) {
		// SI NO SE RECIBE NINGUN TEXTO SE DEVUELVE CADENA VACIA
		if (texto_recibido == null) {
			return "";
		}
		// PASAMOS EL TEXTO A UN OBJETO QUE NOS PERMITE MODIFICAR EL TEXTO SIN
		// CREAR A CADA PASO UN OBJETO NUEVO. AHORRO DE COSTES EN EJECUCION
		StringBuffer texto_atratar = new StringBuffer(texto_recibido.trim()
				.toLowerCase());
		// COMPROBACION DE CADENA VACIA
		if (texto_atratar.length() == 0) {
			return texto_atratar.toString();
		}
		// PROCESO DEL TEXTO CARACTER A CARACTER
		Character siguiente_caracter;
		int i = 0;
		siguiente_caracter = texto_atratar.charAt(i);
		while (i < texto_atratar.length()) {
			texto_atratar.setCharAt(i++,
					Character.toUpperCase(siguiente_caracter.charValue()));
			if (i == texto_atratar.length()) {
				return texto_atratar.toString();
			}
			// SE PASA AL SIGUIENTE CARACTER
			siguiente_caracter = texto_atratar.charAt(i);
			while (i < texto_atratar.length() - 2
					&& !Character.isWhitespace(siguiente_caracter.charValue())) {
				siguiente_caracter = texto_atratar.charAt(++i);
			}
			// COMPROBACION DE BLANCOS AL FINAL DEL TEXTO
			if (!Character.isWhitespace(siguiente_caracter.charValue())) {
				return texto_atratar.toString();
			}
			// ELIMINACION DE LOS ESPACIOS EN BLANCO SOBRANTES
			siguiente_caracter = texto_atratar.charAt(++i);
			while (i < texto_atratar.length()
					&& Character.isWhitespace(siguiente_caracter.charValue())) {
				texto_atratar.deleteCharAt(i);
				siguiente_caracter = texto_atratar.charAt(i);
			}
		}
		return texto_atratar.toString();
	}

	/**
	 * Damos el formato de parrafo al texto recibido.
	 * 
	 * @param texto
	 *            Texto a formatear.
	 * @return Texto ya formateado.
	 */
	private static String fraseado_Texto(String texto) {
		StringBuilder frasemayuscula = new StringBuilder();
		texto = texto.toLowerCase();
		String[] parrafos = texto.split("\\n");
		for (int i = 0, l = parrafos.length; i < l; ++i) {
			if (i > 0) {
				frasemayuscula.append(" ");
			}
			frasemayuscula.append(Character.toUpperCase(parrafos[i].charAt(0)))
					.append(parrafos[i].substring(1));
		}
		return texto;
	}

	// ***** PROCESOS DE TRATAMIENTO DE LA INFORMACION DE LOS ATRIBUTOS
	/**
	 * Proceso interno que nos sirve para conocer el contenido de los atributos
	 * que lanzan los eventos correspondientes. Solo se trata los tipos
	 * siguientes de atributos. <br/>
	 * Procesos definidos:<br/>
	 * <table border=1>
	 * <thead>
	 * <tr aling="center">
	 * <th colspan="2" >
	 * Procesos definidos</td></th>
	 * <tr>
	 * <th>
	 * Tipo atributo</th>
	 * <th>
	 * Descripcion</th>
	 * </tr>
	 * </thead> <tbody>
	 * <tr>
	 * <td>
	 * Atributo de tipo String.</td>
	 * <td>
	 * Cadena de texto pasada.</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Atributo de tipo Integer.</td>
	 * <td>
	 * Valor numerico entero.</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Atributo de tipo usuario.</td>
	 * <td>
	 * Se devuelve solo el nombre</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Atributo de tipo ResourceBundle.</td>
	 * <td>
	 * Se devuelve el idioma seleccionado.</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Atributo de tipo Double.</td>
	 * <td>
	 * Valor numerico decimal.</td>
	 * </tr>
	 * <tr>
	 * <td>
	 * Atributo de tipo Date.</td>
	 * <td>
	 * Fecha/Hora en texto.</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * 
	 * @param atributo
	 *            Objeto que se añade/quita/reemplaza en la sesion.
	 * @return Contenido del mismo en tipo String.
	 */
	public String coger_Valor(Object atributo) {
		String valor_texto = null;
		if (atributo instanceof String) {
			valor_texto = (String) atributo;
		}
		if (atributo instanceof Integer) {
			valor_texto = ((Integer) atributo).toString();
		}
		if (atributo instanceof Double) {
			valor_texto = ((Double) atributo).toString();
		}

		if (atributo instanceof Date) {
			valor_texto = formato_fecha.format((Date) atributo);
		}
		// if (atributo instanceof Usuarios) {
		// valor_texto = " nombre usuario "
		// + ((Usuarios) atributo).getNombreUsuario();
		// }
		if (atributo instanceof ResourceBundle) {
			valor_texto = " idioma elegido "
					+ ((ResourceBundle) atributo).getString("idioma");
		}
		return valor_texto;
	}

	// ***** PROCESOS DE LOGICA INTERNA DEL RASTREO
	/**
	 * Proceso logico para poder eliminar de la estadistica los atributos
	 * propios del programa.<br/>
	 * Alguno de estos atributos se establecen a nivel de servletcontext, otros
	 * a nivel de sesion.
	 * 
	 * @param nombre_atributo
	 *            El nombre del atributo a procesar.
	 * @return Boolean que indicara si se procesa o no el atributo.
	 */
	protected boolean seguir_Proceso(String nombre_atributo) {
		boolean seguir = true;
		if (nombre_atributo.equals("contador_sesiones")
				|| nombre_atributo.equals("contador_peticiones")
				|| nombre_atributo.equals("contador_atributos_aplicacion")
				|| nombre_atributo.equals("contador_atributos_sesion")
				|| nombre_atributo.equals("contador_atributos_peticion")
				|| nombre_atributo.equals("numero_sesion")
				|| nombre_atributo.equals("numero_peticiones")
				|| nombre_atributo.equals("numero_atributos_sesion")
				|| nombre_atributo.equals("numero_atributos_peticion")
				|| nombre_atributo.equals("hora_creacion")
				|| nombre_atributo.equals("identificador_peticion")
				|| nombre_atributo.equals("mapa_sesiones")) {
			seguir = false;
		}
		return seguir;
	}
}
