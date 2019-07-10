package com.atrium.etiquetas;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Etiqueta basica para la creacion del base href.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 19-4-2017.
 * 
 */
public class Ruta_DinamicaAplicacion extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		// RECIBIMOS EL CONTEXTO DE PETICION PARA SU USO
		HttpServletRequest peticion = (HttpServletRequest) this.pageContext
				.getRequest();
		// CALCULAMOS LA RUTA DINAMICAMENTE PARA PASARSELA A LA PAGINA
		String path = peticion.getContextPath();
		String basePath = peticion.getScheme() + "://"
				+ peticion.getServerName() + ":" + peticion.getServerPort()
				+ path + "/";
		// ESCRIBIR EL HTML PARA LA PAGINA JSP
		try {
			this.pageContext.getOut().append("<base href='" + basePath + "'/>");
		} catch (IOException e) {
			// ERROR EN PROCESO DE SALIDA
			e.printStackTrace();
		}
		// CONTINUA EVALUANDOSE EL RESTO DE LA PAGINA
		return this.EVAL_PAGE;
	}
}
