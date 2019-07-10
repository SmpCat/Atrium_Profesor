package com.atrium.hilos.uno;

/**
 * Ejemplo de uso de cajeras y clientes CON el uso de hilos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class MainThread {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREAMOS DOS CLIENTES CON UNOS DATOS EN CARRO DE COMPRA
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		// TIEMPO INICIAL DE REFERENCIA
		long initialTime = System.currentTimeMillis();
		// CREAMOS DOS CAJERAS EN DOS HILOS DISTINTOS
		CajeraThread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
		CajeraThread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime);
		// ARRANCAMOS LOS HILOS
		cajera1.start();
		cajera2.start();
	}
}