package com.atrium.formbeans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * Clase para los datos de la subida de ficheros. En una primera version solo
 * esta el propio fichero.<br/>
 * Con posterioridad se podran añadir mas propiedades para completar la
 * informacion del documento si es necesario.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.1.
 * @since 6-11-2017.
 * 
 */
public class Subida_Bean extends ActionForm {
	// PROPIEDAD PARA RECIBIR EL FICHERO SUBIDO POR EL CLIENTE
	private FormFile fichero_subido;

	/**
	 * Comprobacion de tamaño de fichero y cuota de disco de cada usuario.
	 */
	@Override
	public ActionErrors validate(ActionMapping mapa_forward,
			HttpServletRequest peticion) {
		ActionErrors errores=new ActionErrors();
		System.out.println("SOY LA VALIDACION DE SUBIDA FICHEROS");
		return errores;
	}

	// ACCESORES PARA STRUT
	public FormFile getFichero_subido() {
		return fichero_subido;
	}

	public void setFichero_subido(FormFile fichero_subido) {
		this.fichero_subido = fichero_subido;
	}

}
