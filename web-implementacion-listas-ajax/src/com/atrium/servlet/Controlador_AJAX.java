package com.atrium.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atrium.negocio.ILogica_ListasAJAX;
import com.atrium.spring.Acceso_ApplicationContext;

/**
 * Controlador del proceso de recepcion y respuesta de las peticiones ajax. 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 9-1-2018.
 *
 */
public class Controlador_AJAX extends HttpServlet {

	
	public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta)
			throws ServletException, IOException {
		// PARAMETRO DE LA PETICION PARA QUE EL CONTROLADOR SEPA LA ACCION A
		// REALIZAR
		String tipo_peticion = peticion.getParameter("tipo_peticion");
		// LOGICA DE NEGOCIO DEL PROCESO
		ILogica_ListasAJAX logica_listas = Acceso_ApplicationContext
				.getBean(ILogica_ListasAJAX.class);
		// RESPUESTA PARA EL CLIENTE
		String salida_cliente = null;
		// GESTION CONTROLADOR
		if (tipo_peticion.equals("cargar_paises")) {
			salida_cliente = logica_listas.consultar_Paises();
		}
		if (tipo_peticion.equals("cargar_provincias")) {
			String pais_seleccionado = peticion
					.getParameter("pais_seleccionado");
			salida_cliente = logica_listas
					.consultar_Provincias(pais_seleccionado);
		}
		if (tipo_peticion.equals("cargar_municipios")) {
			String provincia_seleccionado = peticion
					.getParameter("provincia_seleccionada");
			salida_cliente = logica_listas
					.consultar_Municipios(provincia_seleccionado);
		}
		// ENVIO DE RESPUESTA
		respuesta.setContentType("text/plain");
		respuesta.setCharacterEncoding("iso-8859-15");
		respuesta.getWriter().write(salida_cliente);
	}

}
