package com.atrium.componentes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
public class Ejemplo_Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Ejemplo_Servlet() {
		super();
	}

	/**
	 * Metodo inicial llamado al crear el servlet. <br>
	 *
	 * @throws ServletException
	 *             Excepcion ocurrida.
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	/**
	 *
	 * Metodo para atender las peticiones de tipo GET del protocolo HTTP.
	 * 
	 * @param peticion
	 *            Contexto de peticion.
	 * @param respuesta
	 *            Contexto de respuesta.
	 */
	public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {

		respuesta.setContentType("text/html");
		PrintWriter out = respuesta.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

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

	}

	/**
	 * Metodo final llamado antes de destruir el servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

}
