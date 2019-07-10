package com.atrium.acciones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

/**
 * Clase para el tratamiento propio de la excepcion producida.
 * 
 * @author Juan Antonio Solves Garcia.
 * @since 6-11-2017.
 * @version 2.0.
 *
 */
public class Tratamiento_Error extends ExceptionHandler {

	/**
	 * Proceso llamado por el controlador en respuesta a la excepcion ocurrida.
	 * 
	 * @param excepcion
	 *            Excepcion producida.
	 * @param definicion_excepcion
	 *            Definicion en el strut-config del tratamiento.
	 * @param mapa_forward
	 *            Mapa con los forward posibles.
	 * @param datos_peticion
	 *            Datos de la peticion.
	 * @param peticion
	 *            Contexto de peticion.
	 * @param respuesta
	 *            Contexto de respuesta.
	 * 
	 */
	@Override
	public ActionForward execute(Exception excepcion,
			ExceptionConfig definicion_excepcion, ActionMapping mapa_forward,
			ActionForm datos_peticion, HttpServletRequest peticion,
			HttpServletResponse respuesta) throws ServletException {
		// ACCION PROPIA PARA EL SEGUIMIENTO DE LA EXCEPCION
		System.out.println("traza de error");
		return super.execute(excepcion, definicion_excepcion, mapa_forward,
				datos_peticion, peticion, respuesta);
	}

}
