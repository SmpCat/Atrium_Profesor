package com.atrium.controlador;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Ejemplo de uso de metadatos de la base de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5
 */
public class Caracteristicas_Metadata {

	private static Connection conexion;
	private ResultSet rs;

	public static void main(String arg[]) {
		Caracteristicas_Metadata cm = new Caracteristicas_Metadata();
		try {
			// CARGAMOS EL DRIVER
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ESTABLECEMOS LA CONEXION REMOTA CON LA BD.
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "j117", "j117");
			cm.conexion_Metadatos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ejemplo de caracteristicas de la BD a traves del metadata.
	 * 
	 * @throws SQLException
	 */
	public void conexion_Metadatos() throws SQLException {
		// OBTENEMOS LA INFORMACION DE LOS ELEMENTOS DE LA BASE DE DATOS
		DatabaseMetaData informacion_bd = conexion.getMetaData();
		System.out.println();
		System.out.println("  Informacion DatabaseMetaData");
		System.out.println("  ============================");

		System.out.println();
		System.out.println("  - Nombre Producto          : ");
		try {
			System.out.println(informacion_bd.getDatabaseProductName());
		} catch (SQLException e) {
			System.out.println("java.sql.SQLException: Opcion no soportada");
		}

		System.out.println("  - Numero Version Producto: ");
		try {
			System.out.println(informacion_bd.getDatabaseProductVersion());
		} catch (SQLException e) {
			System.out.println("java.sql.SQLException: Opcion no soportada");
		}

		System.out.println("  - Version Mayor Database : ");
		try {
			System.out.println(informacion_bd.getDatabaseMajorVersion());
		} catch (SQLException e) {
			System.out.println("java.sql.SQLException: Opcion no soportada");
		}

		System.out.println("  - Version Menor Database : ");
		try {
			System.out.println(informacion_bd.getDatabaseMinorVersion());
		} catch (SQLException e) {
			System.out.println("java.sql.SQLException: Opcion no soportada");
		}

		System.out.println("  - Nombre Driver: ");
		try {
			System.out.println(informacion_bd.getDriverName());
		} catch (SQLException e) {
			System.out.println("java.sql.SQLException: Opcion no soportada");
		}

		System.out.println("  - Version Mayor Driver : " + informacion_bd.getDriverMajorVersion());
		System.out.println("  - Version Menor Driver : " + informacion_bd.getDriverMinorVersion());

		System.out.println("  - Nombre Usuario: ");
		try {
			System.out.println(informacion_bd.getUserName());
		} catch (SQLException e) {
			System.out.println("java.sql.SQLException: Opcion no soportada");
		}

		System.out.println("  - Catalogos: ");
		try {
			ResultSet catalogs = informacion_bd.getCatalogs();
			while (catalogs.next()) {
				System.out.println("    - " + catalogs.getString(1));
			}
			catalogs.close();
		} catch (SQLException e) {
			System.out.println("java.sql.SQLException: Opcion no soportada");
		}
	}

	/**
	 * Ejemplo de uso de la informacion de la tabla via resultsetmetada.
	 * 
	 * @throws SQLException
	 */
	public void resultset_Metadatos() throws SQLException {
		// RECOGEMOS LA INFORMACION DE LA TABLA
		ResultSetMetaData informacion_tabla = rs.getMetaData();
		// CONOCEMOS EL NUMERO DE COLUMNAS
		int numero_columnas = informacion_tabla.getColumnCount();
		// OBTENEMOS EL TIPO DE INFORMACION CONTENIDA EN CADA COLUMNA
		int posicion_columna = 1;
		int tipo_columna = informacion_tabla.getColumnType(posicion_columna);
		// CONSTANTES DE CLASE QUE DEFINEN LOS POSIBLES VALORES DEL TIPO DE LA
		// COLUMNA
		tipo_columna = Types.NUMERIC;
		tipo_columna = Types.NCLOB;
		tipo_columna = Types.TIME;
		tipo_columna = Types.DECIMAL;
		// OBTENEMOS EL NOMBRE DE LA COLUMNA DADA
		String nombre_columna = informacion_tabla.getColumnName(posicion_columna);
		// NUMERO DE DIGITOS DE LA COLUMNA SI EL VALOR ES NUMERICO
		int digitos_parteentera = informacion_tabla.getPrecision(posicion_columna);
		int digitos_partedecimal = informacion_tabla.getScale(posicion_columna);
		// TAMAÑO MAXIMO EN CARACTRES DEL CONTENIDO DE LAS COLUMNAS
		int tamaño = informacion_tabla.getColumnDisplaySize(posicion_columna);

	}
}
