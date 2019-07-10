package com.atrium.controlador;

import java.util.List;

import com.atrium.modelo.Municipio;
import com.atrium.modelo.fachada.Gestion_Municipios;
import com.atrium.modelo.fachada.IGestion_Municipios;

/**
 * Ejemplo basico de creacion y uso de combos en una aplicacion sin entorno
 * grafico.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class Inicio_SinVentana {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREACION DE LA FACHADA
		IGestion_Municipios gestion_municipios = new Gestion_Municipios();
		// CONSULTA AL MODELO
		List<Municipio> lista_1 = gestion_municipios.consultar_PorProvincia(new Byte((byte) 1));
		// SALIDA POR CONSOLA DEL RESULTADO DE LA CONSULTA
		for (Municipio muni : lista_1) {
			System.out.println(muni.toString());
		}
		// CONSULTA AL MODELO
		List<Municipio> lista_2 = gestion_municipios.consultar_PorProvincia(new Byte((byte) 28));
		// SALIDA POR CONSOLA DEL RESULTADO DE LA CONSULTA
		for (Municipio muni : lista_2) {
			System.out.println(muni.toString());
		}
	}

}
