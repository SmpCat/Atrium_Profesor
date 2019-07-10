package com.atrium.reflexion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.Border;

import com.atrium.imagenes.IDefinicion_Imagenes;
import com.atrium.imagenes.Obtener_Imagenes;

/**
 * Conjunto de procesos para moldear las propiedades de los objetos de forma
 * generica a traves de reflexion. Metodos estaticos para un uso mas rapido en
 * la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.3.
 * @since 23-9-2016.
 * 
 */
public class Uso_Propiedades {

	/**
	 * Proceso mediante el cual cargamos todo tipo de escuchador en componentes
	 * de swing. En principio se comtemplan cuatro tipos de escuchadores
	 * <ul>
	 * <li>
	 * Eventos de Accion (ActionListener).</li>
	 * <li>
	 * Eventos de Foco (FocusListener).</li>
	 * <li>
	 * Eventos de Raton (MouseListener).</li>
	 * <li>
	 * Eventos de Teclado (KeyListener).</li>
	 * <li>
	 * Eventos de de Seleccion (ItemStateChange).</li>
	 * </ul>
	 * 
	 * @param escuchador
	 *            Objeto escuchador que asignaremos a los componentes que
	 *            pasemos en la coleccion.
	 * @param lista_componentes
	 *            Coleccion con los graficos a tratar.
	 */
	public static void cargar_Escuchadores(List<JComponent> lista_componentes,
			Object escuchador) {
		// PREPARO EL PARAMETRO PARA EL ESCUCHADOR
		Object tabla_parametros[] = { escuchador };
		// PROCESO TODA LA COLECCION DE COMPONENTES
		for (JComponent componente : lista_componentes) {
			// OBTENGO EL CLASS DE CADA COMPONENTE PARA PODER TRABAJAR
			Class objeto_atratar = componente.getClass();
			// PREGUNTO POR EL TIPO DE EVENTO A TRATAR
			if (escuchador instanceof ActionListener) {
				// RECOJO EL METODO QUE ASOCIA EL EMISOR CON EL RECEPTOR
				try {
					Method metodo_ausar = objeto_atratar.getMethod(
							"addActionListener", ActionListener.class);
					// EJECUTO EL METODO QUE ASOCIA EL RECEPTOR CON EL EMISOR
					// SOBRE EL COMPONENTE QUE ESTOY TRATANDO CON EL PARAMETRO
					// RECIBIDO QUE EL ESCUCHADOR DEL EVENTO
					metodo_ausar.invoke(componente, tabla_parametros);
				} catch (Exception e) {
					// SIN TRATAMIENTO
				}
			}
			// PREGUNTO POR EL TIPO DE EVENTO A TRATAR
			if (escuchador instanceof MouseListener) {
				try {
					// RECOJO EL METODO QUE ASOCIA EL EMISOR CON EL RECEPTOR
					Method metodo_ausar = objeto_atratar.getMethod(
							"addMouseListener", MouseListener.class);
					// EJECUTO EL METODO QUE ASOCIA EL RECEPTOR CON EL EMISOR
					// SOBRE EL COMPONENTE QUE ESTOY TRATANDO CON EL PARAMETRO
					// RECIBIDO QUE EL ESCUCHADOR DEL EVENTO
					metodo_ausar.invoke(componente, tabla_parametros);
				} catch (Exception e) {
					// SIN TRATAMIENTO
				}
			}
			// PREGUNTO POR EL TIPO DE EVENTO A TRATAR
			if (escuchador instanceof FocusListener) {
				try {
					// RECOJO EL METODO QUE ASOCIA EL EMISOR CON EL RECEPTOR
					Method metodo_ausar = objeto_atratar.getMethod(
							"addFocusListener", FocusListener.class);
					// EJECUTO EL METODO QUE ASOCIA EL RECEPTOR CON EL EMISOR
					// SOBRE EL COMPONENTE QUE ESTOY TRATANDO CON EL PARAMETRO
					// RECIBIDO QUE EL ESCUCHADOR DEL EVENTO
					metodo_ausar.invoke(componente, tabla_parametros);
				} catch (Exception e) {
					// SIN TRATAMIENTO
				}
			}
			// PREGUNTO POR EL TIPO DE EVENTO A TRATAR
			if (escuchador instanceof KeyListener) {
				try {
					// RECOJO EL METODO QUE ASOCIA EL EMISOR CON EL RECEPTOR
					Method metodo_ausar = objeto_atratar.getMethod(
							"addKeyListener", KeyListener.class);
					// EJECUTO EL METODO QUE ASOCIA EL RECEPTOR CON EL EMISOR
					// SOBRE EL COMPONENTE QUE ESTOY TRATANDO CON EL PARAMETRO
					// RECIBIDO QUE EL ESCUCHADOR DEL EVENTO
					metodo_ausar.invoke(componente, tabla_parametros);
				} catch (Exception e) {// SIN TRATAMIENTO
				}
			}
			// PREGUNTO POR EL TIPO DE EVENTO A TRATAR
			if (escuchador instanceof ItemListener) {
				try {
					// RECOJO EL METODO QUE ASOCIA EL EMISOR CON EL RECEPTOR
					Method metodo_ausar = objeto_atratar.getMethod(
							"addItemListener", ItemListener.class);
					// EJECUTO EL METODO QUE ASOCIA EL RECEPTOR CON EL EMISOR
					// SOBRE EL COMPONENTE QUE ESTOY TRATANDO CON EL PARAMETRO
					// RECIBIDO QUE EL ESCUCHADOR DEL EVENTO
					metodo_ausar.invoke(componente, tabla_parametros);
				} catch (Exception e) { // SIN TRATAMIENTO
				}
			}
			// PREGUNTO POR EL TIPO DE EVENTO A TRATAR
			if (escuchador instanceof WindowListener) {
				try {
					// RECOJO EL METODO QUE ASOCIA EL EMISOR CON EL RECEPTOR
					Method metodo_ausar = objeto_atratar.getMethod(
							"addWindowListener", WindowListener.class);
					// EJECUTO EL METODO QUE ASOCIA EL RECEPTOR CON EL EMISOR
					// SOBRE EL COMPONENTE QUE ESTOY TRATANDO CON EL PARAMETRO
					// RECIBIDO QUE EL ESCUCHADOR DEL EVENTO
					metodo_ausar.invoke(componente, tabla_parametros);
				} catch (Exception e) { // SIN TRATAMIENTO
				}
			}
		}
	}

	/**
	 * Proceso mediante el cual le pasaremos el valor que queramos a la
	 * propiedad que lo necesite de los componentes que pasemos en la coleccion.
	 * 
	 * Los valores a pasar solo podran ser de tipo boolean,de tipo String o de
	 * tipo Font(de momento).
	 * 
	 * Se añadio de tipo border como argunmento.
	 * 
	 * @param lista_componentes
	 *            Coleccion de objetos sobre los que estableceremos el valor de
	 *            la propiedad.
	 * @param propiedad
	 *            Nombre de la propiedad del objeto que queramos cambiar.
	 * @param valor
	 *            Nuevo valor que queramos pasar a la propiedad.
	 */
	public static void establecer_Valor(List<JComponent> lista_componentes,
			String propiedad, Object valor) {
		// CREO EL ARRAY PARA EL PARAMETRO DEL METODO SET CORREPONDIENTE
		Class parametros[] = new Class[1];
		// PREPARA EL TIPO DE PARAMETRO PARA EL SET
		if (valor instanceof Boolean) {
			parametros[0] = boolean.class;
		}
		if (valor instanceof String) {
			parametros[0] = String.class;
		}
		if (valor instanceof Font) {
			parametros[0] = Font.class;
		}
		if (valor instanceof Color) {
			parametros[0] = Color.class;
		}
		if (valor instanceof Border) {
			parametros[0] = Border.class;
		}
		if (valor instanceof Rectangle) {
			parametros[0] = Rectangle.class;
		}
		for (JComponent componente : lista_componentes) {
			Class objeto_componente = componente.getClass();
			try {
				// PREPARAMOS EL METODO SET
				Method metodo = objeto_componente.getMethod(
						"set" + propiedad.substring(0, 1).toUpperCase()
								+ propiedad.substring(1), parametros);
				// EJECUTO EL METODO SET QUE CORRESPONDA
				if (valor instanceof Boolean) {
					metodo.invoke(componente, ((Boolean) valor));
				}
				if (valor instanceof String) {
					metodo.invoke(componente, ((String) valor));
				}
				if (valor instanceof Font) {
					metodo.invoke(componente, ((Font) valor));
				}
				if (valor instanceof Color) {
					metodo.invoke(componente, (Color) valor);
				}
				if (valor instanceof Border) {
					metodo.invoke(componente, (Border) valor);
				}
				if (valor instanceof Rectangle) {
					metodo.invoke(componente, (Rectangle) valor);
				}
			} catch (Exception e) {
				// ERROR SIN TRATAMIENTO
			}
		}
	}

	/**
	 * Proceso mediante el cual se cargara por reflexion la coleccion dada con
	 * los objetos que coincidan con el tipo dado. <br/>
	 * Es necesario colocar accesores en el objeto que contenga las propiedades. <br/>
	 * Se pueden tratar todo tipo de componentes graficos.
	 * 
	 * @param lista_componente
	 *            Coleccion que se rellenara con los objetos
	 * @param tipo_componente
	 *            Cadena de texto que sera la clase del componente a rellenar
	 * @param objeto_emisor
	 *            Clase propia de interface grafica que contendra los
	 *            componentes a seleccionar
	 */
	public static void cargar_Lista(List<JComponent> lista_componente,
			String tipo_componente, Object objeto_emisor) {
		// RECOGEMOS LAS PROPIEDADES DEL CONTENEDOR GRAFICO
		Field lista_propiedades[] = objeto_emisor.getClass()
				.getDeclaredFields();
		// CREO EL NOMBRE COMPLETO(CUALIFICADO) DEL TIPO DE COMPONENTE
		tipo_componente = "javax.swing." + tipo_componente;
		for (Field propiedad_clase : lista_propiedades) {
			// SI EL NOMBRE DEL TIPO DE LA PROPIEDAD COINCIDE SE TRATA
			if (propiedad_clase.getType().getName()
					.equalsIgnoreCase(tipo_componente)) {
				try {
					// OBTENEMOS EL NOMBRE DEL METODO ACCESOR (GET) DEL
					// COMPONENTE
					Method metodo_accesor = objeto_emisor.getClass().getMethod(
							"get"
									+ propiedad_clase.getName().substring(0, 1)
											.toUpperCase()
									+ propiedad_clase.getName().substring(1),
							null);
					// RECOGEMOS EL COMPONENTE
					Object objeto = metodo_accesor.invoke(objeto_emisor, null);
					// LO CARGAMOS EN LA LISTA SOLO SI EL COMPONENTE EXISTE
					if (objeto != null) {
						lista_componente.add((JComponent) objeto);
					}
				} catch (Exception e) {
					// ELIMINAMOS EL TRATAMIENTO POR INNECESARIO
				}
			}
		}
	}

	/**
	 * Proceso mediante el cual se cargara por reflexion la coleccion dada con
	 * los objetos que coincidan con el tipo dado. <br/>
	 * Es necesario colocar accesores en el objeto que contenga las propiedades. <br/>
	 * Se pueden tratar todo tipo de componentes graficos.
	 * 
	 * @param lista_componente
	 *            Coleccion que se rellenara con los objetos
	 * @param tipo_componente
	 *            Cadena de texto que sera la clase del componente a rellenar
	 * @param prefijo
	 *            Cadena de texto mediante la cual se podra distinguir los
	 *            diferentes objetos de la misma clase y cargarla en diferentes
	 *            colecciones.
	 * @param objeto_emisor
	 *            Clase propia de interface grafica que contendra los
	 *            componentes a seleccionar
	 */
	public static void cargar_Lista(List<JComponent> lista_componente,
			String tipo_componente, String prefijo, Object objeto_emisor) {
		// RECOGEMOS LAS PROPIEDADES DEL CONTENEDOR GRAFICO
		Field lista_propiedades[] = objeto_emisor.getClass()
				.getDeclaredFields();
		// CREO EL NOMBRE COMPLETO(CUALIFICADO) DEL TIPO DE COMPONENTE
		tipo_componente = "javax.swing." + tipo_componente;
		for (Field propiedad_clase : lista_propiedades) {
			// SI EL NOMBRE DEL TIPO DE LA PROPIEDAD COINCIDE SE TRATA
			if (propiedad_clase.getType().getName()
					.equalsIgnoreCase(tipo_componente)) {
				try {
					// TRATAMIENTO DE PREFIJO SIN USO
					if ((prefijo == null)
							|| propiedad_clase
									.getName()
									.substring(
											0,
											propiedad_clase.getName().indexOf(
													"_"))
									.equalsIgnoreCase(prefijo.replace("_", ""))) {
						// OBTENEMOS EL NOMBRE DEL METODO ACCESOR (GET) DEL
						// COMPONENTE
						Method metodo_accesor = objeto_emisor.getClass()
								.getMethod(
										"get"
												+ propiedad_clase.getName()
														.substring(0, 1)
														.toUpperCase()
												+ propiedad_clase.getName()
														.substring(1), null);
						// RECOGEMOS EL COMPONENTE
						Object objeto = metodo_accesor.invoke(objeto_emisor,
								null);
						// LO CARGAMOS EN LA LISTA
						lista_componente.add((JComponent) objeto);
					}
				} catch (Exception e) {
					// ELIMINAMOS EL TRATAMIENTO POR INNECESARIO
				}
			}
		}
	}

	/**
	 * Proceso mediante el cual se le asigna valor a la propiedad name de los
	 * componentes.<br/>
	 * Se recoge el nombre con el que esta declarado dicho componente de el
	 * contenedor donde se crea. Con ese valor se genera el string para la
	 * propiedad name.<br/>
	 * Es necesario que los componentes tenga accesores. Para los componentes
	 * que no tengan accesores se produce una excepcion que se ignora.
	 * 
	 * @param lista_componentes
	 *            Coleccion que contendra los componentes alos cuales queramos
	 *            dar valor en la propiedad name.
	 * 
	 * @param objeto_contenedor
	 *            Objeto que declara e instancia los objetos.
	 */
	public static void establecer_Nombre(List<JComponent> lista_componentes,
			Object objeto_contenedor) {
		Class objeto_componente;
		Class class_contenedor = objeto_contenedor.getClass();
		// OBTENEMOS LA TABLA DE PROPIEDADES DE LA CLASE
		Field propiedades_clase[] = class_contenedor.getDeclaredFields();
		// RECORREMOS LA LISTA CON LOS COMPONENTES COMPARANDOLOS CON TODAS LAS
		// PROPIEDADES DE LA TABLA DE CAMPOS PARA ENCONTRAR LAS CORREPONDENCIAS
		for (JComponent componente : lista_componentes) {
			objeto_componente = componente.getClass();
			try {
				// PREPARAMOS EL METODO SETNAME A ESPERA DE ENCONTRAR LA
				// PROPIEDAD EN LA TABLA
				Method metodo_name = objeto_componente.getMethod("setName",
						String.class);
				String nombre_objeto = null;
				// RECORRO TODAS LAS PROPIEDADES DE LA TABLA PARA ENCONTRAR LA
				// EQUIVALENCIA
				for (Field propiedad : propiedades_clase) {
					try {
						// PIDO EN METODO ACCESOR ASI ELIMINO LAS QUE NO LO
						// TIENEN POR LA EXCEPCION
						Method metodo_propiedad = objeto_contenedor.getClass()
								.getMethod(
										"get"
												+ propiedad.getName()
														.substring(0, 1)
														.toUpperCase()
												+ propiedad.getName()
														.substring(1), null);
						// COMPRUEBO SI ES EL MISMO OBJETO TANTO EN LA COLECCION
						// COMO EN LA TABLA
						if (metodo_propiedad.invoke(objeto_contenedor, null)
								.equals(componente)) {
							// PIDO EL NAME AL OBJETO FIELD
							nombre_objeto = propiedad.getName();
							// SE LO PASO A LA PROPIEDAD SETNAME DEL COMPONENTE
							metodo_name.invoke(componente, nombre_objeto);
							// NOS SALTAMOS EL RESTO DE LA TABLA
							break;
						}
					} catch (Exception e) {
						// NO TRATO NADA, SOLO SIRVE PARA ELIMINAR PROPIEDADES
						// DE LA TABLA
					}
				}
			} catch (Exception e) {
				// NO SE TRATA NADA ES EL CATCH DEL GETMETHOD INICIAL QUE NO VA
				// A FALLAR NUNCA PUESTO QUE TODOS LOS COMPONENTES TIENEN
				// SETNAME
			}
		}
	}

	/**
	 * Proceso mediante el cual se le asigna valor a la propiedad ACTIONCOMMAND
	 * de los componentes.<br/>
	 * Se recoge el nombre con el que esta declarado dicho componente de el
	 * contenedor donde se crea. Con ese valor se genera el string para la
	 * propiedad name.<br/>
	 * Es necesario que los componentes tenga accesores. Para los componentes
	 * que no tengan accesores se produce una excepcion que se ignora.
	 * 
	 * @param lista_componentes
	 *            Coleccion que contendra los componentes alos cuales queramos
	 *            dar valor en la propiedad name.
	 * 
	 * @param objeto_contenedor
	 *            Objeto que declara e instancia los objetos.
	 */
	public static void establecer_ActionCommand(
			List<JComponent> lista_componentes, Object objeto_contenedor) {
		Class objeto_componente;
		// OBJETO CLASS DEL CONTENEDOR DE LOS COMPONENTES
		Class class_contenedor = objeto_contenedor.getClass();
		// OBTENEMOS TODAS LAS PROPIEDADES DEL CONTENEDOR
		Field propiedades_clase[] = class_contenedor.getDeclaredFields();
		// TRATAMOS TODOS LOS COMPONENTES DE LA COLECCION PARA ESTABLECER LA
		// PROPIEDAD ACTIONCOMMAND
		for (JComponent componente : lista_componentes) {
			objeto_componente = componente.getClass();
			try {
				// METODO A INVOCAR PARA CARGAR EL NOMBRE DEL COMPONENTE
				Method metodo_name = objeto_componente.getMethod(
						"setActionCommand", String.class);
				String nombre_objeto = null;
				for (Field propiedad : propiedades_clase) {
					try {
						Method metodo_propiedad = objeto_contenedor.getClass()
								.getMethod(
										"get"
												+ propiedad.getName()
														.substring(0, 1)
														.toUpperCase()
												+ propiedad.getName()
														.substring(1), null);
						// COMPROBAMOS QUE LA PROPIEDAD OBTENIDA ES LA DEL
						// COMPONENTE
						if (metodo_propiedad.invoke(objeto_contenedor, null)
								.equals(componente)) {
							// COGO EL NOMBRE DE LA PROPIEDAD
							nombre_objeto = propiedad.getName();
							// ESTABLEZCO LA PROPIEDAD ACTIONCOMMAND CON EL
							// NOMBRE DEL COMPONENTE
							metodo_name.invoke(componente, nombre_objeto);
							break;
						}
					} catch (Exception e) {
						// NO TRATAMOS LA EXCEPCION. SOLO SIRVE PARA ELIMINAR
						// LAS PROPIEDADES QUE NO NOS INTERESAN
					}
				}
			} catch (Exception e) {
				// POSIBLE ERROR AL INTENTAR ACCEDER AL METODO SETACTIONCOMMAND
			}
		}
	}

	/**
	 * Proceso de carga de iconos en los componentes, segun informacion leida de
	 * un fichero properties.<br/>
	 * La clave del properties de establece concatenando ico. con el valor de la
	 * propiedad name del componente.
	 * 
	 * @param lista_componentes
	 *            Coleccion de componentes a poner icono.
	 * @param tamaño
	 *            Tamaño/resolucion del icono segun comstante de
	 *            {@link IDefinicion_Imagenes}.
	 * @param ruta_properties
	 *            Ruta del fichero con la informacion de los iconos a poner a
	 *            cada componente.
	 * @param ruta_iconos
	 *            Ruta donde estan almacenados los iconos a usar.
	 * 
	 */
	public static void cargar_Iconos(List<JComponent> lista_componentes,
			int tamaño, String ruta_properties, String ruta_iconos) {
		ResourceBundle rd = null;
		try {
			rd = ResourceBundle.getBundle(ruta_properties);
		} catch (MissingResourceException e) {
			System.out.println("ERROR EN LA CARGA DE FICHERO PROPERTIES "
					+ ruta_properties
					+ " PARA EL PROCESO DE ESTRABLECER ICONOS");
			// Traza_Log.registro("ERROR EN LA CARGA DE FICHERO PROPERTIES "
			// + ruta_properties
			// + " PARA EL PROCESO DE ESTRABLECER ICONOS");
			return;
		}
		ImageIcon icono_acargar = null;
		// PIDO EL METODO PARA COLOCAR EL ICONO AL COMPONENTE
		Method metodo = null;
		try {
			metodo = lista_componentes.get(0).getClass()
					.getMethod("setIcon", Icon.class);
		} catch (Exception e1) {
			// SIN TRATAMIENTO
		}
		for (JComponent componente : lista_componentes) {
			// USAMOS EL NAME DEL COMPONENTE PARA CREAR LA CLAVE
			String nombre = componente.getName();
			try {
				// RECOGEMOS EL NOMBRE DEL ICONO ASIGNADO AL COMPONENTE
				String texto = rd.getString("ico." + nombre);
				// SI NO HAY UN ICONO ASIGNADO EVITO EL RESTO DEL PROCESO
				if (!texto.equals("")) {
					// CREO EL FLUJO DE LECTURA AL ICONO
					icono_acargar = Obtener_Imagenes.escalar_Imagen(ruta_iconos
							+ texto, tamaño);
					// ASOCIO LA IMAGEN AL COMPONENTE
					metodo.invoke(componente, icono_acargar);
				}
			} catch (MissingResourceException e) {
				System.out.println("ERROR NO EXISTE ICONO PARA ESE COMPONENTE "
						+ nombre);
			} catch (Exception e) {
				System.out.println("ERROR EN LA CARGA DEL ICONO " + nombre);
			}
		}
	}

	/**
	 * Proceso de carga automatica del texto de ayuda de los componentes.<br/>
	 * Logica: Las claves del fichero properties empezaran por 'ttt' seguido del
	 * nombre del objeto. Dicho nombre se obtendra de la propiedad name.
	 * 
	 * @param lista_componentes
	 *            . Coleccion de componentes a cargar el tooltip.
	 * @param ruta_properties
	 *            . Ruta y nombre del properties.
	 */

	public static void establecer_TextoAyuda(
			List<JComponent> lista_componentes, String ruta_properties) {
		ResourceBundle rd = null;
		try {
			// CREAMOS EL RESOURCE BUNDLE PARA LEER EL PROPERTIES DE TEXTO.
			rd = ResourceBundle.getBundle(ruta_properties);
		} catch (MissingResourceException e) {
			System.out.println("ERROR EN LA CARGA DE FICHERO PROPERTIES "
					+ ruta_properties
					+ " PARA EL PROCESO DE ESTRABLECER TOOLTIPS");
			return;
		}
		// BUSCAMOS EL METODO QUE NOS INTERESA LLAMAR
		Method metodo = null;
		try {
			metodo = lista_componentes.get(0).getClass()
					.getMethod("setToolTipText", String.class);
		} catch (Exception e1) {
			// SIN TRATAMIENTO
		}
		for (JComponent componente : lista_componentes) {
			// COGEMOS EL NOMBRE DEL COMPONENTE PARA CREAR LA CLAVE
			String nombre = componente.getName();
			try {
				// LEEMOS EL RESOURCE BUNDLE A PARTIR DE LA CLAVE
				String texto = rd.getString("ttt." + nombre);
				// EJECUTAMOS EL METODO BUSCADO
				metodo.invoke(componente, texto);
			} catch (MissingResourceException e) {
				// EN CASO DE QUE ALGUNA PROPIEDAD NO TENGA TOOLTIPTEXT SE
				// COMUNICA
				System.out
						.println("ERROR NO EXISTE MENSAJE PARA ESE COMPONENTE "
								+ nombre);
			} catch (Exception e) {
				System.out.println("ERROR EN LA CARGA DEL TEXTO DE AYUDA ");
			}
		}
	}

}
