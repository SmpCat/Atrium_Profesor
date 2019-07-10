package com.atrium.servicio;

import java.util.Date;

/**
 * Ejemplo de implementacion basica de webservice.
 * 
 * @author Juan Antonio Solves Garcia.
 * @since 11-5-2017.
 * @serial 1.5
 */
public class Servicio_Web {

	// ******* METODOS / OPERACIONES DEL SERVICIO
	
	public Date fecha_Actual() {
		return new Date();
	}

	public Integer sumar(Integer ope1, Integer ope2) {
		return ope1.intValue() + ope2.intValue();
	}

	public String saludo() {
		return "HOLA MUNDO SERVICIOS WS";
	}

}
