package com.atrium.controlador;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Ejemplo de proceso de escritura de XML con DOM.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 7-10-2016.
 *
 */
public class Ejemplo_DOM {

	/**
	 * Ejemplo de sintaxis para la escritura con DOM.
	 */
	public void ejemplo_EscrituraDOM() {
		try {
			// LEEMOS EL XML Y SE CREA LA ESTRUCTURA DOM
			DocumentBuilderFactory fact_dom = DocumentBuilderFactory.newInstance();
			DocumentBuilder lector = fact_dom.newDocumentBuilder();
			// OBTENEMOS EL OBJETO QUE TIENE SU CONTENIDO PARA MODIFICARLO
			Document documento_DOM = lector.parse("ruta -- nombre XML");
			// COGEMOS LA ETIQUETA QUE CONTIENE EL ATRIBUTO A CAMBIAR
			Node elemento_xml = documento_DOM.getElementsByTagName("nombre etiqueta XML").item(0);
			// CREAMOS UN NUEVO ATRIBUTO CON EL VALOR NUEVO DEL IDIOMA ELEGIDO
			Attr atributo_nuevo = documento_DOM.createAttribute("nombre nodo");
			atributo_nuevo.setNodeValue("valor nuevo");
			// PONEMOS EL ATRIBUTO NUEVO
			elemento_xml.getAttributes().setNamedItem(atributo_nuevo);
			// ESCRIBIMOS EL DOCUMENTO MODIFICADO
			TransformerFactory fact = TransformerFactory.newInstance();
			Transformer flujo_escritura = fact.newTransformer();
			// FORZAMOS LA COLOCACION DEL DOCTYPE DE OTRO MODO SE PIERDE AL
			// REESCRIBIR EL FICHERO CON EL TRANSFORM
			flujo_escritura.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, documento_DOM.getDoctype().getSystemId());
			// AÑADIR INDENTACION A LAS ETIQUETAS SI LES FALTA
			flujo_escritura.setOutputProperty(OutputKeys.INDENT, "yes");
			// QUE CONTENIDO VAMOS A ESCRIBIR
			DOMSource entrada_datos = new DOMSource(documento_DOM);
			// DONDE LO VAMOS A ESCRIBIR
			StreamResult apuntador = new StreamResult("ruta -- nombre XML");
			// ESCRIBIMOS
			flujo_escritura.transform(entrada_datos, apuntador);
		} catch (Exception e) {
			// TRATAMIENTO DEL ERROR SI SE PRODUCE
		}
	}

}
