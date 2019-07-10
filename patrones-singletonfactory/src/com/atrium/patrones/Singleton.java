package com.atrium.patrones;

/**
 * Ejemplo de creacion de un singleton. Objeto unico en el programa.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 4-10-2016.
 *
 */
public class Singleton {

	private static final Singleton INSTANCE = new Singleton();
	private static Singleton INSTANCE_DOS = null;

	/**
	 * Constructor por defecto anulado, por lo tanto no tiene ningun constructor
	 * visible.
	 */
	private Singleton() {
	}

	/**
	 * Metodo de instancia para la obtencion del objeto, siempre el mismo.
	 * 
	 * @return Objeto singleton.
	 */
	public static Singleton getSingleton() {
		// SE DEVUELVE LA INSTANCIA ESTATICA DEL OBJETO
		return INSTANCE;
	}

	/**
	 * Metodo de instancia para la obtencion del objeto, siempre el mismo. Su
	 * creacion solo se realiza cuando es pedido, no antes.
	 * 
	 * @return Objeto singleton.
	 */
	public static Singleton getSingletonDiferido() {
		// SE COMPRUEBA SI EXISTE, SINO SE CREA, DEVOLVIENDO LA INSTANCIA DEL
		// OBJETO
		if (INSTANCE_DOS == null) {
			INSTANCE_DOS = new Singleton();
		}
		return INSTANCE_DOS;
	}

	/**
	 * Metodo de instancia para la obtencion del objeto, siempre el mismo. Su
	 * creacion solo se realiza cuando es pedido, no antes.<br/>
	 * Ademas le añadimos control de hilos para evitar problemas de
	 * sincronizacion.
	 * 
	 * @return Objeto singleton.
	 */
	public static synchronized Singleton getSingletonSincronizado() {
		// EL STATIC CONTROLA LOS ACCESOS SIMULTANEOS EN ENTORNOS MULTI PROCESO
		if (INSTANCE_DOS == null) {
			INSTANCE_DOS = new Singleton();
		}
		return INSTANCE_DOS;
	}

	/**
	 * Metodo de coste de ejecucion mas reducida que la version anterior. Solo
	 * entramos en la zona sincronizada cuando es necesario, el objeto esta
	 * nulo. El resto de veces no.
	 * 
	 * @return Objeto singleton.
	 */
	public static Singleton getSingletonSincronizadoDos() {
		// OPTIMIZACION DE COSTE DE PROCESO RESPECTO DE LA VERSION ANTERIOR
		if (INSTANCE_DOS == null) {
			synchronized (Singleton.class) {
				if (INSTANCE_DOS == null) {
					INSTANCE_DOS = new Singleton();
				}
			}
		}
		return INSTANCE_DOS;
	}

	/**
	 * Sobreescritura del metodo clone para impedir el copiado del objeto y por
	 * lo tanto perder su unicidad.
	 * 
	 * @throws CloneNotSupportedException
	 *             Excepcion que nos indicara que se puede realizar el proceso.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clonacion no permitida en un singleton");
	}

}
