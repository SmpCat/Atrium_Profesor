package com.atrium.controlador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.FilterReader;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberInputStream;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.io.SequenceInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

/**
 * Ejemplo de sintaxis de elementos del paquete IO para el procesamiento de
 * lecturas/escrituras de fuente de datos externas a un programa.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 *
 */
@SuppressWarnings(value = { "unused" })
public class Ejemplo_FileIO {

	/**
	 * Clase FILE de IO.
	 */
	public void ejemplo_File() {

		// URL ficheros_externos=new URL("");
		// REPRESENTACION DE UN FICHERO
		File fichero = new File("ruta absoluta - nombre fichero");
		// REPRESENTACION DE UN DIRECTORIO
		File directorio = new File("ruta directorio");

		// ***** METODOS PARA DIRECTORIOS
		// INFORMACION DE ESPACIO
		long espacio_totalunidad = directorio.getTotalSpace();
		long espacio_libre = directorio.getFreeSpace();
		long espacio_usuado = directorio.getUsableSpace();
		// INFORMACION DE CONTENIDO DEL DIRECTORIO
		String[] tabla_contenido = directorio.list();
		File tabla_conte[] = directorio.listFiles();
		// CREACION DE DIRECTORIO/OS
		boolean correcto = directorio.mkdir();
		correcto = directorio.mkdirs();

		// **** METODOS PARA FICHEROS Y DIRECTORIOS
		// RUTA ABSOLUTA
		String ruta = directorio.getAbsolutePath();
		// EXISTENCIA DEL RECURSO
		boolean existe = fichero.exists();
		// TIPO DE RECURSO
		boolean directorio_tipo = directorio.isDirectory();
		boolean fichero_tipo = fichero.isFile();
		// BORRADO DEL RECURSO
		boolean borrado = directorio.delete();
		directorio.deleteOnExit();
		// INFORMACION DE LAS UNIDADES DISPONIBLES DEL SISTEMA OPERATIVO
		File tabla_unidades[] = File.listRoots();

		// ***** METODOS PARA FICHEROS
		// INFORMACION DE PERMISOS DEL FICHERO
		boolean opcion = fichero.canRead();
		opcion = fichero.canWrite();
		opcion = fichero.canExecute();
		opcion = fichero.isHidden();
		// CAMBIO DE PERMISOS DEL FICHERO
		opcion = fichero.setReadable(true);
		opcion = fichero.setWritable(true);
		opcion = fichero.setExecutable(true);
		opcion = fichero.setReadOnly();
		// CREACION DEL FICHERO
		try {
			opcion = fichero.createNewFile();
		} catch (IOException e) {
			// ERROR EN LA CREACION DEL FICHERO
			e.printStackTrace();
		}

	}

	/**
	 * Ejemplos de flujos lectura/escritura en IO.
	 * 
	 * @throws IOException
	 */
	public void ejemplo_Flujos() throws IOException {
		// PROCESO DE LECTURA
		// 1º ABRIR UN FLUJO A LA FUENTE DE DATOS
		// -- DISPOSITIVO FISICO TECLADO
		// -- DISPOSITIVO LOGICO SOCKET REMOTO
		// -- FICHERO
		// 2º LEER MIENTRAS EXISTAN DATOS DISPONIBLES
		// 3º CERRAR EL FLUJO DE LECTURA

		// ORIGEN LECTURA -- DISPOSITIVO FISICO
		InputStream flujo_entrada = System.in;

		byte tabla_lectura[] = new byte[1024];
		// ********** TRATAMIENTO DE BYTES
		// *** LECTURA
		// LECTURA DE BYTES RELLENANDO LA TABLA DADA
		ByteArrayInputStream buffer_bytes = new ByteArrayInputStream(tabla_lectura);
		// LECTURA DE BYTES SEGUN LOS PROCESOS ESTANDAR DE LECTURA
		FileInputStream lectura_ficherosnocaracter = new FileInputStream("ruta-nombrefichero");
		// CLASE PADRE DE UN CONJUNTO DE FLUJOS DE LECTURA ESPECIALIZADOS
		FilterInputStream lectura_bytes;
		// *** SUBCLASES DE LA ANTERIOR CON METODOS ESPECIALIZADOS DE LECTURA
		BufferedInputStream lectura_bytessecuencial = new BufferedInputStream(flujo_entrada);
		DataInputStream lectura_datosprimitivas = new DataInputStream(flujo_entrada);
		LineNumberInputStream lis;
		PushbackInputStream lectura_conretroceso = new PushbackInputStream(flujo_entrada);
		// LECTURA CON CONTROL DE ACCESO
		PipedInputStream lectura_sincronizada = new PipedInputStream();
		// ENCADENAMIENTO DE LECTURAS
		SequenceInputStream lectura_encadenada = new SequenceInputStream(lectura_datosprimitivas,
				lectura_datosprimitivas);

		// **** METODOS GENERALES DE LECTURA
		// READ
		// SKIP
		// RESET
		// MARK

		// ********************************************************************************************

		// PROCESO DE ESCRITURA
		// 1º ABRIR UN FLUJO A LA FUENTE DE DATOS
		// -- DISPOSITIVO FISICO PANTALLA
		// -- DISPOSITIVO LOGICO SOCKET LOCAL
		// -- FICHERO
		// 2º ESCRIBIR MIENTRAS EXISTAN DATOS DISPONIBLES
		// 3º CERRAR EL FLUJO DE ESCRITURA

		// DESTINO DEL FLUJO DE SALIDA FICHERO
		File fichero_salida = new File("ruta -- nombre fichero");

		// *** ESCRITURA BYTES
		// ESCRITURA POR BLOQUES -- DISPOSITIVOS
		ByteArrayOutputStream buffer_escritura = new ByteArrayOutputStream();
		// ESCRITURA A FICHEROS
		FileOutputStream flujo_fichero = new FileOutputStream(fichero_salida);
		// CLASE PADRE DE UN CONJUNTO DE FLUJOS DE ESCRITURA ESPECIALIZADOS
		FilterOutputStream escritura_bytes;
		// **** TRATAMIENTO DE BUFFER
		BufferedOutputStream escritura_bytessecuencial = new BufferedOutputStream(flujo_fichero);
		// **** TRATAMIENTO DE PRIMITIVAS
		DataOutputStream escritura_datosprimitivas = new DataOutputStream(flujo_fichero);
		// **** TRATAMIENTO SEGUN SISTEMA OPERATIVO
		PrintStream escritura_altonivel = new PrintStream(flujo_fichero);
		// ESCRITURA SINCRONIZADA CON UNA LECTURA
		try {
			PipedOutputStream escritura_sincronizada = new PipedOutputStream(lectura_sincronizada);
		} catch (IOException e) {
			// ERROR EN LA SINCRONIZACION
			e.printStackTrace();
		}

		// **** METODOS GENERALES DE ESCRITURA
		// WRITE
		// FLUSH
		// CLOSE

		// ********** TRATAMIENTO DE CARACTERES
		// RECURSO FICHERO A LEER
		FileReader fichero_entrada = new FileReader("ruta -- nombre fichero");
		// RECURSO FICHERO A ESCRIBIR
		FileWriter fichero_salidacaracteres = new FileWriter("ruta -- nombre fichero");
		// RECURSO DE LECTURA EN CHAR
		char tabla_caracteres[] = new char[1024];

		// *** LECTURA
		// LECTURA DE CARACTERES
		BufferedReader buffer_caracteres = new BufferedReader(fichero_entrada);
		// LECTURA DE CARACTERES POR LINEAS
		LineNumberReader lectura_porlineas = new LineNumberReader(fichero_entrada);
		// LECTURA EN ARRAY DE CHAR
		CharArrayReader lectura_arraychar = new CharArrayReader(tabla_caracteres);
		// CLASE ABSTRACTA PARA LA LECTURA ESPECIALIZADA
		FilterReader filtro_lectura;
		// LECTURA CON RETROCESO
		PushbackReader lectura_caracteresconretroceso = new PushbackReader(fichero_entrada);
		// PUENTE ENTRE BYTES Y CARACTERES
		InputStreamReader lectura_basicacaracteres;
		// LECTURA DE CARACTERES CON CONVERSION A STRING
		FileReader lectura_caracteres = new FileReader(fichero_salida);
		// FLUJO DE LECTURA SINCRONIZABLE CON FLUJO DE ESCRITURA
		PipedReader lectura_caractressincronizada = new PipedReader();
		// LECTURA DE UN OBJETO STRING
		StringReader sri = new StringReader("origen de datos para el flujo");

		// *** ESCRITURA
		// ESCRITURA VIA BUFFER EN FICHERO A PARTIR DE CARACTERES
		BufferedWriter buffer_escrituracaracteres = new BufferedWriter(fichero_salidacaracteres);
		// ESCRITURA VIA ARRAY DE CHAR
		CharArrayWriter escritura_caratereschar = new CharArrayWriter();
		// CLASE ABSTRACTA PARA LA DEFINICION DE FLUJOS DE SALIDA
		FilterWriter fw;
		// PUENTE ENTRE BYTES Y CARACTERES
		OutputStreamWriter osw;
		// ESCRITURA DE FICHEROS A PARTIR DE STRING
		try {
			FileWriter escritura_caracteres = new FileWriter(fichero_salida);
		} catch (IOException e) {
			// ERROR EN EL ACCESO AL FICHERO A ESCRIBIR
			e.printStackTrace();
		}
		// ESCRITURA SINCRONIZADA CON LECTURA
		PipedWriter escritura_caracteressincronizada = new PipedWriter(lectura_caractressincronizada);
		// **** TRATAMIENTO SEGUN SISTEMA OPERATIVO
		PrintWriter escritura_caracteresaltonivel = new PrintWriter(fichero_salidacaracteres);
		// CREACION DE UN STRING A PARTIR DE DATOS LEIDOS
		StringWriter escritura_caracteres = new StringWriter();

		// ********** PROCESO DE SERIALIZACION
		// CONVERSION DE OBJETOS A FICHEROS Y VICEVERSA
		// SE LEE FICHERO PARA OBTENER OBJETO
		ObjectInputStream lectura_objeto = new ObjectInputStream(lectura_encadenada);
		// SE TRATA OBJETO PARA ESCRIBIR FICHERO
		ObjectOutputStream escritura_objeto = new ObjectOutputStream(escritura_altonivel);

	}

}
