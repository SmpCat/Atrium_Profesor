package com.atrium.reflexion;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

/**
 * Procesos de carga de datos entre objetos de las aplicaciones.
 * 
 * @author Juan Antonio Solves Garcia
 * @serial 2.0
 */
public class Cargar_Datos {

	/**
	 * Carga los valores de una fila de un resultset dado en las propiedades
	 * correspondientes del bean. Se hace por igualdad de nombre, eliminado las
	 * diferencias entre mayusculas y minusculas, ademas los posibles guiones
	 * bajos.<br/>
	 * Tipos de base de datos tratados (Solo para Oracle).
	 * <ul>
	 * <li>Numeric. Diferenciando entre enteros y decimales.</li>
	 * <li>Varchar y Char. Como tipo string.</li>
	 * <li>Date. Como tipo date.</li>
	 * <li>Integer. Como tipo integer. No usado en Oracle.</li>
	 * </ul>
	 * 
	 * @param datos_BD
	 *            ResultSet del cual se obtener la informacion a cargar.
	 * 
	 * @param objeto_DTO
	 *            Objeto de persistencia que va a recibir la informacion.
	 * 
	 */
	public static void cargar_Objeto_RS(ResultSet datos_BD, Object objeto_DTO) {
		Object nuevo_DTO = objeto_DTO;
		try {
			// OBTENEMOS EL OBJETO QUE NOS PERMITIRA CONECER LOS CAMPOS DEL
			// RESULTSET
			ResultSetMetaData rsMeta = datos_BD.getMetaData();
			// PEDIMOS EL NUMERO DE COLUMNAS DEL RESULSET
			int numero_columnas = rsMeta.getColumnCount();
			Class objeto_classDTO = objeto_DTO.getClass();
			Field lista_campos[] = objeto_classDTO.getDeclaredFields();
			int numero_campos_DTO = lista_campos.length;
			// COMPARAMOS TODAS LAS COLUMNAS DEL RESULTSET CON TODAS LAS
			// PROPIEDADES DEL OBJETO DTO A CARGAR
			for (int i = 0; i < numero_columnas; i++) {
				// COGEMOS EL NOMBRE DE CADA COLUMNA
				String nombre_columna = rsMeta.getColumnName(i + 1);
				for (int campo = 0; campo < numero_campos_DTO; campo++) {
					// CUANDO COINCIDAN LOS NOMBRES DE PROPIEDAD Y COLUMNA SE
					// CARGA EL OBJETO DTO
					if (lista_campos[campo].getName().replace("_", "")
							.equalsIgnoreCase(nombre_columna.replace("_", ""))) {
						// ESTABLECEMOS EL TIPO DE COLUMNA DEL RESULTSET PARA SU
						// TRATAMIENTO EN JAVA. SOLO SE CONTEMPLAN LOS TIPOS
						// NECESARIOS PARA ORACLE
						int tipo_dato = rsMeta.getColumnType(i + 1);
						Object valor = null;
						switch (tipo_dato) {
						// EN CASO DE SER NUMERICO TRATAMOS LOS DIFERENTES TIPO
						// ENTERO,DECIMAL MAYOR O MENOR NUMERO DE DIGITOS
						// EN CASO DE SER NUMERICO TRATAMOS LOS DIFERENTES TIPO
						// ENTERO,DECIMAL MAYOR O MENOR NUMERO DE DIGITOS
						case Types.NUMERIC:
							// NUMERO POSICIONES DECIMALES
							int decimales = rsMeta.getScale(i + 1);
							if (decimales == 0) {
								// NUMERO ENTERO
								if (rsMeta.getPrecision(i + 1) < 8) {
									if (rsMeta.getPrecision(i + 1) == 2) {
										valor = new Byte(datos_BD.getByte(i + 1));
									} else {
										valor = new Integer(datos_BD.getInt(i + 1));
									}
								} else {
									valor = new Long(datos_BD.getLong(i + 1));
								}
							} else {
								// NUMERO DECIMAL
								valor = new Double(datos_BD.getDouble(i + 1));
							}
							break;
						case Types.INTEGER:
							valor = new Integer(datos_BD.getInt(i + 1));
							break;
						case Types.VARCHAR:
						case Types.CHAR:
							valor = datos_BD.getString(i + 1);
							break;
						case Types.DATE:
							// INTERCAMBIAMOS EL TIPO DATE DE SQL QUE ME DA EL
							// RESULTSET CREANDO UN DATE DE UTIL PARA EL DTO
							if (datos_BD.getDate(i + 1) != null) {
								valor = new Date(datos_BD.getDate(i + 1).getTime());
							} else {
								valor = null;
							}
							break;
						}
						// CARGAMOS EL VALOR DEL RESULTSET EN EL OBJETO
						if (valor != null) {
							// RECOGEMOS EL METODO ACCESOR DE LA PROPIEDAD A
							// CARGAR
							String nombre_metodo = "set" + lista_campos[campo].getName().substring(0, 1).toUpperCase()
									+ lista_campos[campo].getName().substring(1);
							Object parametro[] = { valor };
							try {
								// COGEMOS EL OBJETO METHOD QUE REPRESENTA EL
								// SET NECESARIO
								Method metodo_ainvocar = objeto_classDTO.getMethod(nombre_metodo,
										parametro[0].getClass());
								// EJECUTAMOS EL METODO SET PARA INYECTAR EL
								// VALOR EN LA PROPIEDAD
								metodo_ainvocar.invoke(nuevo_DTO, parametro);
								// FINALIZAMOS EL FOR PARA OPTIMAR EL PROCESO
								break;
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
