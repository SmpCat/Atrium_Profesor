package com.atrium.controlador;

import java.util.Date;

/**
 * Ejemplo de cliente para servicio web.
 * 
 * @author Juan Antonio Solves Garcia.
 * @serial 2.0.
 * @since 11-5-2017.
 *
 */
public class Inicio {

	public static void main(String[] args) {
		// INSTACIA DE LA FACHADA
		Gestion_ServicioInicial gestion_servicio = new Gestion_ServicioInicial();
		// LLAMADA A LOS METODOS DEL SERVICIO
		String saludo = gestion_servicio.saludo();

		Integer suma = gestion_servicio.sumar(new Integer(5), new Integer(10));

		Date fecha = gestion_servicio.fecha_Actual();

		System.out.println("");

	}

}
