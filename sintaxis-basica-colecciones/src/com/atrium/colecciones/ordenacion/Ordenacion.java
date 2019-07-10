package com.atrium.colecciones.ordenacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Ejemplo de ordenacion de colecciones con tipos propios mediante la interface
 * comparator.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Ordenacion implements Comparator<Prueba_Ordenacion> {
	// PROPIEDADES DE CLASE
	// COLECCION A ORDENAR
	private List<Prueba_Ordenacion> lista;
	// CONTROL DEL SENTIDO Y LA PROPIEDAD PARA LA ORDENACION.
	private int sentido;
	private int campo_ordenacion;

	/**
	 * Constructor donde creamos el contenido de la coleccion de forma directa.
	 */
	public Ordenacion() {
		lista = new ArrayList<Prueba_Ordenacion>(0);
		Prueba_Ordenacion objeto = new Prueba_Ordenacion();
		objeto.setFecha(new Date());
		objeto.setTexto("Soy el primero");
		objeto.setNumero(new Integer(1));
		lista.add(objeto);
		objeto = new Prueba_Ordenacion();
		objeto.setFecha(new Date());
		objeto.setTexto("Soy el segundo");
		objeto.setNumero(new Integer(2));
		lista.add(objeto);
		objeto = new Prueba_Ordenacion();
		objeto.setFecha(new Date());
		objeto.setTexto("Soy el tercero");
		objeto.setNumero(new Integer(3));
		lista.add(objeto);

		System.out.println("");
	}

	/**
	 * Proceso de ordenacion indicando el sentido ascendente/desdente.
	 * 
	 * @param sentido
	 *            Valor entero que indica el sentido de la ordenacion.
	 * @return Coleccion ordenada.
	 */
	public List<Prueba_Ordenacion> ordenar_ConSentido(int sentido) {
		this.sentido = sentido;
		this.campo_ordenacion = 1;
		Collections.sort(lista, this);
		return lista;
	}

	/**
	 * Proceso de ordenacion indicando el sentido ascendente/desdente y la
	 * propiedad por la que se ordenara.
	 * 
	 * @param sentido
	 *            Valor entero que indica el sentido de la ordenacion.
	 * @param propiedad
	 *            Valor entero que indica la propiedad por la que se ordenara.
	 * @return Coleccion ordenada.
	 */
	public List<Prueba_Ordenacion> ordenar_PorPropiedad(int sentido, int propiedad) {
		this.sentido = sentido;
		this.campo_ordenacion = propiedad;
		Collections.sort(lista, this);
		return lista;
	}

	/**
	 * Implementacion de la interface {@link Comparator} con la logica de
	 * proceso que hemos querido incluir.
	 * 
	 * @return Valor numero entero que le indicara al metodo sort como quedaran
	 *         los elementos en la tabla.
	 */
	@Override
	public int compare(Prueba_Ordenacion prueba1, Prueba_Ordenacion prueba2) {
		int posicion = 0;
		if (sentido == 1 && campo_ordenacion == 1) {
			posicion = prueba1.getNumero().compareTo(prueba2.getNumero());
		}
		if (sentido == 2 && campo_ordenacion == 1) {
			posicion = prueba2.getNumero().compareTo(prueba1.getNumero());
		}
		if (sentido == 1 && campo_ordenacion == 2) {
			posicion = prueba1.getTexto().compareTo(prueba2.getTexto());
		}
		if (sentido == 2 && campo_ordenacion == 2) {
			posicion = prueba2.getTexto().compareTo(prueba1.getTexto());
		}
		if (sentido == 1 && campo_ordenacion == 3) {
			posicion = prueba1.getFecha().compareTo(prueba2.getFecha());
		}
		if (sentido == 2 && campo_ordenacion == 3) {
			posicion = prueba2.getFecha().compareTo(prueba1.getFecha());
		}
		return posicion;
	}

}
