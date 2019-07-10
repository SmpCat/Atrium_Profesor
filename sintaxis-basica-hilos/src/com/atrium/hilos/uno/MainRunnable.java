package com.atrium.hilos.uno;

/**
 * Ejemplo de uso de cajeras y clientes CON el uso de la interface
 * {@link Runnable}.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class MainRunnable implements Runnable {
	// PROPIEDADES DE LA CLASE
	private Cliente cliente;
	private Cajera cajera;
	private long initialTime;

	// ****** CONSTRUCTOR DE LA CLASE
	public MainRunnable(Cliente cliente, Cajera cajera, long initialTime) {
		this.cajera = cajera;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

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
		// CREAMOS DOS CAJERAS
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");
		// TIEMPO INICIAL DE REFERENCIA
		long initialTime = System.currentTimeMillis();
		// INSTACIA DE DOS OBJETOS PARA SU USO EN HILOS
		Runnable proceso1 = new MainRunnable(cliente1, cajera1, initialTime);
		Runnable proceso2 = new MainRunnable(cliente2, cajera2, initialTime);
		// CREACION Y ARRANQUE DE LOS HILOS
		new Thread(proceso1).start();
		new Thread(proceso2).start();
	}

	/**
	 * Metodo de la interface para su ejecucion en los hilos.
	 */
	@Override
	public void run() {
		this.cajera.procesarCompra(this.cliente, this.initialTime);
	}

}
