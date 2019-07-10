package anotaciones.spring;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import anotaciones.spring.anotadas.Autowired;
import anotaciones.spring.psring.NecesitaObjetoInyectado;

/**
 * Ejemplo de uso de las anotaciones para una gestion dinamica.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
 *
 */
public class SimulaSpring {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		NecesitaObjetoInyectado necesitaInyeccion = new NecesitaObjetoInyectado();

		// SPRING FACILITA UN POCO MÁS AL INSTANCIAR LOS OBJETOS Y NO NECESITAR
		// PEDIR LA INYECCIÓN A UN OBJETO PROPIAMENTE, POR SIMPLIFICAR PEDIREMOS
		// LA INYECCIÓN DIRECTAMENTE
		inyectorDeObjetos(necesitaInyeccion);

		necesitaInyeccion.usarObjetoInyectadoYMostrarPorPantalla();
	}

	/**
	 * Inyecta un objeto cualquiera que esté anotado con @Autowired (Este método
	 * simula al Framework Spring). El proceso es reflexivo.
	 * 
	 * @param objetoNecesitaInyeccion
	 *            objeto que requiere ser inyectado
	 */
	public static void inyectorDeObjetos(final Object objetoNecesitaInyeccion) {
		// OBTENEMOS EL CLASS DEL OBJETO A TRATAR
		Class<?> claseObjetoNecesitaInyeccion = objetoNecesitaInyeccion.getClass();
		// ACCEDEMOS A LA PROPIEDADES DEL OBJETO, INCLUYE VARIABLES PRIVADAS
		final Field[] variables = claseObjetoNecesitaInyeccion.getDeclaredFields();
		// RECORREMOS TODAS LAS PROPIEDADES DEL OBJETO
		for (final Field variable : variables) {
			//ACCEDEMOS A LA ANOTACION DELOBJETO QUE NOS INTERESA
			final Annotation anotacionObtenida = variable.getAnnotation(Autowired.class);
			//COMPROBAMOS EL TIPO
			if (anotacionObtenida != null && anotacionObtenida instanceof Autowired) {
				// OBTIENE EL TIPO DE CLASE A INYECTAR, INDEPENDIENTEMENTE DEL
				// TIPO
				Class<?> claseInyectar = variable.getType();
				try {
					// INSTANCIAMOS EL OBJETO A INYECTAR
					Object nuevoObjetoDeMiClase = claseInyectar.getConstructor().newInstance();
					variable.setAccessible(true);
					// INYECTAMOS EL OBJETO EN LA VARIABLE DEL OBJETO QUE
					// REQUIERE LA INYECCIÓN
					variable.set(objetoNecesitaInyeccion, nuevoObjetoDeMiClase);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}
	}

}