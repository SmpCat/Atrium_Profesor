package com.atrium.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ejemplo de definicion de componente SERVLET dentro de una aplicacion WEB.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 15-11-2016.
 */
public class Servlet_Inicial extends HttpServlet {

	/**
	 * Metodo para atender las peticiones de tipo POST del protocolo HTTP.
	 * 
	 * @param peticion
	 *            Contexto de peticion.
	 * @param respuesta
	 *            Contexto de respuesta.
	 */
	public void doPost(HttpServletRequest peticion,
			HttpServletResponse respuesta) throws ServletException, IOException {

		// 1º CAPTURA DE INFORMACION DE LA PETICION ENVIADA
		// ********* PARAMETROS
		String valor_parametro = peticion.getParameter("nombre parametro");
		String tabla_valores[] = peticion
				.getParameterValues("nombre parametro");
		Enumeration todo_losvalores = peticion.getParameterNames();
		// ********* CABECERAS PROTOCOLO HTTP
		String valor_cabecera = peticion.getHeader("nombre cabecera");
		Enumeration tabla_cabeceras = peticion.getHeaders("nombre cabecera");
		Enumeration todas_lascabeceras = peticion.getHeaderNames();
		// ********* COOKIES
		Cookie tabla_cookies[] = peticion.getCookies();
		String nombre_cookie = tabla_cookies[0].getName();
		String valor_cookie = tabla_cookies[0].getValue();
		// 2º CONVERSION

		// 3º VALIDACION
		if (valor_parametro.equals("")) {
			// LOGICA DE COMPROBACION
		}
		// 4º LOGICA/NEGOCIO

		// ***** PASO DE ATRIBUTOS A CONTEXTOS PARA SU USO EN OTROS COMPONENTES
		// *** CONTEXTO DE PETICION
		peticion.setAttribute("nombre atributo", nombre_cookie);
		peticion.getAttribute("nombre atributo");
		peticion.removeAttribute("nombre atributo");
		// *** CONTEXTO DE SESION
		peticion.getSession().setAttribute("nombre atributo", valor_parametro);
		peticion.getSession().getAttribute("nombre atributo");
		peticion.getSession().removeAttribute("nombre atributo");
		// *** CONTEXTO DE APLICACION
		peticion.getSession().getServletContext()
				.setAttribute("nombre atributo", valor_cabecera);
		peticion.getSession().getServletContext()
				.getAttribute("nombre atributo");
		peticion.getSession().getServletContext()
				.removeAttribute("nombre atributo");

		// 5º NAVEGACION
		RequestDispatcher rqd = peticion
				.getRequestDispatcher("URL-PATTERN/RUTA NOMBRE PAGINA");
		rqd.forward(peticion, respuesta);
	}

}
