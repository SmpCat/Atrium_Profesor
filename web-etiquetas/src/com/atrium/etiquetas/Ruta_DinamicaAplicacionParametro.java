package com.atrium.etiquetas;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Etiqueta basica para la creacion del base href.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 19-4-2017.
 * 
 */
public class Ruta_DinamicaAplicacionParametro extends SimpleTagSupport {

	public HttpServletRequest contexto_peticion;

	@Override
	public void doTag() throws JspException, IOException {
		// CALCULAMOS LA RUTA DINAMICAMENTE PARA PASARSELA A LA PAGINA
		String path = contexto_peticion.getContextPath();
		String basePath = contexto_peticion.getScheme() + "://"
				+ contexto_peticion.getServerName() + ":"
				+ contexto_peticion.getServerPort() + path + "/";
		// ESCRIBIR EL HTML PARA LA PAGINA JSP
		try {
			this.getJspContext().getOut()
					.append("<base href='" + basePath + "'/>");
		} catch (IOException e) {
			// ERROR EN PROCESO DE SALIDA
			e.printStackTrace();
		}
	}

	// ACCESORES PARA EL SERVIDOR
	public void setContexto_peticion(HttpServletRequest contexto_peticion) {
		this.contexto_peticion = contexto_peticion;
	}

}
