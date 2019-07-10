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
 * Accion multiple para el formulario de usuarios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 6-11-2017.
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
		mapa_acciones.put("bot.usuario.alta", "alta_Usuario");
		mapa_acciones.put("bot.usuario.baja", "baja_Usuario");
		mapa_acciones.put("bot.usuario.consulta.ajax", "consulta_Usuario");
		mapa_acciones.put("bot.usuario.modificacion", "modificacion_Usuario");
		mapa_acciones.put("bot.usuario.salir", "volver_aPaginaInicial");
		mapa_acciones.put("bot.usuario.cargarayuda", "cargar_Ayuda");
		mapa_acciones.put("bot.usario.limpiar", "reiniciar_Formulario");
		return mapa_acciones;
	}

	// *******************PROCESOS CRUD DE USUARIO
	/**
	 * Alta de usuario con control de resultado.
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
	public ActionForward alta_Usuario(ActionMapping mapa, ActionForm datos_for,
			HttpServletRequest peticion, HttpServletResponse respuesta) {
		System.out.println("SOY EL ALTA");
		return mapa.getInputForward();
	}

	/**
	 * Baja de usuario con control de resultado.
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
	public ActionForward baja_Usuario(ActionMapping mapa, ActionForm datos_for,
			HttpServletRequest peticion, HttpServletResponse respuesta) {
		System.out.println("SOY LA BAJA");
		return mapa.getInputForward();
	}

	/**
	 * Modificacion de usuario.
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
	public ActionForward modificacion_Usuario(ActionMapping mapa,
			ActionForm datos_for, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		System.out.println("SOY LA MODIFICACION");
		return mapa.getInputForward();
	}

	// ******************* FIN PROCESOS CRUD DE USUARIO

	/**
	 * Consulta de usuarios via AJAX.
	 * 
	 * @param mapa
	 *            Forwards disponibles para la accion
	 * @param datos_for
	 *            Objeto de dominio con los datos de la peticion.
	 * @param peticion
	 *            Request.
	 * @param respuesta
	 *            Response.
	 * @return Null en este caso al ser una peticion ajax.
	 */
	public ActionForward consulta_Usuario(ActionMapping mapa,
			ActionForm datos_for, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		System.out.println("SOY CONSULTA USUARIOS");
		return mapa.getInputForward();
	}

	/**
	 * Vuelta a la pagina inicial del portal para que el usuario pueda seguir
	 * con otra tarea.
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
	public ActionForward volver_aPaginaInicial(ActionMapping mapa,
			ActionForm datos_for, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		System.out.println("SOY PAGINA INICIAL");
		return mapa.getInputForward();
	}

	/**
	 * Restablecer los valores iniciales del formulario de usuario
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
	public ActionForward reiniciar_Formulario(ActionMapping mapa,
			ActionForm datos_for, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		System.out.println("SOY REINICIAR");
		return mapa.getInputForward();
	}

	/**
	 * Proceso de busqueda de informacion para la ayuda del usuarios.
	 * 
	 * @param mapa
	 *            Forwards disponibles para la accion
	 * @param datos_for
	 *            Objeto de dominio con los datos de la peticion.
	 * @param peticion
	 *            Request.
	 * @param respuesta
	 *            Response.
	 * @return Null en este caso al ser una peticion ajax.
	 */
	public ActionForward cargar_Ayuda(ActionMapping mapa, ActionForm datos_for,
			HttpServletRequest peticion, HttpServletResponse respuesta) {
		System.out.println("SOY LA AYUDA");
		return mapa.getInputForward();
	}

}
