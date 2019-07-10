package com.atrium.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Ejemplo basico de creacion y uso de proxy dinamico.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-10-2016.
 *
 */
public class Prueba_Proxy implements InvocationHandler {
	// CUALQUIER OBJETO A TRATAR POR EL PROXY
	private Object objetivo;

	/**
	 * Constructor privado para implementar un factory en la creacion de proxy
	 * dinamicos.
	 * 
	 * @param objeto_atratar
	 *            Cualquier tipo de objeto a ser interceptado por el proxy.
	 */
	private Prueba_Proxy(Object objeto_atratar) {
		this.objetivo = objeto_atratar;
	}

	/**
	 * Metodo factoria para la creacion de proxy dinamicos.
	 * 
	 * @param objeto_atratar
	 *            Objeto que queremos interceptar.
	 * @return Proxy dinamico del objeto dado.
	 */
	public static Object crear_Proxy(Object objeto_atratar) {
		// LA CLASE PROXY PROVEE DE METODOS ESTATICOS PARA LA CREACION RAPIDA DE
		// PROXY, PRIMER ARGUMENTO EL CLASSLOADER DEL OBJETO.
		// SEGUNDO LAS INTERFACES DEL MISMO.
		// TERCERO LA INSTANCIA DEL GESTOR DEL PROXY CREADA A PARTIR DEL
		// CONSTRUCTOR PRIVADO.
		Object objeto_proxy = Proxy.newProxyInstance(objeto_atratar.getClass().getClassLoader(),
				objeto_atratar.getClass().getInterfaces(), new Prueba_Proxy(objeto_atratar));
		return objeto_proxy;
	}

	/**
	 * Metodo que es llamado de forma automatica cada vez que se invoca un
	 * metodo del objeto tratado por el proxy.<br/>
	 * Esto nos permite poder hacer todo aquello que necesitemos antes o despues
	 * de la llamada al metodo, includo llamar a un metodo distinto.
	 * 
	 * 
	 * @param objeto_proxy
	 *            Proxy que trata el objeto.
	 * @param metodo_llamado
	 *            Metodo llamado en el objeto.
	 * @param argumentos_metodo
	 *            Argumentos del metodo.
	 */
	@Override
	public Object invoke(Object objeto_proxy, Method metodo_llamado, Object[] argumentos_metodo) throws Throwable {
		Object valor_devuelto = null;
		// PREGUNTAMOS POR EL NOMBRE DEL METODO Y SEGUN SEA HACEMOS UNA COSA U
		// OTRA.
		if (metodo_llamado.getName().equals("otro_Saludo")) {
			// EJECUTAMOS REFLEXIVAMENTE LA LLAMADA AL METODO DEL OBJETO
			valor_devuelto = metodo_llamado.invoke(objetivo, argumentos_metodo);
		} else {
			// SACAMOS UNA TRAZA POR CONSOLA SIN LLAMAR AL METEDO DEL OBJETO
			System.out.println("NO LLAMO A NADIE PORQUE NO QUIERO.");
		}
		// DEVOLVEMOS EL VALOR
		return valor_devuelto;
	}

}
