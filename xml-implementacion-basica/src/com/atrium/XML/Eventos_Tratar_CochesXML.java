package com.atrium.XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Tratamiento de los eventos necesarios para la obtencion de la informacion.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 7-10-2016.
 *
 */
public class Eventos_Tratar_CochesXML extends DefaultHandler {
	// PROPIEDADES DE CLASE
	private String tabla[] = new String[10];
	private int posicion = 0;
	private String etiqueta_anterior = "";

	/**
	 * Evento de cuerpo con texto de etiqueta
	 */
	@Override
	public void characters(char[] textXML, int inicio, int fin) throws SAXException {
		System.out.println(new String(textXML, inicio, fin));
		// SOLO RECOGEMOS LA MARCA PARA SU USO EN EL PROGRAMA
		if (etiqueta_anterior.equals("marca")) {
			tabla[posicion] = new String(textXML, inicio, fin);
			etiqueta_anterior = "";
			posicion++;
		}
	}

	/**
	 * Evento de etiqueta de apertura.
	 */
	@Override
	public void startElement(String espacio_nombres, String nombre_completo, String nombre_etiqueta,
			Attributes atributos) throws SAXException {
		if (nombre_etiqueta.equals("cantidad")) {
			System.out.println("Cantidad: ");
			etiqueta_anterior = "cantidad";
		}
		if (nombre_etiqueta.equals("dia-embarque")) {
			System.out.println("Dia de embarque de la mercancia: ");
			etiqueta_anterior = "";
		}
		if (nombre_etiqueta.equals("coche")) {
			System.out.println("Datos del Coche: ");
			if (atributos.getLength() == 1) {
				System.out.println(atributos.getValue("segundamano"));
			}
			etiqueta_anterior = "";
		}
		if (nombre_etiqueta.equals("marca")) {
			System.out.println("Marca: ");
			etiqueta_anterior = "marca";
		}
		if (nombre_etiqueta.equals("modelo")) {
			System.out.println("Modelo: ");
			etiqueta_anterior = "";
		}
		if (nombre_etiqueta.equals("precio")) {
			System.out.println("Precio: ");
		}
		if (nombre_etiqueta.equals("kilometros")) {
			System.out.println("Kilometros reales: ");
		}
		if (nombre_etiqueta.equals("fecha-matriculacion")) {
			System.out.println("Fecha de Matricualcion: ");
		}

	}

	// ****** ACCESORES PARA LAS PROPIEDADES DE CLASE
	public String[] getTabla() {
		return tabla;
	}

	public void setTabla(String[] tabla) {
		this.tabla = tabla;
	}

}
