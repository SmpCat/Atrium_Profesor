package com.atrium.flujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo de flujos del paquete IO para el procesamiento de lecturas/escrituras
 * de fuente de datos externas a un programa.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 5-10-2016.
 * 
 */
public class Lectura_EscrituraFichero {

	/**
	 * Arranque del proceso de prueba de flujos
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// CREACION DEL OBJETO
		Lectura_EscrituraFichero prueba = new Lectura_EscrituraFichero();
		try {
			// LLAMADA AL METODO
			prueba.proceso_LecturaEscritura();
			prueba.proceso_LecturaEscrituraBuffer();
			prueba.prueba_DataStream();
		} catch (Exception e) {
			// ERROR EN EL PROCESO
			e.printStackTrace();
		}
	}

	/**
	 * Proceso de lectura del fichero de entrada y escritura en el de salida.
	 * 
	 * @throws Exception
	 *             Excepcion delegada en el metodo superior.
	 */
	public void proceso_LecturaEscritura() throws Exception {
		// CREAMOS EL FLUJO DE LECTURA INDICANDO LA RUTA DE FORMA DINAMICA
		FileReader flujo_lector = new FileReader(this.getClass().getResource("fichero1.txt").getFile());
		// CREAMOS EL FLUJO DE ESCRITURA AL FICHERO DE SALIDA -- RUTA POR
		// DEFECTO, DONDE SE LEE
		FileWriter flujo_escritura = new FileWriter("fichero2.txt");
		int caracter = 0;
		// PROCESO REPETIVO DE LECTURA CARACTER A CARACTER
		while ((caracter = flujo_lector.read()) != -1) {
			// PROCESO DE ESCRITURA CARACTER A CARACTER
			flujo_escritura.write(caracter);
		}
		// CIERRE DEL FLUJO -- VERSION 7 AUTOCLOSABLE
		flujo_escritura.close();
	}

	/**
	 * Proceso de lectura del fichero de entrada y creacion del de salida
	 * mediante buffers para mejorar el coste del proceso.
	 * 
	 * @throws Exception
	 *             Excepcion delegada en el metodo superior.
	 */
	public void proceso_LecturaEscrituraBuffer() throws Exception {
		// CREAMOS EL FLUJO DE LECTURA INDICANDO LA RUTA DE FORMA DINAMICA
		FileReader flujo_lector = new FileReader(this.getClass().getResource("fichero1.txt").getFile());
		// PASAMOS EL FLUJO DE LECTURA AL BUFFER PARA LA OPTIMIZACION DEL
		// PROCESO
		BufferedReader buffer_lector = new BufferedReader(flujo_lector);
		// CREAMOS EL FLUJO DE ESCRITURA AL FICHERO DE SALIDA -- RUTA POR
		// DEFECTO, DONDE SE LEE
		FileWriter flujo_escritura = new FileWriter("fichero2.txt");
		// PASAMOS EL FLUJO DE ESCRITURA AL BUFFER PARA LA OPTIMIZACION DEL
		// PROCESO
		BufferedWriter buffer_escritura = new BufferedWriter(flujo_escritura);
		// LEEMOS Y ESCRIBIMOS UNA SOLO VEZ
		buffer_escritura.write(buffer_lector.readLine());

		// EN CASO DE TENER MULTIPLES LINEAS EL PROCESO DE LECTURA SERIA
		// REPETITVO DE LA SIGUIENTE FORMA
		// PREPARAMOS LO NUEVOS FLUJOS PARA TRATAR OTROS FICHEROS
		flujo_lector = new FileReader(this.getClass().getResource("fichero_multipleslineas.txt").getFile());
		buffer_lector = new BufferedReader(flujo_lector);
		flujo_escritura = new FileWriter("fichero_multipleslineas2.txt");
		buffer_escritura = new BufferedWriter(flujo_escritura);
		// TEXTO LEIDO EN CADA OPERACION
		String leido = "";
		// ACUMULACION DE TODO EL TEXTO LEIDO
		StringBuffer acumulacion_leido = new StringBuffer();
		// PROCESO REPETITVO DE LECTURA HASTA FIN DE FICHERO
		while (leido != null) {
			// LECTURA HASTA EL INTRO (O CUALQUIER OTRO CARACTER EN FUNCION
			// DEL OPERATIVO
			leido = buffer_lector.readLine();
			if (leido != null) {
				// ACUMULAMOS EL TEXTO TOTAL YA LEIDO DEL FICHERO Y
				// AÑADIMOS EL SALTO DE LINEA DEL OPERATIVO
				acumulacion_leido.append(leido + System.getProperty("line.separator"));
			}
		}
		// ESCRIBIMOS TODO EL TEXTO EN UN SOLA LLAMADA AL METODO
		buffer_escritura.write(acumulacion_leido.toString());
		// CERRAMOS
		buffer_escritura.close();
	}

	/**
	 * Prueba de lectura/escritura de primitivas. Tambien añadimos a modo de
	 * demostracion el uso de la interface closable con el try, opcion
	 * especifica de JAVA 7.
	 * 
	 * @throws Exception
	 *             Excepcion delegada en el metodo superior.
	 */
	public void prueba_DataStream() throws Exception {
		// FLUJO DE ESCRITURA AL FICHERO QUE VA A SER CREADO
		FileOutputStream flujo_escritura = new FileOutputStream("primitivas.dat");
		// APERTURA DEL FLUJO DE PRIMITIVAS DENTRO DE UN TRY PARA LA GESTION DEL
		// AUTOCLOSE
		try (DataOutputStream escritura_primitivas = new DataOutputStream(flujo_escritura)) {
			// ESCRIBIMOS LOS DATOS EN EL FICHERO
			escritura_primitivas.writeInt(250);
			escritura_primitivas.writeDouble(10.36);
			escritura_primitivas.writeBoolean(true);
			escritura_primitivas.writeChars("SOY UN TEXTO");
		}
		// FLUJO DE LECTURA DE PRIMITIVAS
		FileInputStream flujo_lectura = new FileInputStream("primitivas.dat");
		// APERTURA DEL FLUJO DE PRIMITIVAS DENTRO DE UN TRY PARA LA GESTION DEL
		// AUTOCLOSE
		try (DataInputStream lectura_primitivas = new DataInputStream(flujo_lectura)) {
			// LECTURA DE LOS DATOS Y SU PASO A PRIMITIVAS
			int valor_entero = lectura_primitivas.readInt();
			double valor_doble = lectura_primitivas.readDouble();
			boolean valor_logico = lectura_primitivas.readBoolean();
			char valor_char = lectura_primitivas.readChar();
		}
	}
}
