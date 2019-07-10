package com.atrium.socket;

import java.io.*;
import java.net.*;

/**
 * Ejemplo de servidor para comunicacion via socket.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-2-2017.
 *
 */
public class Servidor_Socket {

	/**
	 * Ejemplo de metodo de arranque de programa servidor via socket.
	 * 
	 * @param args
	 *            Parametros de la consola del operativo.
	 */
	public static void main(String[] args) throws Exception {
		// CREACION DEL SERVIDOR PARA ATENDER LAS PETICIONES
		ServerSocket servidor_socket = new ServerSocket(1111);
		// TRAZA PARA INDICARNOS QUE EL SERVIDOR ARRANCA Y DONDE
		System.out.println("El server escucha por " + InetAddress.getLocalHost() + " a través del puerto "
				+ servidor_socket.getLocalPort());
		// BUCLE INFINITO PARA LA ESPERA DE LA LLEGADA DE PETICIONES
		while (true) {
			// PREPARAMOS EL OBJETO PARA LA RECEPCION DE PETICIONES
			Socket socket_escuchador = servidor_socket.accept();
			// PREPARAMOS EL FLUJO DE ENTRADA AL SERVIDOR
			DataInputStream flujo_entrada = new DataInputStream(socket_escuchador.getInputStream());
			// LEEMOS LA INFORMACION CUANDO LLEGA
			String message = flujo_entrada.readUTF();
			// TRAZA DEL MENSAJE RECIBIDO
			System.out.println(message);
			// CIERRE DEL FLUJO
			flujo_entrada.close();
		}
	}

}
