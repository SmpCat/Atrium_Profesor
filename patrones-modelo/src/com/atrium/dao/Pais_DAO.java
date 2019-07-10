package com.atrium.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.atrium.conexion.Conexion;
import com.atrium.dto.Pais;

/**
 * DAO para el proceso de la tabla Paises.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 * @since 4-10-2016.
 */
public class Pais_DAO {

	// PROPIEDADES COMUNES PARA SU USO EN TODOS LOS DAOS.
	public Connection conexion;
	public Statement sta;
	public ResultSet rs;
	public ResourceBundle rb;
	public PreparedStatement pta;
	public CallableStatement cta;

	/**
	 * Creacion del DAO obteniendo la conexion mediante el proceso por defecto.
	 * <br/>
	 * Resolviendo en el constructor de clase padre.
	 */
	public Pais_DAO() {
		// INICIAMOS EL PROCESO DE OBTENCION DE CONEXION
		Conexion con = new Conexion();
		// SOLICITAMOS CONEXION SEGUN LA ESTRATEGIA QUE NECESITEMOS
		con.crear_ConexionAutomatica();
		// RECOGEMOS LA CONEXION OBTENIDA
		conexion = con.getConexion();
		// CARGAMOS EL FICHERO DE TEXTO CON LAS SENTENCIAS SQL A USAR
		rb = ResourceBundle.getBundle("com.atrium.jdbc.sql");
	}

	/**
	 * Proceso de consulta de todos los paises de la tabla, sin ningun criterio
	 * de consulta.
	 * 
	 * @return Coleccion con los DTO resultantes de la consulta.
	 * @throws SQLException
	 */
	public List<Pais> consultar_Todos() throws SQLException {
		// PREPARAMOS LA LISTA PARA ONTENER EL RESULTADO DE LA CONSULTA
		List<Pais> lista = new ArrayList<Pais>(0);
		// CREAMOS EL STATEMENT NECESARIO PARA LANZAR LA ORDEN SQL SIN
		// VARIABLES
		sta = conexion.createStatement();
		// EJECUTAMOS LA CONSULTA SACANDO EL CODIGO SQL DEL PROPERTIES
		rs = sta.executeQuery(rb.getString("consulta.paises.todos"));
		Pais nuevo_pais;
		// PROCESAMOS EL RESULTADO DE LA CONSULTA CREANDO LOS DTO NECESARIOS
		// PARA ALMACENAR TODA LA INFORMACION RECIBIDA
		while (rs.next()) {
			nuevo_pais = new Pais();
			// CARGA MANUAL DE DATOS EN EL DTO (SIN REFLEXION)
			nuevo_pais.setCodigo_pais(rs.getLong(1));
			nuevo_pais.setPais_iso2(rs.getString(3));
			nuevo_pais.setPais_iso3(rs.getString(4));
			nuevo_pais.setPais_isonum(rs.getInt(2));
			nuevo_pais.setPais_nombre(rs.getString(5));
			lista.add(nuevo_pais);
		}
		return lista;
	}

	/**
	 * Liberamos recursos para implementar el modelo desconectado.<BR/>
	 * El proceso sera en el orden inverso de creacion.
	 * 
	 * @throws SQLException
	 */
	public void liberar_Recursos() throws SQLException {
		if (rs != null) {
			// CERRAMOS EL RESULTSET
			rs.close();
		}
		if (pta != null) {
			// CERRAMOS EL PREPARESTATEMENT
			pta.close();
		}
		if (sta != null) {
			// CERRAMOS EL STATEMENT
			sta.close();
		}
		if (cta != null) {
			// CERRAMOS EL CALLABLESTATEMENT
			cta.close();
		}
		if (conexion != null) {
			// CERRAMOS LA CONEXION
			conexion.close();
		}
	}

	/**
	 * Proceso de inicio de la transaccion.
	 */
	public void iniciar_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.setAutoCommit(false);
		}
	}

	/**
	 * Proceso de confirmacion de transaccion.
	 * 
	 * @throws SQLException
	 */
	public void confirmar_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.commit();
		}
	}

	/**
	 * Proceso de anulacion de transaccion.
	 * 
	 * @throws SQLException
	 */
	public void anular_Transaccion() throws SQLException {
		if (conexion != null) {
			conexion.rollback();
		}
	}

	/**
	 * Proceso para recibir la conexion de otro dao y poder resolver las
	 * transacciones.
	 * 
	 * @param conexion
	 */
	public void recibir_Conexion(Connection conexion) throws SQLException {
		liberar_Recursos();
		this.conexion = conexion;
	}
}
