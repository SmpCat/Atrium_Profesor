package com.atrium.controlador;

import java.io.IOException;

/**
 * Ejemplo de clase de areanque
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 */
public class Inicio {

	/**
	 * Ejemplo de metodo de arranque de programa
	 * 
	 * @param args
	 *            Parametros de la consola del operativo.
	 */
	public static void main(String args[]) {
		// CREACION DE UN OBJETO DE UNA CLASE PROPIA PARA EL INICIO DE PROGRAMA
		Primera_Clase objeto = new Primera_Clase();

		// CREACION DE UN OBJETO DE UNA CLASE PROPIA QUE LANZA EXCEPCIONES
		Excepciones excepcion = new Excepciones();

		try {
			// CAPTURA DE EXCEPCIONES
			excepcion.prueba_Delegacion();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// CAPTURA DE EXCEPCIONES PROPIAS
			excepcion.prueba_ExcepcionPropia();
		} catch (ExcepcionPropia_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
