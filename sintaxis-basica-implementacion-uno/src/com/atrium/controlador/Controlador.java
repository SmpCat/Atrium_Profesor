package com.atrium.controlador;

import com.atrium.modelo.Modelo;
import com.atrium.vista.Vista;

/**
 * Ejemplo basico de Procesos de control.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 27-9-2016.
 * 
 */
public class Controlador {
	// PROPIEDADES DE CLASE
	private Vista vista;
	private Modelo modelo;

	/**
	 * Constructor sin argumentos.
	 */
	public Controlador() {
		// INSTANCIA DE PROPIEDADES DE CLASE
		vista = new Vista();
		modelo = new Modelo();
		// LLAMADA A METODO DE ACCION
		ejecutar_Prueba();
	}

	/**
	 * Proceso de control de flujo en el programa.
	 */
	public void ejecutar_Prueba() {
		// PASO DE INFORMACION AL MODELO
		modelo.setTexto("Hola prueba java");
		// PRUEBA METODOS VISTA
		vista.mostrar_Texto();
		vista.mostrar_Texto(modelo.getTexto());
	}
}
