package com.atrium.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface ITratar_Ficheros {

	public byte[] leer_Ficheros(File fichero_aleer) throws Exception;

	public int leer_FicheroPorPaquetes(File fichero_aleer) throws Exception;

	// ************************ PROCESOS DE COPIA DE FICHEROS
	// ************* METODOS DE COPIADO USUANDO NIO
	/**
	 * Copia de ficheros usando las apis nuevas de flujos. Posibles problemas en
	 * algun tipo de ordenador. Opcion mas rapida
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws IOException
	 */

	public void copiar_FicherosNIO(File fichero_entrada, File fichero_salida)
			throws IOException;

	// ************* METODOS DE COPIADO USUANDO IO
	/**
	 * Opcion de copia de ficheros con IO. Segura en funcionamiento pero mas
	 * lenta que la opcion con NIO:
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws Exception
	 */

	public void copiar_FicherosIO(File fichero_entrada, File fichero_salida)
			throws Exception;

	/**
	 * Opcion de copia de ficheros para IO.
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws Exception
	 */

	public void copiar_FicherosIO(InputStream fichero_entrada,
			File fichero_salida) throws Exception;

	/**
	 * Copia de ficheros segura, mas lenta que la solucion de nio. Un poco mas
	 * rapida que la anterior, pero aun asi mas lenta que la nio.
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws IOException
	 */

	public void copiar_FicherosIO(String fichero_entrada, String fichero_salida)
			throws IOException;

	public abstract byte[] getBuffer();

	public abstract InputStream getFlujo_lectura();

	public abstract int leer_FicheroPorPaquetes(File fichero_aleer, int tamaño_paquete)
			throws Exception;

}