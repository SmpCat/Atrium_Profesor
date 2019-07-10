package com.atrium.system;

import java.io.Console;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Ejemplo de uso de opciones de la clase system.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 12-10-2016.
 */
public class Prueba_System {

	public static void main(String arg[]) {
		Prueba_System prueba = new Prueba_System();
		prueba.comprobar_VariablesEntorno();
		prueba.comprobar_VariablesEntornoJava();
		prueba.gestionar_VariablesEntornoJava();
	}

	/**
	 * Proceso de obtencion de las variables de entorno del sistema operativo,
	 * sea el que sea.<br/>
	 * Estas no son modificables desde JAVA.
	 */
	public void comprobar_VariablesEntorno() {
		// RECOGEMOS EL CONJUNTO DE VARIABLES DEL SISTEMA EN UN MAPA
		Map<String, String> mapa_entorno = System.getenv();
		Set<String> lista_claves = mapa_entorno.keySet();
		// PROCESAMOS EL CONTENIDO DEL MAPA PARA MOSTRARLO POR CONSOLA
		for (String clave : lista_claves) {
			System.out.println("Nombre variable entorno: " + clave + " valor: "
					+ mapa_entorno.get(clave));
		}
	}

	/**
	 * Proceso de obtencion de variables de entorno propias de JAVA. No
	 * confundir con las variables de entorno del sistema operativo.
	 */
	public void comprobar_VariablesEntornoJava() {
		// RECOGEMOS EL CONJUNTO DE VARIABLES DE JAVA EN UN PROPERTIES
		Properties mapa_entornojava = System.getProperties();
		Set<Object> lista_claves = mapa_entornojava.keySet();
		// PROCESAMOS EL CONTENIDO DEL PROPERTIES PARA MOSTRARLO POR CONSOLA
		for (Object clave : lista_claves) {
			System.out.println("Nombre variable entorno: " + clave + " valor: "
					+ mapa_entornojava.get(clave));
		}
	}

	/**
	 * Procesos de alta, modificacion y eliminacion de variables de entorno
	 * dentro del system.
	 */
	public void gestionar_VariablesEntornoJava() {
		// AÑADIMOS UNA NUEVA VARIABLE
		System.setProperty("nombre variable nueva", "valor nuevo");
		this.comprobar_VariablesEntornoJava();
		// MODIFICAMOS UNA VARIABLE
		System.setProperty("nombre variable nueva", "otro valor distinto");
		this.comprobar_VariablesEntornoJava();
		// ELIMINACION DE UNA VARIABLE
		System.clearProperty("nombre variable nueva");
		this.comprobar_VariablesEntornoJava();
	}

	/**
	 * Borrado de la consola del sistema operativo mediante los comandos del
	 * sistema.
	 */
	private void borrar_ConsolaOperativo() {
		// RECOGEMOS EN UNA VARIABLE EL TIPO DE SU SO
		String sistemaOperativo = System.getProperty("os.name");
		try {
			// COMPROBAMOS SI SE TRATA DE WINDOWS
			if (sistemaOperativo.contains("Windows")) {
				// CLS ES EL COMANDO DE LIMPIEZA EN WINDOWS, PODEIS PROBARLO
				// ABRIENDO CMD.
				Runtime.getRuntime().exec("cls");
			} else {
				// CLEAR ES EL COMANDO DE LIMPIEZA EN LINUX.
				Runtime.getRuntime().exec("clear");
			}
			// SOLO COMPROBAMOS PARA WINDOWS Y LINUX A MODO DE EJEMPLO, YA QUE
			// SON LOS SISTEMAS OPERATIVOS MÁS COMUNES.
		} catch (Exception e) {
		}
	}
}
