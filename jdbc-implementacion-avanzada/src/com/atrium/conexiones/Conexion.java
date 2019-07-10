package com.atrium.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.atrium.jdbc.dao.Abstract_DAO;

/**
 * Gestion unica de las distintas formas de crearnos una conexion con la base de
 * datos.<br/>
 * Dicha conexion sera entregada a los DAO que lo soliciten.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5
 */
public class Conexion {
	// ****** PROPIEDADES DE CLASE
	// CONEXION A LA BASE DE DATOS
	private Connection conexion;
	// LECTURA DEL PROPERTIES
	private ResourceBundle rb;
	// CONJUNTO DE CONSTANTES DE CLASE PARA PEDIR EL TIPO DE CONEXION QUE SE
	// QUIERE EN CADA MOMENTO
	public static final int DESARROLLO = 1;
	public static final int PRODUCCION = 2;
	public static final int PREPRODUCCION = 3;
	public static final int CASA = 4;

	/**
	 * Creamos el lector del fichero properties.
	 */
	public Conexion() {
		rb = ResourceBundle.getBundle("com.atrium.conexiones.conexion");
	}

	// ****** DISTINTAS ESTRATEGIAS DE CONEXION A LA BASE DE DATOS *****
	/**
	 * Proceso de establecer la conexion con la base de datos a partir de la
	 * informacion contenida en el fichero de propiedades adjunto.<br/>
	 * El tipo de conexion viene definida por el valor leido en el properties.
	 */
	public void crear_ConexionAutomatica() {
		// COGEMOS EL VALOR NECESARIO
		String tipoconexion = rb.getString("tipoconexion");
		this.establecer_Conexion(tipoconexion);
	}

	/**
	 * Proceso de conexion a partir del tipo pedido.
	 * 
	 * @param tipo_conexion
	 *            Valor numerico que indica el tipo de conexion.
	 */
	public void crear_ConexionManual(int tipo_conexion) {
		String codigo_conexion = null;
		switch (tipo_conexion) {
		case DESARROLLO:
			codigo_conexion = "d";
			break;
		case PRODUCCION:
			codigo_conexion = "p";
			break;
		case PREPRODUCCION:
			codigo_conexion = "pp";
			break;
		case CASA:
			codigo_conexion = "casa";
			break;
		default:
			break;
		}
		if (codigo_conexion != null) {
			this.establecer_Conexion(codigo_conexion);
		}
	}

	// ****** FIN DISTINTAS ESTRATEGIAS DE CONEXION A LA BASE DE DATOS *****

	/**
	 * Proceso comun de peticion de conexion para todas las logicas
	 * implementadas.
	 * 
	 * @param tipoconexion
	 *            Cadena identificativa del tipo de conexion.
	 */
	private void establecer_Conexion(String tipoconexion) {
		// CON EL VALOR ANTERIOR CARGAMOS LOS DATOS CORRESPONDIENTES A LA
		// CONEXION DEFINIDA
		String url = rb.getString("tipoconexion." + tipoconexion + ".url");
		String usuario = rb.getString("tipoconexion." + tipoconexion
				+ ".usuario");
		String clave = rb.getString("tipoconexion." + tipoconexion + ".clave");
		String driver = rb
				.getString("tipoconexion." + tipoconexion + ".driver");
		boolean valido = true;
		try {
			// CARGAMOS EL DRIVER
			Class.forName(driver);
		} catch (Exception e) {
			valido = false;
		}
		if (valido) {
			try {
				// SI LA CARGA DEL DRIVER A SIDO CORRECTA SE CREA LA CONEXION
				conexion = DriverManager.getConnection(url, usuario, clave);
			} catch (SQLException e) {
				// ERROR EN LA CONEXION, SIN TRATAR
			}
		}
	}

	// METODOS ACCESORES
	public Connection getConexion() {
		return conexion;
	}
}
