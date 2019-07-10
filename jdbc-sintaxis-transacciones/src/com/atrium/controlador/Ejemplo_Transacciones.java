package com.atrium.controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejemplo de definicion y uso de transacciones.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5
 */
public class Ejemplo_Transacciones {
	// PROPIEDADES DE CLASE
	private Connection conexion;
	private Statement sta;

	/**
	 * Ejemplo de definicion de transaccion con JBDC.
	 * 
	 * @throws Exception
	 */
	public void realizar_Transaccion() throws Exception {
		// ***** CODIGO PARA REALIZAR LA TRANSACCION
		try {
			// ELIMINAMOS LA AUTOCONFIRMACION PARA PODER REALIZAR LA TRANSACION
			conexion.setAutoCommit(false);
			// CONJUNTO DE ORDENES QUE QUEREMOS REALIZAR
			sta.execute("comando SQL");
			sta.execute("comando SQL");
			sta.execute("comando SQL");
			sta.executeQuery("comando SQL");
			// SI NO HAY ERROR CONFIRMAMOS A LA BASE DE DATOS
			conexion.commit();
		} catch (SQLException e) {
			// ERROR EN LA TRANSACCION -- ANULACION DE LAS ORDENES DADAS
			conexion.rollback();
		}

		// ***** DEFINICION DE LA GESTION DE TRANSACCIONES CONCURRENTES
		// ESTABLECEMOS EL NIVEL DE BLOQUEO PARA LAS TRANSACCIONES CONCURRENTES
		// NO SE PERMITE TRANSACCIONES
		conexion.setTransactionIsolation(Connection.TRANSACTION_NONE);
		// PREVENCION DE LECTURAS SUCIAS -- LECTURA REGISTRO CON MODIFICACION NO
		// CONFIRMADA BL
		conexion.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		conexion.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		// PREVENCION DE LECTURAS REPETIDAS -- NO SE CONSIDEREN MODIFICIACIONES
		// POR OTRA TRANSACCION BM
		conexion.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		// PREVENCION DE LECTURAS FANTASMAS -- NO SE PERMITE LA INSERCION DE
		// NUEVOS REGISTROS POR OTRA TRANSACCION BI
		conexion.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

	}

}
