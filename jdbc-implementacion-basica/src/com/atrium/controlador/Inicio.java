package com.atrium.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Ejemplo muy basico de uso de jdbc.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * 
 */
public class Inicio {

	public static void main(String[] args) {
		Inicio arranque = new Inicio();
		// LLAMADA AL PROCESO DE CONSULTA
		try {
			arranque.consulta();
		} catch (Exception e) {
			// TRATAMIENTO DEL ERROR SI SE PRODUCE
			e.printStackTrace();
		}
	}

	/**
	 * Ejemplo de consulta muy basica via JDBC.
	 * 
	 * @throws Exception
	 *             Error producido en el aceso a la BD.
	 */
	public void consulta() throws Exception {
		// CARGAMOS EL DRIVER
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// ESTABLECEMOS LA CONEXION REMOTA CON LA BD.
		Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@a3-server:1521:XE", "master", "master");
		// PREPARAMOS EL OBJETO DE ORDENES
		Statement sta = conexion.createStatement();
		// EJECUTAMOS LA CONSULTA
		ResultSet rs = sta.executeQuery("select * from usuarios");
		// TRATAMOS EL RESULTADO MOSTRANDOLO POR CONSOLA
		while (rs.next()) {
			// ACCEDEMOS A LOS CAMPOS QUE NOS INTERESEN
			String nombre = rs.getString("nombre_usuario");
			String clave = rs.getString("password");
			// MOSTRAMOS LA INFORMACION POR PANTALLA
			System.out.println("Usuario " + nombre + " con clave - " + clave);
		}
		// LIBERAMOS RECURSOS
		rs.close();
		sta.close();
		conexion.close();
	}

}
