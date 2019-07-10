package com.atrium.colecciones.ordenacion;

import java.net.InterfaceAddress;
import java.util.Comparator;
import java.util.List;

/**
 * Ejemplo de ordenacion de coleccion de tipos no java (propios) mediante el uso
 * de la {@link Comparator}.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Inicio2 {

	/**
	 * Ejemplo de metodo de arranque de programa
	 * 
	 * @param args
	 *            Parametros de la consola del operativo.
	 */
	public static void main(String[] args) {
		//CREACION DEL PRIMER OBJETO DEL PROGRAMA
		Ordenacion ordenacion = new Ordenacion();
		//ORDENACION DE LA COLECCION SEGUN SENTIDO
		List<Prueba_Ordenacion> lista = ordenacion.ordenar_ConSentido(1);
		lista = ordenacion.ordenar_ConSentido(2);
		//ORDENACION DE LA COLECCION SEGUN SENTIDO Y PROPIEDAD
		lista = ordenacion.ordenar_PorPropiedad(1, 1);
		lista = ordenacion.ordenar_PorPropiedad(2, 1);
		lista = ordenacion.ordenar_PorPropiedad(1, 2);
		lista = ordenacion.ordenar_PorPropiedad(2, 2);
		lista = ordenacion.ordenar_PorPropiedad(1, 3);
		lista = ordenacion.ordenar_PorPropiedad(2, 3);

	}

}
