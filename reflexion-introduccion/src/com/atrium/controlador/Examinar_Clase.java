package com.atrium.controlador;

import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplo mas completo de informacion del contenido de un objeto.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 * 
 */
public class Examinar_Clase {
	// PROPIEDADES DE CLASE
	enum tipo_contenido {
		CONSTRUCTOR, FIELD, METHOD, CLASS, ALL
	};

	private static int count;
	private PrintStream out = System.out;

	/**
	 * Lanzamiento de los procesos reflesivos.
	 * 
	 * @param arg
	 */
	public static void main(String arg[]) {
		// CREACION DEL OBJETO A EXAMINAR
		Examinar_Clase exa = new Examinar_Clase();
		// PRIMER METODO QUE NOS INFORMA DEL CONTENIDO DE LA CLASE
		exa.examinar_Clase("javax.swing.JFrame");
		String lista[] = { "javax.swing.JFrame", tipo_contenido.CONSTRUCTOR.toString() };
		// DISTINTAS OPCIONES DEL USO REFLEXIVO PARA LA OBTENCION DE INFORMACION
		exa.examinar_CodigoClase(lista);
		exa.examinar_Propiedades("javax.swing.JFrame");
		exa.examinar_Metodos("javax.swing.JFrame");
	}

	/**
	 * Muestra por consola la definicion a nivel de clase.<br/>
	 * Interfaces, herencias, modificadores de visibilidad y parametros
	 * 
	 * @param nombre_clase
	 *            Nombre fullqualificated (paquetes y clase) de clase que se va
	 *            a estudiar.
	 */
	public void examinar_Clase(String nombre_clase) {
		try {
			// OBTENEMOS EL CLASS DEL OBJETO PARA TRABAJAR
			Class<?> class_objeto = Class.forName(nombre_clase);
			// MOSTRAMOS POR CONSOLA LA INFORMACION DEL OBJETO
			// INFORMACION A NIVEL DE CLASE
			out.format("Listado de la clase y su definicion:%n");
			out.format("Clase:%n  %s%n%n", class_objeto.getCanonicalName());
			out.format("Modificadores de visibilidad de clase:%n  %s%n%n",
					Modifier.toString(class_objeto.getModifiers()));
			// INFORMACION DE LAS PROPIEDADES DE CLASE
			out.format("Tipo de Parametros:%n");
			TypeVariable[] tv = class_objeto.getTypeParameters();
			if (tv.length != 0) {
				out.format("  ");
				for (TypeVariable t : tv)
					out.format("%s ", t.getName());
				out.format("%n%n");
			} else {
				out.format("  -- No existen parametros --%n%n");
			}
			// INFORMACION DE LAS INTERFACES
			out.format("Interfaces implementadas:%n");
			Type[] intfs = class_objeto.getGenericInterfaces();
			if (intfs.length != 0) {
				for (Type intf : intfs)
					out.format("  %s%n", intf.toString());
				out.format("%n");
			} else {
				out.format("  -- No Implementa Interfaces --%n%n");
			}
			// INFORMACION DE LA HERENCIA
			out.format("Jerarquia de herencia:%n");
			List<Class> lista_herencia = new ArrayList<Class>();
			tratar_herencia(class_objeto, lista_herencia);
			if (lista_herencia.size() != 0) {
				for (Class<?> cl : lista_herencia)
					out.format("  %s%n", cl.getCanonicalName());
				out.format("%n");
			} else {
				out.format("  -- No tiene ninguna herencia --%n%n");
			}
			// INFORMACION DE LAS ANOTACIONES
			out.format("Anotaciones:%n");
			Annotation[] ann = class_objeto.getAnnotations();
			if (ann.length != 0) {
				for (Annotation a : ann)
					out.format("  %s%n", a.toString());
				out.format("%n");
			} else {
				out.format("  -- Sin anotaciones --%n%n");
			}
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	/**
	 * Proceso llamado por el metodo examinar_clase para procesar la herencia.
	 * 
	 * @param class_objeto
	 *            Class a examinar
	 * @param lista_herencia
	 *            Coleccion con todos los padres de la herencia, si la hay.
	 */
	private static void tratar_herencia(Class<?> class_objeto, List<Class> lista_herencia) {
		Class<?> padre_herencia = class_objeto.getSuperclass();
		if (padre_herencia != null) {
			lista_herencia.add(padre_herencia);
			tratar_herencia(padre_herencia, lista_herencia);
		}
	}

	/**
	 * Examinamos el contenido de la clase pasada como parametro.
	 * 
	 * @param datos_clase
	 */
	public void examinar_CodigoClase(String datos_clase[]) {
		try {
			Class<?> c = Class.forName(datos_clase[0]);
			out.format("LISTADO DE LA CLASE Y SU CONTENIDO:%n");
			out.format("Clase:%n  %s%n%n", c.getCanonicalName());

			Package paquete = c.getPackage();
			out.format("Paquetes:%n  %s%n%n", (paquete != null ? paquete.getName() : "-- Sin paquete --"));
			for (int i = 1; i < datos_clase.length; i++) {
				switch (tipo_contenido.valueOf(datos_clase[i])) {
				case CONSTRUCTOR:
					printMembers(c.getConstructors(), "Constructor");
					break;
				case FIELD:
					printMembers(c.getFields(), "Propiedades");
					break;
				case METHOD:
					printMembers(c.getMethods(), "Metodos");
					break;
				case CLASS:
					printClasses(c);
					break;
				case ALL:
					printMembers(c.getConstructors(), "Constuctores");
					printMembers(c.getFields(), "Propiedades");
					printMembers(c.getMethods(), "Metodos");
					printClasses(c);
					break;
				default:
					assert false;
				}
			}
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	/**
	 * Proceso de mostrar por consola los distintos elementos de un objeto.
	 * 
	 * @param elementos_objeto
	 * @param tipo_elemento
	 */
	private void printMembers(Member[] elementos_objeto, String tipo_elemento) {
		out.format("%s:%n", tipo_elemento);
		for (Member mbr : elementos_objeto) {
			if (mbr instanceof Field)
				out.format("  %s%n", ((Field) mbr).toGenericString());
			else if (mbr instanceof Constructor)
				out.format("  %s%n", ((Constructor) mbr).toGenericString());
			else if (mbr instanceof Method)
				out.format("  %s%n", ((Method) mbr).toGenericString());
		}
		if (elementos_objeto.length == 0) {
			out.format("  -- No %s --%n", tipo_elemento);
		} else {
			out.format("%n");
		}
	}

	private void printClasses(Class<?> c) {
		out.format("Clases:%n");
		Class<?>[] clss = c.getClasses();
		for (Class<?> cls : clss)
			out.format("  %s%n", cls.getCanonicalName());
		if (clss.length == 0)
			out.format("  -- Ninguna herencia, interface o enumeracion --%n");
		out.format("%n");
	}

	/**
	 * Examinar las propiedades de las clases.
	 * 
	 * @param nombre_clase
	 */
	public void examinar_Propiedades(String nombre_clase) {
		try {
			Class<?> c = Class.forName(nombre_clase);
			Field propiedades[] = c.getFields();
			out.println("Lista de propiedades de clase");
			for (Field propiedad : propiedades) {
				System.out.println("Nombre:" + propiedad.getName());
				System.out.format("Tipo: %s%n", propiedad.getType());
				System.out.format("Tipo Generico: %s%n", propiedad.getGenericType());
				System.out.println("Valor:" + propiedad.get(c.newInstance()));
			}
			// TRATAMIENTO DE LAS EXCEPCIONES POSIBLES
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Examinar metodos de las clases.
	 * 
	 * @param nombre_clase
	 */
	public void examinar_Metodos(String nombre_clase) {
		try {
			Class<?> c = Class.forName(nombre_clase);
			Method lista_metodos[] = c.getDeclaredMethods();
			for (Method m : lista_metodos) {
				out.format("%s%n", m.toGenericString());
				out.format("  Modificadores:  %s%n", Modifier.toString(m.getModifiers()));
				out.format("  [ synthetic=%-5b var_args=%-5b bridge=%-5b ]%n", m.isSynthetic(), m.isVarArgs(),
						m.isBridge());
				inc();
			}
			out.format("%d matching overload%s found%n", cnt(), (cnt() == 1 ? "" : "s"));
			// TRATAMIENTO DE LAS EXCEPCIONES POSIBLES
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	private static synchronized void inc() {
		count++;
	}

	private static synchronized int cnt() {
		return count;
	}

}
