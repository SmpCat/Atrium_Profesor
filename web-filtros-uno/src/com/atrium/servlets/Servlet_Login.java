package com.atrium.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ejemplo de definicion de componente SERVLET dentro de una aplicacion WEB.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 14-1-2018.
 */
public class Servlet_Login extends HttpServlet {

	/**
	 * Metodo para atender las peticiones de tipo POST del protocolo HTTP.
	 * 
	 * @param peticion
	 *            Contexto de peticion.
	 * @param respuesta
	 *            Contexto de respuesta.
	 */
	public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {
		// LLAMADA DE METODO POR EL SERVIDO UNA VEZ FINALIZADO EL FILTRO
		System.out.println("");
	}
}
