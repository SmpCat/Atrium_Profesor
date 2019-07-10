package com.atrium.hilos.uno;

/**
 * Ejemplo de uso de cajeras y clientes sin el uso de hilos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class Main {

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
		// CREAMOS DOS CAJERAS DISTINTAS PARA ATENDER A LOS CLIENTES
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");

		// TIEMPO INICIAL DE REFERENCIA
		long initialTime = System.currentTimeMillis();
		// PROCESO DE CLIENTES
		cajera1.procesarCompra(cliente1, initialTime);
		cajera2.procesarCompra(cliente2, initialTime);
	}
}