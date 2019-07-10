package com.atrium.modelo;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * DAO de acceso a la fuente de datos del ejemplo.<br/>
 * Para este ejemplo la fuente de datos es un fichero XML, por lo tanto para la
 * comprension del codigo es necesario ver las clases de tratamiento de XML.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-9-2016.
 * 
 * 
 */
public class Datos_DAO extends DefaultHandler {
	// PROPIEDADES DE CLASE
	private String etiqueta_leida;
	private Datos_DTO datos;

	/**
	 * Constuctor de clase con la instancia del DTO.
	 */
	public Datos_DAO() {
		datos = new Datos_DTO();
	}

	/**
	 * Proceso de lectura del XML mediante SAX.
	 * 
	 * @return Datos_DTO Objeto con la informacion leida del fichero XML.
	 */
	public Datos_DTO leer_Datos() {
		try {
			// FLUJO DE LECTURA EN XML
			XMLReader lector = XMLReaderFactory.createXMLReader();
			// ESCUCHADOR DE EVENTOS DE LECTURA
			lector.setContentHandler(this);
			// PROCESO DE "PARSEO" LECTURA DEL FICHERO
			lector.parse(this.getClass().getResource("/com/atrium/vista/datos.xml").getFile());
		} catch (SAXException e) {
			// TRATAMIENTO DEL ERRROR DE XML SI SE DA
			e.printStackTrace();
			datos = null;
		} catch (IOException e) {
			// TRATAMIENTO DEL ERRROR DE IO SI SE DA
			e.printStackTrace();
			datos = null;
		}
		return datos;
	}

	/**
	 * Proceso de escritura en el fichero XML mediante DOM.
	 * 
	 * @param datos_nuevos
	 *            Objeto DTO con la nueva informacion para el fichero.
	 * @return boolean Valor logico que indicara si el proceso de escritura se
	 *         ha realizado de forma correcta o no.
	 */
	public boolean escribir_Datos(Datos_DTO datos_nuevos) {
		boolean valido = true;
		try {
			// LEEMOS EL XML Y SE CREA LA ESTRUCTURA DOM
			DocumentBuilderFactory fact_dom = DocumentBuilderFactory.newInstance();
			DocumentBuilder lector = fact_dom.newDocumentBuilder();
			// OBTENEMOS EL OBJETO QUE TIENE SU CONTENIDO PARA MODIFICARLO
			Document documento_DOM = lector.parse(this.getClass().getResource("/com/atrium/vista/datos.xml").getFile());
			// COGEMOS LA ETIQUETA QUE CONTIENE EL ATRIBUTO A CAMBIAR
			Node elemento_xml = documento_DOM.getElementsByTagName("nombre").item(0);
			elemento_xml.setTextContent(datos_nuevos.getNombre());

			elemento_xml = documento_DOM.getElementsByTagName("apellido").item(0);
			elemento_xml.setTextContent(datos_nuevos.getApellido());

			elemento_xml = documento_DOM.getElementsByTagName("calle").item(0);
			elemento_xml.setTextContent(datos_nuevos.getCalle());

			elemento_xml = documento_DOM.getElementsByTagName("ciudad").item(0);
			elemento_xml.setTextContent(datos_nuevos.getCiudad());

			// ESCRIBIMOS EL DOCUMENTO MODIFICADO
			TransformerFactory fact = TransformerFactory.newInstance();
			Transformer flujo_escritura = fact.newTransformer();
			// QUE CONTENIDO VAMOS A ESCRIBIR
			DOMSource entrada_datos = new DOMSource(documento_DOM);
			// DONDE LO VAMOS A ESCRIBIR
			StreamResult apuntador = new StreamResult(
					this.getClass().getResource("/com/atrium/vista/datos.xml").getFile());
			// ESCRIBIMOS
			flujo_escritura.transform(entrada_datos, apuntador);
		} catch (Exception e) {
			// DETECCION DEL ERROR SI SE DA
			valido = false;
		}
		return valido;
	}

	// ******************* EVENTOS DE LECTURA SAX A TRATAR PARA EL PROCESO
	/**
	 * Proceso de lectura de etiqueta de apertura.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		etiqueta_leida = localName;
	}

	/**
	 * Proceso de lectura de contenido/informacion de la etiqueta
	 */
	@Override
	public void characters(char[] texto, int inicio, int tamaño) throws SAXException {
		String texto_eti = new String(texto, inicio, tamaño);
		if (texto_eti.indexOf("\n") == -1) {
			if (etiqueta_leida.equals("fecha")) {
				datos.setFecha(texto_eti);
			}
			if (etiqueta_leida.equals("autor")) {
				datos.setAutor(texto_eti);
			}
			if (etiqueta_leida.equals("nombre")) {
				datos.setNombre(texto_eti);
			}
			if (etiqueta_leida.equals("apellido")) {
				datos.setApellido(texto_eti);
			}
			if (etiqueta_leida.equals("calle")) {
				datos.setCalle(texto_eti);
			}
			if (etiqueta_leida.equals("ciudad")) {
				datos.setCiudad(texto_eti);
			}
		}
	}

}
