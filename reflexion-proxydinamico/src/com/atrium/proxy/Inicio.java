package com.atrium.proxy;

/**
 * Ejemplo basico de uso de proxy dinamicos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-10-2016.
 */
public class Inicio {
	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREAMOS EL PROXY DINAMICO
		ISaludo objeto_proxy = (ISaludo) Prueba_Proxy.crear_Proxy(new Saludo());
		// LLAMAMOS A LOS METODOS
		String retorno_proxy = objeto_proxy.saludo();
		String retorno_metodo = objeto_proxy.otro_Saludo("milagro");
	}

}
