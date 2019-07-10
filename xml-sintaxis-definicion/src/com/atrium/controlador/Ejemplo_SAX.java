package com.atrium.controlador;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Ejemplo de proceso de lectura de XML con SAX.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 7-10-2016.
 *
 */
public class Ejemplo_SAX extends DefaultHandler {

	/**
	 * Lectura del fichero XML via SAX.
	 */
	public void lectura_Sax() {
		try {
			// CREACION DEL FACTORY PARA LA OBTENCION DEL LECTOR
			SAXParserFactory sax_fabrica = SAXParserFactory.newInstance();
			try {
				// OBTENCION DEL LECTOR DEL XML
				SAXParser sax_lector = sax_fabrica.newSAXParser();
				// APUNTADOR DEL XML A TRATAR
				File fichero_xml = new File("ruta -- nombre XML");
				// LECTURA DEL XML
				sax_lector.parse(fichero_xml, this);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el fichero XML " + e.getMessage());
		}
	}

	// ********** TRATAMIENTO DE EVENTOS DE LECTURA
	/**
	 * Proceso inicial que nos sirve para conocerlo en la traza de depuracion.
	 */
	@Override
	public void startDocument() throws SAXException {

	}

	/**
	 * Proceso final que nos sirve para mostrar el total de informacion
	 * procesada en la traza de depuracion.
	 */
	@Override
	public void endDocument() throws SAXException {

	}

	/**
	 * Proceso de las etiquetas de apertura del fichero XML.<br/>
	 * Cada una de estas es tratada en un IF distinto para poder distinguir unas
	 * etiquetas de otras.<br/>
	 * Las que poseen atributos son tratadas aqui y las que la informacion esta
	 * el cuerpo en el metodo characters.
	 * 
	 * @param localizador_externo
	 *            Nombre de la etiqueta acompañado de la referencia externa.
	 * @param localizador_interno
	 *            Nombre de la etiqueta acompañdo de la referencia interna.
	 * @param nombre_etiqueta
	 *            Nombre de la etiqueta.
	 * @param atributos
	 *            Mapa de los atributos de la etiqueta si es que los tiene.
	 * @throws SAXException
	 *             Excepcion arrojada en caso de error.
	 */
	@Override
	public void startElement(String localizador_externo, String localizador_interno, String nombre_etiqueta,
			Attributes atributos) throws SAXException {

	}

	/**
	 * Proceso del cuerpo de texto la etiqueta, cuando esta la tenga.<br/>
	 * Para ello recordamos en una variable de clase la etiqueta anterior leida.
	 * 
	 * @param contenido_XML
	 *            Tabla de char con todo el contenido del fichero.
	 * @param inicio_cadena
	 *            Posicion inicial dentro de la tabla del cuerpo de la etiqueta.
	 * @param fin_cadena
	 *            Posicion final dentro de la tabla del cuerpo de la etiqueta.
	 */
	@Override
	public void characters(char[] contenido_XML, int inicio_cadena, int fin_cadena) throws SAXException {

	}

	/**
	 * Proceso de las etiquetas de cierre.<br/>
	 * En este caso solo mostramos alguna informacion para la traza del proceso
	 * en el cierre de las etiuqetas que me interese.
	 * 
	 * @param localizador_externo
	 *            Nombre de la etiqueta acompañado de la referencia externa.
	 * @param localizador_interno
	 *            Nombre de la etiqueta acompañado de la referencia interna.
	 * @param nombre_etiqueta
	 *            Nombre de la etiqueta.
	 * @throws SAXException
	 *             Excpecion arrojada en caso de error.
	 */
	@Override
	public void endElement(String localizador_externo, String localizador_interno, String nombre_etiqueta)
			throws SAXException {

	}

}
