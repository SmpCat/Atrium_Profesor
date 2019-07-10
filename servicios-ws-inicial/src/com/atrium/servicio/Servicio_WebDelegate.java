package com.atrium.servicio;

import java.util.Date;

@javax.jws.WebService(targetNamespace = "http://servicio.atrium.com/", serviceName = "Servicio_WebService", portName = "Servicio_WebPort")
public class Servicio_WebDelegate {

	com.atrium.servicio.Servicio_Web servicio_Web = new com.atrium.servicio.Servicio_Web();

	public Date fecha_Actual() {
		return servicio_Web.fecha_Actual();
	}

	public Integer sumar(Integer ope1, Integer ope2) {
		return servicio_Web.sumar(ope1, ope2);
	}

	public String saludo() {
		return servicio_Web.saludo();
	}

}