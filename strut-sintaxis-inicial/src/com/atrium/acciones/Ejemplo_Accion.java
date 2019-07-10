package com.atrium.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Ejemplos de defincion de accion dentro de Strut1.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 12-12-2016.
 */
public class Ejemplo_Accion extends Action {

	@Override
	public ActionForward execute(ActionMapping mapa_forward,
			ActionForm datos_formulario, HttpServletRequest peticion,
			HttpServletResponse respuesta) throws Exception {
		// PROCESOS PROPIOS DE STRUT

		// LOGICA DE LA ACCION

		// ESTABLECIMIENTO DEL FORWARD (NAVEGACION)
		
		return null;
	}

}
