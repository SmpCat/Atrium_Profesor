package com.atrium.managedbean;

import javax.faces.event.ActionEvent;

/**
 * prueba basica inicial de managedbean.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 26-4-2017
 * 
 */
public class Prueba_Bean {

	// PROPIEDAD PARA RECIBIR EL VALOR DEL COMPONENTE
	private String texto_prueba;

	/**
	 * Constructor con valores por defecto para las propiedades.
	 */
	public Prueba_Bean() {
		texto_prueba = "Hola mundo JSF2.";
	}

	/**
	 * Ejemplo de defincion de metodo de accion.
	 * 
	 * @return
	 */
	public String metodo_Accion() {
		System.out.println("Soy la accion");
		return null;
	}

	/**
	 * Ejemplo de definicion de metodo de evento.
	 * 
	 * @param evento
	 */
	public void metodo_Evento(ActionEvent evento) {
		System.out.println("Soy el evento");
	}

	// ACCESORES PARA JSF
	public String getTexto_prueba() {
		return texto_prueba;
	}

	public void setTexto_prueba(String texto_prueba) {
		this.texto_prueba = texto_prueba;
	}

}
