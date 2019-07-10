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
 * Proceso de establecimiento de idioma por defecto en la primera peticion de la
 * aplicacion.<br/>
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 16-11-2016.
 */
public class Filtro_Idioma implements Filter {
	// PARAMETROS DE CLASE PARA SU FUNCIONAMIENTO
	private boolean no_elegido = true;
	private String idioma_defecto;
	private Logger log = Logger.getLogger(Filtro_Idioma.class);

	/**
	 * Proceso de establecimiento del idioma por defecto para los usuarios.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ESTABLECIMIENTO DE LA RUTA PARA EL RESOURCEBUNDLE CORRESPONDIENTE
		idioma_defecto = "com/atrium/idiomas/textos_"
				+ filterConfig.getServletContext().getInitParameter(
						"idioma_por_defecto");
		// TRAZA DEL PROCESO
		if (log.isTraceEnabled()) {
			log.trace("--->>>>>>>>> CREACION DEL FILTRO DE IDIOMA INICIAL  <<<<<<<<<<<---");
		}
	}

	/**
	 * Cargamos el idioma por defecto en base a la eleccion de idioma del
	 * navegador del cliente que hace la peticion.<br/>
	 * En caso de que no se tenga ese idioma se carga el idioma por defecto
	 * establecido en el metodo init.<br/>
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
		// ESTABLECEMOS EL IDIOMA POR DEFECTO
		String idioma_elegido_peticion = idioma_defecto;
		// CONVERTIMOS EL TIPO DE LA PETICION
		HttpServletRequest http_peticion = null;
		if (peticion instanceof HttpServletRequest) {
			http_peticion = (HttpServletRequest) peticion;
		} else {
			// REDIRECCIONAMIENTO INTERNO EN CASO DE ERROR EN EL CAST
		}
		// RECOGEMOS EL PARAMETRO QUE NOS DICE EL IDIOMA PREFERIDO EN EL
		// NAVEGADOR DEL USUARIO
		String idioma_preferido = http_peticion.getHeader("accept-language");
		// DIVIDIMOS LA CADENA EN PARTES PARA EL CASO DE TENER MAS DE UN IDIOMA
		// ELEGIDO
		String lista_idiomas[] = idioma_preferido.split(",");
		// BUSCAMOS DENTRO DE LOS IDIOMAS ACCESIBLES EL QUE CORRESPONDA A LA
		// PREFERANCIA DEL USUARIO
		for (int i = 0; i < lista_idiomas.length; i++) {
			if (lista_idiomas[i].substring(0, 2).equals("es") && no_elegido) {
				idioma_elegido_peticion = "com/atrium/idiomas/textos_es";
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals("en") && no_elegido) {
				idioma_elegido_peticion = "com/atrium/idiomas/textos_en";
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals("fr") && no_elegido) {
				idioma_elegido_peticion = "com/atrium/idiomas/textos_fr";
				no_elegido = false;
			}
		}
		// GUARDAMOS EN LA SESION EL IDIOMA PARA ESE USUARIO
		http_peticion.getSession().setAttribute("idioma_elegido",
				idioma_elegido_peticion);
		// REINICIO EL INTERRUPTOR PARA LA PROXIMA PETICION
		no_elegido = true;
		// CONTINUA LA PETICION COMO CORRESPONDA
		cadena_peticion.doFilter(peticion, respuesta);
	}

	/**
	 * Solo informamos de la finalizacion del filtro para el seguimiento de la
	 * aplicacion.
	 */
	@Override
	public void destroy() {
		// TRAZA DEL PROCESO
		if (log.isTraceEnabled()) {
			log.trace("--->>>>>>>> DESTRUCCION DEL FILTRO DE IDIOMA INICIAL <<<<<<<<<<---");
		}
	}

}
