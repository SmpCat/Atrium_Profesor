package com.atrium.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Accion de Strut para producir un error y comprobar su tratamiento.
 * 
 * @author Juan Antonio Solves Garcia.
 * @since 6-11-2017.
 * @version 2.0.
 *
 */
public class Accion_Error extends Action {
	// PROPIEDADE DE CLASE
	private String no_existe;

	/**
	 * Proceso generador del error.
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// ERROR DE NULLPOINTER EXCEPTION
		no_existe.length();
		return null;
	}

}
