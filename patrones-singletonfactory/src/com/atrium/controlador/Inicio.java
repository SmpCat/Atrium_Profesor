package com.atrium.controlador;

import com.atrium.patrones.Singleton;

/**
 * Ejemplo de uso de singleton.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 20-10-2016.
 *
 */
public class Inicio {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		//COMPROBACION DE LA CREACION DE OBJETOS SINGLETON CON LAS DIFERENTES OPCIONES
		Singleton prueba=Singleton.getSingleton();
		Singleton prueba2=Singleton.getSingleton();
		
		Singleton prueba3=Singleton.getSingletonDiferido();
		Singleton prueba4=Singleton.getSingletonDiferido();
		
		Singleton prueba5=Singleton.getSingletonSincronizado();
		Singleton prueba6=Singleton.getSingletonSincronizado();
		
		Singleton prueba7=Singleton.getSingletonSincronizadoDos();
		Singleton prueba8=Singleton.getSingletonSincronizadoDos();
	}

}
