package com.atrium.hilos.uno;

/**
 * Deficion de la clase cajera. Los objetos de esta clase van a procesar a los
 * objetos de la clase cliente.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-2-2017.
 *
 */
public class CajeraThread extends Thread {
	// PROPIEDADES DE LA CLASE
	private String nombre;
	private Cliente cliente;
	private long initialTime;

	// ******** CONSTRUCTORES
	public CajeraThread() {
	}

	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	/**
	 * Metodo de arranque del hilo. Procede de la interface {@link Thread}
	 */
	@Override
	public void run() {
		// TRAZA DE INICIO DE PROCESO DEL CLIENTE
		System.out.println(
				"La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + this.cliente.getNombre()
						+ " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		// PROCESADO DEL CLIENTE
		for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
			// SE PROCESA EL PEDIDO EN X SEGUNDOS
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre()
					+ "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}
		// TRAZA DE FIN DE PROCESO DE CLIENTE
		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " + this.cliente.getNombre()
				+ " EN EL TIEMPO: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
	}

	/**
	 * Proceso auxiliar de espera para generar un retardo que supuestamente
	 * seria el tiempo de proceso del cliente.
	 * 
	 * @param segundos
	 *            Retardo en segundos.
	 */
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	// ACCESORES PARA LAS PROPIEDADES
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}