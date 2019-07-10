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
public class Cajera {
	// PROPIEDADES DE LA CLASE
	private String nombre;

	// ******** CONSTRUCTORES
	public Cajera() {
	}

	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo donde el objeto cliente es atendido.
	 * 
	 * @param cliente
	 *            Objeto a tratar.
	 * @param timeStamp
	 *            Tiempo en que empieza el proceso.
	 */
	public void procesarCompra(Cliente cliente, long timeStamp) {
		// TRAZA DE INICIO DE PROCESO DEL CLIENTE
		System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
				+ cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
		// PROCESADO DEL CLIENTE
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesado el producto " + (i + 1) + " ->Tiempo: "
					+ (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
		}
		// TRAZA DE FIN DE PROCESO DE CLIENTE
		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre()
				+ " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
	}

	/**
	 * Proceso auxiliar de espera para generar un retardo que supuestamente
	 * seria el tiempo de proceso del cliente.
	 * 
	 * @param segundos Retardo en segundos.
	 */
	private void esperarXsegundos(int segundos) {
		try {
			//ORDEN DE PARADA DEL HILO
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

}