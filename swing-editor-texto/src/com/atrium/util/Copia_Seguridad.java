package com.atrium.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Proceso general de creacion de copia de seguridad de ficheros
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 30-6-2015.
 * 
 */

public class Copia_Seguridad {
	// PROPIEDADES DE CLASE
	private static StringBuilder texto_total;

	/**
	 * Proceso de copia de seguridad de un fichero. <br/>
	 * Normas de la copia:<br/>
	 * 1º La copia tiene el mismo nombre que el fichero anterior, con al fecha y
	 * hora añadida (datacion).<br/>
	 * 2º Se hace en la misma ruta donde esta el fichero anterior.
	 * 
	 * @param fichero_acopiar
	 *            Objeto File a tratar.
	 * @throws Fallo_EnCopiaException
	 *             Error en el proceso de la copia de seguridad.
	 */
	public static void crear_Copia(File fichero_acopiar)
			throws Fallo_EnCopiaException {
		String ruta = fichero_acopiar.getAbsolutePath();
		// FORMATO DE FECHA DE LA COPIA DE SEGURIDAD
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH-mm");
		// AÑADIMOS LA FECHA A LA COPIA DE SEGURIDAD
		File copia_seguridad = new File(ruta + "." + formato.format(new Date()));
		// DECLARAMOS DE SOLO LECTURA LA COPIA DE SEGURIDAD
		copia_seguridad.setReadOnly();
		// ESCRIBIMOS LA COPIA DE SEGURIDAD
		FileWriter copia_s;
		try {
			copia_s = new FileWriter(copia_seguridad);
		} catch (IOException e1) {
			throw new Fallo_EnCopiaException(
					ITipos_FalloCopias.ERROR_FICHEROCOPIA);
		}
		// LEEMOS EL CONTENIDO DEL FICHERO existente
		FileReader flujo;
		try {
			flujo = new FileReader(fichero_acopiar);
		} catch (FileNotFoundException e1) {
			throw new Fallo_EnCopiaException(
					ITipos_FalloCopias.RUTA_COPIANOVALIDA);
		}
		BufferedReader lector = new BufferedReader(flujo);
		String texto_leido = "";
		texto_total = new StringBuilder();
		// REALIZAMOS EL PROCESO DE LECTURA
		while (texto_leido != null) {
			try {
				// LEO DEL FICHERO ANTIGUO
				texto_leido = lector.readLine();
				if (texto_leido != null) {
					texto_leido = texto_leido
							+ System.getProperty("line.separator");
					// COPIA AL FICHERO NUEVO
					copia_s.append(texto_leido);
				} else {
					// CERRAMOS EL FLUJO DE ESCRITURA
					copia_s.flush();
					copia_s.close();
					// CERRAMOS EL FLUJO DE LECTURA
					flujo.close();
				}
			} catch (IOException e) {
				throw new Fallo_EnCopiaException(
						Fallo_EnCopiaException.ERROR_INDETERMINADO);
			}
		}
	}

}
