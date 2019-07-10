package com.atrium.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Conjunto de procesos de ficheros. Cada metodo es capaz de realizar un proceso
 * con un fichero,como por ejemplo copiar, leer... Se puede usar en cada uno de
 * los metodos una metodologia y unas apis distintas.<br/>
 * Sirven como ejemplo del uso de las apis de ficheros.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 3.0
 * @since 13-6-2016.
 * 
 */
@Component("tratar_ficheros")
@Scope("prototype")
public class Tratar_Ficheros implements ITratar_Ficheros {

	private InputStream flujo_lectura;
	private byte buffer[];

	// *********** PROCESOS DE LECTURA DE FICHEROS
	/**
	 * Proceso de lectura de ficheros en una solo operacion.<br/>
	 * Valido para ficheros de tamaño reducido.
	 */
	@Override
	public byte[] leer_Ficheros(File fichero_aleer) throws Exception {
		InputStream lectura = null;
		int cantidad_aleer;
		// TABLA CON LOS ELEMENTOS SEGUN TAMAÑO FICHERO
		byte[] buffer = new byte[(int) fichero_aleer.length()];
		try {
			lectura = new FileInputStream(fichero_aleer);
			// LECTURA DEL FICHERO
			cantidad_aleer = lectura.read(buffer);
		} catch (Exception e) {
			// ERROR EN LA LECTURA
			throw e;
		} finally {
			if (lectura != null) {
				lectura.close();
			}
		}
		return buffer;
	}

	/**
	 * Proceso de lectura de ficheros por paquetes de tamaño fijo.<br/>
	 * El contenido leido se expone en una propiedad de clase llamada buffer
	 * mediante su accesor.
	 * 
	 * @param fichero_aleer
	 *            Objeto file que representa el fichero a leer.
	 * @return Cantidad de bytes leidos, sirve de control de fin de fichero.
	 */
	@Override
	public int leer_FicheroPorPaquetes(File fichero_aleer) throws Exception {
		int cantidad_leida = -1;
		if (flujo_lectura == null) {
			flujo_lectura = new FileInputStream(fichero_aleer);
		}
		// TABLA CON LOS ELEMENTOS SEGUN TAMAÑO PAQUETE (2KB)
		buffer = new byte[2048];
		try {
			// LECTURA DEL FICHERO
			cantidad_leida = flujo_lectura.read(buffer);
			// TRATAMIENTO ULTIMO PAQUETE DEL FICHERO A DESCARGAR
			if (cantidad_leida != 2048 && cantidad_leida > -1) {
				// REDIMENSIONAMOS LA TABLA A LOS BYTES RESTANTES DEL FICHERO
				buffer = Arrays.copyOf(buffer, cantidad_leida);
			}
		} catch (Exception e) {
			// CIERRE DE FLUJO EN CASO DE ERROR DE FICHERO
			flujo_lectura.close();
			throw e;
		}
		// RETORNAMOS EL VALOR DE CONTROL DE FINAL DE FICHERO
		return cantidad_leida;
	}

	/**
	 * Proceso de lectura de ficheros por paquetes de tamaño variable segun
	 * necesidades.<br/>
	 * El contenido leido se expone en una propiedad de clase llamada buffer
	 * mediante su accesor.
	 * 
	 * @param fichero_aleer
	 *            Objeto file que representa el fichero a leer.
	 * @param tamaño_paquete
	 *            Valor numerico que representa eltamaño del paquete a leer en
	 *            cada operacion.
	 * @return Cantidad de bytes leidos, sirve de control de fin de fichero.
	 * @throws Exception
	 */
	@Override
	public int leer_FicheroPorPaquetes(File fichero_aleer, int tamaño_paquete)
			throws Exception {
		int cantidad_leida = -1;
		if (flujo_lectura == null) {
			flujo_lectura = new FileInputStream(fichero_aleer);
		}
		// TABLA CON LOS ELEMENTOS SEGUN TAMAÑO INDICADO
		buffer = new byte[tamaño_paquete];
		try {
			// LECTURA DEL FICHERO
			cantidad_leida = flujo_lectura.read(buffer);
			// TRATAMIENTO ULTIMO PAQUETE DEL FICHERO A DESCARGAR
			if (cantidad_leida != tamaño_paquete && cantidad_leida > -1) {
				// REDIMENSIONAMOS LA TABLA A LOS BYTES RESTANTES DEL FICHERO
				buffer = Arrays.copyOf(buffer, cantidad_leida);
			}
		} catch (Exception e) {
			// CIERRE DE FLUJO EN CASO DE ERROR DE FICHERO
			flujo_lectura.close();
			throw e;
		}
		// RETORNAMOS EL VALOR DE CONTROL DE FINAL DE FICHERO
		return cantidad_leida;
	}

	// *********** FIN PROCESOS DE LECTURA DE FICHEROS

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

	@Override
	public void copiar_FicherosNIO(File fichero_entrada, File fichero_salida)
			throws IOException {
		// PREPARO CANAL DE ENTRADA
		FileChannel inChannel = new FileInputStream(fichero_entrada)
				.getChannel();
		// PREPARO CANAL DE SALIDA
		FileChannel outChannel = new FileOutputStream(fichero_salida)
				.getChannel();
		try {
			// SE TRANSFIERE LA INFORMACION DEL FICHERO DE ENTRADA AL DE SALIDA
			// MEDIANTE STREAMING
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
	}

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

	@Override
	public void copiar_FicherosIO(File fichero_entrada, File fichero_salida)
			throws Exception {
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(
				fichero_entrada));
		BufferedOutputStream fos = new BufferedOutputStream(
				new FileOutputStream(fichero_salida));
		try {
			// TAMAÑO DE PAQUETE
			byte[] buf = new byte[2048];
			int i = 0;
			// SE LEE UN PAQUETE
			while ((i = fis.read(buf)) != -1) {
				// SE ESCRIBE EL PAQUETE LEIDO
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}

	/**
	 * Opcion de copia de ficheros para IO.
	 * 
	 * @param fichero_entrada
	 *            Fichero que va ha ser copiado.
	 * @param fichero_salida
	 *            Fichero de salida (la copia).
	 * @throws Exception
	 */

	@Override
	public void copiar_FicherosIO(InputStream fichero_entrada,
			File fichero_salida) throws Exception {
		BufferedInputStream fis = new BufferedInputStream(fichero_entrada);
		BufferedOutputStream fos = new BufferedOutputStream(
				new FileOutputStream(fichero_salida));
		try {
			byte[] buf = new byte[2048];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null)
				fis.close();
			if (fos != null)
				fos.close();
		}
	}

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

	@Override
	public void copiar_FicherosIO(String fichero_entrada, String fichero_salida)
			throws IOException {
		InputStream in = null;
		OutputStream out = null;
		int amountRead;
		byte[] buffer = new byte[2048];
		try {
			in = new FileInputStream(fichero_entrada);
			out = new FileOutputStream(fichero_salida);
			while (true) {
				amountRead = in.read(buffer);
				if (amountRead == -1) {
					break;
				}
				out.write(buffer, 0, amountRead);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	// ACCESOR DE LA PROPIEDAD QUE CONTIENE LOS DATOS LEIDOS
	@Override
	public byte[] getBuffer() {
		return buffer;
	}

	@Override
	public InputStream getFlujo_lectura() {
		return flujo_lectura;
	}

}
