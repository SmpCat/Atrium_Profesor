package com.atrium.controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * Ejemplo de sintaxis de elementos para la conexion a la base de datos via
 * JDBC.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * 
 */
public class Ejemplo_ConexionJDBC {

	private Connection conexion_bd;

	public void conexion_BD() throws Exception {
		// PASO UNO -- SE CARGA EL DRIVER NECESARIO SEGUN BASE DE DATOS
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// PASO DOS -- SE ESTABLECE LA CONEXION A PARTIR DEL DRIVER
		conexion_bd = DriverManager.getConnection("cadena de conexion",
				"usuario", "password");

	}

	public void lanzar_OrdenesBD() throws SQLException {
		// -- PASO TRES -- SE CREA EL OBJETO NECESARIO PARA LANZAR LAS ORDENES A
		// LA BASE DE DATOS
		// ********** STATEMENT
		// STA CON OPCIONES POR DEFECTO CON EL RESULTSET
		Statement sta = conexion_bd.createStatement();
		// STA INDICANDO TIPO DE LECTURA Y ACCIONES A REALIZAR CON EL RESULTSET
		sta = conexion_bd.createStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY);
		// STA INDICANDO TIPO DE LECTURA Y ACCIONES A REALIZAR CON EL RESULTSET
		// ADEMAS DE LA PERMANENCIA DEL MISMO.
		sta = conexion_bd.createStatement(ResultSet.CONCUR_READ_ONLY,
				ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
		// ********** PREPARESTATEMENT
		// PTA BASICO CON RESULTSET POR DEFECTO -- MISMAS OPCIONES QUE EN EL STA
		PreparedStatement pta = conexion_bd.prepareStatement("comando SQL");
		// PTA INDICANDO TIPO DE LECTURA Y ACCIONES A REALIZAR CON EL RESULTSET
		// -- MISMAS OPCIONES QUE EN EL STA
		pta = conexion_bd.prepareStatement("comando SQL",
				ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		// PTA INDICANDO TIPO DE LECTURA Y ACCIONES A REALIZAR CON EL RESULTSET
		// ADEMAS DE LA PERMANENCIA DEL MISMO -- MISMAS OPCIONES QUE EN EL STA
		pta = conexion_bd.prepareStatement("comando SQL", ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
		// ********** CALLABLESTATEMENT
		// CLA DE LLAMADA A UN PROCEDIMIENTO ALMACENADO -- INCLUYE PARAMETROS DE
		// ENTRADA
		// OPCIONES DE RESULTASET IGUAL QUE EN LOS CASOS ANTERIORES
		CallableStatement cla = conexion_bd.prepareCall("{call demoSp(?, ?)}");

		// -- PASO CUATRO SE LANZA LA ORDEN CONTRA LA BASE DE DATOS
		// EXECUTE
		// EXECUTEQUERY
		// EXECUTEUPDATE

		// PETICION DE EJECUCION DE ORDEN RESULTADO TRUE/FALSE SEGUN COMANDO SQL
		// Y RESULTADO OBTENIDO
		boolean actualizacion_consulta = sta.execute("COMANDO SQL");

		// PETICION DE CONSULTA Y OBTENCION DEL RESULTADO DE LA CONSULTA PARA A
		// CONTINUACION TRABAJAR CON EL
		ResultSet rs = sta.executeQuery("CONSULTA SQL");

		// PETICION DE EJECUCION DE ORDEN NO CONSULTA Y OBTENCION DE NUMERO DE
		// REGISTROS AFECTADOS
		int numero_registrosafectados = sta
				.executeUpdate("COMANDO SQL NO CONSULTA");

		// *** PREPARESTATEMENT
		// SI LA ORDEN CONTIENE VARIABLES SE SUSTITUIRAN ANTES DE LANZAR LA
		// ORDEN CON METODOS SET.. CORRESPONDIENTES
		pta.setInt(2, 5);
		pta.setString(4, "");
		// LANZAMIENTO DE PETICION Y OBTENCION DEL RESULTA EXACTAMENTE IGUAL QUE
		// CON EL STA
		actualizacion_consulta = pta.execute();
		rs = pta.executeQuery();

		// *** CALLABLESTATEMENT
		// SI EL PROCEDIMIENTO ALMACENADO DEVOLVIESE ALGUN VALOR SE DECLARA EL
		// PARANETRO QUE LO RECIBIRIA
		cla.registerOutParameter(4, Types.INTEGER);
		cla.registerOutParameter("nombre parametro salida", Types.BOOLEAN);

		// SI LA LLAMADA TIENE PASA DE PARAMETROS SE SUSTITUYEN POR LOS VALORES
		// A ENVIAR.
		cla.setInt(3, 10);
		cla.setString("nombre pametro", "texto a pasar");
		// LLAMADA AL PROCEDIMIENTO CON LAS MISMAS NORMAS QUE LOS ANTERIORES
		cla.execute();
		// SI EL PROCEMIENTO ES UNA CONSULTA Y DEVUELVE LOS VALORES UNA OPCION
		// SERIA GETRESULTSET
		rs = cla.getResultSet();
		// SI DEVUELVE VALORES EN PARAMETROS SE RECOGEN UNO A UNO LLAMANDOLOS
		// LLAMADA POR POSICION
		int valor = cla.getInt(2);
		// LLAMADA POR NOMBRE
		valor = cla.getInt("");

		// -- ULTIMO PASO CIERRE DE RECURSOS DESPUES DEL TRATAMIENTO DLE
		// RESULTADO DE LA CONSULTA
		cla.close();
		pta.close();
		sta.close();
		// EL ULTIMO ELEMENTO EN CERRARSE DEBE SER LA CONEXION
		conexion_bd.close();
	}

	public void tratar_ResultadoConsultas() throws SQLException {
		// OBJETO DONDE SE RECIBE EL RESULTADO DE LA CONSULTA
		ResultSet resultado_consulta = null;

		// *** MOVIMIENTOS DENTRO DEL RESULTSET -- POSIBLES SEGUN TIPO DE
		// RESULTSET
		// SIGUIENTE REGISTRO -- SIEMPRE POSIBLE
		resultado_consulta.next();
		// PRIMERA FILA Y ULTIMA FILA
		resultado_consulta.first();
		resultado_consulta.last();
		// ANTES DE LA PRIMERA FILA (BOF) Y DESPUES DE LA ULTIMA FILA (EOF)
		resultado_consulta.beforeFirst();
		resultado_consulta.afterLast();
		// MOVIMIENTO A FILAS CONCRETAS
		int numero_fila = 1;
		// FILA DEL RESULTA SEGUN EL NUMERO
		resultado_consulta.absolute(numero_fila);
		// FILA SEGUN LA POSICION EN LA QUE ESTEMOS -- POSITIVO ADELANTE
		// NEGATIVO RETROCESO
		resultado_consulta.relative(numero_fila);
		resultado_consulta.previous();
		// IDA AL REGISTRO DE EDICION
		resultado_consulta.moveToInsertRow();
		// VUELTA AL REGISTRO ACTIVO
		resultado_consulta.moveToCurrentRow();
		
		// *** ACCIONES CON LOS REGISTROS
		// ALTA EN LA BASE DE DATOS
		resultado_consulta.insertRow();
		// MODIFICACION EN LA BASE DE DATOS
		resultado_consulta.updateRow();
		// BORRADO EN LA BASE DE DATOS
		resultado_consulta.deleteRow();
		// CONFIRMACION O DENEGACION DE LA ACCION DE ALTA
		resultado_consulta.rowInserted();
		// CONFIRMACION O DENEGACION DE LA ACCION DE MODIFICACION
		resultado_consulta.rowUpdated();
		// CONFIRMACION O DENEGACION DE LA ACCION DE BAJA
		resultado_consulta.rowDeleted();

		// *** ACCIONES CON LOS COLUMNAS DE LAS FILAS
		// RECOGEMOS EL VALOR DEL CAMPO
		resultado_consulta.getInt(3);
		resultado_consulta.getInt("nombre columna resultaset");
		// MODIFICAMOS/ INTRODUCIMOS EL VALOR EN EL CAMPO
		resultado_consulta.updateInt(2, 4);
		resultado_consulta.updateInt("nombre columna resultaset", 2);

		// ULTIMO PASO CIERRE DEL RESULTASET PARA LIBERAR RECURSO
		resultado_consulta.close();

	}

}
