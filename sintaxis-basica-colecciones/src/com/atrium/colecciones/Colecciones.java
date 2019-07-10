package com.atrium.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase de uso de la coleccion List.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 */
public class Colecciones {
	// PROPIEDADES DE CLASE
	// COLECCION A USAR EN EL EJEMPLO
	private List<Integer> lista;
	private int elementos;

	/**
	 * Instanciacion de la coleccion a usar, con seguridad de tipo.
	 */
	public Colecciones() {
		lista = new ArrayList<Integer>();
		elementos = 0;
	}

	/**
	 * Proceso de carga del valor en la coleccion.
	 * 
	 * @param numero_nuevo
	 *            Integer a cargar.
	 * @return Valor booleano que nos indica si se carga el valor o no.
	 */
	public boolean cargar_Lista(Integer numero_nuevo) {
		boolean cargado = false;
		// LIMITE DE ELEMENTOS EN LA COLECCION
		if (elementos < 6) {
			// COMPROBACION DE QUE SEA UN NUMERO POSITIVO
			if (numero_nuevo.intValue() >= 0) {
				lista.add(numero_nuevo);
				elementos++;
				cargado = true;
			} else {
				System.out.println("Solo se admiten numeros positivos");
			}
		}
		return cargado;
	}

	/**
	 * Proceso de ordenacion de la coleccion.
	 */
	public void ordenar_Lista() {
		// LLAMADA AL SORT PARA LA ORDENACION.
		Collections.sort(lista);
	}

	/**
	 * Proceso de devolucion de valor menor. Solo util despues de ordenar la
	 * coleccion.
	 * 
	 * @return Integer menor.
	 */
	public Integer coger_Menor() {
		Integer salida = null;
		// COMPROBACION DE QUE LA COLECCION NO ESTE VACIA
		if (!lista.isEmpty()) {
			// OBTENCION DEL PRIMER ELEMENTO DE LA COLECCION
			salida = lista.get(0);
		}
		return salida;
	}

	/**
	 * Proceso de devolucion de valor mayor. Solo util despues de ordenar la
	 * coleccion.
	 * 
	 * @return Integer mayor.
	 */
	public Integer coger_Mayor() {
		Integer salida = null;
		// COMPROBACION DE QUE LA COLECCION NO ESTE VACIA
		if (!lista.isEmpty()) {
			// OBTENCION DEL ULTIMO ELEMENTO DE LA COLECCION
			salida = lista.get(lista.size() - 1);
		}
		return salida;
	}

	/**
	 * Proceso de calculo de la media numerica de los valores de la coleccion.
	 * 
	 * @return Media numerica.
	 */
	public Integer calcular_Media() {
		int total = 0;
		// RECORRIDO POR EL ITERADOR DE LA LISTA
		for (Integer numero : lista) {
			//ACUMULACION DE LOS VALORES MEDIANTE UNA SUMA
			total = total + numero.intValue();
		}
		//CALCULO DEL NUEMRO DE ELEMENTOS DE LA COLECCION
		int numero_elementos = lista.size() - 1;
		//CALCULO DE LA MEDIA
		Integer media = new Integer(total / numero_elementos);
		return media;
	}

	/**
	 * Proceso de vaciado de la coleccion.
	 */
	public void vaciar_Lista() {
		lista.clear();
	}
}
