package com.atrium.controlador;

import com.atrium.logica.Logica;
import com.atrium.modelo.Modelo;
import com.atrium.vista.Vista;

/**
 * Ejemplo de implementacion de uso de tablas. Contiene creacion,carga y gestion
 * de datos en la tabla, tanto ordenados como no ordenados.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Controlador {

	/**
	 * Proceso de uso de tablas.
	 */
	public void proceso() {
		// CREACION DE OBJETOS PARA SU USO.
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Logica logica = new Logica();

		// CREACION DE LA TABLA
		vista.mostrar_Pantalla("Teclear numero de elementos");
		int numero = vista.cambio_Tipo(vista.captura_Valor());

		modelo.crear_Tabla(numero);

		// CARGA DE VALORES EN LA TABLA
		for (int i = 0; i < numero; i++) {
			vista.mostrar_Pantalla("Dar valor al elemento " + String.valueOf(i + 1));
			modelo.getTabla()[i] = vista.cambio_Tipo(vista.captura_Valor());
		}

		// PROCESOS CON LA TABLA DESORDENADA
		vista.mostrar_Pantalla("El valor mayor es " + String.valueOf(logica.calcular_MayorD(modelo.getTabla())));
		vista.mostrar_Pantalla("El valor menor es " + String.valueOf(logica.calcular_MenorD(modelo.getTabla())));
		vista.mostrar_Pantalla("El valor medio es " + String.valueOf(logica.calcular_MediaD(modelo.getTabla())));

		// PROCESOS CON LA TABLA ORDENADA
		vista.mostrar_Pantalla("El valor mayor es " + String.valueOf(logica.calcular_Mayor(modelo.getTabla())));
		vista.mostrar_Pantalla("El valor menor es " + String.valueOf(logica.calcular_Menor(modelo.getTabla())));
		vista.mostrar_Pantalla("El valor medio es " + String.valueOf(logica.calcular_Media(modelo.getTabla())));
	}
}
