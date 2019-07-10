package com.atrium.hilos.dos;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejemplo de uso de cajeras y clientes sin el uso de hilos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class MainExecutor {

	private static final int numCajeras = 2;

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREAMOS UNA COLECCION DE CLIENTES PARA SU PROCESAMIENTO
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		// 12 Seg
		clientes.add(new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2 }));
		// 9 Seg
		clientes.add(new Cliente("Cliente 2", new int[] { 1, 1, 5, 1, 1 }));
		// 16 Seg
		clientes.add(new Cliente("Cliente 3", new int[] { 5, 3, 1, 5, 2 }));
		// 16 Seg
		clientes.add(new Cliente("Cliente 4", new int[] { 2, 4, 3, 2, 5 }));
		// 11 Seg
		clientes.add(new Cliente("Cliente 5", new int[] { 1, 3, 2, 2, 3 }));
		// 11 Seg
		clientes.add(new Cliente("Cliente 6", new int[] { 4, 2, 1, 3, 1 }));
		// 19 Seg
		clientes.add(new Cliente("Cliente 7", new int[] { 3, 3, 2, 4, 7 }));
		// 14 Seg
		clientes.add(new Cliente("Cliente 8", new int[] { 6, 1, 3, 1, 3 }));

		// TIEMPO TOTAL EN PROCESAR TODOS LOS PEDIDOS = 108 SEGUNDOS

		// INSTANTE INICIAL DEL PROCESAMIENTO
		long init = System.currentTimeMillis();
		// CREACION DEL NUMERO DE HILOS A GESTIONAR, EN EL EJEMPLO 2
		ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
		//TRATAMOS CADA UNO DE LOS CLIENTES PASANDOLOS AL EXECUTOR PARA SU GESTION DE HILOS
		for (Cliente cliente : clientes) {
			//CREACION DEL HILO
			Runnable cajera = new CajeraRunnable(cliente, init);
			//EJECUCION/PUESTA EN MARCHA DEL HILO
			executor.execute(cajera);
		}
		// CIERRO EL EXECUTOR
		executor.shutdown();
		while (!executor.isTerminated()) {
			// ESPERO A QUE TERMINEN DE EJECUTARSE TODOS LOS PROCESOS
			// PARA PASAR A LAS SIGUIENTES INSTRUCCIONES
		}
		// INSTANTE FINAL DEL PROCESAMIENTO
		long fin = System.currentTimeMillis();
		// TRAZA DE FIN DE PROCESO
		System.out.println("Tiempo total de procesamiento: " + (fin - init) / 1000 + " Segundos");
	}
}
