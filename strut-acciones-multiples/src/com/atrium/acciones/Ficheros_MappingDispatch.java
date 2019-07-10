package com.atrium.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.MappingDispatchAction;

/**
 * Ejemplo de accion multiple para los trabajos con ficheros.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 6-11-2017.
 * 
 */
public class Ficheros_MappingDispatch extends MappingDispatchAction {

	/**
	 * Accion que cumple las reglas definidas en cuanto a calculo de limites
	 * para aceptar y grabar el fichero elegido por el usuario.
	 */
	public ActionForward subir_fichero(ActionMapping mapa_navegacion,
			ActionForm datos, HttpServletRequest peticion,
			HttpServletResponse respuesta) throws Exception {
		System.out.println("SOY SUBIR FICHEROS");
		return mapa_navegacion.getInputForward();
	}

	/**
	 * Accion que descarga al cliente (navegador) el fichero pedido.
	 */
	public ActionForward descargar_fichero(ActionMapping mapa_navegacion,
			ActionForm datos, HttpServletRequest peticion,
			HttpServletResponse respuesta) throws Exception {
		System.out.println("SOY DESCARGAR FICHEROS");
		return mapa_navegacion.getInputForward();
	}

	/**
	 * Borrado simple de fichero en el servidor.</br> Confirmamos el resultado
	 * de la operacion.
	 */
	public ActionForward eliminar_fichero(ActionMapping mapa_navegacion,
			ActionForm datos, HttpServletRequest peticion,
			HttpServletResponse respuesta) throws Exception {
		System.out.println("SOY ELIMINAR FICHEROS");
		return mapa_navegacion.getInputForward();
	}
}
