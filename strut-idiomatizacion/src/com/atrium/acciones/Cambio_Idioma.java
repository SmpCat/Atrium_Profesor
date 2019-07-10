package com.atrium.acciones;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

/**
 * Proceso de cambio dinamico de idioma segun peticion de usuario.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0.
 * @since 3-11-2017.
 * 
 */
public class Cambio_Idioma extends Action {

	@Override
	public ActionForward execute(ActionMapping mapa_navegacion,
			ActionForm datos_peticion, HttpServletRequest peticion,
			HttpServletResponse response) throws Exception {
		// NAVEGACION A LA PAGINA DEL FORMULARIO DE LOGIN
		ActionForward salida = new ActionForward();
		salida = mapa_navegacion.getInputForward();
		DynaActionForm objeto_dominio = (DynaActionForm) datos_peticion;
		// RECOGEMOS EL IDIOMA SELECCIONADO POR EL USUARIO
		String cambio = (String) objeto_dominio.get("idioma");
		Locale idioma = new Locale(cambio);
		// MODIFICAMOS EL IDIOMA PREFERIDO EN LA SESION
		peticion.getSession().setAttribute("org.apache.struts.action.LOCALE", idioma);
		// VOLVEMOS  A LA PAGINA
		return salida;
	}
}
