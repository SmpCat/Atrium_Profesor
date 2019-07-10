package com.atrium.listas;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Ejemplo de carga en propiedades compuestas. 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class ManejadorColecciones {
	private List lista;
	private Persona[] array;
	private Set conjunto;
	private Map mapa;
	private Properties propiedades;

	public void setLista(List lista) {
		this.lista = lista;
	}

	public void setArray(Persona[] array) {
		this.array = array;
	}

	public void setConjunto(Set conjunto) {
		this.conjunto = conjunto;
	}

	public void setMapa(Map mapa) {
		this.mapa = mapa;
	}

	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	public void muestraLista() {
		System.out.println("--- L I S T A ---");
		for (Object o : lista) {
			System.out.println(o.getClass() + ": " + o);
		}
	}

	public void muestraArray() {
		System.out.println("--- A R R A Y ---");
		for (Object o : array) {
			System.out.println(o.getClass() + ": " + o);
		}
	}

	public void muestraConjunto() {
		System.out.println("--- C O N J U N T O ---");
		for (Iterator it = this.conjunto.iterator(); it.hasNext();) {
			Object o = it.next();
			System.out.println(o.getClass() + ": " + o);
		}
	}

	public void muestraMapa() {
		System.out.println("--- M A P A ---");
		for (Iterator it = this.mapa.keySet().iterator(); it.hasNext();) {
			Object o = it.next();
			System.out.print("[clave] " + o.getClass() + ": " + o);
			System.out.println(", [valor] " + mapa.get(o).getClass() + ": "
					+ mapa.get(o));
		}
	}

	public void muestraPropiedades() {
		System.out.println("--- P R O P I E D A D E S ---");
		for (Iterator it = this.propiedades.keySet().iterator(); it.hasNext();) {
			Object o = it.next();
			System.out.print("[clave] " + o.getClass() + ": " + o);
			System.out.println(", [valor] " + propiedades.get(o).getClass()
					+ ": " + propiedades.get(o));
		}
	}
}
