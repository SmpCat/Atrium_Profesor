package com.atrium.socket;

import java.io.*;
import java.net.*;

/**
 * Ejemplo de cliente para comunicacion via socket.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-2-2017.
 *
 */
public class Cliente_Socekt {

	/**
	 * Ejemplo de metodo de arranque de programa cliente de socket.
	 * 
	 * @param args
	 *            Parametros de la consola del operativo.
	 */
	public static void main(String[] args) throws Exception {
		// NOMBRE DEL ORDENADOR NOMBRE RESIDE EL PROGRAMA QUE ESCUCHA/ATIENDE
		// LAS PETICIONES
		String serverName = "A2-01J";
		// PUERTO LOGICO A DONDE DIRIGIR LA PETICION
		int serverPort = 1111;
		// TEXTO DEL MENSAJE QUE SE MANDARA AL SERVIDOR
		String message = "hola mundo de las comunicaciones Cliente: " + Inet4Address.getLocalHost() + "\nquit";
		// INSTANCIA DEL CLIENTE
		Socket cliente_socket = new Socket();
		// CONEXION CON EL SERVIDOR
		cliente_socket.connect(new InetSocketAddress(serverName, serverPort));
		// FLUJO POR DONDE SE ENVIA LA INFORMACION AL SERVIDOR
		DataOutputStream dos = new DataOutputStream(cliente_socket.getOutputStream());
		// ENVIO DE INFORMACION
		dos.writeUTF(message);
		// CIERRE DEL FLUJO/CLIENTE
		dos.close();
		//CIERRE DE LA CONEXION
		cliente_socket.close();
	}

}
