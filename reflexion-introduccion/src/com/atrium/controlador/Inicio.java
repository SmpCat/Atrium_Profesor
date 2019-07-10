package com.atrium.controlador;

import java.lang.reflect.Method;

import javax.swing.JFrame;

/**
 * Ejemplo basico de uso de reflexion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 */
public class Inicio {
	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREACION DEL OBJETO A REFLEXIONAR
		JFrame ventana = new JFrame();
		// OBTENCION DEL CLASS
		Class class_ventana = ventana.getClass();
		// TRATAMIENTO DE LA INFORMACION DEL OBJETO
		// RUTA Y NOMBRE DE CLASE
		System.out.println("Nombre de la clase: " + class_ventana.getName());
		System.out.println("Paqueta: " + class_ventana.getPackage());
		// INFORMACION DE LAS INTERFACES QUE INCORPORA
		Class lista_interfaces[] = class_ventana.getInterfaces();
		for (Class class_interface : lista_interfaces) {
			System.out.println("Interface implementada: " + class_interface.getName());
		}
		// INFORMACION DE LOS METODOS QUE CONTIENE
		Method lista_metodos[] = class_ventana.getDeclaredMethods();
		for (Method metodo : lista_metodos) {
			System.out.println("Metodo: " + metodo.getName());
			System.out.print(" valor devuelto: " + metodo.getReturnType().getName() + "\n");
		}
	}

}
