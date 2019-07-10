package com.atrium.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Proceso para el tratamiento de las cargas vagas de forma reflexiva.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 14-2-2018.
 * 
 */
@Component("eliminacion_cargasvagas")
@Scope("prototype")
public class Eliminacion_CargasVagas implements IEliminacion_CargasVagas {

	/**
	 * Proceso de busqueda de propiedades en los objetos de hibernate con cargas
	 * vagas pendientes para su anulacion previa a la conversion a texto.<br/>
	 * Este proceso es valido si la carga vaga es de una propiedad simple, no
	 * funciona si la propiedad es una coleccion.
	 * 
	 * @param tipo_vago
	 *            Tipo del objeto de persistencia.
	 * @param objeto_vago
	 *            Objeto desconectado de hibernate.
	 */
	@Override
	public void eliminar_CargasVagas(Class<?> tipo_vago, Object objeto_vago) {
		// BUSCAMOS TODAS LAS PROPIEDADES DEL OBJETO
		Field propiedades[] = tipo_vago.getDeclaredFields();
		// LAS RECORREMOS UNA A UNA
		for (Field propiedad : propiedades) {
			// ACCEDEMOS A SU VALOR
			String nombre_propiedad = propiedad.getName();
			String nombre_metodo = "get"
					+ nombre_propiedad.substring(0, 1).toUpperCase()
					+ nombre_propiedad.substring(1);
			try {
				Method metodo = tipo_vago.getMethod(nombre_metodo, null);
				// OBTENER EL VALOR DE LA PROPIEDAD PARA COMPROBAR SI ES UN
				// PROXY DINAMICO
				Object proxy_dynamicohibernate = metodo.invoke(objeto_vago,
						null);
				if (proxy_dynamicohibernate != null) {
					Field pro_proxy[] = proxy_dynamicohibernate.getClass()
							.getDeclaredFields();
					for (Field pro : pro_proxy) {
						String nombre_propiedadproxy = pro.getName();
						// COMPROBAMOS SI LA PROPIEDAD ES UN PROXY DINAMICO O NO
						// EN FUNCION DEL NOMBRE DE UNA PROPIEDAD CONCRETA DE
						// LOS PROXYS
						// LA PROPIEDAD ES PARA HIBERNATE 4.X
						if (nombre_propiedadproxy.equalsIgnoreCase("handler")) {
							// ERROR DE CARGA VAGA
							String nombre_set = "set"
									+ nombre_propiedad.substring(0, 1)
											.toUpperCase()
									+ nombre_propiedad.substring(1);
							try {
								// ANULAMOS EL VALOR DE LA PROPIEDAD PASADO UN
								// NULL
								Class tipo_argumento = propiedad.getType();
								Method metodo_set = tipo_vago.getMethod(
										nombre_set, tipo_argumento);
								Object argumentos[] = { null };
								metodo_set.invoke(objeto_vago, argumentos);
							} catch (Exception e) {
								// ERRORES DE REFLEXION
								e.printStackTrace();
							}
						}
					}
				}
			} catch (Exception e) {
				// ERRORES DE REFLEXION
				e.printStackTrace();
			}
		}
	}

	/**
	 * Proceso para la eliminacion de cargas vagas en objetos de persistencia en
	 * forma reflexiva
	 */
	@Override
	public void eliminar_CargasEnColecciones(Class<?> tipo_vago,
			Object objeto_vago) {
		// OBTENGO EL CLASS DEL MANAGEDBEAN
		Class<?> managedbean_ausar_class = objeto_vago.getClass();
		// BUSCO LAS PROPIEDADES DEL MANAGEDBEAN
		Field lista_propiedades[] = managedbean_ausar_class.getDeclaredFields();
		// RECORRO CADA UNA DE ELLAS PARA BUSCAR LA QUE HAY QUE CARGAR.
		for (Field propiedad : lista_propiedades) {
			// VOY COMPARANDO EL TIPO DE CADA PROPIEDAD PARA SABER SI ES UNA
			// COLECCION (PARA HIBERNATE SIEMPRE SET)
			if (propiedad.getType().getName().equals("java.util.Set")) {
				// SE OBTIENE EL TIPO DE LOS ELEMENTOS DE LA COLECCION DEL
				// MANAGED BEAN
				ParameterizedType contenido_coleccion = (ParameterizedType) propiedad
						.getGenericType();
				Class<?> tipo = (Class<?>) contenido_coleccion
						.getActualTypeArguments()[0];
				try {
					// CUANDO SE ENCUENTRA LA PROPIEDAD ADECUADA SE LLAMA AL
					// METODO GET
					Method metodo_propiedad = managedbean_ausar_class
							.getMethod(
									"get"
											+ propiedad.getName()
													.substring(0, 1)
													.toUpperCase()
											+ propiedad.getName().substring(1),
									null);
					// SE OBTIENE LA COLECCION SET A TRATAR
					Set propiedad_acargar = (Set) metodo_propiedad
							.invoke(objeto_vago);
					// INTENTAMOS ACCEDER AL CONTENIDO DE LA COLECCION
					// PROVOCANDO EL ERROR DE LAZYINIT
					Iterator ite = propiedad_acargar.iterator();
				} catch (Exception e) {
					// PONEMOS A NULL LA PROPIEDAD
					try {
						Method metodo_propiedad = managedbean_ausar_class
								.getMethod("set"
										+ propiedad.getName().substring(0, 1)
												.toUpperCase()
										+ propiedad.getName().substring(1),
										java.util.Set.class);
						Object parametros[] = { null };
						metodo_propiedad.invoke(objeto_vago, parametros);
					} catch (Exception d) {
						// ERROR EN EL ACCESO REFLEXIVO
						System.out.println("");
					}
				}
			}
		}
	}
}
