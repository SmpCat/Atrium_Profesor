package com.atrium.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Filtro para establecer en la sesion un atributo que nos indicara el tipo de
 * navegador usuado por el cliente.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0
 * @since 29-7-2015.
 */
public class Filtro_Navegador implements Filter, IFiltro_Navegador {

	// PARAMETROS DE CLASE PARA EL PROCESO
	private Logger log = Logger.getLogger(Filtro_Idioma.class);

	// TABLA CON LOS VALORES DE LOS DISTINTOS NAVEGADORES
	private int navegador[] = { EXPLORER_6, EXPLORER_7, EXPLORER_8, EXPLORER_9,
			EXPLORER_10, EXPLORER_11, MOZILLA, CHROME, DESCONOCIDO };
	// CADENAS DEVUELTAS POR DISTINTOS NAVEGADORES PARA SU IDENTIFICACION
	// IE VERSION 6
	private String cadena_explorer6 = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1";
	// IE VERSION 7
	private String cadena_explorer7 = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; BTRS87211; .NET CLR 2.0.50727)";
	// IE VERSION 8
	private String cadena_explorer8 = "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0)";
	// IE VERSION 9
	private String cadena_explorer9 = "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)";
	// IE VERSION 10
	private String cadena_explorer10 = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0)";
	// IE VERSION 11
	private String cadena_explorer11 = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; ASU2JS; rv:11.0) like Gecko";
	// MOZILLA FIREFOX
	private String cadena_mozilla = "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";
	// CHROME
	private String cadena_chrome = "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.4 (KHTML, like Gecko) Chrome/22.0.1229.94 Safari/537.4";

	/**
	 * Proceso de traza al crear el filtro.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TRAZA DE LA CREACION
		if (log.isTraceEnabled()) {
			log.trace("--->>>>>>>>> CREACION DEL FILTRO DE NAVEGADOR  <<<<<<<<<<<-----");
		}
	}

	/**
	 * Establecemos el navegador del usuario para su posterior uso, contemplando
	 * nueve navegadores, varias versiones de Internet Explorer, Chrome y
	 * Firefox.
	 * 
	 * @param peticion
	 *            Objeto que representa la peticion. En nuestro caso es un
	 *            objeto HTTPSERVLETREQUEST.
	 * @param respuesta
	 *            Objeto que representa la peticion. En nuestro caso es un
	 *            objeto HTTPSERVLETRESPONSE.
	 * @param cadena_peticion
	 *            Objeto que nos permitira seguir la secuencia de la peticion
	 *            una vez terminado el proceso.
	 */
	public void doFilter(ServletRequest peticion, ServletResponse respuesta,
			FilterChain cadena_peticion) throws IOException, ServletException {
		String nombre_navegador = null;
		Integer int_navegador = null;
		// CONVERTIMOS EL TIPO DE LA PETICION
		HttpServletRequest http_peticion = null;
		if (peticion instanceof HttpServletRequest) {
			http_peticion = (HttpServletRequest) peticion;
		}
		// RECOGEMOS EL NAVEGADOR USADO POR EL CLIENTE EN LA PETICION
		String navegador_cliente = http_peticion.getHeader("user-agent");
		// EN FUNCION DEL NAVEGADOR ESTABLECEMOS UN ATRIBUTO DE SESION PARA
		// PODER DETERMINAR DINAMICAMENTE LOS RECURSOS A ENVIAR COMPARACION
		// EXPLORER
		boolean reconocido = false;
		if (navegador_cliente.indexOf("MSIE 6.0") > -1) {
			nombre_navegador = "Internet Explorer 6";
			int_navegador = new Integer(navegador[0]);
			reconocido = true;
		}
		if (navegador_cliente.indexOf("MSIE 7.0") > -1) {
			nombre_navegador = "Internet Explorer 7";
			int_navegador = new Integer(navegador[1]);
			reconocido = true;
		}
		if (navegador_cliente.indexOf("MSIE 8.0") > -1) {
			nombre_navegador = "Internet Explorer 8";
			int_navegador = new Integer(navegador[2]);
			reconocido = true;
		}
		if (navegador_cliente.indexOf("MSIE 9.0") > -1) {
			nombre_navegador = "Internet Explorer 9";
			int_navegador = new Integer(navegador[3]);
			reconocido = true;
		}
		if (navegador_cliente.indexOf("MSIE 10") > -1) {
			nombre_navegador = "Internet Explorer 10";
			int_navegador = new Integer(navegador[4]);
			reconocido = true;
		}
		if (navegador_cliente.indexOf("rv:11.0") > -1) {
			nombre_navegador = "Internet Explorer 11";
			int_navegador = new Integer(navegador[5]);
			reconocido = true;
		}
		// COMPARACION FIREFOX
		if (navegador_cliente.indexOf("Firefox") > -1) {
			nombre_navegador = "Mozilla Firefox";
			int_navegador = new Integer(navegador[6]);
			reconocido = true;
		}
		// COMPARACION CHROME
		if (navegador_cliente.indexOf("Chrome") > -1) {
			nombre_navegador = "Chrome";
			int_navegador = new Integer(navegador[7]);
			reconocido = true;
		}
		// TRATAMIENTO PARA LOS CASOS EN QUE NO SE CONOZCA EL NAVEGADOR
		if (!reconocido) {
			nombre_navegador = "No reconocido";
			int_navegador = new Integer(navegador[8]);
		}
		// COLOCAMOS EN LA SESION LA IDENTIFICACION DEL NAVEGADOR PARA SU
		// POSTERIOR USO, TANTO EN LETRA COMO EN VALOR NUMERICO
		http_peticion.getSession().setAttribute("navegador", int_navegador);
		http_peticion.getSession().setAttribute("nombre_navegador",
				nombre_navegador);
		// TRAZA DEL PROCESO
		if (log.isTraceEnabled()) {
			log.trace("identificador navegador en letra..:" + nombre_navegador);
			log.trace("identificador navegador en numero..:"
					+ int_navegador.intValue());
		}
		// CONTINUA LA PETICION COMO CORRESPONDA
		cadena_peticion.doFilter(peticion, respuesta);
	}

	/**
	 * Proceso de traza al eliminar el filtro.
	 */
	@Override
	public void destroy() {
		if (log.isTraceEnabled()) {
			log.trace("--->>>>>>>>> DESTRUCCION DEL FILTRO DE NAVEGADOR  <<<<<<<<<<<-----");
		}
	}

}
