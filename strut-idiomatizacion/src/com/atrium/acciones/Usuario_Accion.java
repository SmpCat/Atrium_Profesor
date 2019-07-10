package com.atrium.acciones;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

/**
 * Accion multiple de prueba para el formulario de usuarios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 3-11-2017.
 * 
 */
public class Usuario_Accion extends LookupDispatchAction {

	/**
	 * Mapeado simple de los metodos de la clase en funcion de la peticion
	 * recibida.
	 */
	@Override
	protected Map getKeyMethodMap() {
		Map<String, String> mapa_acciones = new HashMap<String, String>(0);
		// CLAVE - VALOR A COMPARAR CON EL PARAMETRO DEFINIDO
		// VALOR - NOMBRE DEL METODO A EJECUTAR
		mapa_acciones.put("bot.usuario.alta", "prueba_Usuario");
		mapa_acciones.put("bot.usuario.baja", "prueba_Usuario");
		mapa_acciones.put("bot.usuario.consulta.ajax", "prueba_Usuario");
		mapa_acciones.put("bot.usuario.modificacion", "prueba_Usuario");
		mapa_acciones.put("bot.usuario.salir", "prueba_Usuario");
		mapa_acciones.put("bot.usuario.cargarayuda", "prueba_Usuario");
		mapa_acciones.put("bot.usario.limpiar", "prueba_Usuario");
		return mapa_acciones;
	}

	/**
	 * Proceso de control de las peticiones de los botones del formulario.
	 * 
	 * @param mapa
	 *            Forwards disponibles para la accion
	 * @param datos_for
	 *            Objeto de dominio con los datos de la peticion.
	 * @param peticion
	 *            Request.
	 * @param respuesta
	 *            Response.
	 * @return La pagina definida por atributo forward de la accion.
	 */
	public ActionForward prueba_Usuario(ActionMapping mapa,
			ActionForm datos_for, HttpServletRequest peticion,
			HttpServletResponse respuesta) {

		return mapa.getInputForward();
	}

}
