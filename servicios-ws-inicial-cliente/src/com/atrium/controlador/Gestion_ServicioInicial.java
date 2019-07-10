package com.atrium.controlador;

import java.util.Date;

import com.atrium.cliente.ServicioWebDelegate;
import com.atrium.cliente.ServicioWebService;

/**
 * Fachada de acceso al servicio web.
 * 
 * @author Juan Antonio Solves Garcia.
 * @serial 1.5.
 * @since 11-5-2017.
 */
public class Gestion_ServicioInicial {
	// **PROPIEDADES DE CLASE
	private ServicioWebService conexion;
	private ServicioWebDelegate servicio_dao;

	public Gestion_ServicioInicial() {
		conexion = new ServicioWebService();
		servicio_dao = conexion.getServicioWebPort();
	}

	public Integer sumar(Integer ope1, Integer ope2) {
		return servicio_dao.sumar(ope1, ope2);
	}

	public String saludo() {
		return servicio_dao.saludo();
	}

	public Date fecha_Actual() {
		return servicio_dao.fechaActual().toGregorianCalendar().getTime();
	}

}
