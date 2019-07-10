package com.atrium.XML;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Clase que lee un documento XML dado.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 7-10-2016.
 *
 */
public class Tratar_XML {
	// PROPIEDADES DE CLASE
	private String nombre_XML = null;
	private Eventos_Tratar_CochesXML ev = null;

	/**
	 * Proceso de lectura del XML.
	 */
	public void leer_Coches_XML() {
		try {
			// LECTOR DEL XML
			XMLReader lector = XMLReaderFactory.createXMLReader();
			// ASOCIACION DEL ESCUCHADOR DE EVENTOS
			ev = new Eventos_Tratar_CochesXML();
			lector.setContentHandler(ev);
			// PARSEADO DEL DOCUMENTO
			lector.parse(this.getNombre_XML());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ********** ACCESORES DE LAS PROPIEDADES DE CLASE
	public Eventos_Tratar_CochesXML getEv() {
		return ev;
	}

	public void setEv(Eventos_Tratar_CochesXML ev) {
		this.ev = ev;
	}

	public String getNombre_XML() {
		return nombre_XML;
	}

	public void setNombre_XML(String nombre_XML) {
		this.nombre_XML = nombre_XML;
	}

}
